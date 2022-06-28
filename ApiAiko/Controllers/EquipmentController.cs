using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;

namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public EquipmentController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<Equipment> GetEquipments()
        {
            string query = @"SELECT * FROM operation.equipment";

            NpgsqlDataReader reader;
            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    var equipments = new List<Equipment>();

                    while (reader.Read())
                    {
                        equipments.Add(new Equipment()
                        {
                            id = reader.GetGuid("id").ToString(),
                            equipment_model_id = reader.GetGuid("equipment_model_id").ToString(),
                            name = reader.GetString("name")
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
        public Equipment GetEquipment(string id)
        {
            string query = @"
            SELECT id, equipment_model_id, name
	        FROM operation.equipment
            WHERE id = @id";


            NpgsqlDataReader reader;
            Equipment equipment = new Equipment();

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());
                    reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        equipment = new Equipment()
                        {
                            id = reader.GetGuid("id").ToString(),
                            equipment_model_id = reader.GetGuid("equipment_model_id").ToString(),
                            name = reader.GetString("name")
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
        public JsonResult CreateEquipment(Equipment equipment)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment(
	            id, equipment_model_id, name)
	            VALUES (@id, @equipment_model_id, @name);";

                string? id = equipment.id;
                string? equipment_model_id = equipment.equipment_model_id;
                string? name = equipment.name;


                NpgsqlDataReader reader;
                    string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                    using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                    {
                        conn.Open();
                        using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                        {
                            cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());
                            cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                            cmd.Parameters.AddWithValue("@name", NpgsqlTypes.NpgsqlDbType.Text).Value = name.ToString();

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
        public JsonResult UpdateEquipment(Equipment equipment)
        {
            string query = @"
                UPDATE operation.equipment
	            SET equipment_model_id=@equipment_model_id, name=@name
	            WHERE id=@id";

            try
            {
                string? id = equipment.id;
                string? equipment_model_id = equipment.equipment_model_id;
                string? name = equipment.name;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());
                        cmd.Parameters.AddWithValue("@equipment_model_id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(equipment_model_id.ToString());
                        cmd.Parameters.AddWithValue("@name", NpgsqlTypes.NpgsqlDbType.Text).Value = name.ToString();

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
        public JsonResult DeleteEquipment(string id)
        {
            try
            {
                string query = @"
                DELETE FROM operation.equipment
	            WHERE id=@id";

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());

                        reader = cmd.ExecuteReader();
                        cmd.Dispose();
                        reader.Close();
                        conn.Close();
                    }
                }

                return new JsonResult("Deleted Successfully");
            }
            catch (NpgsqlException e)
            {
                return new JsonResult(e.Message);
            }
        }
    }
}   
