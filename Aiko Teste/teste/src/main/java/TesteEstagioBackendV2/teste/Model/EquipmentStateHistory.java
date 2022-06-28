package TesteEstagioBackendV2.teste.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EquipmentStateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    @Column
    private Date date;


}
