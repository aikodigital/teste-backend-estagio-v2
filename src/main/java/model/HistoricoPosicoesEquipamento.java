package model;

import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class HistoricoPosicoesEquipamento {
    private UUID uuidEquipamento;
    private Date data;
    private double latitude;
    private double longitude;

    public UUID getUuidEquipamento() {
        return uuidEquipamento;
    }

    public void setUuidEquipamento(UUID uuidEquipamento) {
        this.uuidEquipamento = uuidEquipamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("idEquipment", this.getUuidEquipamento().toString());
        objetoJSON.put("data", this.getData().toString());
        objetoJSON.put("latitude", this.getLatitude());
        objetoJSON.put("longitude", this.getLongitude());

        return objetoJSON;
    }
}
