package dao;

import model.EstadoEquipamento;
import model.ModeloEquipamento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class ModeloEquipamentoDAO extends DAO{
    public ModeloEquipamentoDAO(){
        super("operation.equipment_model");
    }

    public ModeloEquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }

    @Override
    public boolean createDAO(Object objeto) {
        ModeloEquipamento modeloEquipamento = (ModeloEquipamento)  objeto;
        return createModeloEquipamento(modeloEquipamento);
    }

    private boolean createModeloEquipamento(ModeloEquipamento modeloEquipamento){

        String atributos = ("id, name");
        String valores = String.format("'%s', '%s'", modeloEquipamento.getUuid().toString(), modeloEquipamento.getNome());

        boolean status = insertDAO(atributos, valores);

        return status;
    }

    public ModeloEquipamento readModeloEquipamento(UUID uuid) {

        ModeloEquipamento modeloEquipamento = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("id='%s'", uuid.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                modeloEquipamento = new ModeloEquipamento(rs.getString("id"), rs.getString("name"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return modeloEquipamento;
    }

    public ModeloEquipamento[] readAllModeloEquipamento(){

        ModeloEquipamento[] modeloEquipamentos = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);

            if (rs.next()){

                rs.last();
                modeloEquipamentos = new ModeloEquipamento[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0 ; rs.next() ; i++) {
                    modeloEquipamentos[i] = new ModeloEquipamento(rs.getString("id"), rs.getString("name"));
                }
            }

            st.close();

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        return modeloEquipamentos;
    }

    public boolean updateDAO(Object objeto){
        ModeloEquipamento modeloEquipamentos = (ModeloEquipamento) objeto;
        return updateModeloEquipamento(modeloEquipamentos);
    }

    private boolean updateModeloEquipamento(ModeloEquipamento modeloEquipamentos){

        String set = String.format("name='%s'", modeloEquipamentos.getNome());
        String where = String.format("id='%s'", modeloEquipamentos.getUuid().toString());

        boolean status = updateDAO(set, where);
        return status;
    }

    public boolean deleteDAO(Object objeto){
        ModeloEquipamento modeloEquipamentos = (ModeloEquipamento) objeto;
        return deleteModeloEquipamento(modeloEquipamentos);
    }

    private boolean deleteModeloEquipamento(ModeloEquipamento modeloEquipamentos) {

        String where = String.format("id='%s'", modeloEquipamentos.getUuid().toString());

        boolean status = deleteDAO(where);
        return status;
    }
}
