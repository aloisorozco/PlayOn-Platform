function onLoad() {
    getLeagueName(getId());

    getTeams(getId());
}

function getId() {
    var url = new URL(document.URL);
    return parseInt(url.searchParams.get("id"));
}

function getLeagueName(id) {
    $.ajax({
        url: `http://localhost:8080/league/get?leagueId=${id}`,
        type: 'GET',
        data: null,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: showLeagueName,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}

function showLeagueName(league, status, xhr) {
    document.getElementById("leagueName").placeholder = league.name;
    document.getElementById("leagueNameTitle").innerHTML = `${league.name}'s Standings`;
}

function getTeams(id) {

    $.ajax({
        url: `http://localhost:8080/team/getTeamsInLeague?leagueId=${id}`,
        type: 'GET',
        data: null,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: showTeams,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}

function showTeams(teamList, status, xhr) {
    teamList.sort(function(a, b) {
        return a.fPoints-b.fPoints;//TEST
    });

    teamList.forEach(showTeam);
}

function getFPoints(team) {
    var total = 0;
    for (let x of team.players) {
        total += x.fPoints;
    }
    return total;
}

function showTeam(team, index, arr) {
    var a = document.createElement("a");
    a.href = `/team.html?id=${team.id}`;
    a.className = "list-group-item list-group-item-action flex-column align-items-start";

    var div = document.createElement("div");
    div.className = "d-flex w-100 justify-content-between";

    var teamTitle = document.createElement("h5");
    teamTitle.className = "mb-1";
    teamTitle.innerHTML = ` ${team.name}`;

    var span = document.createElement("span");
    span.className = "badge bg-primary";
    span.innerHTML = index+1;

    teamTitle.prepend(span);

    var fPoints = document.createElement("h5");
    fPoints.innerHTML = team.fPoints;//TEST

    div.appendChild(teamTitle);
    div.appendChild(fPoints);

    a.appendChild(div);

    document.getElementById("teamList").appendChild(a);
}

function updateLeagueBtnClicked() {

    var league = {};

    league['id'] = getId();
    league['name'] = document.getElementById("leagueName").value;

    var json = JSON.stringify(league);

    $.ajax({
        url: 'http://localhost:8080/league/updateName',
        type: 'PUT',
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: updateNameSuccess,
        error: function (jqXhr, textStatus, errorMessage) {
            setErrorOccured();
            console.log(errorMessage);
        }
    });
}

function updateNameSuccess() {
    document.getElementById("errorMsg").innerHTML = "";

    getLeagueName(getId());
}

function setErrorOccured() {
    var p = document.getElementById("errorMsg");
    p.innerHTML = "Error occured";
    p.style.color = "#D90429";
}
