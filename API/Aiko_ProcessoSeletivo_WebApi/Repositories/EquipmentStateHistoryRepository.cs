using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentStateHistoryRepository : IEquipmentStateHistoryRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentStateHistoryRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(EquipmentStateHistoryViewModel history)
        {
            EquipmentStateHistory e =  ctx.EquipmentStateHistories.FirstOrDefault(b => b.EquipmentStateId == history.EquipmentStateId && b.EquipmentId == history.EquipmentId && b.Date == history.Date); 
            e.EquipmentStateId = history.NovoEquipmentStateId;
            e.Date = DateTime.Now;

            ctx.EquipmentStateHistories.Update(e);

            ctx.SaveChanges();
        }


        public void Cadastrar(EquipmentStateHistoryViewModel history)
        {
            EquipmentStateHistory e = new();
            e.EquipmentId = history.EquipmentId;
            e.EquipmentStateId = history.EquipmentStateId;
            e.Date = DateTime.Now;

            ctx.EquipmentStateHistories.Add(e);
            ctx.SaveChanges();
        }

        public void Deletar(EquipmentStateHistoryViewModel history)
        {
            EquipmentStateHistory e = ctx.EquipmentStateHistories.FirstOrDefault(b => b.EquipmentStateId == history.EquipmentStateId && b.EquipmentId == history.EquipmentId && b.Date == history.Date);

            ctx.EquipmentStateHistories.Remove(e);

            ctx.SaveChanges();
        }

        public List<EquipmentStateHistory> Listar()
        {
            return ctx.EquipmentStateHistories.Include(c => c.Equipment).Include(c => c.EquipmentState).ToList();
        }

        public EquipmentStateHistory RetornarUltimoEstado(EquipmentStateHistoryViewModel history)
        {
            List<EquipmentStateHistory> temp = ctx.EquipmentStateHistories.Include(c => c.Equipment).Include(c => c.EquipmentState).Where(b => b.EquipmentId == history.EquipmentId).OrderByDescending(h => h.Date).ToList();

            return temp[0];
        }
    }
}
