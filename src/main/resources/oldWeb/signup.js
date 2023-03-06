function onload() {
    //document.getElementsByClassName("formInput").foreach((element)=> element.addEveelement.style.border= "none");
    //remove red border when focused on input
    //better to do just when form is clicked or focused
}

function onsignup() {
    
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (validateFields(username, email, password, confirmPassword)){
        register(username, email, password);
    }
    else {
        if (validateUsername(username)) {
            document.getElementById("usernameLabel").style.color = "black";
            document.getElementById("username").style.border ="solid 1px #ced4da";
        }
        else {
            document.getElementById("usernameLabel").style.color = "#D90429";
            document.getElementById("username").style.border ="solid 1px #D90429";
        }
        if (validateEmail(email)) {
            document.getElementById("emailLabel").style.color = "black";
            document.getElementById("email").style.border ="solid 1px #ced4da";
        }
        else {
            document.getElementById("emailLabel").style.color = "#D90429";
            document.getElementById("email").style.border ="solid 1px #D90429";
        }
        if (validatePassword(password, confirmPassword)) {
            document.getElementById("passwordLabel").style.color = "black";
            document.getElementById("password").style.border ="solid 1px #ced4da";
            document.getElementById("confirmPasswordLabel").style.color = "black";
            document.getElementById("confirmPassword").style.border ="solid 1px #ced4da";
        }
        else {
            document.getElementById("passwordLabel").style.color = "#D90429";
            document.getElementById("password").style.border ="solid 1px #D90429";
            document.getElementById("confirmPasswordLabel").style.color = "#D90429";
            document.getElementById("confirmPassword").style.border ="solid 1px #D90429";
        }
    }

}

function validateFields(username, email, password, confirmPassword) {
    return validateUsername(username) && validateEmail(email) && validatePassword(password, confirmPassword);
}

function validateUsername(username) {
    var regex = /^[A-Za-z0-9]{5,20}$/;
    return regex.test(username);
}

function validateEmail(email) {
    console.log("bruh");
    var regex = /^\S+@\S+\.\S+$/;
    return regex.test(email);
}

function validatePassword(password, confirmPassword) {
    var regex = /^(?=.*[0-9])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
    if (confirmPassword == "" || confirmPassword == null) {
        return false;
    }
    return regex.test(password) && password === confirmPassword;
}

function register(username, email, password) {

    var account = {};

    account['username'] = username;
    account['email'] = email;
    account['password'] = password;

    var json = JSON.stringify(account);

    $.ajax({
        url: 'http://localhost:8080/account/register',
        type: 'POST',  // http method
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: function (data, status, xhr) {
            //console.log(data);
            window.location = "login.html";
        },
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}