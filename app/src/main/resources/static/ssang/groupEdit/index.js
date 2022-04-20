import{getGroupNO} from '/ssang/js/module.js';
var groupNo = getGroupNO(); 


// 신청서 생성
// $(document).on("click","#create-applyForom",function(){
//     $("#applyForm").show();  $("#create-applyForm-div").hide();
// })
// 추가 이벤트
document.querySelector("#x-addQuestion-btn").onclick = function() {
var questionList = xQuestionList.cloneNode(true);
questionList.querySelector("#listQuestionName").value = "";
xQuestionListCon.append(questionList);
};

//신청서 등록 현황 
var br = document.querySelector("#accordion-body")
var brTemplate = document.querySelector("#br-template");
var htmlGenerator = Handlebars.compile(brTemplate.innerHTML);
fetch(`/applyQuestion/findQuestion?no=${groupNo}`)
  .then(function(res){
    return res.json()
  }).then(function(result){
    console.log(result.data)
    br.innerHTML = htmlGenerator(result.data);
  })



// 신청서 등록
var xQuestionCon = document.querySelector("#x-question-container")
document.querySelector("#x-apply-form").onclick = function() {
    var xQuestions = xQuestionCon.querySelectorAll(".x-question");
    var qs="";
    for (var xQuestion of xQuestions) {
        var question = xQuestion.querySelector("input");
        qs += `&questionName=${question.value}`
    }
    fetch(`/applyQuestion/add?no=${groupNo}${qs}`)
      .then(function(res){
        return res.json()
      }).then(function(result){
        // location.href=`/ssang/groupEdit/index.html?no=${groupNo}`
      })
    // window.Swal.fire({
    // position: 'top-end',
    // icon: 'success',
    // title: 'Your work has been saved',
    // showConfirmButton: false,
    // timer: 1500
    // })
}
// 신청서 초기화
// document.querySelector("#x-reform").onclick = function() {
//   fetch("/applyQuestion/delete")
//     .then(function(res){
//       return res.text()
//     }).then(function(no){
//       // window.location.href = `index.html?no=${groupNo}`;
//     })

// };


