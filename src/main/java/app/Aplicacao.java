package app;

import org.json.JSONObject;
import service.EquipamentoService;
import service.EstadoEquipamentoService;

import static spark.Spark.*;

public class Aplicacao {

    private static EquipamentoService equipamentoService = new EquipamentoService();
    private static EstadoEquipamentoService estadoEquipamentoService = new EstadoEquipamentoService();

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




    }
}
