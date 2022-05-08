package model;

import org.json.JSONObject;

public class EstadoEquipamento {
    private String uuid;
    private String nome;
    private String cor;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("id", this.getUuid().toString());
        objetoJSON.put("name", this.getNome());
        objetoJSON.put("color", this.getCor());

        return objetoJSON;
    }
}
