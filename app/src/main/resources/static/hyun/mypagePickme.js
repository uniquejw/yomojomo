$.ajax({ //로그인 여부 확인 ajax START 비회원은 등록버튼 감춘다.
  url : "/member/getLoginUser",
  type : "POST",
  datatype : "json",
  success: function (result) {
    var memberInfo = result.data;
    if (result.status == "fail") {
      location.href="/junho/index.html";
    } else { 

      //초대 메세지 보기
      


      $.ajax({ //픽미 게시글 화면에 뿌리기
        url: "/pickme/mypagelist",
        type: "POST",
        datatype: "json",
        data: {
          pageSize: 3,
          pageNo: 1,
          memberNo : memberInfo.no
        },
        success: function (result) {
          console.log(result);
          let tbody = document.querySelector("#pickmeTable tbody");
          let trTemplate = document.querySelector("#tr-template");  
          let htmlGenerator = Handlebars.compile(trTemplate.innerHTML);
          let totalListCount = result.totalListCount;
          let totalPageSize = result.totalPageSize;
          let requestPageNo = result.pageNo;
          
          if (totalListCount != 0) {
            console.log("참");
            tbody.innerHTML = htmlGenerator(result.data);
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
              success: function (result) {
                totalListCount = result.totalListCount;
                totalPageSize = result.totalPageSize;
                requestPageNo = result.pageNo;
                $("#pageNo").text(requestPageNo);
                $("#preA").val(requestPageNo - 1);
                $("#nextA").val(requestPageNo + 1);
                tbody.innerHTML = htmlGenerator(result.data);

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
              success: function (result) {
                totalListCount = result.totalListCount;
                totalPageSize = result.totalPageSize;
                requestPageNo = result.pageNo;
                $("#pageNo").text(requestPageNo);
                $("#preA").val(requestPageNo - 1);
                $("#nextA").val(requestPageNo + 1);
                tbody.innerHTML = htmlGenerator(result.data);

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
            $("input:checkbox[name=no]:checked").each(function() { //선택된 멤버 번호 배열로 빼기
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

