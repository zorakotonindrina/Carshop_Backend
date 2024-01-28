insert into Utilisateur(nom,prenom,date_naissance,email,mdp,profil) 
    values 
        ('Admin','Admi','1990-09-09','admin@gmail.com','000',1),
        ('Gg','Fitia','2005-04-12','fitia@gmail.com','111',0),
        ('Naivo','Kanto','2002-08-28','kanto@gmail.com','222',0),
        ('Rakoto','Zo','2005-01-26','zo@gmail.com','333',0),
        ('Lo','Bri','2000-01-01','bri@gmail.com','444',0),
        ('Admin2','Admi2','1991-09-09','admin2@gmail.com','admin2',1);

        
insert into modele (nom_modele)
    values
        ('Camry'), --Toyota
        ('Corolla'),
        ('Prius'),
        ('RAV4'),
        ('Mustang'), --Mustang
        ('F-150'),
        ('Focus'),
        ('Explorer'),
        ('Golf'), --Volkswagen
        ('Passat'),
        ('Tiguan'),
        ('Jetta'),
        ('Civic'), --Honda
        ('Accord'),
        ('CR-V'),
        ('Pilot'),
        ('Silverado'), --Chevrolet
        ('Malibu'),
        ('Equinox'),
        ('Camaro'),
        ('3 Series'), --BMW
        ('5 Series'),
        ('X5'),
        ('7 Series'),
        ('C-Class'), --Mercedes-Benz
        ('E-Class'),
        ('GLC'),
        ('S-Class'),
        ('Altima'), --Nissan
        ('Rogue'),
        ('Sentra'),
        ('Pathfinder'),
        ('Model S'), --Tesla
        ('Model 3'),
        ('Model X'),
        ('Model Y'),
        ('A4'), --Audi
        ('Q5'),
        ('A6'),
        ('Q7');


INSERT INTO marque (nom_marque)
VALUES
    ('Toyota'),
    ('Ford'),
    ('Volkswagen'),
    ('Honda'),
    ('Chevrolet'),
    ('BMW'),
    ('Mercedes-Benz'),
    ('Nissan'),
    ('Tesla'),
    ('Audi'),
    ('Hyundai'),
    ('Kia'),
    ('Subaru'),
    ('Mazda'),
    ('Fiat'),
    ('Jeep'),
    ('Volvo'),
    ('Lexus'),
    ('Porsche'),
    ('Jaguar'),
    ('Land Rover'),
    ('Mitsubishi'),
    ('Buick'),
    ('Cadillac'),
    ('Chrysler'),
    ('Dodge'),
    ('Ram'),
    ('Acura'),
    ('Infiniti'),
    ('Mini');


INSERT INTO categorie (nom_categorie)
VALUES
    ('Berline Sedan'),
    ('Coupe'),
    ('Cabriolet Convertible'),
    ('Break Wagon'),
    ('Monospace Minivan'),
    ('Vehicule Utilitaire Sport VUS ou SUV'),
    ('Crossover'),
    ('Coupe Sport'),
    ('Vehicule Tout-Terrain VTT'),
    ('Berline de Luxe'),
    ('Supercar'),
    ('Voiture de Sport'),
    ('Voiture electrique VE'),
    ('Voiture Hybride'),
    ('Voiture Hydrogene'),
    ('Voiture Autonome');


    
INSERT INTO type_carburant (nom_type)
VALUES
    ('Essence'),
    ('Diesel'),
    ('Ethanol E85'),
    ('GPL Gaz de Petrole Liquefie'),
    ('GNV Gaz Naturel pour Vehicules'),
    ('Hydrogene'),
    ('Biodiesel'),
    ('Electricite');


INSERT INTO couleur (nom)
VALUES
    ('Blanc'),
    ('Noir'),
    ('Argent'),
    ('Gris'),
    ('Bleu'),
    ('Rouge'),
    ('Vert'),
    ('Jaune'),
    ('Orange'),
    ('Marron'),
    ('Beige'),
    ('Or'),
    ('Bronze'),
    ('Violet'),
    ('Rose'),
    ('Turquoise'),
    ('Bordeaux'),
    ('Cuivre'),
    ('Gris anthracite'),
    ('Bleu marine'),
    ('Rouge fonce'),
    ('Vert olive'),
    ('Gris metallise'),
    ('Bleu metallise'),
    ('Rouge metallise'),
    ('Jaune citron'),
    ('Rose pale'),
    ('Vert menthe'),
    ('Marron chocolat'),
    ('Or rose'),
    ('Bleu ciel'),
    ('Rouge cerise'),
    ('Vert emeraude'),
    ('Brun caramel'),
    ('Gris perle'),
    ('Bleu royal'),
    ('Violet fonce'),
    ('Jaune moutarde'),
    ('Orange corail'),
    ('Vert lime'),
    ('Beige dore'),
    ('Rouge brique'),
    ('Bleu saphir'),
    ('Gris acier'),
    ('Vert foret'),
    ('Marron taupe'),
    ('Rose saumon'),
    ('Bleu turquoise'),
    ('Rouge cardinal'),
    ('Vert kaki');

INSERT INTO vehicule (id_utilisateur, id_modele, id_marque, id_categorie, id_type_carburant, matriculation, id_couleur, annee, consommation, capacite_reservoir, nombre_place, transmission, kilometrage)
VALUES
    (2, 35, 9, 10, 2, '1111WWT', 2, 2022, 7.5, 60.0, 4, 1, 15000.0),
    (3, 4, 1, 11, 2, '2222TBJ', 14, 2020, 7.0, 70.0, 5, 1, 30000.0),
    (4, 17, 10, 1, 1, '3333TBH', 1, 2020, 7.5, 80.0, 5, 1, 15000.0),
    (5, 9, 3, 2, 1, '4444TBL', 6, 2021, 7., 70.0, 5, 1, 15000.0);


INSERT INTO infos_vehicule (id_vehicule, climatiseur, chaise_bebe, gps, confre, musique, ceinture_securite, bleutooth, tableau_bord, verouillage_centralise, verouillage_distance, kit_vehicule)
VALUES
    (5, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
    (6, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1),
    (7, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
    (8, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0);

    INSERT INTO vehicule_photo (id_vehicule, photo)
    values
        (5,'f1.jpg'),
        (6,'k1.jpg'),
        (7,'z1.jpg'),
        (8,'b1.jpg');

        INSERT INTO annonce (id_vehicule, prix, descriptions, date_annonce, validations, etat)
    values
        (5,400000000, 'Bogosy', '2024-01-14',0,0),
        (6,300000000, 'Manja', '2024-01-14',1,0),
        (7,350000000, 'Bg', '2024-01-13',1,1),
        (8,380000000, 'Gg', '2024-01-11',1,1);

        INSERT INTO annonce_refus (id_annonce, date_refus)
    values 
        (3,'2024-01-14');

        INSERT INTO annonce_valide (id_annonce, date_valide)
    values (4,'2024-01-13');

    INSERT INTO annonce_favoris (id_annonce, id_utilisateur, date_favoris)
    VALUES
        (1, 2, CURRENT_DATE);