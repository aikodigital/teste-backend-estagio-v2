using Microsoft.AspNetCore.Mvc;
using Npgsql;

namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ServiceController : Controller
    {
        private readonly IConfiguration _configuration;
        public ServiceController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        public struct EquipmentStateH
        {
            public string id { get; set; }
            public string name { get; set; }
            public string state { get; set; }
            public DateTime date { get; set; }
        }

        public struct EquipmentPositionH
        {
            public string id { get; set; }
            public string name { get; set; }
            public float? lat { get; set; }
            public float? lon { get; set; }
            public DateTime date { get; set; }
        }

        [Route("/EquipmentsState")]
        [HttpGet]
        public Array GetEquipmentsState()
        {
            string query = @"
                SELECT h.equipment_id as id, e.name, s.name as state, h.date
                FROM operation.equipment_state_history AS h INNER JOIN (
                            SELECT equipment_id, max(date) as date
                            FROM operation.equipment_state_history 
                            group by equipment_id) AS t ON
                        h.equipment_id = t.equipment_id
                    INNER JOIN operation.equipment AS e ON
                        h.equipment_id = e.id
                    INNER JOIN operation.equipment_state AS s on
                        h.equipment_state_id = s.id
                WHERE h.date = t.date";

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");
            List<EquipmentStateH> equipments = new List<EquipmentStateH>();
            NpgsqlDataReader reader;

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentStateH()
                        {
                            id = reader.GetGuid(0).ToString(),
                            name = reader.GetString(1),
                            state = reader.GetString(2),
                            date= reader.GetDateTime(3)
                        }); ;
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();
                }
            }

            return equipments.ToArray();
        }

        [Route("/EquipmentsPosition")]
        [HttpGet]
        public Array GetEquipmentsPosition()
        {
            string query = @"
                SELECT h.equipment_id, e.name, h.lat, h.lon, h.date
                FROM operation.equipment_position_history AS h INNER JOIN (
                SELECT equipment_id, max(date) as date
                FROM operation.equipment_position_history 
                group by equipment_id) AS t ON
                        h.equipment_id = t.equipment_id
                    INNER JOIN operation.equipment AS e ON
                        h.equipment_id = e.id
                WHERE h.date = t.date";

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");
            List<EquipmentPositionH> equipments = new List<EquipmentPositionH>();
            NpgsqlDataReader reader;

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentPositionH()
                        {
                            id = reader.GetGuid(0).ToString(),
                            name = reader.GetString(1),
                            lat = reader.GetFloat(2),
                            lon = reader.GetFloat(3),
                            date = reader.GetDateTime(4)
                        });
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();
                }
            }

            return equipments.ToArray();
        }
    }
}
