package app;

import model.ModeloEquipamento;
import org.json.JSONObject;
import service.EquipamentoService;
import service.EstadoEquipamentoService;
import service.GanhoHoraEstadoService;
import service.ModeloEquipamentoService;

import static spark.Spark.*;

public class Aplicacao {

    private static EquipamentoService equipamentoService = new EquipamentoService();
    private static EstadoEquipamentoService estadoEquipamentoService = new EstadoEquipamentoService();
    private static ModeloEquipamentoService modeloEquipamentoService = new ModeloEquipamentoService();
    private static GanhoHoraEstadoService ganhoHoraEstadoService = new GanhoHoraEstadoService();

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
    }
}
