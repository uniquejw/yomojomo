
function login() {
	var xEmail = document.querySelector("input[name=email]");
	var xPassword = document.querySelector("input[name=password]");

	document.querySelector("form[name=formyo]").onsubmit = function() {
		if (xEmail.value == "" || xPassword.value == "") {
			window.alert("필수 입력 항목이 비어 있습니다.");
			return false;
		}

		var fd = new FormData(document.forms.namedItem("formyo"));
		var back = document.refferer;
		fetch("/member/signin", {
			method: "POST",
			body: new URLSearchParams(fd)
		}).then(function(response) {
			return response.json();
		}).then(function(result) {
			if (result.status == "success") {
				history.go(-1);
			} else {
				window.alert("로그인 실패!")
			}
		});
		return false;
	};
}

function fblogin() {

	window.fbAsyncInit = function() {
		FB.init({
			appId: '1646718509011068',
			cookie: true,
			xfbml: true,
			version: 'v13.0'
		});

		FB.AppEvents.logPageView();

	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) { return; }
		js = d.createElement(s); js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));


}
function checkLoginState() {
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') { // 로그인이 정상적으로 되었을 때,

			var params = new URLSearchParams();
			params.append("accessToken", response.authResponse.accessToken);

			fetch("/member/facebookLogin", {
				method: "POST",
				body: params
			}).then(function(response) {
				return response.json();
			}).then(function(result) {
				if (result.status == "success") {
					history.go(-1);
				} else {
					window.alert("페이스북 로그인 실패!");
				}
			})

		} else { // 로그인이 되지 않았을 때,
			console.log("로그인 되지 않았음");
		}
	})
}

function userEmail() {
	var userEmail = Cookies.get('userEmail');
	if (userEmail != undefined) {
		xEmail.value = userEmail;
	}
}



