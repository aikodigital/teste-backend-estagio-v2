package dao;

import java.sql.*;

public class DAO {

    protected Connection conexao;
    private String servidor = "localhost";
    private String bancoDeDados = "aiko";
    private int porta = 5432;
    private String nomeUsuario = "blue";
    private String senha = "1234";

    protected String nomeTabela;

    public DAO(String nomeTabela){
        conexao = null;
        this.nomeTabela = nomeTabela;
    }

    public boolean Conectar(){
        String nomeDriver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + bancoDeDados;
        boolean status = false;

        try {
            Class.forName(nomeDriver);
            conexao = DriverManager.getConnection(url, nomeUsuario, senha);
            status = (conexao == null);
            System.out.println("conexao efetuada com o postgres!");
        } catch (ClassNotFoundException e){
            System.err.println("conexao nao efetuada com o postgres -- Driver nao encontrado -- " + e.getMessage());
        } catch (SQLException e){
            System.err.println("conexao nao efetuada com o postgres -- " + e.getMessage());
        }

        return status;
    }
}
