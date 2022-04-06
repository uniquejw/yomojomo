	var xEmail = document.querySelector("input[name=email]");
	var xPassword = document.querySelector("input[name=password]");

	document.querySelector("form[name=formyo]").onsubmit = function() {
		if (xEmail.value == "" || xPassword.value == "") {
			window.alert("필수 입력 항목이 비어 있습니다.");
			return false;
		}

		var fd = new FormData(document.forms.namedItem("formyo"));

		fetch("/sign/signin", {
			method : "POST",
			body : new URLSearchParams(fd)
		}).then(function(response) {
			return response.text();
		}).then(function(text) {
			if (text == "success") {
				location.href = "/junho/index.html";
			} else {
				window.alert("로그인 실패!")
			}
		});
		return false;
	};