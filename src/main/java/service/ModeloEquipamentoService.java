package service;

import dao.ModeloEquipamentoDAO;
import model.EstadoEquipamento;
import model.ModeloEquipamento;
import spark.Request;
import spark.Response;

import java.util.UUID;


public class ModeloEquipamentoService {

    private ModeloEquipamentoDAO modeloEquipamentoDAO;

    public ModeloEquipamentoService(){
        modeloEquipamentoDAO = new ModeloEquipamentoDAO();
    }

    public Object add(Request request, Response response){

        UUID uuid = UUID.randomUUID();
        String name = request.queryParams("name");
        String id = uuid.toString();

        ModeloEquipamento modeloEquipamento = new ModeloEquipamento(id, name);

        modeloEquipamentoDAO.conectar();
        modeloEquipamentoDAO.createDAO(modeloEquipamento);
        modeloEquipamentoDAO.close();

        response.status(201);

        return "Modelo Equipamento " + modeloEquipamento.toJSON() + "criado.";
    }

    public Object get(Request request, Response response){

        String id = request.params(":id");
        UUID uuid = UUID.fromString(id);

        modeloEquipamentoDAO.conectar();
        ModeloEquipamento modeloEquipamento = modeloEquipamentoDAO.readModeloEquipamento(uuid);
        modeloEquipamentoDAO.close();

        if(modeloEquipamento == null){
            response.status(404);
            return "Equipamento: " + id + "não encontrado.";
        }

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return "Modelo Equipamento: " + modeloEquipamento.toJSON();
    }

    public Object getAll(Request request, Response response){

        StringBuffer buffer = new StringBuffer();

        modeloEquipamentoDAO.conectar();
        ModeloEquipamento[] modeloEquipamentos = modeloEquipamentoDAO.readAllModeloEquipamento();
        modeloEquipamentoDAO.close();

        for (int i = 0; i < modeloEquipamentos.length; i++) {

            ModeloEquipamento modeloEquipamento = modeloEquipamentos[i];

            buffer.append(modeloEquipamento.toJSON());

            if(i+1 != modeloEquipamentos.length){
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

        modeloEquipamentoDAO.conectar();
        ModeloEquipamento modeloEquipamento = (ModeloEquipamento) modeloEquipamentoDAO.readModeloEquipamento(UUID.fromString(uuid));

        if (modeloEquipamento == null) {
            modeloEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " não encontrado.";
        }

        modeloEquipamento.setNome(request.queryParams("name"));

        modeloEquipamentoDAO.updateDAO(modeloEquipamento);
        modeloEquipamentoDAO.close();

        return modeloEquipamento.toJSON();
    }

    public Object delete(Request request, Response response) {

        String uuid = request.params(":id");

        modeloEquipamentoDAO.conectar();
        ModeloEquipamento modeloEquipamento = (ModeloEquipamento) modeloEquipamentoDAO.readModeloEquipamento(UUID.fromString(uuid));

        if (modeloEquipamento == null) {
            modeloEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " nao encontrado.";
        }

        modeloEquipamentoDAO.deleteDAO(modeloEquipamento);
        modeloEquipamentoDAO.close();

        response.status(200);

        return modeloEquipamento.toJSON();
    }
}
