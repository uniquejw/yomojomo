


//document.querySelector("form[name=signup]").onsubmit = function() {
function signForm() {
	var xEmail = $("input[name=email]");
	var xPassword = $("input[name=passWord]");
	var xName = $("input[name=memberName]");
	var xTel = $("input[name=tel]");
	var xPostNo = $("input[name=postNo]");
	var xBaseAddress = $("input[name=baseAddress]");
	var xAddress = $("input[name=address]");
	var validTargets = [xEmail, xPassword, xName, xTel, xPostNo, xBaseAddress, xAddress];
	// xEmail.value === ''


	$('form').on('submit', function(e) {
		e.preventDefault();
		// !xEmail.value

		var isValid = true;
		validTargets.forEach(target => {
			if (!target.value) {
				isValid = false;
			}
		});
		if (isValid === false) {
			window.alert("필수 항목을 입력하세요")
			return false;
		}
		var fd = new FormData(document.forms.namedItem("signup"));
		fd.append('type', '1');
		xLocallist = $("#locallist")
		for (var i = 0; i < xLocallist.children.length; i++) {
			var value = xLocallist.children[i].value
			fd.append('localsArr', value);
		}
		xPupslist = $("#pupslist")
		for (var i = 0; i < xPupslist.children.length; i++) {
			var value = xPupslist.children[i].value
			fd.append('pupsArr', value);
		}



		fetch("/member/signup", {
			method: "POST",
			body: new URLSearchParams(fd)
		}).then(function(response) {
			return response.json();
		}).then(function(result) {
			if (result.status == "success") {
				location.href = "/junho/index.html";
			} else {
				window.alert("로그인 실패!")
			}
		});
		return false;
	});
}



function localListSi() {
	var locallistsi = document.querySelector("#localboard");
	var Selectsi = document.querySelector("#select-si");
	var htmlGenerators = Handlebars.compile(Selectsi.innerHTML);
	fetch("/activeLocal/list")
		.then(function(response) {
			return response.json();
		}).then(function(result) {
			if (result.status == "fail") {
				window.alert("서버 요청 오류!");
				console.log(result.data);
				return;
			}
			locallistsi.innerHTML = htmlGenerators(result);
		});
}

function localListGu() {
	var locallistgu = document.querySelector("#locallistgu");
	var Selectgu = document.querySelector("#select-gu");
	var htmlGeneratorg = Handlebars.compile(Selectgu.innerHTML);
	$('#localboard').change(function() {
		var gu = $("#localboard option:selected").val()
		var qs = `nameGu=${gu}`
		fetch(`/activeLocal/list-gu?${qs}`)
			.then(function(response) {
				return response.json();
			}).then(function(result) {
				if (result.status == "fail") {
					window.alert("서버 요청 오류!");
					console.log(result.data);
					return;
				}
				locallistgu.innerHTML = htmlGeneratorg(result);
			});
	})
}

function addLocal() {
	var locallist = document.querySelector("#locallist");
	var selectlocal = document.querySelector("#selectlocal");
	var htmlGeneratorselect = Handlebars.compile(selectlocal.innerHTML);
	
	$('.lo-btn').on('click', (e) => {
		var gu = $("#locallistgu option:selected").val()
		if (!gu) {
			alert("시/구를 입력해주세요");
			return false
		}
		var qs = `no=${gu}`
		fetch(`/activeLocal/get?${qs}`)
			.then(function(response) {
				return response.json();
			}).then(function(result) {
				if (result.status == "fail") {
					window.alert("서버 요청 오류!");
					console.log(result.data);
					return;
				}
				var localchild = $(locallist).children()
				for (var i = 0; i < localchild.length; i++) {
					if (localchild[i].value == result.no) {
						console.log(result.no)
						alert("중복된 지역은 추가할 수 없습니다.")
						return false;
					}
				}

				if (localchild.length > 2) {
					alert("3개 이상은 등록할 수 없습니다.")
					return false;
				}

				locallist.innerHTML += htmlGeneratorselect(result);
			});
	})
}

function deleteLocal() {
	$(document).on("click", "#locallist", (e) => {
		e.preventDefault();
		alert('삭제되었습니다.');
		$("#locals").remove();
	})

}

function pupsList() {
	var pupslist = document.querySelector("#purpose");
	var Selectpups = document.querySelector("#select-pups");
	var htmlGeneratorp = Handlebars.compile(Selectpups.innerHTML);
	fetch("/purpose/list")
		.then(function(response) {
			return response.json();
		}).then(function(result) {
			if (result.status == "fail") {
				window.alert("서버 요청 오류!");
				console.log(result.data);
				return;
			}
			pupslist.innerHTML = htmlGeneratorp(result);
		});
}

function addPups() {
	var pupslist = document.querySelector("#pupslist");
	var Selectpups = document.querySelector("#selectpups");
	var htmlGeneratorpups = Handlebars.compile(Selectpups.innerHTML);
	$('.pur-btn').on('click', (e) => {
		var pups = $("#purpose option:selected").val()
		if (!pups) {
			alert("시/구를 입력해주세요");
			return false
		}
		var qs = `no=${pups}`
		fetch(`/purpose/get?${qs}`)
			.then(function(response) {
				return response.json();
			}).then(function(result) {
				if (result.status == "fail") {
					window.alert("서버 요청 오류!");
					console.log(result.data);
					return;
				}
				var pupslistchild = $(pupslist).children()
				for (var i = 0; i < pupslistchild.length; i++) {
					if (pupslistchild[i].value == result.no) {
						console.log(result.no)
						alert("중복된 목적은 추가할 수 없습니다.")
						return false;
					}
				}

				if (pupslistchild.length > 2) {
					alert("3개 이상은 등록할 수 없습니다.")
					return false;
				}

				pupslist.innerHTML += htmlGeneratorpups(result);
			});
	})
}

function deletePups() {
	$(document).on("click", "#pupslist", (e) => {
		e.preventDefault();
		alert('삭제되었습니다.');
		$("#pups").remove();
	})

}

/*function memRegi() {

	var fd = new FormData(document.forms.namedItem("signup"));
	fd.append('type', '1');


	fetch("/member/signup", {
		method: "POST",
		body: new URLSearchParams(fd)
	}).then(function(response) {
		return response.json();
	}).then(function(result) {
		if (result.status == "success") {
			location.href = "/junho/index.html";
		} else {
			window.alert("로그인 실패!")
		}
	});
	return false;
}
*/

