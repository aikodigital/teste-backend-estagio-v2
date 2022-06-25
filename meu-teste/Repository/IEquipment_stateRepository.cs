using equipment_state.Model;

namespace equipment_state.Repository
{
    public interface IEquipment_stateRepository
    {
        Task<IEnumerable<Equipment_state>> BuscaEquipment_states();
        Task<Equipment_state> BuscaEquipment_state(int id);

        void AdicionaEquipment_state(Equipment_state equipment_state);

        void AtualizaEquipment_state(Equipment_state equipment_state);

        void DeletaEquipment_state(Equipment_state equipment_state);

        Task<bool> SaveChangesAsync();
    }
}