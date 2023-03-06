function verifyAccountLeague() {
    var requestBody = {};

    requestBody['username'] = getCookie("username");
    requestBody['leagueId'] = getId();

    var json = JSON.stringify(requestBody);

    $.ajax({
        url: 'http://localhost:8080/team/verifyAccessToLeague',
        type: 'POST',
        data: json,
        crossDomain: true,
        crossOrigin: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        success: checkVerification,
        error: function (jqXhr, textStatus, errorMessage) {
            console.log(errorMessage);
        }
    });
}

function checkVerification(res, status, xhr) {
    if (res != "valid") {
        window.location.href = "/main.html";
    }
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

function getId() {
    var url = new URL(document.URL);
    return parseInt(url.searchParams.get("id"));
}

verifyAccountLeague();