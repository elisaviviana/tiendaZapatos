//fetch
// fetch('http://my-json-server.typicode.com/elisaviviana/jsonDH')

fetch('https://my-json-server.typicode.com/elisaviviana/jsonDH/productos')
   .then(function(respuesta){
      return respuesta.json();
   })
   .then(function(dataCruda){
     //console.log(dataCruda);
     // var lista = document.querySelector('ul');
     // var nuevoli = document.createElement('li');
     // var textoDelLi = document.createElement('soy un elemento');
     //
     // nuevoli.append(textoDelLi);
     // lista.append(nuevoli);
 let produc = document.querySelector('.jsonproducto');
 let nuevorow = document.createElement('div');
 nuevorow.className = "row ";
 produc.append(nuevorow);


dataCruda.forEach(function(elemento){
   // console.log(dataCruda[0]['id']);


if(elemento['id']%3==0){
  console.log("entro al ig ==0");
 let nuevorow = document.createElement('div');
 nuevorow.className = "row ";
 produc.append(nuevorow);

dataCruda.forEach(function(elemento){

     let nuevodiv = document.createElement('div');
      nuevodiv.className+="col-md-4 col-sm-4";
     console.log(nuevodiv);
     let nuevodiv2=document.createElement('div');
     nuevodiv2.className+="header-content-left";
     nuevodiv.append(nuevodiv2);
     let img=document.createElement('img');
     img.src+=src=elemento['img'];
     img.style=style="width: 100%;"
     nuevodiv2.append(img);
     let nuevoh4=document.createElement('h4');
     nuevoh4.className+="display-5";
     nuevoh4.innerHTML='Descripcion: '+elemento['desc'];
     nuevodiv2.append(nuevoh4);
     nuevop=document.createElement('p');
     nuevop.className+="mt-2";
     nuevop.innerHTML="Precio: $"+elemento['precio'];
     nuevodiv2.append(nuevop);

     nuevodiv3=document.createElement('div');
     nuevodiv3.className="mb-2 bg-success text-white text-center font-weight-bold text-decoration-none";

     nuevoa=document.createElement('a');
     nuevoa.className="text-reset";
     nuevoa.href="descripcion.html";
     nuevoa.innerHTML='Agregar al Carrito';
     nuevodiv3.append(nuevoa);
     nuevodiv2.append(nuevodiv3);
     nuevorow.append(nuevodiv);
        console.log(produc);


});
}else{
  console.log("entro al ig !=0");

  dataCruda.forEach(function(elemento){

       let nuevodiv = document.createElement('div');
        nuevodiv.className+="col-md-4 col-sm-4";
       console.log(nuevodiv);
       let nuevodiv2=document.createElement('div');
       nuevodiv2.className+="header-content-left";
       nuevodiv.append(nuevodiv2);
       let img=document.createElement('img');
       img.src+=src=elemento['img'];
       img.style=style="width: 100%;"
       nuevodiv2.append(img);
       let nuevoh4=document.createElement('h4');
       nuevoh4.className+="display-5";
       nuevoh4.innerHTML='Descripcion: '+elemento['desc'];
       nuevodiv2.append(nuevoh4);
       nuevop=document.createElement('p');
       nuevop.className+="mt-2";
       nuevop.innerHTML="Precio: $"+elemento['precio'];
       nuevodiv2.append(nuevop);

       nuevodiv3=document.createElement('div');
       nuevodiv3.className="mb-2 bg-success text-white text-center font-weight-bold text-decoration-none";

       nuevoa=document.createElement('a');
       nuevoa.className="text-reset";
       nuevoa.href="descripcion.html";
       nuevoa.innerHTML='Agregar al Carrito';
       nuevodiv3.append(nuevoa);
       nuevodiv2.append(nuevodiv3);
       nuevorow.append(nuevodiv);
          console.log(produc);


  });
}
 });



      // dataCruda.forEach(function(elemento){
      //    var pais = elemento['name'];
      //    let nuevoOption = document.createElement('option');
      //    nuevoOption.innerHTML = pais;
      //    //Aquí sería necesario agregar el atributo "value" de cada option y colocarle el valor correspondiente segun el codigo del pais (por ejemplo Argentina es "ar", chile es "cl", colombia es "co");
      //    selectPaises.append(nuevoOption);
      //    selectPaises.selectedIndex = 10; // seleccionamos por defecto Argentina
      // });
   })
   .catch(function(error){
      console.log('Descripción del Error: ' + error);
});
