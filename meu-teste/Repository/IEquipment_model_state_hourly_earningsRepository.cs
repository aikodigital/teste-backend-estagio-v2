using equipment_model_state_hourly_earnings.Model;

namespace equipment_model_state_hourly_earnings.Repository
{
    public interface IEquipment_model_state_hourly_earningsRepository
    {
        Task<IEnumerable<Equipment_model_state_hourly_earnings>> BuscaEquipment_model_state_hourly_earningss();
        Task<Equipment_model_state_hourly_earnings> BuscaEquipment_model_state_hourly_earnings(Guid equipment_model_id, Guid equipment_state_id);

        void AdicionaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings);

        void AtualizaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings);

        void DeletaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings);

        Task<bool> SaveChangesAsync();
    }
}