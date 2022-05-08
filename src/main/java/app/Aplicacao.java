package app;

import org.json.JSONObject;
import service.EquipamentoService;
import static spark.Spark.*;

public class Aplicacao {

    private static EquipamentoService equipamentoService = new EquipamentoService();

    public static void main(String[] args) {


        post("/equipamento", (request, response) -> equipamentoService.add(request, response));
        get("/equipamento/read/:id", (request, response) -> equipamentoService.get(request, response));
        put("/equipamento/update/:id", (request, response) -> equipamentoService.update(request, response));
        get ("/equipamento/delete/:id", (request, response) -> equipamentoService.delete(request, response));
        get("/equipamentos", (request, response) -> equipamentoService.getAll(request, response));

        post("/modeloequipamento", (request, response) -> equipamentoService.add(request, response));



    }
}
