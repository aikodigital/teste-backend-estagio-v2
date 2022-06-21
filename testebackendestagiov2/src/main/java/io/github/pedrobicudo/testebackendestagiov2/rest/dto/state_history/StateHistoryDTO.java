package io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.StateHistory;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StateHistoryDTO {
    private String id;
    private String equipmentId;
    private Date date;
    private EquipmentStateDTO state;

    public StateHistoryDTO(StateHistory stateHistory) {
        this.id = String.format(
                "%s_%s",
                stateHistory.getPk().getEquipment().getId().toString(),
                stateHistory.getPk().getDate().getTime()
        );
        this.equipmentId = stateHistory.getPk().getEquipment().getId().toString();
        this.state = new EquipmentStateDTO(stateHistory.getState());
        this.date = stateHistory.getPk().getDate();
    }
}
