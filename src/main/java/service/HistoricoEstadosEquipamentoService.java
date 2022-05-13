package service;

import dao.HistoricoEstadosEquipamentoDAO;
import model.HistoricoEstadosEquipamento;

import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.util.UUID;

public class HistoricoEstadosEquipamentoService {

    private HistoricoEstadosEquipamentoDAO historicoEstadosEquipamentoDAO;

    public HistoricoEstadosEquipamentoService(){
        historicoEstadosEquipamentoDAO = new HistoricoEstadosEquipamentoDAO();
    }

    public Object add(Request request, Response response) throws ParseException {

        String idEquipment = request.queryParams("idEquipment");
        String idState = request.queryParams("idState");
        String date = request.queryParams("date");

        HistoricoEstadosEquipamento historicoEstadosEquipamento = new HistoricoEstadosEquipamento(idEquipment, idState, date);

        historicoEstadosEquipamentoDAO.conectar();
        historicoEstadosEquipamentoDAO.createDAO(historicoEstadosEquipamento);
        historicoEstadosEquipamentoDAO.close();

        response.status(201);

        return historicoEstadosEquipamento.toJSON();
    }

    public Object getHistoricoPorPorDataEEquipamento(Request request, Response response) {

        String idEquipment = request.params(":idEquipment");
        String dateString = request.params(":date");
        UUID uuidEquipment = UUID.fromString(idEquipment);

        historicoEstadosEquipamentoDAO.conectar();
        HistoricoEstadosEquipamento historicoEstadosEquipamento = historicoEstadosEquipamentoDAO.readHistoricoPorDataEEquipamento(uuidEquipment, dateString);
        historicoEstadosEquipamentoDAO.close();

        if(historicoEstadosEquipamento == null){
            response.status(404);
            return "ID: " + idEquipment + " | " + dateString + "não encontrado.";
        }

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return historicoEstadosEquipamento.toJSON();
    }

    public Object getHistoricoPorEquipamentoEPorEstado(Request request, Response response){

        String idEquipment = request.params(":idEquipment");
        String idState = request.params(":idState");
        UUID uuidEquipment = UUID.fromString(idEquipment);
        UUID uuidState = UUID.fromString(idState);

        historicoEstadosEquipamentoDAO.conectar();
        HistoricoEstadosEquipamento []historicoEstadosEquipamento = historicoEstadosEquipamentoDAO.readHistoricoPorEquipamentoEPorEstado(uuidEquipment, uuidState);
        historicoEstadosEquipamentoDAO.close();

        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0; i < historicoEstadosEquipamento.length; i++) {

            HistoricoEstadosEquipamento historicoEstado = historicoEstadosEquipamento[i];

            buffer.append(historicoEstado.toJSON());

            if(i+1 != historicoEstadosEquipamento.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object getHistoricoPorEquipamento(Request request, Response response){

        String idEquipment = request.params(":idEquipment");
        UUID uuidEquipment = UUID.fromString(idEquipment);

        historicoEstadosEquipamentoDAO.conectar();
        HistoricoEstadosEquipamento []historicoEstadosEquipamento = historicoEstadosEquipamentoDAO.readHistoricoPorEquipamento(uuidEquipment);
        historicoEstadosEquipamentoDAO.close();

        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0; i < historicoEstadosEquipamento.length; i++) {

            HistoricoEstadosEquipamento historicoEstado = historicoEstadosEquipamento[i];

            buffer.append(historicoEstado.toJSON());

            if(i+1 != historicoEstadosEquipamento.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object getAllHistorico(Request request, Response response){

        historicoEstadosEquipamentoDAO.conectar();
        HistoricoEstadosEquipamento []historicoEstadosEquipamento = historicoEstadosEquipamentoDAO.readAllHistorico();
        historicoEstadosEquipamentoDAO.close();

        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0; i < historicoEstadosEquipamento.length; i++) {

            HistoricoEstadosEquipamento historicoEstado = historicoEstadosEquipamento[i];

            buffer.append(historicoEstado.toJSON());

            if(i+1 != historicoEstadosEquipamento.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object update(Request request, Response response) throws ParseException{
        return this.add(request, response);
    }

    public Object delete(Request request, Response response) {

        String uuid = request.params(":idEquipment");
        String date = request.params(":date");

        UUID uuidEquipamento = UUID.fromString(uuid);

        historicoEstadosEquipamentoDAO.conectar();
        HistoricoEstadosEquipamento historicoEstadosEquipamento = historicoEstadosEquipamentoDAO.readHistoricoPorDataEEquipamento(uuidEquipamento, date);

        if (historicoEstadosEquipamento == null) {
            historicoEstadosEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " nao encontrado.";
        }

        historicoEstadosEquipamentoDAO.deleteDAO(historicoEstadosEquipamento);
        historicoEstadosEquipamentoDAO.close();

        response.status(200);

        return historicoEstadosEquipamento.toJSON();
    }

}
