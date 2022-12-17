function onlogin() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (validateFields(email, password)){
        login(email, password);
    }
    else {
        setInvalidCredentials();
    }
}

//make disappear after a bit or disappear after user goes on from again
function setInvalidCredentials() {
    var p = document.getElementById("invalidMsg");
    p.innerHTML = "Invalid credentials";
    p.style.color = "#D90429";
}

function validateFields(email, password) {
    return validateEmail(email) && validatePassword(password);
}

function validateEmail(email) {
    console.log("bruh");
    var regex = /^\S+@\S+\.\S+$/;
    return regex.test(email);
}

function validatePassword(password) {
    var regex = /^(?=.*[0-9])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
    return regex.test(password);
}

function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

function loggedIn(account, status, xhr) {

    if (account['id'] != null) {
        //set either id or username in cookieS
        setCookie("username", account['username'], 1);
        window.location = "main.html";
    }
    else {
        setInvalidCredentials();
    }
}

function login(email, password) {

    var account = {};

    account['email'] = email;
    account['password'] = password;

    var json = JSON.stringify(account);

    $.ajax({
        url: 'http://localhost:8080/account/verifyLogin',
        type: 'POST',
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: loggedIn,
        error: function (jqXhr, textStatus, errorMessage) {
            setInvalidCredentials();
            console.log(errorMessage);
        }
    });
}