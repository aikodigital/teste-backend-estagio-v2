package dao;

public class ModeloEquipamentoDAO extends DAO{
    public ModeloEquipamentoDAO(){
        super("operation.equipment_model");
    }

    public ModeloEquipamentoDAO(String nomeTabela){
        super(nomeTabela);
    }
}
