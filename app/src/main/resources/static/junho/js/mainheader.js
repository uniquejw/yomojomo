
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


document.querySelector("#logout-btn").onclick = function() {
  fetch("/member/signout").then(function(response) {
	  location.reload();
  });
};

$.ajax({
	url : "/member/getLoginUser",
	type : "POST",
	datatype : "json",
	success : function(result) {
		const memberNo = result.data.no;
		console.log(memberNo);
		var suceesSignIn = document.querySelector("#sign-up")
		suceesSignIn.classList.add('suceess-sign-in')
		if (result.status == "fail") {
			$("#alert-msg-li").hide();
			$("#createGroupli").hide();
			suceesSignIn.classList.remove('suceess-sign-in')
			css(".suceess-sign-in", "display", "block")
		}
		window.loginUser = result.data;
		
		css(".suceess-sign-in", "display", "none")

		$.ajax({
			url: "/invitebox/invitelistbyrecipient",
			type: "POST",
			datatype: "json",
			data : {"member.no" : memberNo},
			success: function (result) {
				var msgResult = result.data;
				console.log(msgResult)
				var msgCount = 0;

				$.ajax({
					url: "/applyFixedAnswer/findRequestByMasNO",
					type: "POST",
					datatype: "json",
					data : {"master.no" : memberNo},
					success: function (result) {
						var GroupmsgResult = result.data;
						console.log(msgResult)
						console.log(GroupmsgResult)
						var groupMsgCnt = 0;
						for (i = 0; i < GroupmsgResult.length; i++) {
							if (GroupmsgResult[i].confirm == false) {
								groupMsgCnt++;
							}
						}

						for (i = 0; i < msgResult.length; i++) {
							if (msgResult[i].confirm == false) {
								msgCount++;
							}
						}

						if (msgResult.length > 0 || GroupmsgResult.length > 0) {
							console.log("참");
							$("#invitemsgCnt").text(msgCount);
							$("#requestmsgCnt").text(groupMsgCnt);
							$("#totalMsgCnt").text(msgCount + groupMsgCnt); 
						}
					}	
				})
			}	
		})
	}
});

document.querySelector('.btn-group-link').addEventListener('click', function() {
	window.location.href = '/ssang/group/form.html';
})