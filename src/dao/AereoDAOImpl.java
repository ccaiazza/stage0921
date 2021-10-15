package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Aereo;
import bean.Aeroporto;
import bean.Volo;
import services.ServicesCustomer;

public class AereoDAOImpl implements GenericDAO<Aereo>{

	@Override
	public boolean insert(Aereo t) {

		Statement stmt = null;
		Connection conn = null;
		if(getByPk(t.getAereoId())==null) {
			try {
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "INSERT INTO aereo(aereo_id, tipo_aereo, posti_disponibili, compagnia_appartenenza, nome_aereo) VALUES("+t.getAereoId()+",'"+t.getTipoAereo()+"',"+t.getPostiDisponibili()+",'"+t.getCompagniaAppartenenza()+"','"+t.getNomeAereo()+"')";
				System.out.println("Inserting records into the table Aereo...");
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				try {
					if (stmt!=null)
						stmt.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
				try{
					if(conn!= null)
						conn.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
			} 
			return true;
		} else {
			System.out.println("Esiste già un id uguale");
			return false;
		}
	}

	@Override
	public boolean delete(Object id) {
		
		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(id)!=null) {	
			try {
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "DELETE FROM aereo WHERE aereo_id="+ id + ";";
				System.out.println("Deleting records into the table Aereo...");
				
				service.removeVoloFromAereo(id);
				
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				try {
					if (stmt!=null)
						stmt.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
				try{
					if(conn!= null)
						conn.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
			}
			return true;
		}else {
			System.out.println("non esiste un record con questo id");
			return false;
		}

	}

	@Override
	public boolean update(Aereo t, Object id) {
		
		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(id)!=null) {
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("***UPDATE AEREO***Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "UPDATE aereo set aereo_id=" + t.getAereoId() + ", tipo_aereo='" + t.getTipoAereo()+"',posti_disponibili="+ t.getPostiDisponibili()+", compagnia_appartenenza='"+ t.getCompagniaAppartenenza()+"', nome_aereo='"+ t.getNomeAereo() +"' Where aereo_id="+id +";";
				System.out.println("***UPDATE AEREO***Selected records into the table Aereo WHERE id =" + id + "...");
				
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				try {
					if (stmt!=null)
						stmt.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
				try{
					if(conn!= null)
						conn.close();
				}catch (SQLException se){
					se.printStackTrace();
				}
			}
			return true;
		}else {
			System.out.println("non è possibile effettuare l'update");
            return false;
		}
		
	}

	@Override
	public ArrayList<Aereo> getAll() {
		
		Statement stmt = null;
		Connection conn = null;
		ArrayList <Aereo> lista = new ArrayList<Aereo>();
		
		try {
			
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("***getAll***Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM aereo;";
			System.out.println("***getAll***Selected records into the table Aereo...");
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			while (myRs.next()) {
				int aereooId=myRs.getInt("aereo_id");
				String tipoAereo=myRs.getString("tipo_aereo");
				int postiDisponibili=myRs.getInt("posti_disponibili");
				String compagniaAppartenenza=myRs.getString("compagnia_appartenenza");
				String nomeAereo=myRs.getString("nome_aereo");
				Aereo aereo=new Aereo(aereooId,tipoAereo,postiDisponibili,nomeAereo,compagniaAppartenenza);
				lista.add(aereo);
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			try {
				if (stmt!=null)
					stmt.close();
			}catch (SQLException se){
				se.printStackTrace();
			}
			try{
				if(conn!= null)
					conn.close();
			}catch (SQLException se){
				se.printStackTrace();
			}
		}

		return lista;
	}

	@Override
	public Aereo getByPk(Object id) {
		
		Statement stmt = null;
		Connection conn = null;
		Aereo aereo=null;
		
		try {
			
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM aereo WHERE aereo_id="+ id + ";";
			System.out.println("Aereo records into the table with id =" + id + "...");
			
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			
			while (myRs.next()) {
				int aereoId=myRs.getInt("aereo_id");
				String tipoAereo=myRs.getString("tipo_aereo");
				int postiDisponibili=myRs.getInt("posti_disponibili");
				String compagniaAppartenenza=myRs.getString("compagnia_appartenenza");
				String nomeAereo=myRs.getString("nome_aereo");
				aereo=new Aereo(aereoId,tipoAereo,postiDisponibili,compagniaAppartenenza,nomeAereo);
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			try {
				if (stmt!=null)
					stmt.close();
			}catch (SQLException se){
				se.printStackTrace();
			}
			try{
				if(conn!= null)
					conn.close();
			}catch (SQLException se){
				se.printStackTrace();
			}
		}

		if(aereo==null) {
			System.out.println("Id Volo non trovato");
			return null;
		}
		else { 
			return aereo;
		}
	}

}
