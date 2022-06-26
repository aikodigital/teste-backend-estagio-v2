using Equipments.Domain.Commands;
using Equipments.Domain.Commands.Interface;
using Equipments.Domain.Entities;
using Equipments.Domain.Handler.Interface;
using Equipments.Domain.Repositories;
using Flunt.Notifications;

namespace Equipments.Domain.Handler
{
    public class Handler : Notifiable,
        IHandler<CreateEquipmentCommand>,
        IHandler<CreateEquipmentModelCommand>,
        IHandler<CreateEquipmentStateCommand>,
        IHandler<CreateEquipmentHourlyEarningsCommand>,
        IHandler<CreateEquipmentStateHistoryCommand>,
        IHandler<CreateEquipmentPositionHistoryCommand>
    {
        private readonly IEquipmentRepository _equipmentRepository;
        private readonly IEquipmentModelRepository _equipmentModelRepository;
        private readonly IEquipmentStateRepository _equipmentStateRepository;
        private readonly IEquipmentHourlyEarningsRepository _equipmentHourlyEarningsRepository;
        private readonly IEquipmentPositionHistoryRepository _equipmentPositionHistoryRepository;
        private readonly IEquipmentStateHistoryRepository _equipmentStateHistoryRepository;

        public Handler(IEquipmentRepository equipmentRepository, 
            IEquipmentModelRepository equipmentModelRepository, 
            IEquipmentStateRepository equipmentStateRepository, 
            IEquipmentHourlyEarningsRepository equipmentHourlyEarningsRepository, 
            IEquipmentPositionHistoryRepository equipmentPositionHistoryRepository, 
            IEquipmentStateHistoryRepository equipmentStateHistoryRepository)
        {
            _equipmentRepository = equipmentRepository;
            _equipmentModelRepository = equipmentModelRepository;
            _equipmentStateRepository = equipmentStateRepository;
            _equipmentHourlyEarningsRepository = equipmentHourlyEarningsRepository;
            _equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
            _equipmentStateHistoryRepository = equipmentStateHistoryRepository;
        }

        public async Task<ICommandResult> Handle(CreateEquipmentCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar Equipamento", command.Notifications);

            var equipmentModel = await _equipmentModelRepository.GetByIdAsync(command.EquipmentModelId);

            if(equipmentModel == null)
                return new GenericCommandResult(false, "Modelo de equipamento inválido", command.Notifications);

            var equipment = new Equipment(command.EquipmentModelId, command.Name);

            await _equipmentRepository.CreateAsync(equipment);

            return new GenericCommandResult(true, "Equipamento registrado com sucesso", equipment);
        }

        public async Task<ICommandResult> Handle(CreateEquipmentModelCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar modelo de equipamento", command.Notifications);

            var equipmentModel = new EquipmentModel(command.Name);

            await _equipmentModelRepository.CreateAsync(equipmentModel);

            return new GenericCommandResult(true, "Modelo de equipamento registrado com sucesso", equipmentModel);
        }

        public async Task<ICommandResult> Handle(CreateEquipmentStateCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar estado do equipamento", command.Notifications);

            var equipmentState = new EquipmentState(command.Name, command.Color);

            await _equipmentStateRepository.CreateAsync(equipmentState);

            return new GenericCommandResult(true, "Estado do equipamento registrado com sucesso", equipmentState);

        }

        public async Task<ICommandResult> Handle(CreateEquipmentHourlyEarningsCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar ganhos por hora do equipamento", command.Notifications);

            var equipmentModel = await _equipmentModelRepository.GetByIdAsync(command.EquipmentModelId);
            var equipmentState = await _equipmentStateRepository.GetByIdAsync(command.EquipmentStateId);

            if (equipmentModel == null)
                return new GenericCommandResult(false, "Modelo de equipamento inválido", command.Notifications);
            if(equipmentState == null)
                return new GenericCommandResult(false, "Estado do equipamento inválido", command.Notifications);

            var equipmentEarnings = new EquipmentHourlyEarnings(command.EquipmentModelId, command.EquipmentStateId, command.Value);

            await _equipmentHourlyEarningsRepository.CreateAsync(equipmentEarnings);

            return new GenericCommandResult(true, "Ganhos por hora do equipamento registrado com sucesso", equipmentEarnings);
        }

        public async Task<ICommandResult> Handle(CreateEquipmentStateHistoryCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar histórico de estado do equipamento", command.Notifications);

            var equipment = await _equipmentRepository.GetByIdAsync(command.EquipmentId);
            var equipmentState = await _equipmentStateRepository.GetByIdAsync(command.EquipmentStateId);

            if (equipment == null)
                return new GenericCommandResult(false, "Modelo de equipamento inválido", command.Notifications);
            if (equipmentState == null)
                return new GenericCommandResult(false, "Estado do equipamento inválido", command.Notifications);

            var equipmentStateHistory = new EquipmentStateHistory(command.EquipmentId, command.EquipmentStateId, command.Date);

            await _equipmentStateHistoryRepository.CreateAsync(equipmentStateHistory);


            return new GenericCommandResult(true, "Histórico de estados do equipamento registrado com sucesso", equipmentStateHistory);
        }

        public async Task<ICommandResult> Handle(CreateEquipmentPositionHistoryCommand command)
        {
            command.Validate();
            if (command.Invalid)
                return new GenericCommandResult(false, "Falha ao registrar histórico de posições do equipamento", command.Notifications);
            var equipment = await _equipmentRepository.GetByIdAsync(command.EquipmentId);

            if (equipment == null)
                return new GenericCommandResult(false, "Modelo de equipamento inválido", command.Notifications);

            var equipmentPositionHistory = new EquipmentPositionHistory(command.EquipmentId, command.Date, command.Latitude, command.Longitude);

            await _equipmentPositionHistoryRepository.CreateAsync(equipmentPositionHistory);

            return new GenericCommandResult(true, "Histórico de posições do equipamento registrado com sucesso", equipmentPositionHistory);
        }
    }
}
