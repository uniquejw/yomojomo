
  // 시 팝업
  document.querySelector("#local-btn").addEventListener("click", show);
  
  function show() {
    document.querySelector(".background-si").className = "background-si show";
  }

  // 시정보 삽입
    var button = document.querySelector(".local-btn-div")
  
    // 템플릿 엔진에서 사용할 HTML 조각을 가져오기
    var trTemplate = document.querySelector("#tr-template");
    
    //템플릿 엔진 준비
    var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);
  
    fetch("/activeLocal/list").then(function(response){
      return response.json();
    })
    .then(function(locals){
      console.log(locals)
      button.innerHTML = htmlGenerator(locals);
    })
  
  // 군구 팝업
  $(document).on("click",".gungu-btn",function(){
  document.querySelector(".background-si").className = "background-si";
  document.querySelector(".background-gu").className = "background-gu show";
  var value = $(this).val();
  console.log(value);
  var button = document.querySelector(".local-btn-div2")

    // 템플릿 엔진에서 사용할 HTML 조각을 가져오기
    var trTemplate = document.querySelector("#tr-template2");
    
    //템플릿 엔진 준비, 구 버튼 삽입
    var htmlGenerator = Handlebars.compile(trTemplate.innerHTML);
  fetch(`/activeLocal/list-gu?nameGu=${value}`)
  .then(function(response){
      return response.json();
    })
    .then(function(locals){
      console.log(locals)
      button.innerHTML = htmlGenerator(locals);
    })
  })
  // 지역선택완료
  $(document).on("click",".no-btn",function(){
    document.querySelector(".background-gu").className = "background-gu";
    document.querySelector("#local-btn").className = "local-btn selected";
    document.querySelector(".cancel-local-btn").className = "cancel-local-btn show";
    document.querySelector(".correct-local").className = "correct-local";
    var value = $(this).val();
    console.log(value);
    fetch(`/activeLocal/get?no=${value}`)
    .then(function(response){
      return response.json();
    })
    .then(function(locals){
      console.log(locals);
      document.querySelector(".correct-local").innerHTML = `${locals.nameSi},${locals.nameGu}`;
    })
  })
  // 지역 선택 취소 
  // $(document).on("click",".cancel-local-btn",function(){
  //   document.querySelector(".cancel-local-btn").className = "cancel-local-btn";
  //   document.querySelector("#local-btn").className = "local-btn";
  // })
  document.querySelector(".cancel-local-btn").addEventListener("click", cancelLocal);
  
  function cancelLocal() {
    document.querySelector(".cancel-local-btn").className = "cancel-local-btn";
    document.querySelector(".local-btn").className = "local-btn";
    document.querySelector(".correct-local").className = "correct-local selected";
  }

  //닫기 버튼 이벤트
  var cols = document.querySelectorAll(".btn-close");
  [].forEach.call(cols,function(col){
  col.addEventListener("click",close)
  })
  function close() {
  document.querySelector(".background-si").className = "background-si";
  document.querySelector(".background-gu").className = "background-gu";
  }


//   모임 생성 
document.querySelector("#create-btn").addEventListener("click", create);
function create() {
    fetch("/group/insert").then(function(response){}).then(function(){})
}