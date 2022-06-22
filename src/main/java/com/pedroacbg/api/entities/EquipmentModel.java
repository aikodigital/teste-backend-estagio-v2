package com.pedroacbg.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "equipment_model", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Campo Obrigatório")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentModel")
    private List<Equipment> equipment;

}
