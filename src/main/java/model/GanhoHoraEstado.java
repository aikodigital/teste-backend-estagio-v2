package model;

import org.json.JSONObject;

import java.util.UUID;

public class GanhoHoraEstado {

    private UUID uuidModel;
    private UUID uuidState;
    private double valor;

    public GanhoHoraEstado(){
        this("", "", 0.0);
    }

    public GanhoHoraEstado(String uuidModel, String uuidState, double valor){

        this.uuidModel = UUID.fromString(uuidModel);
        this.uuidState = UUID.fromString(uuidState);
        this.valor = valor;
    }

    public UUID getUuidModel() {
        return uuidModel;
    }

    public void setUuidModel(UUID uuidModel) {
        this.uuidModel = uuidModel;
    }

    public UUID getUuidState() {
        return uuidState;
    }

    public void setUuidState(UUID uuidState) {
        this.uuidState = uuidState;
    }

    public double getValor() {
        return valor;
    }

    public void setVaalor(double valor) {
        this.valor = valor;
    }

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("idModel", this.getUuidModel().toString());
        objetoJSON.put("idStatus", this.getUuidState().toString());
        objetoJSON.put("value", this.getValor());

        return objetoJSON;
    }
}
