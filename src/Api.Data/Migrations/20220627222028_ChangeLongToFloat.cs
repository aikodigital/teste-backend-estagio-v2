using Microsoft.EntityFrameworkCore.Migrations;

namespace Data.Migrations
{
    public partial class ChangeLongToFloat : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<float>(
                name: "Lon",
                table: "equipment_position_history",
                type: "real",
                nullable: false,
                oldClrType: typeof(long),
                oldType: "bigint");

            migrationBuilder.AlterColumn<float>(
                name: "Lat",
                table: "equipment_position_history",
                type: "real",
                nullable: false,
                oldClrType: typeof(long),
                oldType: "bigint");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<long>(
                name: "Lon",
                table: "equipment_position_history",
                type: "bigint",
                nullable: false,
                oldClrType: typeof(float),
                oldType: "real");

            migrationBuilder.AlterColumn<long>(
                name: "Lat",
                table: "equipment_position_history",
                type: "bigint",
                nullable: false,
                oldClrType: typeof(float),
                oldType: "real");
        }
    }
}
