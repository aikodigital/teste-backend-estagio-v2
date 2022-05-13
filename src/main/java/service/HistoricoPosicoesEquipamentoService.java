package service;

import dao.HistoricoEstadosEquipamentoDAO;
import dao.HistoricoPosicoesEquipamentoDAO;
import model.GanhoHoraEstado;
import model.HistoricoEstadosEquipamento;
import model.HistoricoPosicoesEquipamento;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.util.UUID;

public class HistoricoPosicoesEquipamentoService {

    private HistoricoPosicoesEquipamentoDAO historicoPosicoesEquipamentoDAO;

    public HistoricoPosicoesEquipamentoService(){
        historicoPosicoesEquipamentoDAO = new HistoricoPosicoesEquipamentoDAO();
    }

    public Object add(Request request, Response response) throws ParseException {

        String idEquipment = request.queryParams("idEquipment");
        String date = request.queryParams("date");
        double lat = Double.parseDouble(request.queryParams("lat"));
        double lon = Double.parseDouble(request.queryParams("lon"));

        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = new HistoricoPosicoesEquipamento(idEquipment, date, lat, lon);

        historicoPosicoesEquipamentoDAO.conectar();
        historicoPosicoesEquipamentoDAO.createDAO(historicoPosicoesEquipamento);
        historicoPosicoesEquipamentoDAO.close();

        response.status(201);

        return historicoPosicoesEquipamento.toJSON();
    }


    public Object getHistoricoPorIDEquipamento(Request request, Response response) {

        String idEquipment = request.params(":idEquipment");
        UUID uuidEquipment = UUID.fromString(idEquipment);

        historicoPosicoesEquipamentoDAO.conectar();
        HistoricoPosicoesEquipamento [] historicoPosicoesEquipamento = historicoPosicoesEquipamentoDAO.readHistoricoPosicoesIDEquipamento(uuidEquipment);
        historicoPosicoesEquipamentoDAO.close();

        if(historicoPosicoesEquipamento == null){
            response.status(404);
            return "ID: " + idEquipment + "não encontrado.";
        }

        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0 ; i < historicoPosicoesEquipamento.length; i++){
            HistoricoPosicoesEquipamento historicoPosicoes = historicoPosicoesEquipamento[i];

            buffer.append(historicoPosicoes.toJSON());

            if(i+1 != historicoPosicoesEquipamento.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object getAllHistorico(Request request, Response response){

        historicoPosicoesEquipamentoDAO.conectar();
        HistoricoPosicoesEquipamento [] historicoPosicoesEquipamentos = historicoPosicoesEquipamentoDAO.readAllHistoricoPosicoes();
        historicoPosicoesEquipamentoDAO.close();

        StringBuffer buffer = new StringBuffer("[");

        for (int i = 0; i < historicoPosicoesEquipamentos.length; i++) {

            HistoricoPosicoesEquipamento historicoPosicoes = historicoPosicoesEquipamentos[i];

            buffer.append(historicoPosicoes.toJSON());

            if(i+1 != historicoPosicoesEquipamentos.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object update(Request request, Response response){

        String uuidEquipment = request.params(":idEquipment");
        String date = request.params(":date");

        UUID uuid = UUID.fromString(uuidEquipment);

        historicoPosicoesEquipamentoDAO.conectar();
        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = historicoPosicoesEquipamentoDAO.readPorIdEquipamentoEPorData(uuid, date);

        if (historicoPosicoesEquipamento == null){
            historicoPosicoesEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " não encontrado.";
        }

        double lat = Double.parseDouble(request.queryParams("lat"));
        double lon = Double.parseDouble(request.queryParams("lon"));

        historicoPosicoesEquipamento.setLatitude(lat);
        historicoPosicoesEquipamento.setLatitude(lon);
        historicoPosicoesEquipamentoDAO.close();

        return historicoPosicoesEquipamento.toJSON();
    }


    public Object delete(Request request, Response response) {

        String uuid = request.params(":idEquipment");
        String date = request.params(":date");

        historicoPosicoesEquipamentoDAO.conectar();
        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = historicoPosicoesEquipamentoDAO.readPorIdEquipamentoEPorData(UUID.fromString(uuid), date);

        if (historicoPosicoesEquipamento == null) {
            historicoPosicoesEquipamentoDAO.close();
            response.status(404);
            return "ID: " + uuid + " não encontrado.";
        }

        historicoPosicoesEquipamentoDAO.deleteDAO(historicoPosicoesEquipamento);
        historicoPosicoesEquipamentoDAO.close();

        response.status(200);

        return historicoPosicoesEquipamento.toJSON();
    }

}
