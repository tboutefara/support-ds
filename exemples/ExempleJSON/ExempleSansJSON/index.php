<?php
/*
Université de Jijel
Faculté des Sciences Exactes et d'Informatique
Département d'Informatique
3ème Année Licence - Informatique
Données Semi-structurées (DS)
Exemple : Exemple sans JSON
*/

// Cette partie simule l'accès à une base de données. Ce code se trouve mélangé
// avec le code HTML conçu pur la mise en forme et la vislualisation.

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
?>
<html>
    <head>
        <title>Client JSON</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="../node_modules/jquery/dist/jquery.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id = "contenu">
            <h3>Liste des Employés</h3>
            <ul id="liste">
                <?php
                    // Le code PHP qui gère les doonnées se trouve mélangé avec
                    // le code HTML conçu pour la mise en forme.
                    foreach($employes as $employe){
                        echo "<li>$employe->nom $employe->prenom</li>";
                    } 
                ?>
            </ul>
        </div>
    </body>
</html>

