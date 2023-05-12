var actuel = -1;

var mes_donnees = [];

function ajouter() {
    var personne = {
        code: document.getElementById("code").value,
        nom: document.getElementById("nom").value,
        prenom: document.getElementById("prenom").value,
        email: document.getElementById("email").value
    };

    mes_donnees.push(personne);
    afficher();
}

function modifier(i){
    var q = mes_donnees[i];
    
    document.getElementById("code").value = q.code;
    document.getElementById("nom").value = q.nom;
    document.getElementById("prenom").value = q.prenom;
    document.getElementById("email").value = q.email;
            
    actuel = i;
}

function sauvegarder(){
    
    var personne = {
        code: document.getElementById("code").value,
        nom: document.getElementById("nom").value,
        prenom: document.getElementById("prenom").value,
        email: document.getElementById("email").value
    };

    mes_donnees[actuel] = personne;
    afficher();
    
}

function supprimer(i){
    var temp = [];
    for(var j = 0; j < mes_donnees.length; j++){
        if(j != i)
            temp.push(mes_donnees[j]);
    }
    mes_donnees = temp;
    afficher();
}

function afficher() {
    
    document.getElementById("donnees").innerHTML = "";

    var tr = document.createElement("tr");

    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");

    td1.appendChild(document.createTextNode("Code"));
    td2.appendChild(document.createTextNode("Nom"));
    td3.appendChild(document.createTextNode("Prénom"));
    td4.appendChild(document.createTextNode("Email"));
    td5.appendChild(document.createTextNode("Actions"));

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);

    document.getElementById("donnees").appendChild(tr);

    for (var i = 0; i < mes_donnees.length; i++) {
        var p = mes_donnees[i];

        tr = document.createElement("tr");

        td1 = document.createElement("td");
        td2 = document.createElement("td");
        td3 = document.createElement("td");
        td4 = document.createElement("td");
        td5 = document.createElement("td");
        
        var modifier = "<button onclick='modifier(" + i + ")'>Modifier</button>";
        var supprimer = "<button onclick='supprimer(" + i + ")'>Supprimer</button>";
        
        td1.appendChild(document.createTextNode(p.code));
        td2.appendChild(document.createTextNode(p.nom));
        td3.appendChild(document.createTextNode(p.prenom));
        td4.appendChild(document.createTextNode(p.email));
        td5.appendChild(document.createTextNode(modifier));
        td5.innerHTML = modifier + supprimer;

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);

        document.getElementById("donnees").appendChild(tr);
    }


}


