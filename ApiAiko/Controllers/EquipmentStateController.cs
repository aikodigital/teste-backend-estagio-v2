using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;

namespace ApiAiko.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public EquipmentStateController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<EquipmentState> GetEquipments()
        {
            string query = @"SELECT * FROM operation.equipment_state";

            NpgsqlDataReader reader;

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    var equipments = new List<EquipmentState>();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentState()
                        {
                            id = reader.GetGuid(0).ToString(),
                            name = reader.GetString(1),
                            color = reader.GetString(2)
                        });
                    }

                    cmd.Dispose();
                    reader.Close();
                    conn.Close();

                    return equipments;
                }
            }
        }

        [HttpGet("{id}")]
        public EquipmentState GetEquipment(string id)
        {
            string query = @"
                SELECT *
	            FROM operation.equipment_state
                WHERE id = @id";


            NpgsqlDataReader reader;

            var equipment = new EquipmentState();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id);
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipment = new EquipmentState()
                        {
                            id = reader.GetGuid(0).ToString(),
                            name = reader.GetString(1),
                            color = reader.GetString(2)
                        };
                    }

                    cmd.Dispose();
                    reader.Close();
                }
                conn.Close();

                return equipment;
            }
        }

        [HttpPost]
        public JsonResult CreateEquipment(EquipmentState equipmentState)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment_state(
	            id, name, color)
	            VALUES (@id, @name, @color);";

                string? id = equipmentState.id;
                string? name = equipmentState.name;
                string? color = equipmentState.color;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id);
                        cmd.Parameters.AddWithValue("@name", NpgsqlTypes.NpgsqlDbType.Text).Value = name;
                        cmd.Parameters.AddWithValue("@color", NpgsqlTypes.NpgsqlDbType.Text).Value = color;

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();

                    }
                    conn.Close();
                }

                return new JsonResult("Inserted Successfully!");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }

        [HttpPut]
        public JsonResult UpdateEquipment(EquipmentState equipmentState)
        {
            string query = @"
                UPDATE operation.equipment_state
	            SET name=@name, color=@color
	            WHERE id=@id";

            try
            {
                string? id = equipmentState.id;
                string? name = equipmentState.name;
                string? color = equipmentState.color;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id);
                        cmd.Parameters.AddWithValue("@name", NpgsqlTypes.NpgsqlDbType.Text).Value = name;
                        cmd.Parameters.AddWithValue("@color", NpgsqlTypes.NpgsqlDbType.Text).Value = color;

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                    }
                    conn.Close();
                }

                return new JsonResult("Updated Successfully!");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }

        [HttpDelete("{id}")]
        public JsonResult DeleteEquipment(string id)
        {
            string query = @"
                DELETE 
	            FROM operation.equipment_state
	            WHERE id=@id";

            try
            {
                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id);

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                    }
                    conn.Close();
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
