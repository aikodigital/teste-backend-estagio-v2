package TesteEstagioBackendV2.teste.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModelStateHourlyEarnings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_model_id")
    private EquipmentModel equipmentModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    @Column
    private float value;


}
