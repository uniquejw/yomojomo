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





// ============================================게시글 입력
$('#s-post-btn').on('click', () => { 
  var xContent = document.getElementById("xx-content")
  if (xContent.value == ""){
    Swal.fire({
      icon: 'warning',
      title: '잠시만요',
      text: '작성된 내용이 없어요',
      footer: ''
    })
    return;
  }
  // var formData = new FormData();
  // formData.append('content',xContent.value)
  // formData.append('no',getBoard)
  // formData.append('groupNo',getGroup)
  fetch(`/board/findByBoardNo?no=${getBoard}`)
  .then(res => res.json())
  .then(res => {
    console.log(res.status)
    location.href=`index.html?gno=${getGroup}`
  });
})
  document.querySelector("#s-cancel-btn").onclick = function() {
    window.location.href = `index.html?gno=${getGroup}`;
  };