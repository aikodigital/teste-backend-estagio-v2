package EquipmentDAO;

/**
 *
 * @author Gabriel castro
 */
public class Equipment_model_state_hourly_earnings {
    
    int Equipment_Model_Id;
    int Equipment_State_Id;
    int Value;

    public int getEquipment_Model_Id() {
        return Equipment_Model_Id;
    }

    public void setEquipment_Model_Id(int Equipment_Model_Id) {
        this.Equipment_Model_Id = Equipment_Model_Id;
    }

    public int getEquipment_State_Id() {
        return Equipment_State_Id;
    }

    public void setEquipment_State_Id(int Equipment_State_Id) {
        this.Equipment_State_Id = Equipment_State_Id;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }
}
