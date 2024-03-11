package com.romero.fiancaspro.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;;

@Data
@Entity
public class Categoria extends Object {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome; 
    private String icone;
    
}