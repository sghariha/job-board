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

async function CheckIfEmailExists(email) {
    if (email === '') {
        email = '000000'
    }
    let response = await fetch('/api/seekerUsers/userExistsByEmail/' + email, 
    {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    let jsonResponse = await response.json();
    return jsonResponse;
}

async function RegisterSeekerUser(email, password, firstName, lastName, dob) {
    const data = {
        'email': email,
        'password': password,
        'firstName': firstName,
        'lastName': lastName,
        'dob': dob
    };
    await fetch('/api/seekerUsers/new',
    {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}

export {CheckAuth, CheckCredentials, CheckIfEmailExists, RegisterSeekerUser};