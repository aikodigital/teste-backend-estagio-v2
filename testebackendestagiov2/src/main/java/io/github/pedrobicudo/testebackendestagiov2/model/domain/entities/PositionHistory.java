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
@Table(name = "equipment_position_history")
public class PositionHistory {

    @EmbeddedId
    private PositionHistoryPK pk;

    @Column
    private Double lat;

    @Column
    private Double lon;

}
