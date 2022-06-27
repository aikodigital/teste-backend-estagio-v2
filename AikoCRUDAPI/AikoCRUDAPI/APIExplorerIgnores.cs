using Microsoft.AspNetCore.Mvc.ApplicationModels;

namespace AikoCRUDAPI
{
    public class APIExplorerIgnores: IActionModelConvention
    {
        public void Apply(ActionModel action)
        {
            if (action.Controller.ControllerName.Equals("Pwa"))
                action.ApiExplorer.IsVisible = false;
        }
    }
}
