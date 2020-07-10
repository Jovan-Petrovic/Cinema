/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Bron Zilar
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MOVIE_WORKER_TYPE")
public abstract class MovieWorker implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_MOVIE_WORKER")
    @TableGenerator(name = "GEN_MOVIE_WORKER", table = "GEN_ID_MOVIE_WORKER",
            pkColumnName = "PK_GEN", valueColumnName = "VALUE_GEN",
            pkColumnValue = "TBL_MOVIE_WORKER", initialValue = 0, allocationSize = 1)
    private Long id;
    
    private String firstname;
    private String lastanme;
    private String nationality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastanme() {
        return lastanme;
    }

    public void setLastanme(String lastanme) {
        this.lastanme = lastanme;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "MovieWorker{" + "id=" + id + ", firstname=" + firstname + ", lastanme=" + lastanme + ", nationality=" + nationality + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.firstname);
        hash = 83 * hash + Objects.hashCode(this.lastanme);
        hash = 83 * hash + Objects.hashCode(this.nationality);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieWorker other = (MovieWorker) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastanme, other.lastanme)) {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
