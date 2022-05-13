package dao;

import interfaces.CRUD;
import model.Equipamento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class EquipamentoDAO extends DAO {

    public EquipamentoDAO(){
        super("operation.equipment");
    }

    public EquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }

    @Override
    public boolean createDAO(Object objeto) {
        Equipamento equipamento = (Equipamento) objeto;
        return createEquipamento(equipamento);
    }

    private boolean createEquipamento(Equipamento equipamento){

        String atributos = ("id, equipment_model_id, name");
        String valores = String.format("'%s', '%s', '%s'", equipamento.getUuid().toString(), equipamento.getUuidModel().toString(),equipamento.getNome());

        boolean status = insertDAO(atributos, valores);

        return status;
    }


    public Equipamento read(UUID uuid) {

        Equipamento equipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("id='%s'", uuid.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                equipamento = new Equipamento(rs.getString("id"), rs.getString("equipment_model_id"),  rs.getString("name"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return equipamento;
    }

    public Equipamento[] readAll(){

        Equipamento[] equipamentos = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);

            if (rs.next()){

                rs.last();
                equipamentos = new Equipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0 ; rs.next() ; i++) {
                    equipamentos[i] = new Equipamento(rs.getString("id"), rs.getString("equipment_model_id"), rs.getString("name"));
                }
            }

            st.close();

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        return equipamentos;
    }

    @Override
    public boolean updateDAO(Object objeto){
        Equipamento equipamento = (Equipamento) objeto;
        return updateEquipamento(equipamento);
    }

    private boolean updateEquipamento(Equipamento equipamento){

        String set = String.format("name='%s'", equipamento.getNome());
        String where = String.format("id='%s'", equipamento.getUuid().toString());

        boolean status = updateDAO(set, where);
        return status;
    }

    @Override
    public boolean deleteDAO(Object objeto){
        Equipamento equipamento = (Equipamento) objeto;
        return deleteDisciplina(equipamento);
    }

    private boolean deleteDisciplina(Equipamento equipamento) {

        String where = String.format("id='%s'",equipamento.getUuid().toString());

        boolean status = deleteDAO(where);
        return status;
    }

}
