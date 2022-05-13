package interfaces;

public interface CRUD {
    public boolean createDAO (Object object);

    public boolean readDAO(Object object);

    public boolean updateDAO(Object object);

    public boolean deleteDAO(Object object);
}
