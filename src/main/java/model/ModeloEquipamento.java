package model;

import org.json.JSONObject;

import java.util.UUID;

public class ModeloEquipamento {

    private UUID uuid;
    private String nome;

    public ModeloEquipamento(){
        this("", "");
    }

    public ModeloEquipamento(String uuid, String nome){
        this.uuid = UUID.fromString(uuid);
        this.nome = nome;
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

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("id", this.getUuid().toString());
        objetoJSON.put("name", this.getNome());

        return objetoJSON;
    }
}
