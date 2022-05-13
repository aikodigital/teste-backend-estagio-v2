package app;

import dao.HistoricoPosicoesEquipamentoDAO;
import model.ModeloEquipamento;
import org.json.JSONObject;
import service.*;

import static spark.Spark.*;

public class Aplicacao {

    private static EquipamentoService equipamentoService = new EquipamentoService();
    private static EstadoEquipamentoService estadoEquipamentoService = new EstadoEquipamentoService();
    private static ModeloEquipamentoService modeloEquipamentoService = new ModeloEquipamentoService();
    private static GanhoHoraEstadoService ganhoHoraEstadoService = new GanhoHoraEstadoService();
    private static HistoricoEstadosEquipamentoService historicoEstadosEquipamentoService = new HistoricoEstadosEquipamentoService();
    private static HistoricoPosicoesEquipamentoService historicoPosicoesEquipamentoService = new HistoricoPosicoesEquipamentoService();

    public static void main(String[] args) {

        post("/equipamento", (request, response) -> equipamentoService.add(request, response));
        get("/equipamento/read/:id", (request, response) -> equipamentoService.get(request, response));
        put("/equipamento/update/:id", (request, response) -> equipamentoService.update(request, response));
        get ("/equipamento/delete/:id", (request, response) -> equipamentoService.delete(request, response));
        get("/equipamentos", (request, response) -> equipamentoService.getAll(request, response));


        post("/estado/equipamento", (request, response) -> estadoEquipamentoService.add(request, response));
        get("/estado/equipamento/read/:id", (request, response) -> estadoEquipamentoService.get(request, response));
        put("/estado/equipamento/update/:id", (request, response) -> estadoEquipamentoService.update(request, response));
        get("/estado/equipamento/delete/:id", (request, response) -> estadoEquipamentoService.delete(request, response));
        get("/estado/equipamentos", (request, response) -> estadoEquipamentoService.getAll(request, response));


        post("/modelo/equipamento", (request, response) -> modeloEquipamentoService.add(request, response));
        get("/modelo/equipamento/read/:id", (request, response) -> modeloEquipamentoService.get(request, response));
        put("/modelo/equipamento/update/:id", (request, response) -> modeloEquipamentoService.update(request, response));
        get("/modelo/equipamento/delete/:id", (request, response) -> modeloEquipamentoService.delete(request, response));
        get("/modelo/equipamentos", (request, response) -> modeloEquipamentoService.getAll(request, response));


        post("/ganho", (request, response) -> ganhoHoraEstadoService.add(request, response));
        get("/ganho/read/:idModel/:idState", (request, response) -> ganhoHoraEstadoService.get(request, response));
        put("/ganho/update/:idModel/:idState", (request, response) -> ganhoHoraEstadoService.update(request, response));
        get("/ganho/delete/:idModel/:idState", (request, response) -> ganhoHoraEstadoService.delete(request, response));
        get("/ganhos", (request, response) -> ganhoHoraEstadoService.getAll(request, response));


        post("/historico/estado", (request, response) -> historicoEstadosEquipamentoService.add(request,response));
        get("/historico/estados/read/:idEquipment", (request, response) -> historicoEstadosEquipamentoService.getHistoricoPorEquipamento(request,response));
        get("/historico/estados/read/:idEquipment/:idState", (request, response) -> historicoEstadosEquipamentoService.getHistoricoPorEquipamentoEPorEstado(request,response));
        get("/historico/estados/read/de/:idEquipment/:date", (request, response) -> historicoEstadosEquipamentoService.getHistoricoPorPorDataEEquipamento(request,response));
        post("/historico/estados/update", (request, response) -> historicoEstadosEquipamentoService.update(request,response));
        get("/historico/estados/delete/:idEquipment/:date", (request, response) -> historicoEstadosEquipamentoService.delete(request,response));
        get("/historico/estados", (request, response) -> historicoEstadosEquipamentoService.getAllHistorico(request,response));


        post("/historico/posicao", (request, response) -> historicoPosicoesEquipamentoService.add(request, response));
        get("/historico/posicao/read/:idEquipment", (request, response) -> historicoPosicoesEquipamentoService.getHistoricoPorIDEquipamento(request, response));
        put("/historico/posicao/update/:idEquipment/:date", (request, response) -> historicoPosicoesEquipamentoService.update(request, response));
        get("/historico/posicao/delete/:idEquipment/:date", (request, response) -> historicoPosicoesEquipamentoService.delete(request, response));
        get("/historico/posicoes", (request, response) -> historicoPosicoesEquipamentoService.getAllHistorico(request, response));
    }
}
