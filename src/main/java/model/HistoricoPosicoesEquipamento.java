package model;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class HistoricoPosicoesEquipamento {
    private UUID uuidEquipamento;
    private Date data;
    private double latitude;
    private double longitude;

    public HistoricoPosicoesEquipamento() throws ParseException{
        this("", "" , 0.0, 0.0);
    }

    public HistoricoPosicoesEquipamento(String idEquipment, String date, double lat, double lon) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.uuidEquipamento = UUID.fromString(idEquipment);
        this.data = df.parse(date);
        this.latitude = lat;
        this.longitude = lon;
    }

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

    public String getSLatitude() {
        return String.format("%.6f", latitude).replace(",",".");
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getSLongitude() {
        return String.format("%.6f", longitude).replace(",",".");
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
