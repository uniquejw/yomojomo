$.ajax({ //로그인 여부 확인 ajax START 비회원은 등록버튼 감춘다.
  url : "/member/getLoginUser",
  type : "POST",
  // datatype : "json",
  success: function (result) {
    let memberInfo = result.data;
    // console.log(memberInfo);
    if (result.status == "fail") {
      location.href="/junho/index.html";
    } else { 
      console.log();

      //초대 메세지 보낸거 뿌리기
      $.ajax({
        url: "/invitebox/invitelistbysender",
        type : "POST",
        data: {
          "pageSize": 3,
          "pageNo": 1,
          "memberNo": memberInfo.no
        },
        success: function (invitebySender) {
          let senderData = invitebySender.data;
          // console.log(senderData);
          let senderTbody = document.querySelector(".sender-table tbody");
          let senderTrTemplate = document.querySelector("#sender-tr-template");
          let senderTableGenerator = Handlebars.compile(senderTrTemplate.innerHTML);
          let totalListCount = invitebySender.totalListCount;
          let totalPageSize = invitebySender.totalPageSize;
          let requestPageNo = invitebySender.pageNo;
          invitebySenderArr = [];

          for (i = 0; i < senderData.length; i++) {
            let xtrue = "읽음";
            let xfalse = "읽지 않음";

            invitebySenderArr.push({
              inviteNo: senderData[i].inviteNo,
              groupNo: senderData[i].joinMember.group.no,
              groupName: senderData[i].joinMember.group.groupName,
              content: senderData[i].content,              
              recipientNo: senderData[i].member.no,
              recipientName: senderData[i].member.memberName,
              regDt: senderData[i].regDt,
              title: senderData[i].title,
              confirm: senderData[i].confirm,
              confirmName: senderData[i].confirm == true ? xtrue : xfalse
            })
          }

          if (totalListCount != 0) {
            senderTbody.innerHTML = senderTableGenerator(invitebySenderArr);
          } else {
            $("#sendlistnone").show();
          }

          $("#sendpageNo").text(requestPageNo); //번호 출력

          if (requestPageNo == 1) {
            $("#sendpreA").hide();
          } else {
            $("#sendpreA").show();
          }
    
          if (totalPageSize == requestPageNo) {
            $("#sendnextA").hide();
          } else {
            $("#sendnextA").show();
          }
          
          $("#sendpreA").val(requestPageNo - 1);
          $("#sendnextA").val(requestPageNo + 1);

          //요청 다음버튼
          $("#sendnextA").on("click", function () {
            $.ajax({ //픽미 게시글 화면에 뿌리기
              url: "/invitebox/invitelistbysender",
              type: "POST",
              datatype: "json",
              data: {
                pageSize: 3,
                pageNo: $("#sendnextA").val(),
                memberNo: memberInfo.no
              },
              success: function (sendnextResult) {
                totalListCount = sendnextResult.totalListCount;
                totalPageSize = sendnextResult.totalPageSize;
                requestPageNo = sendnextResult.pageNo;
                nextinvitebySenderArr = [];
                $("#sendpageNo").text(requestPageNo);
                $("#sendpreA").val(requestPageNo - 1);
                $("#sendnextA").val(requestPageNo + 1);

                for (i = 0; i < sendnextResult.data.length; i++) {
                  let xtrue = "읽음";
                  let xfalse = "읽지 않음";
                  nextinvitebySenderArr.push({
                    inviteNo: sendnextResult.data[i].inviteNo,
                    groupNo: sendnextResult.data[i].joinMember.group.no,
                    groupName: sendnextResult.data[i].joinMember.group.groupName,
                    content: sendnextResult.data[i].content,
                    recipientNo: sendnextResult.data[i].member.no,
                    recipientName: sendnextResult.data[i].member.memberName,
                    regDt: sendnextResult.data[i].regDt,
                    title: sendnextResult.data[i].title,
                    confirm: sendnextResult.data[i].confirm,
                    confirmName: sendnextResult.data[i].confirm == true ? xtrue : xfalse
                  })
                }
                senderTbody.innerHTML = senderTableGenerator(nextinvitebySenderArr);

                if (requestPageNo == 1) {
                  $("#sendpreA").hide();
                } else {
                  $("#sendpreA").show();
                }
        
                if (totalPageSize == requestPageNo) {
                  $("#sendnextA").hide();
                } else {
                  $("#sendnextA").show();
                }
              }
            })
          }); //$("#sendnextA") click Event END

          //요청 이전버튼
          $("#sendpreA").on("click", function () {
            $.ajax({ //픽미 게시글 화면에 뿌리기
              url: "/invitebox/invitelistbysender",
              type: "POST",
              datatype: "json",
              data: {
                pageSize: 3,
                pageNo: $("#sendpreA").val(),
                memberNo: memberInfo.no
              },
              success: function (sendpreResult) {
                totalListCount = sendpreResult.totalListCount;
                totalPageSize = sendpreResult.totalPageSize;
                requestPageNo = sendpreResult.pageNo;
                preinvitebySenderArr = [];
                $("#sendpageNo").text(requestPageNo);
                $("#sendpreA").val(requestPageNo - 1);
                $("#sendnextA").val(requestPageNo + 1);

                for (i = 0; i < sendpreResult.data.length; i++) {
                  let xtrue = "읽음";
                  let xfalse = "읽지 않음";
                  preinvitebySenderArr.push({
                    inviteNo: sendpreResult.data[i].inviteNo,
                    groupNo: sendpreResult.data[i].joinMember.group.no,
                    groupName: sendpreResult.data[i].joinMember.group.groupName,
                    content: sendpreResult.data[i].content,
                    recipientNo: sendpreResult.data[i].member.no,
                    recipientName: sendpreResult.data[i].member.memberName,
                    regDt: sendpreResult.data[i].regDt,
                    title: sendpreResult.data[i].title,
                    confirm: sendpreResult.data[i].confirm,
                    confirmName: sendpreResult.data[i].confirm == true ? xtrue : xfalse
                  })
                }
                senderTbody.innerHTML = senderTableGenerator(preinvitebySenderArr);

                if (requestPageNo == 1) {
                  $("#sendpreA").hide();
                } else {
                  $("#sendpreA").show();
                }
        
                if (totalPageSize == requestPageNo) {
                  $("#sendnextA").hide();
                } else {
                  $("#sendnextA").show();
                }
              }
            })
          }); //$("#sendpreA") click Event END

          //요청 메세지 모달 띄우기
          $("#senderTitle").on("click", function () {
            // console.log(memberInfo.no);
            $("#sendModal").modal("show");

            $.ajax({ //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기할 차례
              url: "/invitebox/get",
              type: "POST",
              data: {
                inviteNo : $("#senderTitle").attr("value"),
                senderNo : memberInfo.no
              },
              success: function (sendInviteResult) {
                console.log(sendInviteResult.data);
              }
            })

          })


          //요청 전체 체크박스          
          $(".send-all-check").click(function (e) {
            if ($(".send-all-check").is(":checked")) {
              $(".sender-table").find("input").prop("checked", true)
            } else {
              $(".sender-table").find("input").prop("checked", false)
            }
          });

          //요청 삭제 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!메세지 받는거 한 후에 confirm 별 권한 설정하기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
          $("#send-deleteBtn").on("click", function () {
            console.log("클릭");
            let deleteArr = [];
            $("input:checkbox[name=no]:checked").each(function() { 
              var choiceno = $(this).val();
              deleteArr.push({no : choiceno})
            })
            console.log(deleteArr);

            for (i = 0; i < deleteArr.length; i++) {
              $.ajax({
                url: '/invitebox/delete',
                type: "POST",
                data: { "no": deleteArr[i].no},
                success: function(result) {
                  window.alert("삭제되었습니다.")
                  location.href = "/minkyu/mypage/pickme.html";
                }
              })
            }
          }) //$("#send-deleteBtn") END
        }
      }) //초대 메세지 보낸거 뿌리기 END

      //픽미 게시글 화면에 뿌리기
      $.ajax({ 
        url: "/pickme/mypagelist",
        type: "POST",
        datatype: "json",
        data: {
          "pageSize": 3,
          "pageNo": 1,
          "memberNo" : memberInfo.no
        },
        success: function (pickmeResult) {
          // console.log(pickmeResult);
          let tbody = document.querySelector("#pickmeTable tbody");
          let trTemplate = document.querySelector("#tr-template");  
          let htmlGenerator = Handlebars.compile(trTemplate.innerHTML);
          let totalListCount = pickmeResult.totalListCount;
          let totalPageSize = pickmeResult.totalPageSize;
          let requestPageNo = pickmeResult.pageNo;
          
          if (totalListCount != 0) {
            tbody.innerHTML = htmlGenerator(pickmeResult.data);
          } else {
            $("#listnone").show();
          }
          
          $("#pageNo").text(requestPageNo); //번호 출력

          if (requestPageNo == 1) {
            $("#preA").hide();
          } else {
            $("#preA").show();
          }
    
          if (totalPageSize == requestPageNo) {
            $("#nextA").hide();
          } else {
            $("#nextA").show();
          }
          
          $("#preA").val(requestPageNo - 1);
          $("#nextA").val(requestPageNo + 1);
    
          $("#nextA").on("click", function () {
            $.ajax({ //픽미 게시글 화면에 뿌리기
              url: "/pickme/mypagelist",
              type: "POST",
              datatype: "json",
              data: { pageSize: 3,
                      pageNo: $("#nextA").val(),
                      memberNo: memberInfo.no},
              success: function (pickmeResult) {
                totalListCount = pickmeResult.totalListCount;
                totalPageSize = pickmeResult.totalPageSize;
                requestPageNo = pickmeResult.pageNo;
                $("#pageNo").text(requestPageNo);
                $("#preA").val(requestPageNo - 1);
                $("#nextA").val(requestPageNo + 1);
                tbody.innerHTML = htmlGenerator(pickmeResult.data);

                if (requestPageNo == 1) {
                  $("#preA").hide();
                } else {
                  $("#preA").show();
                }
        
                if (totalPageSize == requestPageNo) {
                  $("#nextA").hide();
                } else {
                  $("#nextA").show();
              }
              }
            })
          })

          $("#preA").on("click", function () { 
            $.ajax({ //픽미 게시글 화면에 뿌리기
              url: "/pickme/mypagelist",
              type: "POST",
              datatype: "json",
              data: { pageSize: 3,
                      pageNo: $("#preA").val(),
                      memberNo: memberInfo.no},
              success: function (pickmeResult) {
                totalListCount = pickmeResult.totalListCount;
                totalPageSize = pickmeResult.totalPageSize;
                requestPageNo = pickmeResult.pageNo;
                $("#pageNo").text(requestPageNo);
                $("#preA").val(requestPageNo - 1);
                $("#nextA").val(requestPageNo + 1);
                tbody.innerHTML = htmlGenerator(pickmeResult.data);

                if (requestPageNo == 1) {
                  $("#preA").hide();
                } else {
                  $("#preA").show();
                }
        
                if (totalPageSize == requestPageNo) {
                  $("#nextA").hide();
                } else {
                  $("#nextA").show();
                }
              }
            })
          })

          //삭제 전체 체크
          $(".pickme-all-check").click(function (e) {
            if ($(".pickme-all-check").is(":checked")) {
              $(".pickme-table").find("input").prop("checked", true)
            } else {
              $(".pickme-table").find("input").prop("checked", false)
            }
          });

          //삭제
          $("#pickme-deleteBtn").on("click", function () {
            console.log("클릭");
            let deleteArr = [];
            $("input:checkbox[name=no]:checked").each(function() { 
              var choiceno = $(this).val();
              deleteArr.push({no : choiceno})
            })
            
            for (i = 0; i < deleteArr.length; i++) {
              $.ajax({
                url: '/pickme/delete',
                type: "POST",
                data: { "no": deleteArr[i].no},
                success: function(result) {
                  window.alert("삭제되었습니다.")
                  location.href = "/minkyu/mypage/pickme.html";
                }
              })
            }         
          });
        }// pickme list success END
      })// pickme list END
    } //로그인 됐으면
  } //로그인 success END
}); //로그인 여부 확인 ajax END

// console.log(no);

