using System.ComponentModel.DataAnnotations;

namespace AikoCRUDAPI.Models
{
    public class Equipment
    {
        [Key]
        public Guid id { get; set; }
        public Guid equipment_model_id { get; set; }
        public string name { get; set; }
    }
}
