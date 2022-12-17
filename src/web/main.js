function showDiv() {
    //check if cookie is set to see if logged in
    //if not redirect to login.html
    var username = getCookie("username");
    console.log(username);

    //also show name on nav bar

    document.getElementById("joinLeagueDiv").style.display = "block";
}

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}


function addLeague(league) {
    const newDiv = document.createElement("div");
    const newP = document.createElement("p");

    //style div and p

    //add info to newP
    newP.innerHTML = league.name;

    newDiv.appendChild(newP);
    document.getElementById("leagueListDiv").appendChild(newDiv);
}

function getLeagues(username) {

    //TBD -> need to figure out in the back end
    /*var account = {};

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
            console.log(errorMessage);
        }
    });*/
}

