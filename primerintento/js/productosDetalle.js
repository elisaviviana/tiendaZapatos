//1-capturar id
//2-buscar con el id los datos del producto particular
//3 - arma html con los datos del productos

fetch('http://localhost:8081/producto/productos/9')
.then(function(respuesta){
  return respuesta.json();
})
.then(function(dataCruda){
  let produc = document.querySelector('.jsonproductoDetalle');

  dataCruda.forEach(function(elemento){

      let nuevorow = document.createElement('div');
      nuevorow.className = "col-md-6";
      produc.append(nuevorow);

  let imgdefault = 'img/productos/NoDisponible.png';
  if(elemento['img']== null && elemento['img']== ''&& elemento['img']== ' ' ){
    imgdefault = elemento['img'];
  }
  let img=document.createElement('img');
  img.src+=src=imgdefault;
      nuevorow.append(img);
  });
  
  console.log(dataCruda);
})
.catch(function(error){
  console.log('Descripción del Error:'+ error );
});




// <div class="col-md-6">
//   <img src="img/image2.jpg" style="width: 100%" height="100%">
// </div>
// <div class="col-md-6 my-auto">
//   <div class="info-right ">
//     <h2>Marca de Zapatos.</h2>
//     <p>descripcion del producto</p>
//     <label for="">Selecciona talle: </label>
//     <select  class="form-control form-control-sm" id="talle" name="talle">
//       <option value="" selected>Selecionar Talle</option>
//       <option value="31">31</option>
//       <option value="32" disabled>32</option>
//       <option value="40" >40</option>
//       <option value="42">42</option>
//     </select>
//     <a href="carrito.html" class="btn btn-outline-secondary btn-md mt-3 carcomprar">Comprar</a>
//   </div>
// </div>
