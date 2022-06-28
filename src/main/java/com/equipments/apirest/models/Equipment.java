package com.equipments.apirest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "equipment", schema = "operation")
public class Equipment {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id", foreignKey = @ForeignKey(name = "fk_equipment_model"))
    private EquipmentModel equipmentModel;


}
