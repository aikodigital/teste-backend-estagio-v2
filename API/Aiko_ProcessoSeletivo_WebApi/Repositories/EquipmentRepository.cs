using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentRepository : IEquipmentRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(Guid id, EquipmentViewModel equipamentoAtualizado)
        {
            Equipment e = BuscarPorId(id);

            if (e.EquipmentModelId != equipamentoAtualizado.equipmentModelId)
            {
                e.EquipmentModelId = equipamentoAtualizado.equipmentModelId;
            }

            if (e.Name != equipamentoAtualizado.name && !String.IsNullOrEmpty(equipamentoAtualizado.name))
            {
                e.Name = equipamentoAtualizado.name;
            }

            ctx.Equipment.Update(e);

            ctx.SaveChanges();
        }

        public Equipment BuscarPorId(Guid id)
        {
            return ctx.Equipment.Where(b => b.Id == id).FirstOrDefault();
        }

        public void Cadastrar(EquipmentViewModel equipamento)
        {
            Equipment e = new();
            e.Id = Guid.NewGuid();
            e.Name = equipamento.name;
            e.EquipmentModelId = equipamento.equipmentModelId;

            ctx.Equipment.Add(e);
            ctx.SaveChanges();
        }

        public void Deletar(Guid id)
        {
            Equipment questionarioBuscado = BuscarPorId(id);

            ctx.Equipment.Remove(questionarioBuscado);

            ctx.SaveChanges();
        }

        public List<Equipment> Listar()
        {
            return ctx.Equipment.Include(c => c.EquipmentModel).ToList();
        }
    }
}
