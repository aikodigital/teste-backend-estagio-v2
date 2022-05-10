package model;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class HistoricoEstadosEquipamento {

    private UUID uuidEquipamento;
    private UUID uuidEstadoEquipamento;
    private Date data;

    public HistoricoEstadosEquipamento(){
        this("", "", (Date) null);
    }

    public HistoricoEstadosEquipamento(String uudEqipamento, String uuidEstadoEquipamento, Date date) {

        this.uuidEquipamento = UUID.fromString(uudEqipamento);
        this.uuidEstadoEquipamento = UUID.fromString(uuidEstadoEquipamento);
        this.data = date;
    }

    public HistoricoEstadosEquipamento(String uudEqipamento, String uuidEstadoEquipamento, String date) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        this.uuidEquipamento = UUID.fromString(uudEqipamento);
        this.uuidEstadoEquipamento = UUID.fromString(uuidEstadoEquipamento);
        this.data = df.parse(date);
    }

    public UUID getUuidEquipamento() {
        return uuidEquipamento;
    }

    public void setUuidEquipamento(UUID uuidEquipamento) {
        this.uuidEquipamento = uuidEquipamento;
    }

    public UUID getUuidEstadoEquipamento() {
        return uuidEstadoEquipamento;
    }

    public void setUuidEstadoEquipamento(UUID uuidEstadoEquipamento) {
        this.uuidEstadoEquipamento = uuidEstadoEquipamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("idEquipment", this.getUuidEquipamento().toString());
        objetoJSON.put("idState", this.getUuidEstadoEquipamento().toString());
        objetoJSON.put("date", this.getData().toString());

        return objetoJSON;
    }
}
