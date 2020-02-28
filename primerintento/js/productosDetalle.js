//1-capturar id
//2-buscar con el id los datos del producto particular
//3 - arma html con los datos del productos
let id=document.querySelector('#id')


fetch('http://localhost:8081/producto/productos/'+id)
.then(function(respuesta){
  return respuesta.json();
})
.then(function(dataCruda){
  let produc = document.querySelector('.jsonproductoDetalle');
  console.log(dataCruda);
  let nuevorow = document.createElement('div');
nuevorow.className = "col-md-6";
produc.append(nuevorow);

let imagen = 'img/productos/NoDisponible.png';
if(dataCruda['img']!= null && dataCruda['img']!= '' && dataCruda['img'] != ' ' ){
   imagen = dataCruda['img'];
 }
let img=document.createElement('img');
img.src+=src=imagen;
img.style="width: 50%;height: 100%";




nuevorow.append(img);

let nuevorow1 = document.createElement('div');
nuevorow1.className = "col-md-6 my-auto";


let nuevorow2 = document.createElement('div');
nuevorow2.className = "info-right";

let h2 = document.createElement('h2');
h2.innerHTML = dataCruda['marca'];


let p = document.createElement('p');
p.innerHTML = dataCruda['descripcion'];


let label = document.createElement('label');
label.innerHTML = 'Selecciona talle:';

let select = document.createElement('select');
select.className = "form-control form-control-sm";
select.name = "talle";

let link = document.createElement('a');
link.className = 'btn btn-outline-secondary btn-md mt-3 carcomprar';
link.href = "carrito.html";
link.innerHTML = "Comprar";





nuevorow1.append(nuevorow2);
nuevorow2.append(h2);
produc.append(nuevorow1);
nuevorow2.append(p);
nuevorow2.append(label);
nuevorow2.append(select);
nuevorow2.append(link);









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
