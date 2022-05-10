package dao;

import model.GanhoHoraEstado;
import model.HistoricoEstadosEquipamento;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.UUID;

public class HistoricoEstadosEquipamentoDAO extends DAO{
    public HistoricoEstadosEquipamentoDAO(){
        super("operation.equipment_state_history");
    }

    public HistoricoEstadosEquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }

    public boolean createDAO(Object objeto) {
        HistoricoEstadosEquipamento historicoEstadosEquipamento = (HistoricoEstadosEquipamento) objeto;
        return createHistoricoEstadosEquipamento(historicoEstadosEquipamento);
    }

    private boolean createHistoricoEstadosEquipamento(HistoricoEstadosEquipamento historicoEstadosEquipamento){

        String atributos = ("equipment_id, equipment_state_id, date");

        String valores = String.format("'%s','%s','%s'", historicoEstadosEquipamento.getUuidEquipamento().toString(), historicoEstadosEquipamento.getUuidEstadoEquipamento().toString(), historicoEstadosEquipamento.getData().toString());

        boolean status = insertDAO(atributos, valores);

        return status;
    }

    public HistoricoEstadosEquipamento readHistoricoPorDataEEquipamento(UUID uuid, String date) {

        HistoricoEstadosEquipamento historicoEstadosEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_id='%s' and date='%s'", uuid.toString(), date);
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                historicoEstadosEquipamento = new HistoricoEstadosEquipamento (rs.getString("equipment_id"), rs.getString("equipment_state_id"), rs.getString("date"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoEstadosEquipamento;
    }

    public HistoricoEstadosEquipamento [] readHistoricoPorEquipamentoEPorEstado(UUID uuid, UUID uuidState) {

        HistoricoEstadosEquipamento [] historicoEstadosEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_id='%s' and equipment_state_id='%s'", uuid.toString(), uuidState.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.last();
                historicoEstadosEquipamento = new HistoricoEstadosEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    historicoEstadosEquipamento[i] = new HistoricoEstadosEquipamento (rs.getString("equipment_id"), rs.getString("equipment_state_id"), rs.getString("date"));
                }

            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoEstadosEquipamento;
    }

    public HistoricoEstadosEquipamento [] readHistoricoPorEquipamento(UUID uuid) {

        HistoricoEstadosEquipamento [] historicoEstadosEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_id='%s'", uuid.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.last();
                historicoEstadosEquipamento = new HistoricoEstadosEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    historicoEstadosEquipamento[i] = new HistoricoEstadosEquipamento (rs.getString("equipment_id"), rs.getString("equipment_state_id"), rs.getString("date"));
                }

            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoEstadosEquipamento;
    }

    public HistoricoEstadosEquipamento [] readAllHistorico() {

        HistoricoEstadosEquipamento [] historicoEstadosEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s", nomeTabela));

            if(rs.next()){

                rs.last();
                historicoEstadosEquipamento = new HistoricoEstadosEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next() ; i++) {
                    historicoEstadosEquipamento[i] = new HistoricoEstadosEquipamento (rs.getString("equipment_id"), rs.getString("equipment_state_id"), rs.getString("date"));
                }

            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoEstadosEquipamento;
    }


    public boolean updateDAO(Object objeto){
        HistoricoEstadosEquipamento historicoEstadosEquipamento = (HistoricoEstadosEquipamento) objeto;
        return updateHistoricoEstadosEquipamento(historicoEstadosEquipamento);
    }

    private boolean updateHistoricoEstadosEquipamento(HistoricoEstadosEquipamento historicoEstadosEquipamento){

        String set = String.format("equipment_state_id='%s', date='%s'", historicoEstadosEquipamento.getUuidEstadoEquipamento(), LocalDate.now().toString());
        String where = String.format("equipment_id='%s' AND date='%s'", historicoEstadosEquipamento.getUuidEquipamento(), historicoEstadosEquipamento.getUuidEstadoEquipamento(), historicoEstadosEquipamento.getData().toString());

        boolean status = updateDAO(set, where);
        return status;
    }

    public boolean deleteDAO(Object objeto){
        HistoricoEstadosEquipamento historicoEstadosEquipamento = (HistoricoEstadosEquipamento) objeto;
        return deleteHistoricoEstadosEquipamento(historicoEstadosEquipamento);
    }

    private boolean deleteHistoricoEstadosEquipamento(HistoricoEstadosEquipamento historicoEstadosEquipamento) {

        String where = String.format("equipment_id='%s' AND equipment_state_id='%s' AND date='%s'", historicoEstadosEquipamento.getUuidEquipamento(), historicoEstadosEquipamento.getUuidEstadoEquipamento(), historicoEstadosEquipamento.getData().toString());

        boolean status = deleteDAO(where);
        return status;
    }

}
