window.onload = function(){

  var divheader = document.querySelector(".menus");
  //var boton = document.querySelector(".btnheader");

  console.log(divheader);
//  console.log(boton);

  divheader.onclick = function () {
    divheader.style.height = "100vh";
  }
//  boton.onclick = function(){
//    divheader.style.zindex = "100%";
//    }
}
