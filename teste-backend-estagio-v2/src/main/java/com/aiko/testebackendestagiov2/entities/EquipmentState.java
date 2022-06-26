package com.aiko.testebackendestagiov2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class EquipmentState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String color;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentState", cascade = CascadeType.ALL)
    List<EquipmentStateHistory> equipmentStateHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentState", cascade = CascadeType.ALL)
    List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
}
