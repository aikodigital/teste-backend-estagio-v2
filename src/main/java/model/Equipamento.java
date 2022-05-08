package model;

import org.json.JSONObject;
import java.util.UUID;

public class Equipamento {
    private UUID uuid;
    private UUID uuidModel;
    private String nome;

    public Equipamento(){
        this("", "", "");
    }

    public Equipamento(String uuid, String uuidModel, String nome){
        this.uuid = UUID.fromString(uuid);
        this.uuidModel = UUID.fromString(uuidModel);
        this.nome = nome;
    }

    public UUID getUuidModel() {
        return uuidModel;
    }

    public void setUuidModel(UUID uuidModel) {
        this.uuidModel = uuidModel;
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

    @Override
    public String toString(){
        return "Equipamento [id=" + uuid + ", nome=" + nome + "]";
    }

    public JSONObject toJSON(){

        JSONObject objetoJSON = new JSONObject();

        objetoJSON.put("id", this.getUuid().toString());
        objetoJSON.put("idModel", this.getUuidModel().toString());
        objetoJSON.put("name", this.getNome());

        return objetoJSON;
    }

    public String toJson(){
        String json = String.format("{"+
                        "\"id\":\"%s\","+
                        "\"idModel\":\"%s\","+
                        "\"name\":\"%s\""+
                        "}"
                ,getUuid().toString()
                ,getUuidModel().toString()
                ,getNome());
        return json;
    }
}
