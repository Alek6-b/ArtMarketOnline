function func(id){
	var xhr = new XMLHttpRequest();
	var url = "/ArtMarket/ProductDisplayServlet?id="+id;
	xhr.setRequestHeader("Content-Type","application/json");
	xhr.send();
	xhr.onreadystatechange = function(){
		if (xhr.readyState=== 4 && xhr.status === 200) {
			var json = JSON.parse(xhr.responseText);
			var outString = json.format + json.price;
			document.getElementById("productDisplay").innerHTML = outString;
		}
	}
	

}