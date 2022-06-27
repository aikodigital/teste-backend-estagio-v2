using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentStateRepository : IEquipmentStateRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentStateRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(Guid id, EquipmentState estadoAtualizado)
        {
            EquipmentState e = BuscarPorId(id);

            if (e.Color != estadoAtualizado.Color && !String.IsNullOrEmpty(estadoAtualizado.Color))
            {
                e.Color = estadoAtualizado.Color;
            }

            if (e.Name != estadoAtualizado.Name && !String.IsNullOrEmpty(estadoAtualizado.Name))
            {
                e.Name = estadoAtualizado.Name;
            }

            ctx.EquipmentStates.Update(e);

            ctx.SaveChanges();
        }

        public EquipmentState BuscarPorId(Guid id)
        {
            return ctx.EquipmentStates.Where(b => b.Id == id).FirstOrDefault();
        }

        public void Cadastrar(EquipmentState estado)
        {
            estado.Id = Guid.NewGuid();

            ctx.EquipmentStates.Add(estado);
            ctx.SaveChanges();
        }

        public void Deletar(Guid id)
        {
            EquipmentState estadoBuscado = BuscarPorId(id);

            ctx.EquipmentStates.Remove(estadoBuscado);

            ctx.SaveChanges();
        }

        public List<EquipmentState> Listar()
        {
            return ctx.EquipmentStates.ToList();
        }
    }
}
