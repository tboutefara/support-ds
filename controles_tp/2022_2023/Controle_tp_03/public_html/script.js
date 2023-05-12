var mes_donnees = [
    {
        id: 1,
        designation: "Stylo bleu",
        description: "Stylo bleu rechargeable",
        prix: 25
    },
    {
        id: 2,
        designation: "Cahier 64p",
        description: "Cahier 64 décoré avec des fleurs",
        prix: 75
    },
    {
        id: 3,
        designation: "Cahier 288p",
        description: "Cahier 288 pages décoré avec des images de joueurs",
        prix: 350
    },
    {
        id: 4,
        designation: "Cahier TP GF",
        description: "Cahier des Travaux Pratiques (Grand Format)",
        prix: 245
    }
];

function liste() {
    var d = document.getElementById("donnees");
    d.innerHTML = "";

    var ul = document.createElement("ul");
    d.appendChild(ul);

    for (var i = 0; i < mes_donnees.length; i++) {
        var p = mes_donnees[i];

        var li1 = document.createElement("li");
        li1.appendChild(document.createTextNode("Produit : " + p.id));
        ul.appendChild(li1);

        var ul2 = document.createElement("ul");
        li1.appendChild(ul2);

        var li2 = document.createElement("li");
        li2.appendChild(document.createTextNode(p.designation));
        ul2.appendChild(li2);

        var li3 = document.createElement("li");
        li3.appendChild(document.createTextNode(p.description));
        ul2.appendChild(li3);

        var li4 = document.createElement("li");
        li4.appendChild(document.createTextNode(p.prix));
        ul2.appendChild(li4);
    }
}

function tableau() {

    var d = document.getElementById("donnees");
    d.innerHTML = "";

    var table = document.createElement("table");
    d.appendChild(table);

    var tr = document.createElement("tr");
    table.appendChild(tr);

    var td = document.createElement("td");
    td.appendChild(document.createTextNode("Id"));
    tr.appendChild(td);

    td = document.createElement("td");
    td.appendChild(document.createTextNode("Designation"));
    tr.appendChild(td);

    td = document.createElement("td");
    td.appendChild(document.createTextNode("Description"));
    tr.appendChild(td);

    td = document.createElement("td");
    td.appendChild(document.createTextNode("Prix"));
    tr.appendChild(td);

    for (var i = 0; i < mes_donnees.length; i++) {
        var p = mes_donnees[i];

        tr = document.createElement("tr");
        table.appendChild(tr);

        td = document.createElement("td");
        td.appendChild(document.createTextNode(p.id));
        tr.appendChild(td);

        td = document.createElement("td");
        td.appendChild(document.createTextNode(p.designation));
        tr.appendChild(td);

        td = document.createElement("td");
        td.appendChild(document.createTextNode(p.description));
        tr.appendChild(td);

        td = document.createElement("td");
        td.appendChild(document.createTextNode(p.prix));
        tr.appendChild(td);
    }
}


