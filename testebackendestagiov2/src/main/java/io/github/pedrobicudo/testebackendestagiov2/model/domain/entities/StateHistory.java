package io.github.pedrobicudo.testebackendestagiov2.model.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment_state_history")
public class StateHistory {

    @EmbeddedId
    private StateHistoryPK pk;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState state;
}
