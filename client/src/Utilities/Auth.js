import Cookies from 'js-cookie';

const CheckAuth = function() {
    return (Cookies.get('token') === undefined) ? false : true;
};

async function CheckCredentials(email, password) {
    const data = {
        'email': email,
        'password': password,
        'userType': 's'
    };
    let response = await fetch('/api/userManagement/seekerUser/login', 
    {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    let jsonResponse = await response.json();
    return jsonResponse;
}

export {CheckAuth, CheckCredentials};