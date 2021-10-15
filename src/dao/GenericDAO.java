package dao;

import java.util.ArrayList;

import services.ServicesCustomer;


public interface GenericDAO <T> {
	
	public static ServicesCustomer service = new ServicesCustomer();
	
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL= "jdbc:mysql://localhost:3306/Aeroporto_db2?user=root&password=DES-616?!cia";

	public boolean insert(T t);
	
	public boolean delete(Object id);

	public boolean update(T t, Object id);

	public ArrayList<T> getAll();

	public T getByPk(Object id);

}
