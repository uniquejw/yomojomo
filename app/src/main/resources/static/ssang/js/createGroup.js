
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
    document.querySelector("#local-btn").className = "local-btn a11y-hidden";
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
    document.querySelector(".cancel-local-btn").className = "cancel-local-btn a11y-hidden";
    document.querySelector(".local-btn").className = "local-btn";
    document.querySelector(".correct-local").className = "correct-local a11y-hidden";
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

  var xTitle = document.querySelector("#x-title")
  var xIntro = document.querySelector("#x-intro")
  var xPurpose = document.querySelector("#x-purpose")
  

  $("#x-file").on('change',function(){
    var fileName = $("#x-file").val();
    $(".upload-name").val(fileName);
  });
//   모임 생성 
document.querySelector("#create-btn").onclick = function() {
  if (xTitle.value == "" || xIntro.value == "" || xPurpose.value == "") {
    Swal.fire({
      icon: 'error',
      title: '잠시만요!!',
      text: '필수입력사항(*)을 기재해 주세요',
      footer: ''
    })
    return;
  }

  var formData = new FormData(); // new FromData()로 새로운 객체 생성
    formData.append('name','hyemin');
    formData.append('item','hi'); // <input name="item" value="hi"> 와 같다.
    formData.append('item','hello'); // <input name="item" value="hello">

  // fetch("/group/add",{
  //   method : "POST",
  //   body : ?
  // })
  // .then(function(response){

  // }).then(function(){})
}