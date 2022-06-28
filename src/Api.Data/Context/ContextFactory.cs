using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Design;
using Pomelo.EntityFrameworkCore.MySql.Infrastructure;
using System;

namespace Api.Data.Context
{
    public class ContextFactory: IDesignTimeDbContextFactory<MyContext>
    {
        public MyContext CreateDbContext(string[] args)
        {
            //Usado para Criar as Migrações
            var connectionString = "Server=localhost;Port=5432;Database=Aiko;UserId=postgres;Password=mudar@123";
            var optionsBuilder = new DbContextOptionsBuilder<MyContext> ();
            optionsBuilder.UseNpgsql(connectionString);
            return new MyContext (optionsBuilder.Options);
        }
    }
}
