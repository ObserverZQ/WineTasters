/**
 * Created by island on 2017/7/17.
 */
function log() {
    var username = $('#logInUsername').val();
    var password = $('#logInPassword').val();
    // alert(username);

    if (username == "" || password == "") {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        url: "/userAction/userLogin",
        type: "POST",
        dataType: "json",
        data: {
            "username": username,
            "password": password
        },
        async: false,
        success: function (data) {
            // alert(data.result);
            if (data.result == "success") {
                closeLoginView();
                // alert("success");
                setCookie("username", username, "h1");
                // alert("success");
                logInfo(username);
                return;
            }
            if (data.result == "fail") {
                alert(data.loginInfo);
                return;
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error");
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function signIn() {
    var username = $('#signInUsername').val();
    var password = "";
    if ($('#signInPassword').css("display") == "inline-block") {
        password = $('#signInPassword').val();
    }
    else if ($('#signInText').css("display") == "inline-block") {
        password = $('#signInText').val();
    }
    if (username == "" || password == "") {
        alert("请输入完整信息");
        return;
    }

    $.ajax({
        url: "/userAction/userSignUp",
        type: "POST",
        dataType: "json",
        data: {
            "username": username,
            "password": password
        },
        async: false,
        success: function (data) {
            // alert("ok");
            if (data.result == "fail") {
                alert(data.signinInfo);
            }
            if (data.result == "success") {
                alert("注册成功");
                closeSigninView();
                setCookie("username", username, "h1");
                // logInfo(username);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error");
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function logInfo(username) {
    // alert(username);
    $('#preLog').css("display", "none");
    $('#afterLog').fadeIn();
    $('#userNameLabel').html(username);
}

function quitLog() {
    delCookie("username");
    $('#afterLog').css("display", "none");
    $('#preLog').fadeIn();
}

function showLoginView() {
    $('#searchView').css("display", "none");
    $('#signinView').css("display", "none");
    $('#loginView').fadeIn();
}

function closeLoginView() {
    $('#loginView').css("display", "none");
    $('#searchView').fadeIn();
}

function showSigninView() {
    $('#searchView').css("display", "none");
    $('#loginView').css("display", "none");
    $('#signinView').fadeIn();
}

function closeSigninView() {
    $('#signinView').css("display", "none");
    $('#searchView').fadeIn();
}

function showPassword() {
    if ($('#signInPassword').css("display") == "inline-block") {
        var password = $('#signInPassword').val();
        $('#eyeButton').css("background-image", "url(../images/openEye.png)");

        $('#signInPassword').css("display", "none");
        $('#signInText').css("display", "inline-block");
        $('#signInText').val(password);
    }
    else if ($('#signInText').css("display") == "inline-block") {
        var password = $('#signInText').val();
        $('#eyeButton').css("background-image", "url(../images/closeEye.png)");
        $('#signInText').css("display", "none");
        $('#signInPassword').css("display", "inline-block");
        $('#signInPassword').val(password);
    }
}