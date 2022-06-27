using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentPositionHistoryRepository : IEquipmentPositionHistoryRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentPositionHistoryRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(EquipmentPositionHistoryViewModel history)
        {
            EquipmentPositionHistory e = ctx.EquipmentPositionHistories.FirstOrDefault(b => b.Lon == history.Lon && b.EquipmentId == history.EquipmentId && b.Date == history.Date && b.Lat == history.Lat);
            e.Lon = history.NovoLon;
            e.Date = DateTime.Now;
            e.Lat = history.NovoLat;
            

            ctx.EquipmentPositionHistories.Update(e);

            ctx.SaveChanges();
        }


        public void Cadastrar(EquipmentPositionHistoryViewModel history)
        {
            EquipmentPositionHistory e = new();
            e.EquipmentId = history.EquipmentId;
            e.Lon = history.Lon;
            e.Date = DateTime.Now;
            e.Lat = history.Lat;

            ctx.EquipmentPositionHistories.Add(e);
            ctx.SaveChanges();
        }

        public void Deletar(EquipmentPositionHistoryViewModel history)
        {
            EquipmentPositionHistory e = ctx.EquipmentPositionHistories.FirstOrDefault(b => b.Lon == history.Lon && b.EquipmentId == history.EquipmentId && b.Date == history.Date && b.Lat == history.Lat);

            ctx.EquipmentPositionHistories.Remove(e);

            ctx.SaveChanges();
        }

        public List<EquipmentPositionHistory> Listar()
        {
            return ctx.EquipmentPositionHistories.Include(c => c.Equipment).ToList();
        }

        public EquipmentPositionHistory RetornarUltimaLocalizacao(EquipmentPositionHistoryViewModel history)
        {
            List<EquipmentPositionHistory> temp = ctx.EquipmentPositionHistories.Include(c => c.Equipment).Where(b => b.EquipmentId == history.EquipmentId).OrderByDescending(h => h.Date).ToList();

            return temp[0];
        }
    }
}
