
  // //태그 
  // $(document).on("click","#tag-post-btn",function(){
  //   var tag = document.querySelector(".posted-tags")
  //   var trTemplate = document.querySelector("#tag-template");
  //   var tagGenerator = Handlebars.compile(trTemplate.innerHTML);

  //   fetch("/groupTag/add")
  //   .then(function(res){
  //     return res.json()
  //   }).then(function(result){
  //     tag.innerHTML = tagGenerator(result);
  //   })    
  // })
  // 시 팝업
  document.querySelector("#local-btn").addEventListener("click", show);
  function show() {
    document.querySelector(".background-si").className = "background-si show";
  }

    var button = document.querySelector(".local-btn-div")
    var trTemplate = document.querySelector("#tr-template");
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

    var trTemplate = document.querySelector("#tr-template2");
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
      document.getElementById("myText").value = `${locals.no}`;
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

  //=========================닫기 버튼 이벤트=========================
  var cols = document.querySelectorAll(".btn-close");
  [].forEach.call(cols,function(col){
  col.addEventListener("click",close)
  })
  function close() {
  document.querySelector(".background-si").className = "background-si";
  document.querySelector(".background-gu").className = "background-gu";
  }

  var xFile = document.querySelector("input[name=file]")
  var xTitle = document.querySelector("#x-title")
  var xIntro = document.querySelector("#x-intro")
  var xPurpose = document.querySelector("#x-purpose")
  var xActiveLocalNo = document.querySelector("input[name=activeLocalNo]")
  

  $("#x-file").on('change',function(){
    var fileName = $("#x-file").val();
    $(".upload-name").val(fileName);
  });


//=======================모임 생성 =========================
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
    formData.append('GroupName',xTitle.value);
    formData.append('file',xFile.files[0]); 
    formData.append('intro',xIntro.value); 
    formData.append('purposeNo',xPurpose.value);
    formData.append('activeLocalNo',xActiveLocalNo.value);
    
  fetch("/group/add",{
    method : "POST",
    body : formData
  })
  .then(function(response){
    return response.json()
  })
  .then(function(result) {
    console.log(result);
    if (result.status == "success") {
      location.href = "/junho/index.html";
    } else {
      alert(result.data);
    }
  });
  
}