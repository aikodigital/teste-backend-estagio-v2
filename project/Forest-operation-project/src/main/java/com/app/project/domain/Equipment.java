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
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id")
    private EquipmentModel model;

    @JsonIgnore
    @OneToMany(mappedBy = "equipment")
    private List<EquipmentStateHistory> equipmentStateHistories;
}
