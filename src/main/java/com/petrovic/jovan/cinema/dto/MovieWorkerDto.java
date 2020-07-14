/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petrovic.jovan.cinema.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bron Zilar
 */
public abstract class MovieWorkerDto implements Serializable {
    protected static final long serialVersionUID = 2151959395889955260L;
    protected Long id; 
    protected String name;
    protected String nationality;

    public MovieWorkerDto() {
    }

    public MovieWorkerDto(Long id, String firstname, String nationality) {
        this.id = id;
        this.name = firstname;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.nationality);
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
        final MovieWorkerDto other = (MovieWorkerDto) obj;
        if (!Objects.equals(this.name, other.name)) {
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

    @Override
    public String toString() {
        return "MovieWorkerDto{" + "id=" + id + ", name=" + name + ", nationality=" + nationality + '}';
    }
    
    
}
