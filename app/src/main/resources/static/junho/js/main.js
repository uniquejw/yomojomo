var memberNo = 0;
getLoginUser();
sugestionGroupList();
setTimeout(function() {
  console.log(memberNo)
  if (memberNo == undefined){
    $('.my-group').addClass("non-sign-in");
  } else {
    memberGroupList(memberNo)
  }
},1000)

var swiper = new Swiper(".mySwiper", {
  effect: "coverflow",
  grabCursor: true,
  centeredSlides: true,
  slidesPerView: "3",
  autoplay: {
    delay: 3000,
  },
  loop: true,
  coverflowEffect: {
    rotate: 50,
    stretch: 0,
    depth: 100,
    modifier: 1,
    slideShadows: true,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true
  },
  navigation : {
    prevEl : '.swiper-prev',
    nextEl : '.swiper-next'
  }
});

// ---------------------------------------------------------------
// 로그인 정보 가져오기

function getLoginUser() {
  $.ajax({
    url: '/member/getLoginUser',
    type: "POST",
    dataType: 'json',
    success: function(result) {
      console.log(result)
      memberNo = result.data.no;
    }
  })
}
// ---------------------------------------------------------------

// ---------------------------------------------------------------
// 비회원 그룹 리스트
var nonMemberGroupList = [];
// 템플릿 엔진에서 사용할 HTML 조각을 가져오기
var divNonMemberTemplate = document.querySelector("#div-nonmember-template");
console.log(divNonMemberTemplate)
//템플릿 엔진 준비
var htmlGeneratorNonMember = Handlebars.compile(divNonMemberTemplate.innerHTML);

function sugestionGroupList() {
  $.ajax({
    url: '/mainpage/group/nonmemberlist',
    type: "POST",
    dataType: 'json',
    success: function(result) {
      for (var group of result.data) {
        if (group.logo == null) {
          group.logo = "default.png";
        }
        nonMemberGroupList.push(group)
      }
      console.log(nonMemberGroupList)
      $('.suggestion').html(htmlGeneratorNonMember(nonMemberGroupList))
    }
  })
}
// ---------------------------------------------------------------

// ---------------------------------------------------------------
// 회원 그룹리스트
var memberGroupListData = [];

var divMemberTemplate = document.querySelector("#div-member-template");
console.log(divMemberTemplate)
//템플릿 엔진 준비
var htmlGeneratorMember = Handlebars.compile(divMemberTemplate.innerHTML);

function memberGroupList(memberNo) {
  var data = {'membNo': memberNo}
  $.ajax({
    url: '/mainpage/group/memberlist',
    type: "POST",
    dataType: 'json',
    data: data,
    success: function(result) {
      for (var group of result.data) {
        if (group.logo == null) {
          group.logo = "default.png";
        }
        memberGroupListData.push(group)
      }
      console.log(memberGroupListData)
      $('.my-group-handlebars').html(htmlGeneratorMember(memberGroupListData))
    }
  })
}

// ---------------------------------------------------------------
// 모임정보 팝업
const PATH = {
  'groupList' : '/group/list',
  'groupGet' : '/group/get',
  'applyQuestion' : '/applyQuestion/findQuestion'
}
$(document).on("click",".btn-show",function(){
  console.log('clcick')
  document.querySelector(".background").className = "background show";
  var value = $(this).attr('name'); // 그룹넘버
  console.log($(this).attr('name'))
  fetch(`${PATH.groupGet}?gno=${value}`)
  .then(function(response){
    return response.json()
  }).then(function(result){
    if (result.status == "fail") {
      window.alert("서버 요청 오류!");
      console.log(result.data);
      return;
    }
    if(result.data.logo == null){
      result.data.logo = "default.png";
    }
    
    document.querySelector(".popup-group-name").innerText = result.data.groupName;
    document.querySelector(".popup-group-content").innerText = result.data.intro;
    var path = "/group/photo?filename=" + result.data.logo
    document.querySelector('.main-logo').setAttribute("src", path)
    $('#apply-form-btn').val(result.data.no);
  })
})

// 가입신청서로 이동
$(document).on("click","#apply-form-btn",function(){
  //   document.querySelector(".background").className = "background";
  //   document.querySelector(".report-background").className = "report-background show";
    var value = $(this).val();//모임번호
    location.href=`/ssang/group/apply.html?gno=${value}`
  })

//닫기
$("button.btn-close").click((e) => {
  var dialog = e.target.getAttribute("data-dialog");
  $(`.${dialog}`).removeClass("show");
});






