using equipment_model.Model;

namespace equipment_model.Repository
{
    public interface IEquipment_modelRepository
    {
        Task<IEnumerable<Equipment_model>> BuscaEquipment_models();
        Task<Equipment_model> BuscaEquipment_model(Guid id);

        void AdicionaEquipment_model(Equipment_model equipment_model);

        void AtualizaEquipment_model(Equipment_model equipment_model);

        void DeletaEquipment_model(Equipment_model equipment_model);

        Task<bool> SaveChangesAsync();
    }
}