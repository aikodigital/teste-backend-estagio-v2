using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentModelRepository : IEquipmentModelRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentModelRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(Guid id, EquipmentModel equipamentoAtualizado)
        {
            EquipmentModel e = BuscarPorId(id);

            if (e.Name != equipamentoAtualizado.Name && !String.IsNullOrEmpty(equipamentoAtualizado.Name))
            {
                e.Name = equipamentoAtualizado.Name;
            }

            ctx.EquipmentModels.Update(e);

            ctx.SaveChanges();
        }

        public EquipmentModel BuscarPorId(Guid id)
        {
            return ctx.EquipmentModels.Where(b => b.Id == id).FirstOrDefault();
        }

        public void Cadastrar(EquipmentModel equipamento)
        {
            equipamento.Id = Guid.NewGuid();

            ctx.EquipmentModels.Add(equipamento);
            ctx.SaveChanges();
        }

        public void Deletar(Guid id)
        {
            EquipmentModel questionarioBuscado = BuscarPorId(id);

            ctx.EquipmentModels.Remove(questionarioBuscado);

            ctx.SaveChanges();
        }

        public List<EquipmentModel> Listar()
        {
            return ctx.EquipmentModels.ToList();
        }
    }
}
