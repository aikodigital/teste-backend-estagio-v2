package com.aiko.testebackendestagiov2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class EquipmentStateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id", referencedColumnName = "id")
    private EquipmentState equipmentState;
//    O histórico de estados por equipamento.
//
//    equipment_id: Chave estrangeira, utilizada para referenciar de qual equipamento é esse estado.
//    date: Data em que o equipamento declarou estar nesse estado.
//            equipment_state_id: Chave estrangeira, utilizada para referenciar qual é o estado que o equipamento estava nesse momento.
}
