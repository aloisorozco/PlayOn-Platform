function showDiv() {
    //check if cookie is set to see if logged in
    //if not redirect to login.html
    var username = getCookie("username");

    document.getElementById("leagueDiv").style.display = "block";
    //document.getElementById("joinLeagueDiv").style.display = "block";

    getLeagues(username);
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

    $.ajax({
        url: `http://localhost:8080/league/getLeagues?username=${username}`,
        type: 'GET',
        data: null,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: showLeagues,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}

function showLeagues(leagueList, status, xhr) {
    //MISSING TEAM INFO (standing in league and total fantasy points)

    if (leagueList.length == 0) {
        document.getElementById("noLeagueDiv").style.display = "block";
    }
    else {
        document.getElementById("noLeagueDiv").style.display = "none";
        leagueList.forEach(showLeague);
    }
}

function showLeague(league) {
    var a = document.createElement("a");
    a.href = `/league.html?id=${league.id}`;
    a.className = "list-group-item list-group-item-action flex-column align-items-start";

    var div = document.createElement("div");
    div.className = "d-flex w-100 justify-content-between indLeagueDiv";

    var leagueTitle = document.createElement("h5");
    leagueTitle.className = "mb-1";
    leagueTitle.innerHTML = ` ${league.name}`;//TEST

    /*var span = document.createElement("span");
    span.className = "badge bg-primary";
    span.innerHTML = "1";//FOR NOW

    leagueTitle.prepend(span);

    var fPoints = document.createElement("h5");
    fPoints.innerHTML = "900";//FOR NOW*/

    div.appendChild(leagueTitle);
    //div.appendChild(fPoints);

    a.appendChild(div);

    document.getElementById("leagueList").appendChild(a);
}

function joinBtnClicked() {
    
    var requestBody = {};

    requestBody['username'] = getCookie("username");
    requestBody['leagueCode'] = document.getElementById("joinCode").value;

    var json = JSON.stringify(requestBody);

    $.ajax({
        url: 'http://localhost:8080/team/add',
        type: 'POST',
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: joinLeagueSuccess,
        error: function (jqXhr, textStatus, errorMessage) {
            setInvalidCode();
            console.log(errorMessage);
        }
    });
}

function joinLeagueSuccess(responseBody, status, xh) {
    getLeagues(getCookie("username"));
}

function setInvalidCode() {
    var p = document.getElementById("invalidMsg");
    p.innerHTML = "Invalid code";
    p.style.color = "#D90429";
}

