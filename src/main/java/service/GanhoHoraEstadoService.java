package service;

import dao.GanhoHoraEstadoDAO;
import dao.ModeloEquipamentoDAO;
import model.GanhoHoraEstado;
import model.ModeloEquipamento;
import spark.Request;
import spark.Response;

import java.util.UUID;

public class GanhoHoraEstadoService {

    private GanhoHoraEstadoDAO ganhoHoraEstadoDAO;

    public GanhoHoraEstadoService (){
        ganhoHoraEstadoDAO = new GanhoHoraEstadoDAO();
    }

    public Object add(Request request, Response response){

        String idModel = request.queryParams("idModel");
        String idState = request.queryParams("idState");
        double value = Double.parseDouble(request.queryParams("value"));

        GanhoHoraEstado ganhoHoraEstado = new GanhoHoraEstado(idModel, idState, value);

        ganhoHoraEstadoDAO.conectar();
        ganhoHoraEstadoDAO.createDAO(ganhoHoraEstado);
        ganhoHoraEstadoDAO.close();

        response.status(201);

        return ganhoHoraEstado.toJSON();
    }

    public Object get(Request request, Response response){

        String idModel = request.params(":idModel");
        String idState = request.params(":idState");
        UUID uuidModel = UUID.fromString(idModel);
        UUID uuidState = UUID.fromString(idState);

        ganhoHoraEstadoDAO.conectar();
        GanhoHoraEstado ganhoHoraEstado = ganhoHoraEstadoDAO.readGanhoHoraEstado(uuidModel, uuidState);
        ganhoHoraEstadoDAO.close();

        if(ganhoHoraEstado == null){
            response.status(404);
            return "Ganho: " + uuidModel + " | " + uuidState + "não encontrado.";
        }

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return ganhoHoraEstado.toJSON();
    }

    public Object getAll(Request request, Response response){

        StringBuffer buffer = new StringBuffer("[");

        ganhoHoraEstadoDAO.conectar();
        GanhoHoraEstado[] ganhoHoraEstados = ganhoHoraEstadoDAO.readAllGanhoHoraEstado();
        ganhoHoraEstadoDAO.close();

        for (int i = 0; i < ganhoHoraEstados.length; i++) {

            GanhoHoraEstado ganhoHoraEstado = ganhoHoraEstados[i];

            buffer.append(ganhoHoraEstado.toJSON());

            if(i+1 != ganhoHoraEstados.length){
                buffer.append(",");
            }
        }

        buffer.append("]");

        response.header("Content-Type", "application/json");
        response.header("Content-Encoding", "UTF-8");

        return buffer.toString();
    }

    public Object update(Request request, Response response) {

        String uuidModel = request.params(":idModel");
        String uuidState = request.params(":idState");

        ganhoHoraEstadoDAO.conectar();
        GanhoHoraEstado ganhoHoraEstado = (GanhoHoraEstado) ganhoHoraEstadoDAO.readGanhoHoraEstado(UUID.fromString(uuidModel), UUID.fromString(uuidState));

        if (ganhoHoraEstado == null) {
            ganhoHoraEstadoDAO.close();
            response.status(404);
            return "ID: " + uuidModel + " | " + uuidState + " não encontrado.";
        }

        ganhoHoraEstado.setVaalor(Double.parseDouble(request.queryParams("value")));

        ganhoHoraEstadoDAO.updateDAO(ganhoHoraEstado);
        ganhoHoraEstadoDAO.close();

        return ganhoHoraEstado.toJSON();
    }

    public Object delete(Request request, Response response) {

        String uuidModel = request.params(":idModel");
        String uuidState = request.params(":idState");

        ganhoHoraEstadoDAO.conectar();
        GanhoHoraEstado ganhoHoraEstado = (GanhoHoraEstado) ganhoHoraEstadoDAO.readGanhoHoraEstado(UUID.fromString(uuidModel), UUID.fromString(uuidState));

        if (ganhoHoraEstado == null) {
            ganhoHoraEstadoDAO.close();
            response.status(404);
            return "ID: " + uuidModel + " | " + uuidState + " não encontrado.";
        }

        ganhoHoraEstadoDAO.deleteDAO(ganhoHoraEstado);
        ganhoHoraEstadoDAO.close();

        response.status(200);

        return ganhoHoraEstado.toJSON();
    }
}
