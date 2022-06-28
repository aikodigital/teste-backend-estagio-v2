using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;

namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateHistoryController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public EquipmentStateHistoryController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<EquipmentStateHistory> GetEquipments() 
        {
            string query = @"
                SELECT *
                FROM operation.equipment_state_history";
           
            NpgsqlDataReader reader;
            
            var equipments = new List<EquipmentStateHistory>();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using(NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentStateHistory()
                        {
                            date = reader.GetDateTime("date"),
                            equipment_id = reader.GetGuid("equipment_id").ToString(),
                            equipment_state_id = reader.GetGuid("equipment_state_id").ToString()
                        });
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();

                    return equipments;
                }
            }
        }

        [HttpGet("{equipment_id},{equipment_state_id}")]
        public EquipmentStateHistory GetEquipment(string equipment_id, string equipment_state_id)
        {
            string query = @"
                SELECT *
	            FROM operation.equipment_state_history
                WHERE equipment_id = @equipment_id
                AND equipment_state_id = @equipment_state_id";


            NpgsqlDataReader reader;

            var equipment = new EquipmentStateHistory();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id);
                    cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id);
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipment = new EquipmentStateHistory()
                        {
                            date = reader.GetDateTime("date"),
                            equipment_id = reader.GetGuid("equipment_id").ToString(),
                            equipment_state_id = reader.GetGuid("equipment_state_id").ToString()
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
        public JsonResult CreateEquipment(EquipmentStateHistory history)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment_state_history(
	            equipment_id, date, equipment_state_id)
	            VALUES (@equipment_id, @date, @equipment_state_id)";

                string? equipment_id = history.equipment_id;
                DateTime? date = history.date;
                string? equipment_state_id = history.equipment_state_id;

                NpgsqlDataReader reader;
                    string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                    using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                    {
                        conn.Open();
                        using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                        {
                            cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id);
                            cmd.Parameters.AddWithValue("@date", NpgsqlTypes.NpgsqlDbType.Date).Value = date;
                            cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id);

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
        public JsonResult UpdateEquipment(EquipmentStateHistory history)
        {
            string query = @"
                UPDATE operation.equipment_state_history
	            SET date=@date, equipment_state_id=@equipment_state_id
	            WHERE equipment_id=@equipment_id";

            try
            {
                string? equipment_id = history.equipment_id;
                DateTime? date = history.date;
                string? equipment_state_id = history.equipment_state_id;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id);
                        cmd.Parameters.AddWithValue("@date", NpgsqlTypes.NpgsqlDbType.Date).Value = date;
                        cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id);

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

        [HttpDelete("{id}")]
        public JsonResult DeleteEquipment(EquipmentStateHistory history)
        {
            string query = @"
                DELETE 
	            FROM operation.equipment_state_history
	            WHERE equipment_id=@equipment_id
                AND equipment_state_id=@equipment_state_id
                AND date=@date";

            try
            {
                string? equipment_id = history.equipment_id;
                DateTime? date = history.date;
                string? equipment_state_id = history.equipment_state_id;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_id);
                        cmd.Parameters.AddWithValue("@date", NpgsqlTypes.NpgsqlDbType.Date).Value = date;
                        cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id);
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
