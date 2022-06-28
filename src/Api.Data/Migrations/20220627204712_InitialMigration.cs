using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace Data.Migrations
{
    public partial class InitialMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "equipment_model",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    Name = table.Column<string>(type: "character varying(60)", maxLength: 60, nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment_model", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "equipment_state",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    Name = table.Column<string>(type: "character varying(60)", maxLength: 60, nullable: false),
                    Color = table.Column<string>(type: "character varying(60)", maxLength: 60, nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment_state", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "equipment",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    EquipmentModelId = table.Column<Guid>(type: "uuid", nullable: false),
                    Name = table.Column<string>(type: "character varying(60)", maxLength: 60, nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment", x => x.Id);
                    table.ForeignKey(
                        name: "FK_equipment_equipment_model_EquipmentModelId",
                        column: x => x.EquipmentModelId,
                        principalTable: "equipment_model",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "equipment_model_state_hourly_earnings",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    Value = table.Column<decimal>(type: "numeric", nullable: false),
                    EquipmentModelId = table.Column<Guid>(type: "uuid", nullable: false),
                    EquipmentStateId = table.Column<Guid>(type: "uuid", nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment_model_state_hourly_earnings", x => x.Id);
                    table.ForeignKey(
                        name: "FK_equipment_model_state_hourly_earnings_equipment_model_Equip~",
                        column: x => x.EquipmentModelId,
                        principalTable: "equipment_model",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_equipment_model_state_hourly_earnings_equipment_state_Equip~",
                        column: x => x.EquipmentStateId,
                        principalTable: "equipment_state",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "equipment_position_history",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    Date = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    Lat = table.Column<long>(type: "bigint", nullable: false),
                    Lon = table.Column<long>(type: "bigint", nullable: false),
                    EquipmentId = table.Column<Guid>(type: "uuid", nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment_position_history", x => x.Id);
                    table.ForeignKey(
                        name: "FK_equipment_position_history_equipment_EquipmentId",
                        column: x => x.EquipmentId,
                        principalTable: "equipment",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "equipment_state_history",
                columns: table => new
                {
                    Id = table.Column<Guid>(type: "uuid", nullable: false),
                    Date = table.Column<DateTime>(type: "timestamp without time zone", nullable: false),
                    EquipmentStateId = table.Column<Guid>(type: "uuid", nullable: false),
                    EquipmentId = table.Column<Guid>(type: "uuid", nullable: false),
                    CreateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true),
                    UpdateAt = table.Column<DateTime>(type: "timestamp without time zone", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_equipment_state_history", x => x.Id);
                    table.ForeignKey(
                        name: "FK_equipment_state_history_equipment_EquipmentId",
                        column: x => x.EquipmentId,
                        principalTable: "equipment",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_equipment_state_history_equipment_state_EquipmentStateId",
                        column: x => x.EquipmentStateId,
                        principalTable: "equipment_state",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_equipment_EquipmentModelId",
                table: "equipment",
                column: "EquipmentModelId");

            migrationBuilder.CreateIndex(
                name: "IX_equipment_model_state_hourly_earnings_EquipmentModelId",
                table: "equipment_model_state_hourly_earnings",
                column: "EquipmentModelId");

            migrationBuilder.CreateIndex(
                name: "IX_equipment_model_state_hourly_earnings_EquipmentStateId",
                table: "equipment_model_state_hourly_earnings",
                column: "EquipmentStateId");

            migrationBuilder.CreateIndex(
                name: "IX_equipment_position_history_EquipmentId",
                table: "equipment_position_history",
                column: "EquipmentId");

            migrationBuilder.CreateIndex(
                name: "IX_equipment_state_history_EquipmentId",
                table: "equipment_state_history",
                column: "EquipmentId");

            migrationBuilder.CreateIndex(
                name: "IX_equipment_state_history_EquipmentStateId",
                table: "equipment_state_history",
                column: "EquipmentStateId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "equipment_model_state_hourly_earnings");

            migrationBuilder.DropTable(
                name: "equipment_position_history");

            migrationBuilder.DropTable(
                name: "equipment_state_history");

            migrationBuilder.DropTable(
                name: "equipment");

            migrationBuilder.DropTable(
                name: "equipment_state");

            migrationBuilder.DropTable(
                name: "equipment_model");
        }
    }
}
