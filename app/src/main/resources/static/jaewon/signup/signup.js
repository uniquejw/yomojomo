


//document.querySelector("form[name=signup]").onsubmit = function() {
function signForm() {
	var xEmail = document.querySelector("input[name=email]");
	var xPassword = document.querySelector("input[name=passWord]");
	var xName = document.querySelector("input[name=memberName]");
	var xTel = document.querySelector("input[name=tel]");
	var xPostNo = document.querySelector("input[name=postNo]");
	var xBaseAddress = document.querySelector("input[name=baseAddress]");
	var xAddress = document.querySelector("input[name=address]");
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
		xLocallist = document.querySelector("#locallist")
		for(i=0; i<xLocallist.children.length; i++){
			var value = xLocallist.children[i].value
			fd.append('localsArr', value);
		}
		xPupslist = document.querySelector("#pupslist")
		for(i=0; i<xPupslist.children.length; i++){
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



function locallistsi() {
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

function locallistgu() {
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

function addlocal() {
	var locallist = document.querySelector("#locallist");
	var selectlocal = document.querySelector("#selectlocal");
	var htmlGeneratorselect = Handlebars.compile(selectlocal.innerHTML);
	$('.lo-btn').on('click', (e) => {
		var gu = $("#locallistgu option:selected").val()
		if (gu === '') {
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

				for (i = 0; i < $(locallist).children().length; i++) {
					if ($(locallist).children()[i].value == result.no) {
						console.log(result.no)
						alert("중복된 지역은 추가할 수 없습니다.")
						return false;
					}
				}

				if ($(locallist).children().length > 2) {
					alert("3개 이상은 등록할 수 없습니다.")
					return false;
				}

				locallist.innerHTML += htmlGeneratorselect(result);
			});
	})
}

function deletelocal() {
	$(document).on("click", "#locallist", (e) => {
		e.preventDefault();
		alert('삭제되었습니다.');
		$("#locals").remove();
	})

}

function pupslist() {
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

function addpups() {
	var pupslist = document.querySelector("#pupslist");
	var Selectpups = document.querySelector("#selectpups");
	var htmlGeneratorpups = Handlebars.compile(Selectpups.innerHTML);
	$('.pur-btn').on('click', (e) => {
		var pups = $("#purpose option:selected").val()
		if (pups === '') {
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

				for (i = 0; i < $(pupslist).children().length; i++) {
					if ($(pupslist).children()[i].value == result.no) {
						console.log(result.no)
						alert("중복된 목적은 추가할 수 없습니다.")
						return false;
					}
				}

				if ($(pupslist).children().length > 2) {
					alert("3개 이상은 등록할 수 없습니다.")
					return false;
				}

				pupslist.innerHTML += htmlGeneratorpups(result);
			});
	})
}

function deletepups() {
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

