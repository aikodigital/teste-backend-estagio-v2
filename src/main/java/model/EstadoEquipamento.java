package model;

import org.json.JSONObject;

import java.util.UUID;

public class EstadoEquipamento {

    private UUID uuid;
    private String nome;
    private String cor;

    public EstadoEquipamento(){
        this("", "", "");
    }

    public EstadoEquipamento(String uuid, String name, String color){
        this.uuid = UUID.fromString(uuid);
        this.nome = name;
        this.cor = color;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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
