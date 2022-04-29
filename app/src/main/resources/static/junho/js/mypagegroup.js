getLoginUser()
const swa = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-primary mx-2',
    cancelButton: 'btn btn-secondary mx-2'
  },
  buttonsStyling: false
})

$(".card").children("img").click(function(e){
  location.href = "/ssang/groupBoard/index.html"
})
$(".g-title").click(function(e){
  $("tr").removeClass("lately")
  $(e.target.closest("tr")).addClass("lately")
  $(".modal").modal("show")
})
$(".btn-cancel").click(function(e){
  e.stopPropagation();
  swa.fire({
    title: '신청을 취소하시겠습니까?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '신청 취소',
    cancelButtonText: '취소',
  }).then((result) => {
    if (result.isConfirmed) {
      $(e.target).closest(".card").remove()
      swa.fire(
        '신청이 취소되었습니다',
        '',
        'success'
      )
    }
  })
})
$(".btn-accept").click(function(e){
  e.stopPropagation();
  swa.fire({
    title: '가입을 수락하시겠습니까?',
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: '수락',
    cancelButtonText: '취소'
  }).then((result) => {
    if (result.isConfirmed) {
      $(".lately").remove()
      $(".modal").modal("hide")
      swa.fire(
        '가입을 수락하였습니다.',
        '',
        'success'
        )
      }
    })
  })
$(".btn-reject").click(function(e){
  e.stopPropagation();
  swa.fire({
    title: '가입을 거절하시겠습니까?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '거절',
    cancelButtonText: '취소'
  }).then((result) => {
    if (result.isConfirmed) {
      $(".lately").remove()
      $(".modal").modal("hide")
      swa.fire(
        '가입을 거절하였습니다.',
        '',
        'success'
        )
      }
    })
  })
  $(".all-check").click(function(e){
  if ($(".all-check").is(":checked")){
    $("input").prop("checked", true)
  } else {
    $("input").prop("checked", false)
  }
})
$(".btn-delete").click(function(e){
  if ($(".form-check-input").is(":checked") == false) {
    swa.fire(
    '글이 선택되지 않았습니다',
    '삭제할 글을 선택해주세요',
    'error'
    )} else {
      swa.fire({
      title: '글을 삭제 하시겠습니까?',
      text: '삭제하면 가입이 자동 거절됩니다',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '삭제',
      cancelButtonText: '취소',
    }).then((result) => {
      if (result.isConfirmed) {
        $(".all-check").prop("checked", false)
        $("input:checkbox:checked").each(function(){
          this.closest("tr").remove()
        })
        swa.fire(
          '삭제가 완료되었습니다',
          '',
          'success'
          )
      }
    })
  }
})


function getLoginUser() {
  var memberNo = 0;
  $.ajax({
    url: '/member/getLoginUser',
    type: "POST",
    dataType: 'json',
    success: function(result) {
      console.log(result)
      memberNo = result.data.no;
      console.log(memberNo)
      getSendList(memberNo)
    }
  })
}

var divApplyTemplate = document.querySelector("#div-applyList-template");
console.log(divApplyTemplate)
//템플릿 엔진 준비
var htmlGeneratorApply = Handlebars.compile(divApplyTemplate.innerHTML);

var sendHandlebarsEl = document.querySelector('.sendHandlebars');

function getSendList(i) {
  var data = {'sendMember.no': i}
  var groupList=[]
  $.ajax({
    url: '/mypage/group/sendApplyList',
    type: "POST",
    dataType: 'json',
    data: data,
    success: function(result) {
      for(var i = 0; i < result.length; i++) {
        if (result[i].group.logo == null) {
          result[i].group.logo = "default.png";
        }
        console.log(result[i])
        groupList.push(result[i].group)
      }
      console.log(groupList)
      
      sendHandlebarsEl.innerHTML =htmlGeneratorApply(groupList)
    }
  })
}







