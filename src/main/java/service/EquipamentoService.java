package service;

import model.Equipamento;
import dao.EquipamentoDAO;
import spark.*;

import java.util.UUID;

public class EquipamentoService {

    private EquipamentoDAO equipamentoDAO;

    public EquipamentoService(){
        equipamentoDAO = new EquipamentoDAO();
    }

    public Object add(Request request, Response response){

        equipamentoDAO.conectar();

        UUID uuid = UUID.randomUUID();
        String uuidModel = request.queryParams("idModel");
        String nome = request.queryParams("name");
        String id = uuid.toString();

        Equipamento equipamento = new Equipamento(id, uuidModel, nome);

        equipamentoDAO.createDAO(equipamento);
        equipamentoDAO.close();

        response.status(201);

        return "Equipamento " + equipamento.toJson() + "criado.";
    }

    public Object get(Request request, Response response){

        String id = request.params(":id");
        System.out.println("ID " + id);
        UUID uuid = UUID.fromString(id);

        equipamentoDAO.conectar();
        Equipamento equipamento = equipamentoDAO.read(uuid);

        if(equipamento == null){
            equipamentoDAO.close();
            response.status(404);
            return "Equipamento: " + id + "não encontrado.";
        }

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");
        equipamentoDAO.close();

        return "Equipamento: " + equipamento.toJSON();
    }

    public Object getAll(Request request, Response response){

        StringBuffer buffer = new StringBuffer("[");

        equipamentoDAO.conectar();
        Equipamento[] equipamentos = equipamentoDAO.readAll();
        equipamentoDAO.close();

        for(int i = 0;i < equipamentos.length;i++) {

            Equipamento equipamento = equipamentos[i];

            buffer.append(equipamento.toJson());

            if(i+1 != equipamentos.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object update(Request request, Response response) {

        String uuid = request.params(":id");

        equipamentoDAO.conectar();
        Equipamento equipamento = (Equipamento) equipamentoDAO.read(UUID.fromString(uuid));

        if (equipamento == null) {
            equipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " nao encontrado.";
        }

        equipamento.setNome(request.queryParams("name"));
        equipamentoDAO.updateDAO(equipamento);
        equipamentoDAO.close();

        return equipamento.toJson();
    }

    public Object delete(Request request, Response response) {

        String uuid = request.params(":id");

        equipamentoDAO.conectar();
        Equipamento equipamento = (Equipamento) equipamentoDAO.read(UUID.fromString(uuid));

        if (equipamento == null) {
            equipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " nao encontrado.";
        }

        equipamentoDAO.deleteDAO(equipamento);
        equipamentoDAO.close();

        response.status(200);

        return equipamento.toJson();
    }
}
