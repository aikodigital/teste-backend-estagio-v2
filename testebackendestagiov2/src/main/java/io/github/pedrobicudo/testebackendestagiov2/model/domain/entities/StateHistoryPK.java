package io.github.pedrobicudo.testebackendestagiov2.model.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class StateHistoryPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column
    private Date date;

}
