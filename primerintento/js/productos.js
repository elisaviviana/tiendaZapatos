//fetch
fetch('https://my-json-server.typicode.com/elisaviviana/jsonDH')
   .then(function(respuesta){
      return respuesta.json();
   })
   .then(function(dataCruda){
     // var lista = document.querySelector('ul');
     // var nuevoli = document.createElement('li');
     // var textoDelLi = document.createElement('soy un elemento');
     //
     // nuevoli.append(textoDelLi);
     // lista.append(nuevoli);


      let produc = document.querySelector('.jsonproducto');
      let div1 = document.createElement('div');
      div1.className += " col-md-4 col-sm-4 ";
      produc.append(div1);

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



// <div class="col-md-4 col-sm-4 ">
//   <div class="header-content-left">
//     <img src="img/image1.jpg" style="width: 100%;">
//     <h4 class="display-5">Descripcion</h4>
//     <p class="mt-2">Numero: </p>
//
//     <div class="mb-2 bg-success text-white text-center font-weight-bold text-decoration-none"><a href="descripcion.html" class="text-reset">Agregar al Carrito</a></div>
//
//   </div>
// </div>
