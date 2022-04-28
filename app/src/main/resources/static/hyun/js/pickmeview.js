//헤더, 푸터, 권한 설정
$(document).ready(function () {
  $('#header').load('/junho/mainHeader.html'); //헤더 인클루드
  $('#footer').load('/junho/mainfooter.html'); //푸터부분 인클루드

  $.ajax({ //로그인 여부 확인 ajax START
      url : "/member/getLoginUser",
      type : "POST",
      datatype : "json",
      success : function(result) {
        if (result.status == "fail") {
          $("#x-invitation-btn").hide(); 
          $("#x-delete-btn").hide();
          $("#x-update-btn").hide();
        } else if (result.status == "success") {
          let loginUserNo = result.data.no; //로그인한 회원 번호
          fetch(`/pickme/get?no=${no}`) //글 작성자 확인 fetch-then-then START
          .then(function(response) {
            return response.json();
          })
          .then(function(result){
            let writerNo = result.data.member.no;

            if (writerNo != loginUserNo) {
              $("#x-delete-btn").hide();
              $("#x-update-btn").hide();
              $("input[name=title]").attr("disabled", true);
              $("#nameSi").attr("disabled", true);
              $("#nameGu").attr("disabled", true);
              $("#purpose").attr("disabled", true);
              $("#x-content").attr("disabled", true);              
            } else if (writerNo == loginUserNo) {
              $("#x-invitation-btn").hide();
              $("#x-cancel-btn").text("취소");
            }
          })//글 작성자 확인 fetch-then-then END
        }// else if
      }//success END
    }); //로그인 여부 확인 ajax END 
});//document.ready END

//화면 뿌리기 Start

//시,도 카테고리 카테고리 불러오기
let selectSiList = document.querySelector("#nameSi");
let selectSiOption = document.querySelector("#optionSi-template");
let opSiGernerator = Handlebars.compile(selectSiOption.innerHTML);

$.ajax({
  url : "/activeLocal/silistcate",
  type : "POST",
  async : false,
  success: function(result) {
      console.log(result.data);
      selectSiList.innerHTML = opSiGernerator(result.data);
  }
});
//시,도 카테고리 불러오기 END

//군,구 카테고리 불러오기
let selectGuList = document.querySelector("#nameGu");
let selectGuOption = document.querySelector("#optionGu-template");
let opGuGernerator = Handlebars.compile(selectGuOption.innerHTML);

$(document).on("click", "#nameSi", function() {
  //console.log("바뀜");
  $.ajax({
    url : "/activeLocal/gulistcate",
    type : "POST",
    async : false,
    data: {nameSi: $("#nameSi option:selected").val()},
    success: function(result) {
        console.log(result.data);
        selectGuList.innerHTML = opGuGernerator(result.data);
        if (selectedGuNo != 0) {
          $("#nameGu").val(selectedGuNo).prop("selected", true);
        }
    } //success END
  }); //ajax END
}); //nameSi change End
//군,구 카테고리 카테고리 불러오기 END

//관심 활동 리스트 불러오기 START
let selectPuposeList = document.querySelector("#purpose");
let selectPurposeOption = document.querySelector("#optionPurpose-template");
let PurposeopGernerator = Handlebars.compile(selectPurposeOption.innerHTML);

$.ajax({
    url : "/purpose/list",
    type : "POST",
    async : false,
    datatype : "json",
    success : function(result) {
      // console.log(result);
      selectPuposeList.innerHTML = PurposeopGernerator(result);
    }//success END
  })//ajax END
// 관심 활동 리스트 불러오기 END

let arr = location.href.split("?");

// console.log(arr);
if (arr.length == 1) {
  alert("요청 형식이 올바르지 않습니다.")
  throw "URL 형식 오류";
}
let qs = arr[1];

let params = new URLSearchParams(qs);
var no = params.get("no");

if(no == null) {
  alert("게시물 번호가 없습니다.");
  throw "파라미터 오류";
}

let xTitle = document.querySelector("input[name=title]");
let xNo = document.querySelector("input[name=no]");
let xregDt = document.querySelector("#reg_dt");
let xName = document.querySelector("#x-name");
let xViewCnt = document.querySelector("#x-viewCnt");
let xNameGu = document.querySelector("#nameGu");
let xPurpose = document.querySelector("#purpose");
let xPurposeName = document.querySelector("#purpose");
let xContent = document.querySelector("textarea");
let selectedGuNo = 0;
let purposeNo = 0;

fetch(`/pickme/get?no=${no}`)
  .then(function(response) {
    return response.json();
  })
  .then(function(result){
    if (result.status == "fail") {
      window.alert("서버 요청 오류!");
    } else {
      let pickmeCont = result.data;
      console.log(pickmeCont);  
      xTitle.value = pickmeCont.title;
      xNo.value = pickmeCont.no;
      xregDt.value = pickmeCont.date;
      xViewCnt.value = pickmeCont.viewCnt;
      xName.value = pickmeCont.member.memberName;
      $("#nameSi").val(pickmeCont.activeLocal.nameSi).prop("selected", true);
      selectedGuNo = pickmeCont.activeLocal.no;
      purposeNo = pickmeCont.purpose.no;
      xContent.value = pickmeCont.content;
      $('#nameSi').click();

      //초대하기 버튼 이벤트 시작
      document.querySelector("#x-invitation-btn").onclick = function() {
            let xModalName = document.querySelector("#recipient-name");
            xModalName.value = xName.value;
            let recipientNameno = pickmeCont.member.no;
            // console.log(recipientNameno);
            //로그인한 회원 정보 가져오기
            $.ajax({
              url : "/member/getLoginUser",
              type : "POST",
              datatype : "json",
              success : function(result) {
                console.log(result.data.no);
                console.log(result);
                if (result.status == "fail") {
                  $("#invitationbtn").hide(); //초대하기 버튼 숨기기
                  window.alert("로그인 하지 않았습니다.");
                  // console.log(result.status);
                } else {
                  var inviteeNo = result.data.no; //초대 보내는 사람 회원 번호
                  let selectGroupList = document.querySelector("#groupList");
                  var selectGroupOption = document.querySelector("#joinedGroupList-template");
                  var opGernerator = Handlebars.compile(selectGroupOption.innerHTML);

            $.ajax({ //초대 보내는 사람의 모임 리스트 가져오는 ajax
              url : "/joinmember/grouplistbymno",
              type : "POST",
              datatype : "json",
              data : {"member.no" : inviteeNo},
              success : function(result) {
                console.log(result.data);
                selectGroupList.innerHTML = opGernerator(result.data);
                    // 모임리스트 선택한 결과 값 알아내기
                    $("#groupList").on("change", function() {
                      // console.log("클릭함");
                        //초대하기 버튼 클릭 이벤트 시작
                        $("#invitationbtn").on("click", function() {
                          //서버 요청
                          $.ajax({
                            url : "/invitebox/send",
                            type : "POST",
                            async : false,
                            data : {
                              "title" : $("#title").val(),
                              "content" : $("#content").val(),
                              "member.no" : recipientNameno,
                              "joinMember.member.no" : inviteeNo,
                              "joinMember.group.no" : $("#groupList option:selected").val(),
                            },
                            success : function(result) {
                              console.log(result);
                              window.alert("발송되었습니다");
                              window.location.href = "index.html";
                            }
                          })//초대하기 서버 요청END
                        })//초대하기 버튼 클릭 이벤트 END
                      })//초대할 모임 선택확인
                  }//초대 보내는 사람의 모임 리스트 가져오는 suceess END
                })//초대 보내는 사람의 모임 리스트 가져오는 ajax END
              } //else 문(로그인 정보 가져오는) 끝
            } //로그인한 회원 정보 success END
          })//로그인한 회원정보 가져오기 ajax END
      }//초대하기 버튼 이벤트 END
    } //else END
  }); //화면 뿌리는 fetch END
//화면 뿌리기 END

//서버로 보내기
document.querySelector("#x-update-btn").onclick = function() {
let fd = new FormData(document.forms.namedItem("pickme-update"))    
// fd.append("no", no);

if(        
  xTitle.value == "" ||
  xNameGu.value == "전체" ||
  selectGuList.value == "군구 선택" ||
  selectSiList.value == 0 ||
  xPurpose.value == "" ||
  xContent.value == "") 
  {
    window.alert("필수 입력 항목이 비어 있습니다.")
    return;
  }

  fetch("/pickme/update", {
    method: "POST",
    body: new URLSearchParams(fd)
    })
    .then(function(response) {
    // console.log(response);
      return response.json();
    })
    .then(function(result) {
      console.log(result);
      if (result.status == "success") {
        window.alert("수정되었습니다.")
        location.href = "index.html";
      } else {
        window.alert("게시글 변경 실패");
        console.log(result.data);
      }
    });
  } //updatebtn Event END

//뒤로가기
document.querySelector("#x-cancel-btn").onclick = function() {
window.location.href = "index.html";
};

// 삭제
document.querySelector("#x-delete-btn").onclick = function() {
fetch(`/pickme/delete?no=${no}`)
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
    // console.log(result);
    if(result.status == "success") {
      window.alert("삭제되었습니다.");
      location.href = "index.html";
    } else {
      window.alert("삭제 실패");
      console.log(result.data);
    }
  });
};