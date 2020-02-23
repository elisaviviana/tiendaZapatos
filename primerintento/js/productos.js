//fetch
// fetch('http://my-json-server.typicode.com/elisaviviana/jsonDH')
//fetch('https://my-json-server.typicode.com/elisaviviana/jsonDH/productos')
//fetch('http://localhost:8081/producto/productos', { mode: 'no-cors'})
fetch('http://localhost:8081/producto/productos')
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
      let imgdefault = '/img/imagenNoDisponible.png';
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
    nuevodiv2.className+="header-content-left width_71";
    nuevodiv.append(nuevodiv2);
    let img=document.createElement('img');
    if(elemento['img']!= null && elemento['img']!= ''&& elemento['img']!= ' ' ){
      imgdefault = elemento['img'];
    }
  //  img.src+=src=elemento['img'];
    img.src+=src=imgdefault;
      img.style=style="width: 40%;"
    nuevodiv2.append(img);

    let nuevohp=document.createElement('p');
    nuevohp.className+="mt-2";
    nuevohp.innerHTML=elemento['descripcion'];
    nuevodiv2.append(nuevohp);
    nuevoh=document.createElement('h5');
    nuevoh.className+="display-6 price";
    nuevoh.innerHTML="$"+elemento['precio'];
    nuevodiv2.append(nuevoh);
    nuevodiv3=document.createElement('div');
    nuevodiv3.className="mb-2 bg-success text-white text-center font-weight-bold text-decoration-none";
    nuevoa=document.createElement('a');
    nuevoa.className="text-reset";
    nuevoa.href="descripcion.html?id="+elemento['id'];
    nuevoa.innerHTML='+info';
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
  console.log('Descripción del Error: '+   error );
});
