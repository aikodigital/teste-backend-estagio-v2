package com.aiko.testebackendestagiov2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
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
    private EquipmentModel equipmentModel;

    @JsonIgnore
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<EquipmentPositionHistory> equipmentPositionHistories;

}
