using Microsoft.EntityFrameworkCore;
using equipment.Data;
using equipment.Repository;
using equipment_state.Data;
using equipment_state.Repository;
using equipment_model.Data;
using equipment_model.Repository;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddDbContext<EquipmentContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipmentRepository, EquipmentRepository>();

builder.Services.AddDbContext<Equipment_stateContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipment_stateRepository, Equipment_stateRepository>();

builder.Services.AddDbContext<Equipment_modelContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipment_modelRepository, Equipment_modelRepository>();


var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
