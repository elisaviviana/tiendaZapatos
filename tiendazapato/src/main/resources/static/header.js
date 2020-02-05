window.onload = function(){

var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        document.getElementById("divheader").innerHTML = xmlhttp.responseText;
    }
}
xmlhttp.open("GET", "header.html", true);
xmlhttp.send();



var xmlhttp1 = new XMLHttpRequest();
xmlhttp1.onreadystatechange = function() {
    if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
        document.getElementById("divfooter").innerHTML = xmlhttp1.responseText;
    }
}
xmlhttp1.open("GET", "footer.html", true);
xmlhttp1.send();

}
