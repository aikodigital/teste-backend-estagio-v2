package io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.HourlyEarnings;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HourlyEarningsDTO {
    private String id;
    private EquipmentModelDTO model;
    private EquipmentStateDTO state;
    private Double value;

    public HourlyEarningsDTO(HourlyEarnings hourlyEarnings) {
        this.id = String.format(
                "%s_%s",
                hourlyEarnings.getPk().getState().getId(),
                hourlyEarnings.getPk().getModel().getId()
        );
        this.model = new EquipmentModelDTO(hourlyEarnings.getPk().getModel());
        this.state = new EquipmentStateDTO(hourlyEarnings.getPk().getState());
        this.value = hourlyEarnings.getValue();
    }
}
