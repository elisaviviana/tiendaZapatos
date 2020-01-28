fetch('https://restcountries.eu/rest/v2/all')
   .then(function(respuesta){
      return respuesta.json();
   })
   .then(function(dataCruda){
      let selectPaises = document.querySelector('select[name=pais]');
      dataCruda.forEach(function(elemento){
         var pais = elemento['name'];
         let nuevoOption = document.createElement('option');
         nuevoOption.innerHTML = pais;
         //Aquí sería necesario agregar el atributo "value" de cada option y colocarle el valor correspondiente segun el codigo del pais (por ejemplo Argentina es "ar", chile es "cl", colombia es "co");
         selectPaises.append(nuevoOption);
         selectPaises.selectedIndex = 10; // seleccionamos por defecto Argentina
      });
   })
   .catch(function(error){
      console.log('Descripción del Error: ' + error);
});
