using Equipments.Domain.Commands.Interface;

namespace Equipments.Domain.Handler.Interface
{
    public interface IHandler<T> where T : ICommand
    {
        Task<ICommandResult> Handle(T command);
    }
}
