package io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.PositionHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionHistoryDTO {

    private String id;
    private String equipmentId;
    private Date date;
    private Double lat;
    private Double lon;

    public PositionHistoryDTO(PositionHistory positionHistory) {
        this.id = String.format(
                "%s_%s",
                positionHistory.getPk().getEquipment().getId().toString(),
                positionHistory.getPk().getDate().getTime()
        );
        this.equipmentId = positionHistory.getPk()
                .getEquipment()
                .getId()
                .toString();
        this.date = positionHistory.getPk().getDate();
        this.lat = positionHistory.getLat();
        this.lon = positionHistory.getLon();
    }

}
