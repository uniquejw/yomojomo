import{getGroupNO,getLoginUser,findgrouplistByGno,findgrouplistByMno,getBoardNO} from '/ssang/js/module.js';
var getGroup = getGroupNO();//쿼리스트링에서 가져온 모임번호 
var getBoard = getBoardNO();
var loginUser = await getLoginUser() //로그인한 유저의 정보
var groupList = await findgrouplistByGno(getGroup) // 그룹번호로 조회한 모임과 회원정보 
var getGrade= await findgrouplistByMno(loginUser.data.no) // 로그인 유저 번호로 모임멤버 조회
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

console.log(window.loginUser)
fetch("/member/getLoginUser")
.then(function(res){
  return res.json()
})
.then(function(result){
    var loginUser = result.data
//=============================================게시글 불러오기 
  var writtenContainer = document.querySelector("#handlebars-container");
  var commentTemplate = document.querySelector("#comment-template");
  var commentGenerator = Handlebars.compile(commentTemplate.innerHTML);
  fetch(`/board/findByBoardNo?no=${getBoard}`)
  .then(function(response) {
    return response.json();
  })
  .then(function(result){
    var boards = result.data
    for (var board of boards){
      console.log(board)
      $('.written-content').text(board.content)
      $('.written-author-name').text(board.writer.memberName)
      $('.written-createdTime').text(board.registDate)
      console.log(board.comments)
      for(var comment of board.comments){ //댓글 작성자 여부 검사
        if (comment.writer.no == loginUser.no){
          comment.isWriter = true;
        } else {
          comment.isWriter = false;
        }
        if(loginUserGrade == '모임장'){ // 모임장인지 검사
          comment.isMaster = true;
        } else {
          comment.isMaster = false;
        }
      }
      writtenContainer.innerHTML = commentGenerator(board);
    }
  })
})

// ============================================댓글 수정
$(document).on('click','.comment-edit',function() { 
  var value=$(this).val()
  var content=$(this).data()
  $(`div[data-cno=${value}]`).html(
    `<div class="input-group mb-3">
    <input type="text" class="form-control"   aria-label="Recipient's username" aria-describedby="button-addon2">
    <button class="btn btn-outline-secondary" type="button" id="button-addon2" value="${value}">수정</button>
  </div>`)
  $('.form-control').val(content.content)
})
$(document).on('click','#button-addon2',function() { 
  var value = $(this).val()
  var content = $('.form-control').val()
  var fd = new FormData()
  fd.append('no',value)
  fd.append('content',content)
  fetch("/comment/update",{
    method:"POST",
    body:fd
  })
  .then(function(res){
    return res.json()
  }).then(function(result){
    location.reload()
  })
})
  document.querySelector("#s-cancel-btn").onclick = function() {
    window.location.href = `index.html?gno=${getGroup}`;
  };
  //댓글 삭제 
$(document).on('click','.comment-delete',function(){
  var value = $(this).val();
  fetch(`/comment/delete?no=${value}`)
  .then(function(res){
    return res.json()
  }).then(function(result){
    location.reload()
  })
})