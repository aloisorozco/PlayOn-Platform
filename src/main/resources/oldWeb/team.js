function onLoad() {

    //verifyAccountTeam(username);//with cookie

    getTeamName(getId());

    getPlayers(getId());
}

function getTeamName(id) {
    $.ajax({
        url: `http://localhost:8080/team/get?teamId=${id}`,
        type: 'GET',
        data: null,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: showTeamName,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}

function showTeamName(team, status, xhr) {
    document.getElementById("teamTitle").innerHTML = team.name;
}

function getId() {
    var url = new URL(document.URL);
    return parseInt(url.searchParams.get("id"));
}

function getPlayers() {

    $.ajax({
        url: `http://localhost:8080/basketballplayer/get?teamId=${getId()}`,
        type: 'GET',
        data: null,
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