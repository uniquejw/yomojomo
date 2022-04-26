import{getGroupNO,getLoginUser,findgrouplistByGno} from '/ssang/js/module.js';
var getGroup = getGroupNO();
var loginUser = await getLoginUser()
var groupList = await findgrouplistByGno(getGroup)
console.log(groupList.data)
console.log(loginUser.data.no)
var arr = [];
for (var list of groupList.data){
  arr.push(list.member.no) 
}
if(arr.includes(loginUser.data.no) == false){ 
  // 모임에 가입된 유저가 아니라면 메인화면으로 이동시킨다
  window.alert("모임에 가입하지 않았습니다.")
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
    if (board.writer.no == window.loginUser.no) {
      board.isWriter = true;
    } else {
      board.isWriter = false;
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

