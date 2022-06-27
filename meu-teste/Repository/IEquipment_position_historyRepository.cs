using equipment_position_history.Model;

namespace equipment_position_history.Repository
{
    public interface IEquipment_position_historyRepository
    {
        Task<IEnumerable<Equipment_position_history>> BuscaEquipment_position_historys();
        Task<Equipment_position_history> BuscaEquipment_position_history(Guid equipment_id);

        void AdicionaEquipment_position_history(Equipment_position_history equipment_position_history);

        void AtualizaEquipment_position_history(Equipment_position_history equipment_position_history);

        void DeletaEquipment_position_history(Equipment_position_history equipment_position_history);

        Task<bool> SaveChangesAsync();
    }
}