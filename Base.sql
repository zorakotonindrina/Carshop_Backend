create database carshop;
\c carshop;


CREATE table Utilisateur(
    id_utilisateur serial primary key,
    nom varchar(50),
    prenom varchar(50),
    date_naissance date,
    email varchar(50),
    mdp varchar(50),
    profil int
);

CREATE table Admin(
    id_admin serial primary key,
    nom varchar(50),
    prenom varchar(50),
    date_naissance date,
    email varchar(50),
    mdp varchar(50)
);


CREATE table modele(
    id_modele serial primary  key,
    nom_modele varchar(50)
);

CREATE table marque(
    id_marque serial primary  key,
    nom_marque varchar(50)
);


CREATE table categorie(
    id_categorie serial primary  key,
    nom_categorie varchar(50)
);

CREATE table type_carburant(
    id_type_carburant serial primary  key,
    nom_type varchar(50)
);

CREATE table couleur(
    id_couleur serial primary  key,
    nom varchar(50)
);

CREATE table vehicule(
    id_vehicule serial primary  key,
    id_utilisateur int,
    id_modele int,
    id_marque int,
    id_categorie int,
    id_type_carburant int,
    matriculation varchar(50),
    id_couleur int,
    annee int,
    consommation float,
    capacite_reservoir float,
    nombre_place int,
    transmission int,
    kilometrage float,
    foreign key(id_utilisateur) references Utilisateur(id_utilisateur),
    foreign key(id_modele) references modele(id_modele),
    foreign key(id_marque) references marque(id_marque),
    foreign key(id_categorie) references categorie(id_categorie),
    foreign key(id_type_carburant) references type_carburant(id_type_carburant),
    foreign key(id_couleur) references couleur(id_couleur)
);

CREATE table infos_vehicule(
    id_infos_vehicule serial primary  key,
    id_vehicule int,
    climatiseur int,
    chaise_bebe int,
    gps int,
    confre int,
    musique int,
    ceinture_securite int,
    bleutooth int,
    tableau_bord int,
    verouillage_centralise int,
    verouillage_distance int,
    kit_vehicule int,
    foreign key(id_vehicule) references vehicule(id_vehicule)
);


CREATE table vehicule_photo(
    id_vehicule_photo serial primary  key,
    id_vehicule int,
    photo varchar(50),
    foreign key(id_vehicule) references vehicule(id_vehicule)
);



CREATE table annonce(
    id_annonce serial primary  key,
    id_vehicule int,
    prix float,
    descriptions varchar(100),
    date_annonce date,
    validations int,
    etat int,
    foreign key(id_vehicule) references vehicule(id_vehicule)
);

CREATE table annonce_refus(
    id_annonce_refus serial primary  key,
    id_annonce int,
    date_refus date,
    foreign key(id_annonce) references annonce(id_annonce)
);

CREATE table annonce_valide(
    id_annonce_valide serial primary  key,
    id_annonce int,
    date_valide date,
    foreign key(id_annonce) references annonce(id_annonce)
);

CREATE table annonce_favoris(
    id_annonce_favoris serial primary  key,
    id_annonce int,
    id_utilisateur int,
    date_favoris date,
    foreign key(id_utilisateur) references Utilisateur(id_utilisateur),
    foreign key(id_annonce) references annonce(id_annonce)
);


CREATE table compte(
    id_compte serial primary key,
    id_utilisateur int,
    numero_compte varchar(50),
    code varchar(50),
    foreign key(id_utilisateur) references Utilisateur(id_utilisateur)
);

CREATE table mouvement_compte(
    id_mouvement_compte serial primary key,
    id_compte int,
    date_mouvement timestamp,
    valeure int,
    statut int,
    foreign key(id_compte) references compte(id_compte)
);


CREATE table messages(
    id_message serial primary key,
    id_expediteur int,
    nom_expediteur varchar(50),
    prenom_expediteur varchar(50),
    id_recepteur int,
    nom_recepteur varchar(50),
    prenom_recepteur varchar(50),
    foreign key(id_expediteur) references Utilisateur(id_utilisateur),
    foreign key(id_recepteur) references Utilisateur(id_utilisateur)
);

CREATE table detail_message(
    id_detail_message serial primary key,
    id_message int,
    id_messageur int,
    nom_messageur varchar(250), 
    contenu varchar(250),
    date_message timestamp,
    foreign key(id_message) references messages(id_message),
    foreign key(id_messageur) references Utilisateur(id_utilisateur)
);

CREATE table commission(
    id_commission serial primary key,
    date_commission date,
    id_annonce int,
    pourcentage float ,
    valeure float ,
    etat int,
    foreign key(id_annonce) references annonce(id_annonce)
);


CREATE or replace view v_info_vehicule as select 
    vehicule.id_vehicule,
    vehicule.id_utilisateur,
    vehicule.matriculation,
    vehicule.annee,
    vehicule.consommation,
    vehicule.capacite_reservoir,
    vehicule.nombre_place,
    vehicule.transmission,
    vehicule.kilometrage,
    modele.nom_modele,
    marque.nom_marque,
    categorie.nom_categorie,
    type_carburant.nom_type,
    couleur.nom as couleur,
    infos_vehicule.climatiseur,
    infos_vehicule.chaise_bebe ,
    infos_vehicule.gps,
    infos_vehicule.confre,
    infos_vehicule.musique,
    infos_vehicule.ceinture_securite,
    infos_vehicule.bleutooth,
    infos_vehicule.tableau_bord,
    infos_vehicule.verouillage_centralise,
    infos_vehicule.verouillage_distance,
    infos_vehicule.kit_vehicule,
    Utilisateur.nom,
    Utilisateur.prenom,
    Utilisateur.date_naissance,
    Utilisateur.email,
    Utilisateur.mdp,
    Utilisateur.profil
    from vehicule 
    join modele on vehicule.id_modele = modele.id_modele
    join marque on vehicule.id_marque = marque.id_marque
    join categorie on vehicule.id_categorie = categorie.id_categorie
    join type_carburant on vehicule.id_type_carburant = type_carburant.id_type_carburant
    join couleur on vehicule.id_couleur = couleur.id_couleur
    join infos_vehicule on vehicule.id_vehicule = infos_vehicule.id_vehicule
    join Utilisateur on vehicule.id_utilisateur = Utilisateur.id_utilisateur
    ;


    CREATE OR replace view v_annonce_favoris as 
    select 
    annonce.id_annonce,
    COALESCE(sum(annonce_favoris.id_annonce_favoris),0) as reactions
    from annonce 
    LEFT join annonce_favoris on annonce.id_annonce = annonce_favoris.id_annonce
    group by annonce.id_annonce;



    CREATE or replace view v_annonce as
    select 
    annonce.id_annonce,
    annonce.prix,
    annonce.descriptions,
    annonce.date_annonce,
    annonce.validations,
    annonce.etat,
    v_info_vehicule.id_vehicule,
    v_info_vehicule.id_utilisateur,
    v_info_vehicule.matriculation,
    v_info_vehicule.annee,
    v_info_vehicule.consommation,
    v_info_vehicule.capacite_reservoir,
    v_info_vehicule.nombre_place,
    v_info_vehicule.transmission,
    v_info_vehicule.kilometrage,
    v_info_vehicule.nom_modele,
    v_info_vehicule.nom_marque,
    v_info_vehicule.nom_categorie,
    v_info_vehicule.nom_type,
    v_info_vehicule.couleur,
    v_info_vehicule.climatiseur,
    v_info_vehicule.chaise_bebe ,
    v_info_vehicule.gps,
    v_info_vehicule.confre,
    v_info_vehicule.musique,
    v_info_vehicule.ceinture_securite,
    v_info_vehicule.bleutooth,
    v_info_vehicule.tableau_bord,
    v_info_vehicule.verouillage_centralise,
    v_info_vehicule.verouillage_distance,
    v_info_vehicule.kit_vehicule,
    v_info_vehicule.nom,
    v_info_vehicule.prenom,
    v_info_vehicule.date_naissance,
    v_info_vehicule.email,
    v_info_vehicule.mdp,
    v_info_vehicule.profil,
    v_annonce_favoris.reactions
    from annonce 
    join v_info_vehicule on annonce.id_vehicule = v_info_vehicule.id_vehicule
    join v_annonce_favoris on annonce.id_annonce = v_annonce_favoris.id_annonce
    ;


    






    CREATE or replace view detail_annonce as
    select 
    annonce.id_annonce,
    annonce.prix,
    annonce.descriptions,
    annonce.date_annonce,
    annonce.validations,
    annonce.etat,
    v_info_vehicule.id_vehicule,
    v_info_vehicule.id_utilisateur,
    v_info_vehicule.matriculation,
    v_info_vehicule.annee,
    v_info_vehicule.consommation,
    v_info_vehicule.capacite_reservoir,
    v_info_vehicule.nombre_place,
    v_info_vehicule.transmission,
    v_info_vehicule.kilometrage,
    v_info_vehicule.nom_modele as modele,
    v_info_vehicule.nom_marque as marque,
    v_info_vehicule.nom_categorie as categorie,
    v_info_vehicule.nom_type as types,
    v_info_vehicule.couleur,
    v_info_vehicule.climatiseur,
    v_info_vehicule.chaise_bebe ,
    v_info_vehicule.gps,
    v_info_vehicule.confre,
    v_info_vehicule.musique,
    v_info_vehicule.ceinture_securite,
    v_info_vehicule.bleutooth,
    v_info_vehicule.tableau_bord,
    v_info_vehicule.verouillage_centralise,
    v_info_vehicule.verouillage_distance,
    v_info_vehicule.kit_vehicule,
    v_info_vehicule.nom,
    v_info_vehicule.prenom,
    v_info_vehicule.email,
    v_info_vehicule.mdp,
    v_info_vehicule.profil,
    v_annonce_favoris.reactions
    from annonce 
    join v_info_vehicule on annonce.id_vehicule = v_info_vehicule.id_vehicule
    join v_annonce_favoris on annonce.id_annonce = v_annonce_favoris.id_annonce
    ;



CREATE or replace view stat_marque as 
select
marque.id_marque,
detail_annonce.marque,
sum(detail_annonce.id_annonce)  as nombre from
detail_annonce join marque on marque.nom_marque = detail_annonce.marque 
group by marque.id_marque,detail_annonce.marque order by nombre limit 10;
    

CREATE or replace view stat_modele as 
select
modele.id_modele,
detail_annonce.modele,
sum(detail_annonce.id_annonce) as nombre  from
detail_annonce join modele on modele.nom_modele = detail_annonce.modele
group by modele.id_modele,detail_annonce.modele order by nombre limit 10;


CREATE or replace view stat_categorie as 
select
categorie.id_categorie,
detail_annonce.categorie,
sum(detail_annonce.id_annonce) as nombre from
detail_annonce join categorie on categorie.nom_categorie = detail_annonce.categorie
group by categorie.id_categorie,detail_annonce.categorie order by nombre limit 10;



create or replace view  stat_commission 
as select
sum(commission.valeure) as valeure,
extract(month from commission.date_commission) as mois,
extract(year from commission.date_commission) as annee
from commission group by extract(month from commission.date_commission),extract(year from commission.date_commission);





























