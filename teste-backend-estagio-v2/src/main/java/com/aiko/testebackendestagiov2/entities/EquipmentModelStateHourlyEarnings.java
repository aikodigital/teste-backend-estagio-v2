package com.aiko.testebackendestagiov2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class EquipmentModelStateHourlyEarnings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Float value;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id", referencedColumnName = "id")
    private EquipmentModel equipmentModel;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
    private EquipmentState equipmentState;
//    Informação de qual é o valor por hora do modelo de equipamento em cada um dos estados.
//
//    equipment_model_id: Chave estrangeira, utilizada para referenciar de qual modelo é esse valor.
//    equipment_state_id: Chave estrangeira, utilizada para referenciar de qual valor é esse estado.
//    value: Valor gerado por hora nesse estado.
}
