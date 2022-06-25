using Microsoft.EntityFrameworkCore;
using equipment.Data;
using equipment.Repository;
using equipment_state.Data;
using equipment_state.Repository;
using equipment_model.Data;
using equipment_model.Repository;
using equipment_state_history.Data;
using equipment_state_history.Repository;
using equipment_model_state_hourly_earnings.Data;
using equipment_model_state_hourly_earnings.Repository;
using equipment_position_history.Data;
using equipment_position_history.Repository;

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

builder.Services.AddDbContext<Equipment_state_historyContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipment_state_historyRepository, Equipment_state_historyRepository>();

builder.Services.AddDbContext<Equipment_model_state_hourly_earningsContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipment_model_state_hourly_earningsRepository, Equipment_model_state_hourly_earningsRepository>();

builder.Services.AddDbContext<Equipment_position_historyContext>(options => {
    options.UseNpgsql(builder.Configuration.GetConnectionString("Default"));
});

builder.Services.AddScoped<IEquipment_position_historyRepository, Equipment_position_historyRepository>();

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
