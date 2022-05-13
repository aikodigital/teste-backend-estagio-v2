package dao;

import interfaces.CRUD;

import java.sql.*;

public class DAO implements CRUD {

    protected Connection conexao;
    private String servidor = "localhost";
    private String bancoDeDados = "aiko";
    private int porta = 5432;
    private String nomeUsuario = "blue";
    private String senha = "1234";

    protected String nomeTabela;

    public DAO(){
        conexao = null;
    }

    public DAO(String nomeTabela){
        conexao = null;
        this.nomeTabela = nomeTabela;
    }

    public boolean conectar(){
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

    public boolean close(){

        boolean status = false;

        try{
            conexao.close();
            status = true;
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return status;
    }

    public boolean createDAO (Object object){
        return false;
    }

    public boolean readDAO(Object object){
        return false;
    }

    public boolean updateDAO(Object object){
        return false;
    }

    public boolean deleteDAO(Object object){
        return false;
    }

    public boolean insertDAO (String atributos, String valores){

        boolean status = false;

        System.out.println("\nInserindo [" + valores + "]\n");

        try {

            Statement st = conexao.createStatement();
            st.executeUpdate(String.format("INSERT INTO %s (%s) VALUES (%s);", nomeTabela, atributos, valores));
            st.close();

            status = true;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return status;
    }

    public boolean updateDAO (String set, String where){

        boolean status = false;

        System.out.println("\nAtualizando [" + where + "]\n");

        try {

            Statement st = conexao.createStatement();
            String sql = String.format("UPDATE %s SET %s WHERE %s ", nomeTabela, set, where);

            st.executeUpdate(sql);
            st.close();

            status = true;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return status;
    }

    public boolean deleteDAO (String where){

        boolean status = false;

        System.out.println("\nDeletando [" + where + "]\n");

        try {

            Statement st = conexao.createStatement();
            String sql = String.format("DELETE FROM %s WHERE %s ", nomeTabela, where);

            st.executeUpdate(sql);
            st.close();

        }catch (SQLException e ){
            throw new RuntimeException(e);
        }

        return status;
    }
}
