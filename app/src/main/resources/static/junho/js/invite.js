$(document).ready(function () {
  $('#header').load('/junho/mainHeader.html'); //헤더 인클루드
  $('#footer').load('/junho/mainfooter.html'); //푸터부분 인클루드
});

// 전체선택 함수
function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('member');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}

// 검색어 함수
function searchMember() {
  // var groupListItems = document.querySelectorAll('.list-group-item');
  // groupListItems.forEach((item) => {
  //   item.classList.add('list-search')
  // })
  var searchValue = document.querySelector('.invite .search input').value.toUpperCase();
  console.log(searchValue)

  var name;
  var items = document.querySelectorAll('.list-group-item-search');
  console.log(items)
  for(var i=0;i<items.length;i++){
    name = items[i].getElementsByClassName("member-name");
    console.log(name)
    if(name[0].innerHTML.toUpperCase().indexOf(searchValue) > -1){
      items[i].style.display = "flex";
    }else{
      items[i].style.display = "none";
    }
  }
}



