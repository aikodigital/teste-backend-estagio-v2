package io.github.pedrobicudo.testebackendestagiov2.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class HourlyEarnings {

    @EmbeddedId
    private HourlyEarningsPK pk;

    @Column
    private Double value;

}
