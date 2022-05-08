package dao;

import model.Equipamento;
import model.EstadoEquipamento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class EstadoEquipamentoDAO extends DAO{

    public EstadoEquipamentoDAO(){
        super("operation.equipment_state");
    }

    public EstadoEquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }

    @Override
    public boolean createDAO(Object objeto) {
        EstadoEquipamento estadoEquipamento = (EstadoEquipamento)  objeto;
        return createEstadoEquipamento(estadoEquipamento);
    }

    private boolean createEstadoEquipamento(EstadoEquipamento estadoEquipamento){

        String atributos = ("id, name, color");
        String valores = String.format("'%s', '%s', '%s'", estadoEquipamento.getUuid().toString(), estadoEquipamento.getNome(), estadoEquipamento.getCor());

        boolean status = insertDAO(atributos, valores);

        return status;
    }


    public EstadoEquipamento read(UUID uuid) {

        EstadoEquipamento estadoEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("id='%s'", uuid.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                estadoEquipamento = new EstadoEquipamento(rs.getString("id"), rs.getString("name"),  rs.getString("color"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return estadoEquipamento;
    }

    public EstadoEquipamento[] readAll(){

        EstadoEquipamento[] estadoEquipamentos = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);

            if (rs.next()){

                rs.last();
                estadoEquipamentos = new EstadoEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0 ; rs.next() ; i++) {
                    estadoEquipamentos[i] = new EstadoEquipamento(rs.getString("id"), rs.getString("name"), rs.getString("color"));
                }
            }

            st.close();

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        return estadoEquipamentos;
    }

    @Override
    public boolean updateDAO(Object objeto){
        EstadoEquipamento estadoEquipamento = (EstadoEquipamento) objeto;
        return updateEquipamento(estadoEquipamento);
    }

    private boolean updateEquipamento(EstadoEquipamento estadoEquipamento){

        String set = String.format("name='%s' , color='%s'", estadoEquipamento.getNome(), estadoEquipamento.getCor());
        String where = String.format("id='%s'", estadoEquipamento.getUuid().toString());

        boolean status = updateDAO(set, where);
        return status;
    }

    @Override
    public boolean deleteDAO(Object objeto){
        EstadoEquipamento estadoEquipamento = (EstadoEquipamento) objeto;
        return deleteDisciplina(estadoEquipamento);
    }

    private boolean deleteDisciplina(EstadoEquipamento estadoEquipamento) {

        String where = String.format("id='%s'",estadoEquipamento.getUuid().toString());

        boolean status = deleteDAO(where);
        return status;
    }
}
