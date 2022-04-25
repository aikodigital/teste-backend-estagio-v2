package com.suellenoliveiraprog.aikoprova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Contém todos os estados dos equipamentos. */

@Entity
public class EquipamentState {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //Identificador único do estado de equipamento.
    private String name; //Nome do estado.
    private String color; //Cor utilizada para representar o estado.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
