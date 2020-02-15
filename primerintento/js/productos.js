//fetch
// fetch('http://my-json-server.typicode.com/elisaviviana/jsonDH')

//fetch('https://my-json-server.typicode.com/elisaviviana/jsonDH/productos')
fetch('http://localhost:8081/producto/productos')
//muy importante empezar en 0 el id de los productos, para que distribulla bien los row
.then(function(respuesta){
  return respuesta.json();
})
.then(function(dataCruda){
  let produc = document.querySelector('.jsonproducto');
  let cantidad = 0;
  let nuevorow = document.createElement('div');
  nuevorow.className = "row ";
  produc.append(nuevorow);
  rowultimo = nuevorow;
  //recorremos cada elemento para crear el html
  dataCruda.forEach(function(elemento){
    //si tenemos tres elementos creamos un nuevo row
    // if(elemento['id']%3==0){
    //   console.log("entro al ig ==0");
    //   let nuevorow = document.createElement('div');
    //   nuevorow.className = "row ";
    //   produc.append(nuevorow);
    //   rowultimo = nuevorow;
    // }
    console.log(cantidad);
    while (cantidad==3) {
      let nuevorow = document.createElement('div');
      nuevorow.className = "row ";
      produc.append(nuevorow);
      rowultimo = nuevorow;
      cantidad =0;
}

    let nuevodiv = document.createElement('div');
    nuevodiv.className+="col-md-4 col-sm-4";
    let nuevodiv2=document.createElement('div');
    nuevodiv2.className+="header-content-left";
    nuevodiv.append(nuevodiv2);
    let img=document.createElement('img');
    img.src+=src=elemento['img'];
    img.style=style="width: 100%;"
    nuevodiv2.append(img);
    let nuevoh4=document.createElement('h4');
    nuevoh4.className+="display-5";
    nuevoh4.innerHTML='Descripcion: '+elemento['descripcion'];
    nuevodiv2.append(nuevoh4);
    nuevop=document.createElement('p');
    nuevop.className+="mt-2";
    nuevop.innerHTML="Precio: $"+elemento['precio'];
    nuevodiv2.append(nuevop);
    nuevodiv3=document.createElement('div');
    nuevodiv3.className="mb-2 bg-success text-white text-center font-weight-bold text-decoration-none";
    nuevoa=document.createElement('a');
    nuevoa.className="text-reset";
    nuevoa.href="descripcion.html?imagen=elemento['img']&descripcion=elemento['descripcion']&elemento['precio']";
    nuevoa.innerHTML='Agregar al Carrito';
    nuevodiv3.append(nuevoa);
    nuevodiv2.append(nuevodiv3);
    rowultimo.append(nuevodiv);
    cantidad = cantidad+1;

  });

  console.log(produc);

  //Ejemplo de Jesus
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
