import{getGroupNO,getLoginUser,findgrouplistByGno,findgrouplistByMno} from '/ssang/js/module.js';
var getGroup = getGroupNO();//쿼리스트링에서 가져온 모임번호 
var loginUser = await getLoginUser() //로그인한 유저의 정보
var groupList = await findgrouplistByGno(getGroup) // 그룹번호로 조회한 모임과 회원정보 
var getGrade= await findgrouplistByMno(loginUser.data.no) // 로그인 유저 번호로 모임멤버 조회
console.log(groupList.data)
console.log(loginUser.data)
var loginUserGrade = getGrade.data[0].memberGrade.gradeName; //로그인한 유저의 grade
var arr = [];
for (var list of groupList.data){
  arr.push(list.member.no) 
}
if(arr.includes(loginUser.data.no) == false){ 
  // 모임에 가입된 유저가 아니라면 메인화면으로 이동시킨다
  window.alert("가입한 모임만 입장 가능합니다")
  location.replace("/junho/index.html")
}

// 로그인 정보 요청
fetch("/member/getLoginUser")
.then(function(res){
  return res.json()
})
.then(function(res) {
// 게시글 읽어오기
var writtenContainer = document.querySelector("#handlebars-container");
var divTemplate = document.querySelector("#div-template");
var htmlGenerator = Handlebars.compile(divTemplate.innerHTML);
fetch(`/board/findByGroupNo?no=${getGroup}`)
.then(function(response) {
  return response.json();
})
.then(function(boards){
  for (var board of boards) {
    if (board.writer.no == window.loginUser.no) {//게시글 작성자 인지 검사
      board.isWriter = true;
    } else {
      board.isWriter = false;
    }
    if(loginUserGrade == '모임장'){ // 모임장인지 검사
      board.isMaster = true;
    } else {
      board.isMaster = false;
    }

  }
  console.log(boards);
  writtenContainer.innerHTML = htmlGenerator({
    list : boards,
    user : window.loginUser
  });
})
})// fetch -> member/getLoginUser
// 댓글 등록
$(document).on("click", ".comment-btn", function() {
  var value = $(this).val()
  var input = $(`input[name=${value}]`).val()
  var fd = new FormData;
  fd.append('boardNo',value)
  fd.append('groupNo',getGroup)
  fd.append('content',input)
  fetch("/comment/add",{
  method:"post",
  body:fd
})
.then(res=>res.json())
.then(res=>{
  console.log(res.status)
  location.href=`index.html?gno=${getGroup}`
})
})
//--버튼클릭이벤트 -->
$(document).on("click",".new-post-btn",function(){
  window.location.href = `form.html?gno=${getGroup}`;
});
$(document).on("click",".board-edit",function(){
  var value = $(this).val()
  window.location.href = `view-board-edit.html?gno=${getGroup}&bno=${value}`;
})
$(document).on("click",".written-content",function(){
  var value = $(this).data('bno')
  window.location.href = `view.html?gno=${getGroup}&bno=${value}`;
})

