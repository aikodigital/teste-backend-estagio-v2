using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;

namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelStateHourlyEarningsController : Controller
    {
        private readonly IConfiguration _configuration;
        public EquipmentModelStateHourlyEarningsController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<EquipmentModelStateHourlyEarnings> GetEquipments()
        {
            string query = @"SELECT * FROM operation.equipment_model_state_hourly_earnings";

            NpgsqlDataReader reader;

            var equipments = new List<EquipmentModelStateHourlyEarnings>();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentModelStateHourlyEarnings()
                        {
                            equipment_model_id = reader.GetGuid("equipment_model_id").ToString(),
                            equipment_state_id = reader.GetGuid("equipment_state_id").ToString(),
                            value = reader.GetFloat("value")
                        });
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();

                    return equipments;
                }
            }
        }

        [HttpGet("{equipment_model_id},{equipment_state_id}")]
        public EquipmentModelStateHourlyEarnings GetEquipment(string equipment_model_id, string equipment_state_id)
        {
            string query = @"
                SELECT 
                    equipment_model_id, 
                    equipment_state_id, 
                    value
	            FROM operation.equipment_model_state_hourly_earnings
                WHERE 
                    equipment_model_id = @equipment_model_id and
                    equipment_state_id = @equipment_state_id";

            NpgsqlDataReader reader;
                
            var equipment = new EquipmentModelStateHourlyEarnings();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                    cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id.ToString());
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipment = new EquipmentModelStateHourlyEarnings()
                        {
                            equipment_model_id = reader.GetGuid("equipment_model_id").ToString(),
                            equipment_state_id = reader.GetGuid("equipment_state_id").ToString(),
                            value = reader.GetFloat("value")
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
        public JsonResult Create(EquipmentModelStateHourlyEarnings equipmentModeState)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment_model_state_hourly_earnings(
                    equipment_model_id, 
                    equipment_state_id,     
                    value)
	            VALUES (
                    @equipment_model_id, 
                    @equipment_state_id, 
                    @value);";

                string? equipment_model_id = equipmentModeState.equipment_model_id;
                string? equipment_state_id = equipmentModeState.equipment_state_id;
                float? value = equipmentModeState.value;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                        cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id.ToString());
                        cmd.Parameters.AddWithValue("@value", NpgsqlTypes.NpgsqlDbType.Real).Value = value;

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
        public JsonResult Update(EquipmentModelStateHourlyEarnings equipmentModelState)
        {
            string query = @"
                UPDATE operation.equipment_model_state_hourly_earnings
	            SET 
                    equipment_model_id=@equipment_model_id, 
                    equipment_state_id=@equipment_state_id, 
                    value=@value
	            WHERE 
                    equipment_model_id=@equipment_model_id and 
                    equipment_state_id=@equipment_state_id";

            try
            {
                string? equipment_model_id = equipmentModelState.equipment_model_id;
                string? equipment_state_id = equipmentModelState.equipment_state_id;
                double? value = equipmentModelState.value;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                        cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id.ToString());
                        cmd.Parameters.AddWithValue("@value", NpgsqlTypes.NpgsqlDbType.Real).Value = value;

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

        [HttpDelete("{equipment_model_id},{equipment_state_id}")]
        public JsonResult Delete(string equipment_model_id, string equipment_state_id)
        {
            string query = @"
                DELETE FROM operation.equipment_model_state_hourly_earnings
	            WHERE 
                    equipment_model_id=@equipment_model_id and 
                    equipment_state_id=@equipment_state_id";

            try
            {
                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                        cmd.Parameters.AddWithValue("@equipment_state_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_state_id.ToString());

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
