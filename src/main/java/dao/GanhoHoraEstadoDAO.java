package dao;

import model.GanhoHoraEstado;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.UUID;

public class GanhoHoraEstadoDAO extends DAO{
    public GanhoHoraEstadoDAO(){
        super("operation.equipment_model_state_hourly_earnings");
    }

    public GanhoHoraEstadoDAO(String nomeTabela){
        super(nomeTabela);
    }

    public boolean createDAO(Object objeto) {
        GanhoHoraEstado ganhoHoraEstado = (GanhoHoraEstado) objeto;
        return createGanhoHoraEstado(ganhoHoraEstado);
    }

    private boolean createGanhoHoraEstado(GanhoHoraEstado ganhoHoraEstado){

        String atributos = ("equipment_model_id, equipment_state_id, value");

        String valores = String.format("'%s','%s',%.0f", ganhoHoraEstado.getUuidModel().toString(), ganhoHoraEstado.getUuidState().toString(), ganhoHoraEstado.getValor());

        boolean status = insertDAO(atributos, valores);

        return status;
    }

    public GanhoHoraEstado readGanhoHoraEstado(UUID uuidModel, UUID uuidState) {

        GanhoHoraEstado ganhoHoraEstado = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String where = String.format("equipment_model_id='%s' AND equipment_state_id='%s'", uuidModel.toString(), uuidState.toString());
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE %s", nomeTabela, where));

            if(rs.next()){

                rs.beforeFirst();
                rs.next();

                ganhoHoraEstado = new GanhoHoraEstado(rs.getString("equipment_model_id"), rs.getString("equipment_state_id"), rs.getFloat("value"));
            }

            st.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return ganhoHoraEstado;
    }

    public GanhoHoraEstado[] readAllGanhoHoraEstado(){

        GanhoHoraEstado[] ganhoHoraEstados = null;

        try {

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM " + nomeTabela);

            if (rs.next()){

                rs.last();
                ganhoHoraEstados = new GanhoHoraEstado[rs.getRow()];
                rs.beforeFirst();

                for (int i = 0 ; rs.next() ; i++) {
                    ganhoHoraEstados[i] = new GanhoHoraEstado(rs.getString("equipment_model_id"), rs.getString("equipment_state_id"), rs.getFloat("value"));
                }
            }

            st.close();

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        return ganhoHoraEstados;
    }

    public boolean updateDAO(Object objeto){
        GanhoHoraEstado ganhoHoraEstado = (GanhoHoraEstado) objeto;
        return updateGanhoHoraEstado(ganhoHoraEstado);
    }

    private boolean updateGanhoHoraEstado(GanhoHoraEstado ganhoHoraEstado){

        String set = String.format("value=%.0f", ganhoHoraEstado.getValor());
        String where = String.format("equipment_model_id='%s' AND equipment_state_id='%s'", ganhoHoraEstado.getUuidModel().toString(), ganhoHoraEstado.getUuidModel().toString());

        boolean status = updateDAO(set, where);
        return status;
    }

    public boolean deleteDAO(Object objeto){
        GanhoHoraEstado ganhoHoraEstado = (GanhoHoraEstado) objeto;
        return deleteGanhoHoraEstado(ganhoHoraEstado);
    }

    private boolean deleteGanhoHoraEstado(GanhoHoraEstado ganhoHoraEstado) {

        String where = String.format("equipment_model_id='%s' AND equipment_state_id='%s'", ganhoHoraEstado.getUuidModel().toString(), ganhoHoraEstado.getUuidState().toString());

        boolean status = deleteDAO(where);
        return status;
    }
}
