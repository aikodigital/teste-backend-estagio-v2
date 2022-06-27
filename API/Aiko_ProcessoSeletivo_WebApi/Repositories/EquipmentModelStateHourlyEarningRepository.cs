using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace Aiko_ProcessoSeletivo_WebApi.Repositories
{
    public class EquipmentModelStateHourlyEarningRepository : IEquipmentModelStateHourlyEarningRepository
    {
        private readonly EquipamentosContext ctx;

        public EquipmentModelStateHourlyEarningRepository(EquipamentosContext appContext)
        {
            ctx = appContext;
        }


        public void Atualizar(EarningViewModel ganhosAtualizado)
        {
            EquipmentModelStateHourlyEarning e =  ctx.EquipmentModelStateHourlyEarnings.FirstOrDefault(b => b.EquipmentModelId == ganhosAtualizado.EquipmentModelId && b.EquipmentStateId == ganhosAtualizado.EquipmentStateId);
            e.EquipmentModelId = ganhosAtualizado.EquipmentModelId;
            e.EquipmentStateId = ganhosAtualizado.EquipmentStateId;
            e.Value = ganhosAtualizado.Value;
            ctx.EquipmentModelStateHourlyEarnings.Update(e);

            ctx.SaveChanges();
        }


        public void Cadastrar(EarningViewModel gasto)
        {
            EquipmentModelStateHourlyEarning e = new();
            e.EquipmentModelId = gasto.EquipmentModelId;
            e.EquipmentStateId = gasto.EquipmentStateId;
            e.Value = gasto.Value;

            ctx.EquipmentModelStateHourlyEarnings.Add(e);
            ctx.SaveChanges();
        }

        public void Deletar(EarningViewModel gasto)
        {
            EquipmentModelStateHourlyEarning e = ctx.EquipmentModelStateHourlyEarnings.FirstOrDefault(b => b.EquipmentModelId == gasto.EquipmentModelId && b.EquipmentStateId == gasto.EquipmentStateId);

            ctx.EquipmentModelStateHourlyEarnings.Remove(e);

            ctx.SaveChanges();
        }

        public List<EquipmentModelStateHourlyEarning> Listar()
        {
            return ctx.EquipmentModelStateHourlyEarnings.Include(c => c.EquipmentModel).Include(c => c.EquipmentState).ToList();
        }
    }
}
