package model;

import java.util.Date;

public class HistoricoEstadosEquipamento {
    private String uuidEquipamento;
    private Date data;
    private String uuidEstadoEquipamento;

    public String getUuidEquipamento() {
        return uuidEquipamento;
    }

    public void setUuidEquipamento(String uuidEquipamento) {
        this.uuidEquipamento = uuidEquipamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUuidEstadoEquipamento() {
        return uuidEstadoEquipamento;
    }

    public void setUuidEstadoEquipamento(String uuidEstadoEquipamento) {
        this.uuidEstadoEquipamento = uuidEstadoEquipamento;
    }
}
