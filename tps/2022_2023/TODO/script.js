function ajouter(id_liste, tache, numero){
	var e = document.createElement("li");
	e.appendChild(document.createTextNode(tache));
	e.id = "li" + numero;
	
	e.onclick = function(){
		supprimer(id_liste, this.id);
	}
	
	var liste = document.getElementById(id_liste);
	liste.appendChild(e);
}

function supprimer(id_liste, id_li){
	var e = document.getElementById(id_li);
	var liste = document.getElementById(id_liste);
	liste.removeChild(e);
}
