using equipment_state_history.Model;

namespace equipment_state_history.Repository
{
    public interface IEquipment_state_historyRepository
    {
        Task<IEnumerable<Equipment_state_history>> BuscaEquipment_state_historys();
        Task<Equipment_state_history> BuscaEquipment_state_history(int equipment_id, int equipment_state_id);

        void AdicionaEquipment_state_history(Equipment_state_history equipment_state_history);

        void AtualizaEquipment_state_history(Equipment_state_history equipment_state_history);

        void DeletaEquipment_state_history(Equipment_state_history equipment_state_history);

        Task<bool> SaveChangesAsync();
    }
}