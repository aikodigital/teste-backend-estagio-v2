using equipment.Model;

namespace equipment.Repository
{
    public interface IEquipmentRepository
    {
        Task<IEnumerable<Equipment>> BuscaEquipments();
        Task<Equipment> BuscaEquipment(int id);

        void AdicionaEquipment(Equipment equipment);

        void AtualizaEquipment(Equipment equipment);

        void DeletaEquipment(Equipment equipment);

        Task<bool> SaveChangesAsync();
    }
}