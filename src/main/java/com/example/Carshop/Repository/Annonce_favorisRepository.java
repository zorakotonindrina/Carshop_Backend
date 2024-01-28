
package com.example.Carshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Annonce_favoris;

@Repository
public interface Annonce_favorisRepository extends JpaRepository<Annonce_favoris,Integer>{
    
}
