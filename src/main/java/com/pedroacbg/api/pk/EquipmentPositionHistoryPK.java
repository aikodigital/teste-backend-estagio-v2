package com.pedroacbg.api.pk;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedroacbg.api.entities.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPositionHistoryPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Equipment equipment;


    @NotNull
    private LocalDateTime date;


}
