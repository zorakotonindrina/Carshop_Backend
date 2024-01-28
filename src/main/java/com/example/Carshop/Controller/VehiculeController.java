package com.example.Carshop.Controller;

import com.example.Carshop.Model.Infos_vehicule;
import com.example.Carshop.Model.Vehicule;
import com.example.Carshop.Model.Vehicule_photo;
import com.example.Carshop.Service.CategorieService;
import com.example.Carshop.Service.CouleurService;
import com.example.Carshop.Service.Infos_vehiculeService;
import com.example.Carshop.Service.MarqueService;
import com.example.Carshop.Service.ModeleService;
import com.example.Carshop.Service.Type_carburantService;
import com.example.Carshop.Service.VehiculeService;
import com.example.Carshop.Service.Vehicule_photoService;
import com.example.Carshop.api.APIResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carshop/Vehicules")

public class VehiculeController {

    
    @Autowired
    private VehiculeService VehiculeService;

    @Autowired
    private Infos_vehiculeService Infos_vehiculeService;

    @Autowired
    private Vehicule_photoService Vehicule_photoService;


    @Autowired
    private ModeleService ModeleService;

    @Autowired
    private MarqueService MarqueService;

    @Autowired
    private CouleurService CouleurService;

    @Autowired
    private CategorieService CategorieService;

    @Autowired
    private Type_carburantService Type_carburantService;
    

    @GetMapping
    public ResponseEntity<APIResponse> getAllVehicules() {
        try {
            List<Vehicule>  valeure = VehiculeService.getAllVehicules();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getVehiculeById(@PathVariable int id) {
         try {
            Vehicule valeure = VehiculeService.getVehiculeById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveVehicule(@RequestBody Vehicule Vehicule) {
        try {
            Vehicule  valeure = VehiculeService.saveVehicule(Vehicule);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteVehicule(@PathVariable int id) {
        try {
            VehiculeService.deleteVehicule(id);
            APIResponse api = new APIResponse(null, null);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    @GetMapping("/ajouter")
    public String nouveau_vehicule(Model model){
        model.addAttribute("modele", ModeleService);
        model.addAttribute("marque", MarqueService);
        model.addAttribute("couleur", CouleurService);
        model.addAttribute("Categorie", CategorieService);
        model.addAttribute("Type_carburantService", Type_carburantService);
        return "nouveau_vehicule" ; 
    }

    @GetMapping("/insert")
    public String insert_vehicule(
        @RequestParam(name = "id_modele",defaultValue = " ") int id_modele,
        @RequestParam(name = "id_marque",defaultValue = " ") int id_marque,
        @RequestParam(name = "id_categorie",defaultValue = " ") int id_categorie,
        @RequestParam(name = "id_type_carburant",defaultValue = " ") int id_type_carburant,
        @RequestParam(name = "matriculation",defaultValue = " ") String matriculation,
        @RequestParam(name = "id_couleur",defaultValue = " ") int id_couleur,
        @RequestParam(name = "annee",defaultValue = " ") int annee,
        @RequestParam(name = "consommation",defaultValue = " ") double consommation,
        @RequestParam(name = "capacite_reservoir",defaultValue = " ") double capacite_reservoir,
        @RequestParam(name = "nombre_place",defaultValue = " ") int nombre_place,
        @RequestParam(name = "transmission",defaultValue = " ") int transmission,
        @RequestParam(name = "kilometrage",defaultValue = " ") double kilometrage,
        @RequestParam(name = "climatiseur",defaultValue = " ") int climatiseur,
        @RequestParam(name = "chaise_bebe",defaultValue = " ") int chaise_bebe,
        @RequestParam(name = "gps",defaultValue = " ") int gps,
        @RequestParam(name = "confre",defaultValue = " ") int confre,
        @RequestParam(name = "musique",defaultValue = " ") int musique,
        @RequestParam(name = "ceinture_securite",defaultValue = " ") int ceinture_securite,
        @RequestParam(name = "bleutooth",defaultValue = " ") int bleutooth,
        @RequestParam(name = "tableau_bord",defaultValue = " ") int tableau_bord,
        @RequestParam(name = "verouillage_centralise",defaultValue = " ") int verouillage_centralise,
        @RequestParam(name = "verouillage_distance",defaultValue = " ") int verouillage_distance,
        @RequestParam(name = "kit_vehicule",defaultValue = " ") int kit_vehicule,
        @RequestParam(name = "photo",defaultValue = " ") String photo,
        HttpServletRequest request
    ){
        try{
            
            Vehicule v= new Vehicule();
            v.setId_modele(id_modele);
            v.setId_marque(id_marque);
            v.setId_categorie(id_categorie);
            v.setId_type_carburant(id_type_carburant);
            v.setMatriculation(matriculation);
            v.setId_couleur(id_couleur);
            v.setAnnee(annee);
            v.setConsommation(consommation);
            v.setCapacite_reservoir(capacite_reservoir);
            v.setNombre_place(nombre_place);
            v.setTransmission(transmission);
            v.setKilometrage(kilometrage);
            VehiculeService.saveVehicule(v);

            int id_vehicule= VehiculeService.getLatsVehicule();
            Infos_vehicule infos= new Infos_vehicule();
            infos.setId_vehicule(id_vehicule);
            infos.setClimatiseur(climatiseur);
            infos.setChaise_bebe(chaise_bebe);
            infos.setGps(gps);
            infos.setConfre(confre);
            infos.setMusique(musique);
            infos.setCeinture_securite(ceinture_securite);
            infos.setBleutooth(bleutooth);
            infos.setTableau_bord(tableau_bord);
            infos.setVerouillage_centralise(verouillage_centralise);
            infos.setVerouillage_distance(verouillage_distance);
            infos.setKit_vehicule(kit_vehicule);

            Infos_vehiculeService.saveInfos_vehicule(infos);
            Vehicule_photo vp=new Vehicule_photo();
            vp.setId_vehicule(id_vehicule);
            vp.setPhoto(photo);

            Vehicule_photoService.saveVehicule_photo(vp);
            return "redirect:/carshop/Annonces/voir";
        }catch(Exception ex){
            ex.printStackTrace();
            return "redirect:/carshop/Annonces/voir?erreur="+ex.getMessage();
        }  
    }

    // Autres méthodes CRUD personnalisées si nécessaire

}
