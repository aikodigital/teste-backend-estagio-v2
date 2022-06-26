using Equipments.Domain.Commands.Interface;

namespace Equipments.Domain.Commands
{
    public class GenericCommandResult : ICommandResult
    {
        public GenericCommandResult()
        {

        }
        public bool Success { get; private set; }
        public string Message { get; private set; }
        public object Data { get; private set; }

        public GenericCommandResult(bool success, string message, object data)
        {
            Success = success;
            Message = message;
            Data = data;
        }
    }
}
