package com.example.Carshop.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Detail_annonce;

@Repository
public interface Detail_annonceRepository extends JpaRepository<Detail_annonce,Integer>{

    public List<Detail_annonce> findByMarqueContaining(String marque);

    public List<Detail_annonce> findByModeleContaining(String modele);

    public List<Detail_annonce> findByCategorieContaining(String categorie);

    //public List<Detail_annonce> findByDate_annonce(Date date_annonce);
     
    public List<Detail_annonce> findByPrixBetween(double prixMin, double prixMax);


     

}
