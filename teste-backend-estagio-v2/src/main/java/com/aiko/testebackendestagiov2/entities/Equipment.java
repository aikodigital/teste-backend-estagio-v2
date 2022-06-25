package com.aiko.testebackendestagiov2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
    private EquipmentModel equipmentModel; // precisa do id

}
