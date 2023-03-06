function showDiv() {
    document.getElementById("leagueStandingDiv").style.display = "block";
    //document.getElementById("joinDraftDiv").style.display = "block";

    //for now just ignoring draft roomm functionality

    id = getId();

    getLeagueName(id);

    getTeams(id);

    getPlayers(id);
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
        return a.fPoints - b.fPoints;//TEST
    });

    teamList.forEach(showTeam);
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

    document.getElementById("teamList1").appendChild(a);
    document.getElementById("teamList2").appendChild(a);
}

function getPlayers() {

    var accountLeague = {};

    accountLeague['username'] = getCookie("username");
    accountLeague['leagueId'] = getId();

    var json = JSON.stringify(accountLeague);

    $.ajax({
        url: `http://localhost:8080/basketballplayer/postSearch`,
        type: 'POST',
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: showPlayers,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
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

function getTotalFPoints(team) {
    var total = 0;
    for (let x of team.players) {
        total += x.fPoints;
    }
    return total;
}

function showPlayers(playerList, status, xhr) {

    playerList.forEach(showPlayer)
}

function showPlayer(player) {
    
    var a = document.createElement("a");
    a.href = `#`;
    a.className = "list-group-item list-group-item-action flex-column align-items-start";

    var div = document.createElement("div");
    div.className = "d-flex w-100 justify-content-between pt-2 pr-2";

    var playerTitle = document.createElement("h5");
    playerTitle.className = "mb-1";
    playerTitle.innerHTML = ` ${player.name}`;

    var span = document.createElement("span");
    span.className = "badge bg-primary";
    span.innerHTML = player.position;

    playerTitle.prepend(span);

    var fPoints = document.createElement("h5");
    fPoints.innerHTML = player.fPoints;

    div.appendChild(playerTitle);
    div.appendChild(fPoints);

    var div2 = getStatsDiv(player);

    a.appendChild(div);
    a.appendChild(div2);

    document.getElementById("playerList").appendChild(a);
}

function getStatsDiv(player) {
    let div = document.createElement("div");
    div.className = "statsDiv";

    div.appendChild(getIndStatDiv(player, "Points"));
    div.appendChild(getIndStatDiv(player, "Rebounds"));
    div.appendChild(getIndStatDiv(player, "Assists"));
    div.appendChild(getIndStatDiv(player, "Blocks"));
    div.appendChild(getIndStatDiv(player, "Steals"));
    div.appendChild(getIndStatDiv(player, "Turnovers"));

    return div;
}

function getIndStatDiv(player, statname) {
    let indStatDiv = document.createElement("div");
    indStatDiv.className = "indStatDiv";

    let statnameTitle = document.createElement("h6");
    statnameTitle.innerHTML = statname;

    let statvalue = document.createElement("p");
    statvalue.innerHTML = player[`total${statname}`];

    indStatDiv.appendChild(statnameTitle);
    indStatDiv.appendChild(statvalue);

    return indStatDiv;
}
