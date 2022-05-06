package model;

import java.util.Date;

public class HistoricoPosicoesEquipamento {
    private String uuidEquipamento;
    private Date data;
    private String latitude;
    private String longitude;

    public String getUuidEquipamento() {
        return uuidEquipamento;
    }

    public void setUuidEquipamento(String uuidEquipamento) {
        this.uuidEquipamento = uuidEquipamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
