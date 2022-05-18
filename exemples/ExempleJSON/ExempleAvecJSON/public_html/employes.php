<?php
/*
Université de Jijel
Faculté des Sciences Exactes et d'Informatique
Département d'Informatique
3ème Année Licence - Informatique
Données Semi-structurées (DS)
Exemple : Serveur JSON
*/

// Une classe exemple
class Employe {
    public function __construct($nom, $prenom) {
        $this->nom = $nom;
        $this->prenom = $prenom;
    }
}

// Quelques données
$employes = array(new Employe("Benamer", "Amer"), 
        new Employe("Benomar", "Omar"), 
        new Employe("Benahmed", "Ahmed"), 
        new Employe("Benmohammed", "Mohammed")
    );

// Encodage sous forme JSON
$jsonEmployes = json_encode($employes); // il y a aussi la fonction json_decode

// On returne les données JSON au client
echo $jsonEmployes;
?>
