import{getGroupNO} from '/ssang/js/module.js';
var getGroup = getGroupNO();
console.log(getGroup)

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
  console.log(boards)
  
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
  window.location.href = `view.html?gno=${getGroup}`;
})

