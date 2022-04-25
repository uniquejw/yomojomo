import{getGroupNO,getBoardNO, getLoginUser} from '/ssang/js/module.js';
var getGroup = getGroupNO();
var getBoard = getBoardNO();

// let user;
// (async function(){
//  const response = await getLoginUser()
// console.log("rrrrr:::::",response)
// user = response.data.no;
// console.log("user:::::",user)
// })()

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
      for(var comment of board.comments){
        if (comment.writer.no == loginUser.no){
          comment.isWriter = true;
        } else {
          comment.isWriter = false;
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