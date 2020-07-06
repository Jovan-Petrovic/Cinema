/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.repository;

import com.petrovic.jovan.cinema.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bron Zilar
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    @Query("select m from Movie m")
    List<Movie> getAll();
    
    @Query("select m from Movie m where m.id =?1")
    Movie getById(Long id);

}
