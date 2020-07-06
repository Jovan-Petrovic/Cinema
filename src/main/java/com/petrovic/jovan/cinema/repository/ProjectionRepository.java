/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.repository;

import com.petrovic.jovan.cinema.entity.Projection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bron Zilar
 */
@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long>{
    @Query("select p from Projection p")
    List<Projection> getAll();
    
    @Query("select p from Projection p where p.id =?1")
    Projection getById(Long id);
}
