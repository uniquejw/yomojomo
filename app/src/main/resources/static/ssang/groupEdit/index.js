
// 신청서 생성
$(document).on("click","#create-applyForom",function(){
    $("#applyForm").show();  $("#create-applyForm-div").hide();

})

let xQuestionListCon = document.querySelector("#x-question-container");
let xQuestionList = document.querySelector(".x-question");
// 추가 이벤트
document.querySelector("#x-addQuestion-btn").onclick = function() {
var questionList = xQuestionList.cloneNode(true);
questionList.querySelector("#listmembName").value = "";
xQuestionListCon.append(questionList);
};

// 삭제 이벤트
function deleteDiv(e) {
    if (xQuestionListCon.childElementCount > 1) {
      xQuestionListCon.removeChild(e.target.parentNode);
    }
};

// 신청서 등록
var xQuestionCon = document.querySelector("#x-question-container")
document.querySelector("#x-aplly-form").onclick = function() {
    var xQuestions = xQuestionCon.querySelectorAll(".x-question");
    var qs;
    for (var xQuestion of xQuestions) {
        var question = xQuestion.querySelector("input");
        qs += `&questionName=${question.value}`
    }
    console.log(qs) //맨 앞에 undefined는 왜 뜨지? 
    window.Swal.fire({
    position: 'top-end',
    icon: 'success',
    title: 'Your work has been saved',
    showConfirmButton: false,
    timer: 1500
    })
}
document.querySelector("#x-reform").onclick = function() {
window.location.href = "index.html";
};