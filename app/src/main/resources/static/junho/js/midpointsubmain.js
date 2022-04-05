$(document).ready(function () {
    $('#header').load('/junho/mainHeader.html'); //헤더 인클루드
    $('#footer').load('/junho/mainfooter.html'); //푸터부분 인클루드
});

console.log('안녕')

var addBtnEl = document.querySelector('.add-people');
var inputListEl = document.querySelector('.midpoint .midpoint-input');
var inputListEls = document.querySelector('.midpoint .midpoint-input li');

var addBtnClickCount = 1;

console.log(addBtnEl)
console.log(inputListEl)
console.log(inputListEls)



addBtnEl.addEventListener('click', function() {
  console.log(addBtnClickCount++);
  var h5El = document.createElement('h5');
  h5El.innerHTML = `사용자${addBtnClickCount}`
  console.log(h5El)
  inputListEl.appendChild(h5El)
  inputListEl.appendChild(inputListEls.cloneNode(true))
})






