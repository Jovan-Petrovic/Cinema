/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Bron Zilar
 */
@Entity
@DiscriminatorValue(value = "DIRECTOR")
public class Director extends MovieWorker {

    public Director() {
        super();
    }

    @Override
    public String toString() {
        return "Director{" + "id=" + getId() + ", firstname=" + getFirstname() + ", lastanme=" + getLastanme() + ", nationality=" + getNationality() + '}';
    }

    
    
    
}
