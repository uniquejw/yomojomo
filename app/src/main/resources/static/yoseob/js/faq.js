var boardCardDiv = document.querySelector(".faq_tr")
// const lightBtn = document.querySelector(".category");

function allList() {
  fetch("/faq/list")
    .then(function(response) {
      console.log("aaaaaaaaaaaaaaaaaaa");
      return response.json()
    })
    .then(function(boards) {
      for (var i = 0; i < boards.length; i++) {
        var tr = document.createElement("tr")
        // div.classList.add("card-body")
        tr.innerHTML = `
        <td>${boards[i].maincateno}</td><td>${boards[i].title}</td>
        
        `
        boardCardDiv.appendChild(tr)
      }
    })
}

