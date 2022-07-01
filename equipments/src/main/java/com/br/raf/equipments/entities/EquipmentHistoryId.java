package com.br.raf.equipments.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentHistoryId implements Serializable {

    private UUID equipmentId;
    private LocalDateTime date;




}
