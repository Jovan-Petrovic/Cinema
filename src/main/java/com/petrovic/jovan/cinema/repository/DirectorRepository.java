/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.repository;

import com.petrovic.jovan.cinema.entity.Director;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bron Zilar
 */
@Transactional
@Repository
public interface DirectorRepository extends MovieWorkerBaseRepository<Director>{
    
    Director findByName(String lastname);
}
