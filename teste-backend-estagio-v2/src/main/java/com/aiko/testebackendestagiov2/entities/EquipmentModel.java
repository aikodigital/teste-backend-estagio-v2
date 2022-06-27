package com.aiko.testebackendestagiov2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentModel", cascade = CascadeType.ALL)
    List<Equipment> equipments;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentModel", cascade = CascadeType.ALL)
    List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
}
