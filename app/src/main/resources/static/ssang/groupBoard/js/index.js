//-- 핸들바 -->
  var writtenContainer = document.querySelector("#handlebars-container");

  var divTemplate = document.querySelector("#div-template");

  var htmlGenerator = Handlebars.compile(divTemplate.innerHTML);

  fetch("/board/list")
  .then(function(response) {
    return response.json();
  })
  .then(function(boards){
    console.log(boards)
    writtenContainer.innerHTML = htmlGenerator(boards);
  })

//--버튼클릭이벤트 -->
  document.querySelector(".new-post-btn").onclick = function() {
    window.location.href = "form.html";
  };
  $(document).on("click",".board-edit",function(){
    window.location.href = "view.html";
  })