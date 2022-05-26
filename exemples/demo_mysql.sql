Create Table ExempleXML (
	id Integer Primary Key,
	titre Char(100),
	contenu Text
);

Insert into ExempleXML Values (1, 'Liste Produits',
'<?xml version="1.0" encoding="UTF-8"?>
<produits>
    <produit id="1">
    	<description>Cahier 32 pages</description>
    	<prix>18</prix>
    </produit>
    <produit id="2">
    	<description>Cahier 64 pages</description>
    	<prix>24</prix>
    </produit>
    <produit id="3">
    	<description>Cahier 96 pages</description>
    	<prix>35</prix>
    </produit>
</produits>');

