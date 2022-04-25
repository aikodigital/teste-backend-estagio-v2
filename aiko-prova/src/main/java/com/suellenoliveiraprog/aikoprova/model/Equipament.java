package com.suellenoliveiraprog.aikoprova.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Contém todos os equipamentos da aplicação.*/

@Entity
public class Equipament {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //Identificador único do equipamento.
    @ManyToOne
    @JoinColumn(name="equipament_model_id", nullable=false)
    private EquipamentModel equipamentModel;//Chave estrangeira, utilizada para referenciar de qual modelo é esse equipamento.
    @Column(columnDefinition="TEXT")
    private String name; //Nome do equipamento.

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
