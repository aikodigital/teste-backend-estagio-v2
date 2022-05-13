package dao;

import model.HistoricoPosicoesEquipamento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class HistoricoPosicoesEquipamentoDAO extends DAO{

    public HistoricoPosicoesEquipamentoDAO(){
        super("operation.equipment_position_history");
    }

    public HistoricoPosicoesEquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }

    public boolean createDAO(Object objeto) {
        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = (HistoricoPosicoesEquipamento) objeto;
        return createHistoricoPosicoesEquipamento(historicoPosicoesEquipamento);
    }

    private boolean createHistoricoPosicoesEquipamento(HistoricoPosicoesEquipamento historicoPosicoesEquipamento){

        String atributos = ("equipment_id, date, lat, lon");

        String valores = String.format("'%s','%s', %s, %s", historicoPosicoesEquipamento.getUuidEquipamento(), historicoPosicoesEquipamento.getData(), historicoPosicoesEquipamento.getSLatitude(), historicoPosicoesEquipamento.getSLongitude());

        boolean status = insertDAO(atributos, valores);

        return status;
    }

    public HistoricoPosicoesEquipamento [] readHistoricoPosicoesIDEquipamento(UUID uuid) {

        HistoricoPosicoesEquipamento [] historicoPosicoesEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_id='%s'", uuid.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.last();
                historicoPosicoesEquipamento = new HistoricoPosicoesEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++){
                    historicoPosicoesEquipamento[i] = new HistoricoPosicoesEquipamento(rs.getString("equipment_id"), rs.getString("date"), rs.getDouble("lat"), rs.getDouble("lon"));
                }

            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoPosicoesEquipamento;
    }

    public HistoricoPosicoesEquipamento readPorIdEquipamentoEPorData(UUID uuid, String date){

        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_id='%s' and date='%s'", uuid.toString(), date);
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                historicoPosicoesEquipamento = new HistoricoPosicoesEquipamento(rs.getString("equipment_id"), rs.getString("date"), rs.getDouble("lat"), rs.getDouble("lon"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoPosicoesEquipamento;
    }

    public HistoricoPosicoesEquipamento [] readAllHistoricoPosicoes() {

        HistoricoPosicoesEquipamento [] historicoPosicoesEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s", nomeTabela));

            if(rs.next()){

                rs.last();
                historicoPosicoesEquipamento = new HistoricoPosicoesEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++){
                    historicoPosicoesEquipamento[i] = new HistoricoPosicoesEquipamento(rs.getString("equipment_id"), rs.getString("date"), rs.getDouble("lat"), rs.getDouble("lon"));
                }

            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return historicoPosicoesEquipamento;
    }

    public boolean updateDAO(Object objeto){
        HistoricoPosicoesEquipamento historicoPosicoesEquipamento = (HistoricoPosicoesEquipamento) objeto;
        return updateHistoricoPosicoesEquipamento(historicoPosicoesEquipamento);
    }

    private boolean updateHistoricoPosicoesEquipamento(HistoricoPosicoesEquipamento historicoPosicoesEquipamento){

        String set = String.format("lat=%.6f, lon=%.6f", historicoPosicoesEquipamento.getLatitude(), historicoPosicoesEquipamento.getLongitude());
        String where = String.format("equipment_id='%s' AND date='%s'", historicoPosicoesEquipamento.getUuidEquipamento().toString(), historicoPosicoesEquipamento.getData());

        boolean status = updateDAO(set, where);
        return status;
    }


    private boolean deleteHistoricoPosicoesEquipamento(HistoricoPosicoesEquipamento historicoPosicoesEquipamento) {
        String where = String.format("equipment_id='%s' AND date='%s'", historicoPosicoesEquipamento.getUuidEquipamento().toString(), historicoPosicoesEquipamento.getData());
        return deleteDAO(where);
    }

}