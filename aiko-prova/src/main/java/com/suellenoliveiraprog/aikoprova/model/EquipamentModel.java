package com.suellenoliveiraprog.aikoprova.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Contém todos os modelos de equipamentos. */

@Entity
public class EquipamentModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;//Identificador único do modelo de equipamento.
    @Column(columnDefinition="TEXT")
    private String name;//Nome do modelo de equipamento.

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
