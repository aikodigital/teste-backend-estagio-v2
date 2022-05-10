package service;

import dao.EstadoEquipamentoDAO;
import model.Equipamento;
import model.EstadoEquipamento;
import spark.Request;
import spark.Response;

import java.util.UUID;

public class EstadoEquipamentoService {

    private EstadoEquipamentoDAO estadoEquipamentoDAO;

    public EstadoEquipamentoService(){
        estadoEquipamentoDAO = new EstadoEquipamentoDAO();
    }

    public Object add(Request request, Response response){

        UUID uuid = UUID.randomUUID();
        String name = request.queryParams("name");
        String color = "#" + request.queryParams("color");
        String id = uuid.toString();

        EstadoEquipamento estadoEquipamento = new EstadoEquipamento(id, name, color);

        estadoEquipamentoDAO.conectar();
        estadoEquipamentoDAO.createDAO(estadoEquipamento);
        estadoEquipamentoDAO.close();

        response.status(201);

        return "Equipamento " + estadoEquipamento.toJSON() + "criado.";
    }

    public Object get(Request request, Response response){

        String id = request.params(":id");
        UUID uuid = UUID.fromString(id);

        estadoEquipamentoDAO.conectar();
        EstadoEquipamento estadoEquipamento = estadoEquipamentoDAO.readEstadoEquipamento(uuid);
        estadoEquipamentoDAO.close();

        if(estadoEquipamento == null){
            response.status(404);
            return "Equipamento: " + id + "não encontrado.";
        }

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return "Estado Equipamento: " + estadoEquipamento.toJSON();
    }

    public Object getAll(Request request, Response response){

        StringBuffer buffer = new StringBuffer("[");

        estadoEquipamentoDAO.conectar();
        EstadoEquipamento[] estadoEquipamentos = estadoEquipamentoDAO.readAllEstadoEquipamento();
        estadoEquipamentoDAO.close();

        for (int i = 0; i < estadoEquipamentos.length; i++) {

            EstadoEquipamento estadoEquipamento = estadoEquipamentos[i];

            buffer.append(estadoEquipamento.toJSON());

            if(i+1 != estadoEquipamentos.length){
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

        estadoEquipamentoDAO.conectar();
        EstadoEquipamento estadoEquipamento = (EstadoEquipamento) estadoEquipamentoDAO.readEstadoEquipamento(UUID.fromString(uuid));

        if (estadoEquipamento == null) {
            estadoEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " não encontrado.";
        }

        estadoEquipamento.setNome(request.queryParams("name"));
        estadoEquipamento.setCor(request.queryParams("color"));

        estadoEquipamentoDAO.updateDAO(estadoEquipamento);
        estadoEquipamentoDAO.close();

        return estadoEquipamento.toJSON();
    }

    public Object delete(Request request, Response response) {

        String uuid = request.params(":id");

        estadoEquipamentoDAO.conectar();
        EstadoEquipamento estadoEquipamento = (EstadoEquipamento) estadoEquipamentoDAO.readEstadoEquipamento(UUID.fromString(uuid));

        if (estadoEquipamento == null) {
            estadoEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " nao encontrado.";
        }

        estadoEquipamentoDAO.deleteDAO(estadoEquipamento);
        estadoEquipamentoDAO.close();

        response.status(200);

        return estadoEquipamento.toJSON();
    }
}


