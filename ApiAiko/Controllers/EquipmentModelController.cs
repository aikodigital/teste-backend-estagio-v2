using api.Models;
using Microsoft.AspNetCore.Mvc;
using Npgsql;
using System.Data;

namespace api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelController : Controller
    {
        private readonly IConfiguration _configuration;
        public EquipmentModelController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public List<EquipmentModel> GetEquipments()
        {
            string query = @"SELECT * FROM operation.equipment_model";

            NpgsqlDataReader reader;

            string sqlDataSource = _configuration.GetConnectionString("ApiConn");

            using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
            {
                conn.Open();
                using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                {
                    reader = cmd.ExecuteReader();

                    var equipments = new List<EquipmentModel>();

                    while (reader.Read())
                    {
                        equipments.Add(new EquipmentModel()
                        {
                            id = reader.GetGuid("id").ToString(),
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
        public EquipmentModel GetEquipment(string id)
        {
            string query = @"
                SELECT * FROM operation.equipment_model
                WHERE id = @id";

            NpgsqlDataReader reader;

            EquipmentModel equipment = new EquipmentModel();

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
                        equipment = new EquipmentModel()
                        {
                            id = reader.GetGuid("id").ToString(),
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
        public JsonResult Create(EquipmentModel equipmentModel)
        {
            try
            {
                string query = @"
                INSERT INTO operation.equipment_model(id, name)
	            VALUES (@id, @name);";

                string? id = equipmentModel.id;
                string? name = equipmentModel.name;


                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());
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
        public JsonResult Update(EquipmentModel equipmentModel)
        {
            string query = @"
                UPDATE operation.equipment_model
	            SET name=@name
	            WHERE id=@id";

            try
            {
                string? id = equipmentModel.id;
                string? name = equipmentModel.name;

                NpgsqlDataReader reader;
                string sqlDataSource = _configuration.GetConnectionString("ApiConn");

                using (NpgsqlConnection conn = new NpgsqlConnection(sqlDataSource))
                {
                    conn.Open();
                    using (NpgsqlCommand cmd = new NpgsqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());
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
        public JsonResult Delete(string id)
        {
            string query = @"
                DELETE 
	            FROM operation.equipment_model
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
                        cmd.Parameters.AddWithValue("@id", NpgsqlTypes.NpgsqlDbType.Uuid).Value = Guid.Parse(id.ToString());

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
