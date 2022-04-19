const PATH = {
  'groupList' : '/group/list',
  'groupGet' : '/group/get',
  'applyQuestion' : '/applyQuestion/findQuestion'
}

// 모임리스트
var writtenContainer = document.querySelector("#handlebars-container");
var divTemplate = document.querySelector("#div-template");
var htmlGenerator = Handlebars.compile(divTemplate.innerHTML);
fetch(PATH.groupList)
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
    if (result.status == "fail") {
        window.alert("서버 요청 오류!");
        console.log(result.data);
        return;
    }
    for (var group of result.data) {
      if (group.logo == null) {
        group.logo = "default.png";
      }
      writtenContainer.innerHTML = htmlGenerator(result.data);
    }
  });

  // 시,도 카테고리불러오기
  let selectSiList = document.querySelector("#nameSi");
  var selectSiOption = document.querySelector("#optionSi-template");
  var opGernerator = Handlebars.compile(selectSiOption.innerHTML);

  $.ajax({
    url : "/activeLocal/silistcate",
    type : "POST",
    async : false,
    success: function(result) {
        // console.log(result.data);
        selectSiList.innerHTML = opGernerator(result.data);
    }
  });

  // 군구 불러오기
  let selectGuList = document.querySelector("#nameGu");
  var selectGuOption = document.querySelector("#optionGu-template");
  var opGernerator = Handlebars.compile(selectGuOption.innerHTML);

  $(document).on("click", "#nameSi", function() {
    // console.log("바뀜");
    $.ajax({
      url : "/activeLocal/gulistcate",
      type : "POST",
      async : false,
      data: {nameSi: $("#nameSi option:selected").val()},
      success: function(result) {
          console.log(result.data);
          selectGuList.innerHTML = opGernerator(result.data);
      }
    }); //ajax END
  }); //nameSi change End

  //목적 카테고리  불러오기 
  let selectPurposeList = document.querySelector("#selectPurpose");
  var selectPurOption = document.querySelector("#optionPurpose-template");
  var purOpGernerator = Handlebars.compile(selectPurOption.innerHTML);
  $(document).on("click", "#nameGu", function() {
    // console.log("바뀜");
    $.ajax({
      url : "/purpose/list",
      type : "POST",
      async : false,
      success: function(result) {
        console.log(result)
        selectPurposeList.innerHTML = purOpGernerator(result);
      }
    }); 
  }); 

  // 전체를 선택하면 게시글 리스트 불러오기 
  $("#nameSi").on("click", function() {  
    if ($("#nameSi option:selected").val() == 0) {
      fetch(PATH.groupList)
      .then(function(response) {
        return response.json();
      })
      .then(function(result) {
        if (result.status == "fail") {
          window.alert("서버 요청 오류!");
          console.log(result.data);
          return;
        } else {
          console.log(result);
          writtenContainer.innerHTML = htmlGenerator(result.data);
        }
      });
    }
  })
  
  // 시, 도 카테고리 선택하면 게시글 리스트 불러오기
  $("#nameSi").on("click", function() {
    console.log("바뀜");
    $.ajax({
      url : "/group/selectedSicate",
      type : "POST",
      async : false,
      data : {"activeLocal.nameSi" : $("#nameSi option:selected").val()},
      success : function(result) {
        console.log({"activeLocal.nameSi" : $("#nameSi option:selected").val()})
        console.log(result.data);
        writtenContainer.innerHTML = htmlGenerator(result.data);
      }
    }) //ajax END
  });//nameSi change End
  
  
  // 군, 구 카테고리 선택하면 게시글 리스트 불러오기
  $("#nameGu").on("click", function() { //id가 nameGu를 클릭하면 발생되는 이벤트 시작
    if ($("#nameGu option:selected").text() == "군구 선택") {
    console.log("바뀜");
    $.ajax({
      url : "/group/selectedSicate",
      type : "POST",
      async : false,
      data : {"activeLocal.nameSi" : $("#nameSi option:selected").val()},
      success : function(result) {
        console.log({"activeLocal.nameSi" : $("#nameSi option:selected").val()})
        console.log(result.data);
        writtenContainer.innerHTML = htmlGenerator(result.data);
      }
    }) //ajax END
  } 
    $.ajax({
      url : "/group/selectedGucate", //url 요청
      type : "POST",
      async : false,
      data : {"activeLocal.no" : $("#nameGu option:selected").val()}, //파라미터로 gms_activelocal의 번호를 보낸다.
      success : function(result) { //받아온 list로 handlebars를 화면에 나오게 한다.
        console.log(result.data);
        writtenContainer.innerHTML = htmlGenerator(result.data);
      }
    }) //ajax END
  });//nameGu change End //id가 nameGu를 클릭하면 발생되는 이벤트 끝

  // 모임목적 카테고리 선택하면 게시글 리스트 불러오기
  $(document).on("click", "#selectPurpose", function() { //id가 nameGu를 클릭하면 발생되는 이벤트 시작
    if ($("#nameGu option:selected").text() == "군구 선택") {
      alert("지역을 입력하세요")
    } else if ($("#selectPurpose option:selected").text() != "모임목적") {
    console.log("바뀜");
    $.ajax({
      url : "/group/selectedPurpcate", //url 요청
      type : "POST",
      async : false,
      data : {"activeLocal.no" : $("#nameGu option:selected").val(),
              "purpose.no":$("#selectPurpose option:selected").val()}, //파라미터로 gms_activelocal의 번호를 보낸다.
      success : function(result) { //받아온 list로 handlebars를 화면에 나오게 한다.
        console.log(result.data);
        writtenContainer.innerHTML = htmlGenerator(result.data);
      }
    }) //ajax END
  }
  });


// 모임정보 팝업
$(document).on("click","button.btn-show",function(){
  document.querySelector(".background").className = "background show";
  var value = $(this).val();
  fetch(`${PATH.groupGet}?no=${value}`)
  .then(function(response){
    return response.json()
  }).then(function(result){
    if (result.status == "fail") {
      window.alert("서버 요청 오류!");
      console.log(result.data);
      return;
    }
    if(result.data.logo == null){
      result.data.logo = "default.png";
    }
    
    document.querySelector(".popup-group-name").innerText = result.data.groupName;
    document.querySelector(".popup-group-content").innerText = result.data.intro;
    var path = "/group/photo?filename=" + result.data.logo
    document.querySelector('.main-logo').setAttribute("src", path)
    $('#apply-form-btn').val(result.data.no);
  })
})

// 가입신청서 팝업
$(document).on("click","#apply-form-btn",function(){
  document.querySelector(".background").className = "background";
  document.querySelector(".report-background").className = "report-background show";
  var value = $(this).val();//모임번호
  // 사진
  fetch(`${PATH.groupGet}?no=${value}`)
    .then(function(response){
    return response.json()
    })
    .then(function(result){
      console.log(result.data)
      if (result.status == "fail") {
        window.alert("서버 요청 오류!");
        console.log(result.data);
        return;
      }
      if(result.data.logo == null){
        result.data.logo = "default.png";
      }
      var path2 = "/group/photo?filename=" + result.data.logo
      document.querySelector('.main-logo2').setAttribute("src", path2)
    });
    
  // 질문목록
  fetch(`/applyform/findQuestion?no=${value}`)
    .then(function(res) {
      return res.json();
    })
    .then(function(result) {
      console.log(result.data[0])
      if (result.status == "fail") {
        window.alert("서버 요청 오류!");
        return;
      }
      
      // 핸들바
      var writtenContainer = document.querySelector("#handlebars-container2");
      var divTemplate = document.querySelector("#applyList-template");
      var htmlGenerator = Handlebars.compile(divTemplate.innerHTML);
      writtenContainer.innerHTML = htmlGenerator(result.data);
      $('#apply').val(result.data[0].no);
    });

//신청하기
$(document).on("click","#apply",function(){
  var value = $(this).val();//appl_no
  // var fd = new FormData();
  var answerLength = $("input[name=answer]").length;//값들의 갯수 -> 배열 길이를 지정
  var answers = new Array(answerLength);//배열 생성
  //배열에 값 주입
  for(var i=0; i<answerLength; i++){                          
    answers[i] = $("input[name=answer]").eq(i).val();
  }
  // fd.append('answer',answers)
  // fd.append('answer',document.querySelector("textarea[name=answer]").value)
  // fd.append('applyNo',value)
  answers.push(document.querySelector("textarea[name=answer]").value)
  console.log(answers)
  fetch('/applyAnswer/add',{
    method:"POST",
    body: {
      'answers':`${answers}`,
      'applyNo':`${value}`
    }
  })
  .then(function(res){
    return res.json()
  }).then(function(result){
    location.href="/minkyu/mypage/index.html"
   })
})


//닫기
var cols = document.querySelectorAll("button.btn-close");
[].forEach.call(cols,function(col){
  col.addEventListener("click",close)
})
$(document).on("click",function(e){
  if($(".background").is(e.target)){
    console.log("출력")
    $(".background").css({visibillty:"hidden",
  opacity:0})
  }
})
function close() {
  document.querySelector(".report-background").className = "report-background";
  document.querySelector(".background").className = "background";
}


    
    
    // document.querySelector("#x-create-btn").onclick = function(){
    //   location.href="form.html";
    // };






    // 버튼클릭이벤트 
      // document.querySelector(".new-post-btn").onclick = function() {
      //   window.location.href = "form.html";
      // };
      // $(document).on("click",".board-edit",function(){
      //   window.location.href = "view.html";
      // })

