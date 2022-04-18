var boardCardDiv = document.querySelector(".announcement_tr")
// const lightBtn = document.querySelector(".category");

function allList() {
  fetch("/notice/list")
    .then(function(response) {
      return response.json()
    })
    .then(function(boards) {
      for (var i = 0; i < boards.length; i++) {
        var tr = document.createElement("tr")
        // div.classList.add("card-body")
        tr.innerHTML = `
        <td>${boards[i].no}</td><td>${boards[i].cate}</td><td>${boards[i].title}</td><td>${boards[i].regDate}</td>
        `
        boardCardDiv.appendChild(tr)
      }
    })
}

