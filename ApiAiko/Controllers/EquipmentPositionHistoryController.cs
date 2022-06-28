using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;
namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentPositionHistoryController : Controller
    {
        private readonly IConfiguration _configuration;
        public EquipmentPositionHistoryController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<EquipmentPositionHistory> GetEquipments()
        {
            string query = @"SELECT * FROM operation.equipment_position_history";

            NpgsqlDataReader reader;

            var equipments = new List<EquipmentPositionHistory>();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentPositionHistory()
                        {
                            date = reader.GetDateTime("date"),
                            equipment_id = reader.GetGuid("equipment_id").ToString(),
                            lat = reader.GetFloat("lat"),
                            lon = reader.GetFloat("lon")
                        });
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();

                    return equipments;
                }
            }
        }

        [HttpGet("{equipment_id}")]
        public EquipmentPositionHistory GetEquipment(string equipment_id)
        {
            string query = @"
                SELECT *
	            FROM operation.equipment_position_history
                WHERE equipment_id=@equipment_id";

            NpgsqlDataReader reader;

            var equipment = new EquipmentPositionHistory();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id.ToString());
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipment = new EquipmentPositionHistory()
                        {
                            date = reader.GetDateTime("date"),
                            equipment_id = reader.GetGuid("equipment_id").ToString(),
                            lat = reader.GetFloat("lat"),
                            lon = reader.GetFloat("lon")
                        };
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();

                    return equipment;
                }
            }
        }

        [HttpPost]
        public JsonResult Create(EquipmentPositionHistory equipmentPosition)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment_position_history(
                    equipment_id,
                    date,
                    lat,
                    lon)
	            VALUES(
                    @equipment_id, 
                    @date, 
                    @lat,
                    @lon)";

                string? equipment_id = equipmentPosition.equipment_id;
                DateTime? date = equipmentPosition.date;
                float? lat = equipmentPosition.lat;
                float? lon = equipmentPosition.lon;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id.ToString());
                        cmd.Parameters.AddWithValue("@date", NpgsqlTypes.NpgsqlDbType.Date).Value = date;
                        cmd.Parameters.AddWithValue("@lat", NpgsqlTypes.NpgsqlDbType.Real).Value = lat;
                        cmd.Parameters.AddWithValue("@lon", NpgsqlTypes.NpgsqlDbType.Real).Value = lon;

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                        conn.Close();
                    }
                }

                return new JsonResult("Inserted Successfully!");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }

        [HttpPut]
        public JsonResult Update(EquipmentPositionHistory equipmentPosition)
        {
            string query = @"
                UPDATE operation.equipment_position_history
	            SET 
                    date=@date, 
                    lat=@lat,
                    lon=@lon
	            WHERE 
                    equipment_id=@equipment_id";

            try
            {
                string? equipment_id = equipmentPosition.equipment_id;
                DateTime? date = equipmentPosition.date;
                float? lat = equipmentPosition.lat;
                float? lon = equipmentPosition.lon;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id.ToString());
                        cmd.Parameters.AddWithValue("@date", NpgsqlTypes.NpgsqlDbType.Date).Value = date;
                        cmd.Parameters.AddWithValue("@lat", NpgsqlTypes.NpgsqlDbType.Real).Value = lat;
                        cmd.Parameters.AddWithValue("@lon", NpgsqlTypes.NpgsqlDbType.Real).Value = lon;

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                        conn.Close();
                    }
                }

                return new JsonResult("Updated Successfully!");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }

        [HttpDelete("{equipment_id}")]
        public JsonResult Delete(string equipment_id)
        {
            string query = @"
                DELETE FROM operation.equipment_position_history
	            WHERE equipment_id=@equipment_id";

            try
            {
                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id);

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                        conn.Close();
                    }
                }

                return new JsonResult("Deleted Successfully!");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }
    }
}
