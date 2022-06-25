package com.aiko.testebackendestagiov2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class EquipmentPositionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Float lat;
    private Float lon;

    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;
//    O histórico de posições dos equipamentos.
//
//    equipment_id: Chave estrangeira, utilizada para referenciar de qual equipamento é essa posição.
//    date: Data em que a posição foi registrada.
//            lat: Latitude em WGS84.
//            lon: Longitude em WGS84.
}
