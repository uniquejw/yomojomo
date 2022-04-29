import{getGroupNO,getLoginUser,findgrouplistByGno} from '/ssang/js/module.js';
var getGroup = getGroupNO();//쿼리스트링에서 가져온 모임번호 
var loginUser = await getLoginUser() //로그인한 유저의 정보
var groupList = await findgrouplistByGno(getGroup) // 그룹번호로 조회한 모임과 회원정보 
console.log(loginUser.data)
var membContainer = document.querySelector("#membContainer");
var membTemplate = document.querySelector('#memb-template') 
var membGenerator = Handlebars.compile(membTemplate.innerHTML);
for (var list of groupList.data){
    console.log(list)
    if(list.memberGrade.gradeName == '모임장'){
        $('.x-memb-name').text(list.member.memberName)
    }
}
membContainer.innerHTML= membGenerator(groupList.data)

// 멤버 신고 
var xTitle = document.querySelector('#recipient-name');
var xContent =document.querySelector('#message-text');
$(document).on("click", ".memb-report", function() {
  var value = $(this).val();
  console.log(value)
  $(document).on("click", "#memb-report-exactly", function() {
    console.log('클릭')
    if(xTitle.value == "" || xContent.value == ""){
      alert("신고사유를 작성해주세요");
      return;
    }
    var fd = new FormData(document.forms.namedItem("form1"));
    fd.append('reported',value)
    fd.append('rptCateNo',1)
    fetch("/report/add",{
      method : "POST",
      body : fd
    }).then(function(res){
      return res.json();
    }).then(function(result){
        if(result.status == 'success'){
      alert("신고가 완료되었습니다.")
      location.reload();
        }
    })
  })
})///멤버 신고 끝