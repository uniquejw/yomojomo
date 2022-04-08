
css(".login", "display", "none");

fetch("/member/getLoginUser").then(function(response) {
	return response.json();
}).then(function(result) {
	if (result.status == "success") {
		css(".login", "display", "");
		css(".not-login", "display", "none");
	}
});

function css(selector, name, value) {
	var el = document.querySelectorAll(selector);
  for (var e of el) {
    e.style[name] = value;
  }
}

document.querySelector("#login-btn").onclick = function () {
	location.href = "/jaewon/login/login/index.html";
};

document.querySelector("#logout-btn").onclick = function() {
  fetch("/member/signout").then(function(response) {
	  location.reload();
  });
};