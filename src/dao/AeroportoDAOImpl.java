package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import bean.Aeroporto;

public class AeroportoDAOImpl  implements GenericDAO<Aeroporto> {

	@Override
	public boolean insert(Aeroporto t) {
		
		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(t.getAeroportoId())==null) {
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "INSERT INTO aeroporto (aeroporto_id, città, nome, nazione, numero_piste) VALUES("+t.getAeroportoId()+",' "+t.getCittà()+"','"+t.getNome()+"','"+t.getNazione()+"',"+t.getNumeroPiste()+")";
				System.out.println("Inserting records into the table Aeroporto...");
				
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
				String sql = "DELETE FROM aeroporto WHERE aeroporto_id="+ id + ";";
				System.out.println("Deleting records into the table Aeroporto...");
				
				service.removeVoloFromAeroporto(id);
				
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
	public boolean update(Aeroporto t, Object id) {
		
		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(id)!=null) {
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("***getAll***Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "update aeroporto set aeroporto_id=" + t.getAeroportoId() + ", città='" + t.getCittà()+"', nome='"+ t.getNome()+ "', nazione='" + t.getNazione()+"', numero_piste=" + t.getNumeroPiste() + " Where aeroporto_id=" +id +";";
				System.out.println("***getAll***Selected records into the table Aeroporto...");
				
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
	public ArrayList<Aeroporto> getAll() {
		
		Statement stmt = null;
		Connection conn = null;
		
		ArrayList <Aeroporto> lista = new ArrayList<Aeroporto>();
		try {
			
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("***getAll***Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM aeroporto;";
			System.out.println("***getAll***Selected records into the table Aeroporto...");
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			while (myRs.next()) {
				int aeroportoId=myRs.getInt("aeroporto_id");
				String città=myRs.getString("città");
				String nome=myRs.getString("nome");
				String nazione=myRs.getString("nazione");
				int numeroPiste=myRs.getInt("numero_piste");
				Aeroporto aeroporto=new Aeroporto(aeroportoId,città, nome,nazione,numeroPiste);
				lista.add(aeroporto);
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
	public Aeroporto getByPk(Object id) {
		
		Statement stmt = null;
		Connection conn = null;
		
		Aeroporto aeroporto=null;
		
		try {
			
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM aeroporto WHERE aeroporto_id="+ id + ";";
			System.out.println("Selected records into the table Aeroporto...");
			
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			
			while (myRs.next()) {
				int aeroportoId=myRs.getInt("aeroporto_id");
				String città=myRs.getString("città");
				String nome=myRs.getString("nome");
				String nazione=myRs.getString("nazione");
				int numeroPiste=myRs.getInt("numero_piste");
				aeroporto=new Aeroporto(aeroportoId,città, nome,nazione,numeroPiste);
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

		if(aeroporto==null) {
			System.out.println("Id Aeroporto non trovato");
			return null;
		}
		else { 
			return aeroporto;
		}

	}

}
