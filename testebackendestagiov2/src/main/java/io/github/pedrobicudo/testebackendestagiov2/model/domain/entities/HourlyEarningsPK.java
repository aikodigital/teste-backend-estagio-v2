package io.github.pedrobicudo.testebackendestagiov2.model.domain.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class HourlyEarningsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState state;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id")
    private EquipmentModel model;

}
