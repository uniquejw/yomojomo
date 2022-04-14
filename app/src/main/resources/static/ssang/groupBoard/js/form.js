
// ========================================Quill
var toolbarOptions = [
    ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
    ['blockquote', 'code-block'],
  
    // [{ 'header': 1 }, { 'header': 2 }],               // custom button values
    [{ 'list': 'ordered'}, { 'list': 'bullet' }],
    // [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
    [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
    // [{ 'direction': 'rtl' }],                         // text direction
  
    [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
    // [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
  
    [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
    // [{ 'font': [] }],
    [{ 'align': [] }],
    ['link', 'image'],
  
    // ['clean']                                         // remove formatting button
  ];
   var quill = new Quill('#editor', {
    modules: {
      toolbar: toolbarOptions
    },
      theme: 'snow'
    });

// ============================================게시글 읽어오기
    fetch("/board/list")
  .then(function(response){
    return response.json();
  })
    .then(function(boards){
      console.log(boards);
    });


// var xContent = document.querySelector("textarea");
// document.querySelector("#s-post-btn").onclick = function() {
//     if (xContent.value == "") {
//       window.alert("항목이 비어 있습니다.");
//       return;
//     }

    // var fd = new FormData(document.forms.namedItem("form1"));

    // fetch("/board/add", {
    // 	  method: "POST",
    // 	  body: fd
    //   }).then(function(response){}).then(function(t) {});
  // };
  document.querySelector("#s-cancel-btn").onclick = function() {
    window.location.href = "index.html";
  };