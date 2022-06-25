package EquipmentDAO;

import java.util.Date;
import EquipmentDAO.Equipment_model_state_hourly_earnings;

/**
 *
 * @author Gabriel castro
 */
public class Equipment_state_history {
    java.util.Date Date;
    
    int Equipment_Id;
    Date date;

    public int getEquipment_Id() {
        return Equipment_Id;
    }

    public void setEquipment_Id(int Equipment_Id) {
        this.Equipment_Id = Equipment_Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }       
}
