/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.repository;

import com.petrovic.jovan.cinema.entity.MovieWorker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Bron Zilar
 * @param <T>
 */
@NoRepositoryBean
public interface MovieWorkerBaseRepository<T extends MovieWorker> extends CrudRepository<T, Long>  {
    
    List<T> findAll();
}
