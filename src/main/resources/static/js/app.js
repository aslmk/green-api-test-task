const baseUrl = 'https://green-api-test-task-dt5w.onrender.com/api/v1';
const settingsEndpoint = `${baseUrl}/settings`;
const stateEndpoint = `${baseUrl}/state`;
const textMessageEndpoint = `${baseUrl}/text-message`;
const fileMessageEndpoint = `${baseUrl}/file-message`;

function getSettings() {
    const idInstance = document.getElementById('idInstance').value;
    const apiTokenInstance = document.getElementById('apiTokenInstance').value;

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            idInstance: idInstance,
            apiTokenInstance: apiTokenInstance
        })
    };

    fetch(settingsEndpoint, options)
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').value = JSON.stringify(data, null, 2);
        })
        .catch(error => console.error(error));
}

function getStateInstance() {
    const idInstance = document.getElementById('idInstance').value;
    const apiTokenInstance = document.getElementById('apiTokenInstance').value;

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            idInstance: idInstance,
            apiTokenInstance: apiTokenInstance
        })
    };

    fetch(stateEndpoint, options)
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').value = JSON.stringify(data, null, 2);
        })
        .catch(error => console.error(error));
}

function sendMessage() {
    const idInstance = document.getElementById('idInstance').value;
    const apiTokenInstance = document.getElementById('apiTokenInstance').value;
    const chatId = document.getElementById('chatId').value;
    const message = document.getElementById('textMessage').value;

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            instanceParameters: {
                idInstance: idInstance,
                apiTokenInstance: apiTokenInstance
            },
            chatId: chatId,
            message: message
        })
    };

    fetch(textMessageEndpoint, options)
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').value = JSON.stringify(data, null, 2);
        })
        .catch(error => console.error(error));
}

function sendFileByUrl() {
    const idInstance = document.getElementById('idInstance').value;
    const apiTokenInstance = document.getElementById('apiTokenInstance').value;
    const chatId = document.getElementById('fileChatId').value;
    const urlFile = document.getElementById('urlFile').value;

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            instanceParameters: {
                idInstance: idInstance,
                apiTokenInstance: apiTokenInstance
            },
            chatId: chatId,
            urlFile: urlFile,
            fileName: 'img.png'
        })
    };

    fetch(fileMessageEndpoint, options)
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').value = JSON.stringify(data, null, 2);
        })
        .catch(error => console.error(error));
}

document.getElementById('getSettings').addEventListener('click', getSettings);
document.getElementById('getStateInstance').addEventListener('click', getStateInstance);
document.getElementById('sendMessage').addEventListener('click', sendMessage);
document.getElementById('sendFileByUrl').addEventListener('click', sendFileByUrl);