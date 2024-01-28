use carshop;

{
  "_id": ObjectId("id_du_message"),
  "expediteur": {
    "id": ObjectId("id_de_l_expediteur"),
    "nom": "Nom de l'expéditeur",
    "prenom": "Prénom de l'expéditeur"
  },
  "recepteur": {
    "id": ObjectId("id_du_recepteur"),
    "nom": "Nom du récepteur",
    "prenom": "Prénom du récepteur"
  }
}


{
  "_id": ObjectId("id_du_detail_message"),
  "message": ObjectId("id_du_message_associe"),
  "messageur": {
    "id": ObjectId("id_du_messageur"),
    "nom": "Nom du messageur",
    "prenom": "Prénom du messageur"
  },
  "contenu": "Contenu du message",
  "date_message": ISODate("2022-01-01T00:00:00Z")
}




{
  "_id": ObjectId("ID_UNIQUE"),
  "expediteur": {
    "id": ObjectId("ID_UTILISATEUR_EXPEDITEUR"),
    "nom": "Nom de l'expéditeur",
    "prenom": "Prénom de l'expéditeur"
  },
  "recepteur": {
    "id": ObjectId("ID_UTILISATEUR_RECEPTEUR"),
    "nom": "Nom du destinataire",
    "prenom": "Prénom du destinataire"
  },
 message
}



{
  "_id": ObjectId("ID_UNIQUE"),
  "id_message": ObjectId("ID_MESSAGE_CORRESPONDANT"),
  "id_messageur": ObjectId("ID_UTILISATEUR_EMETTEUR"),
  "contenu": "Contenu du message",
  "date_message": ISODate("2024-01-25T00:00:00Z")
  // Autres champs détail message
}


{
  "_id": ObjectId("ID_UNIQUE"),
  "contenu": "Contenu de la notification",
  "date_notification": ISODate("2024-01-25T00:00:00Z"),
  "lue": false,
  // Autres champs notification
}


db.messages.insert({
  expediteur: ObjectId("id_de_l_expediteur"),
  recepteur: ObjectId("id_du_recepteur")
})

db.detail_message.insert({
  message: ObjectId("id_du_message_associe"),
  messageur: ObjectId("id_du_messageur"),
  contenu: "Contenu du message",
  dateMessage: ISODate("2022-01-01T00:00:00Z")
})


// Insertion dans la collection 'messages'
db.messages.insert({
  expediteur: ObjectId("id_de_l_expediteur"),
  recepteur: ObjectId("id_du_recepteur")
})

// Insertion dans la collection 'detail_message'
db.detail_message.insert({
  message: ObjectId("id_du_message_associe"),
  messageur: ObjectId("id_du_messageur"),
  contenu: "Contenu du message",
  dateMessage: ISODate("2022-01-01T00:00:00Z")
})



