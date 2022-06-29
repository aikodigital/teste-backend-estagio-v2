package com.app.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "equipment_state")
public class EquipmentState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    private String name;

    private String color;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentState")
    List<EquipmentStateHistory> equipmentStateHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentState")
    List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
}
