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

public class VoloDAOImpl implements GenericDAO <Volo> {

	@Override
	public boolean insert(Volo t) {

		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(t.getCodiceVolo())==null) {
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "INSERT INTO volo(codice_volo, data_partenza, data_arrivo, numero_passeggeri, aeroporto_partenza,aeroporto_arrivo,aereo) VALUES("+t.getCodiceVolo()+",'"+t.getDataPartenza()+"','"+t.getDataArrivo()+"',"+t.getNumeroPasseggeri()+","+t.getAeroportoPartenza().getAeroportoId()+","+t.getAeroportoArrivo().getAeroportoId()+","+t.getAereo().getAereoId()+")";
				System.out.println("Inserting records into the table Volo...");
		
				//TODO dobbiamo controllare siano presenti l'areo e gli aeroporti 
				// il controllo va fatto nel service 
				
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
				String sql = "DELETE FROM volo WHERE codice_volo="+ id + ";";
				System.out.println("Deleting records into the table Volo...");
				
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
	public boolean update(Volo t, Object id) {

		Statement stmt = null;
		Connection conn = null;
		
		if(getByPk(id)!=null) {
			try {	
				System.out.println(t.getDataPartenza()); 	
				Class.forName(JDBC_DRIVER).newInstance();
				System.out.println("***getAll***Connecting to a selected dabase...");
				conn= DriverManager.getConnection(DB_URL);
				String sql = "UPDATE volo set codice_volo="+ t.getCodiceVolo() + ", data_partenza='" + t.getDataPartenza()+"', data_arrivo='"+ t.getDataArrivo()+ "',aeroporto_partenza=" + t.getAeroportoPartenza().getAeroportoId()+",aeroporto_arrivo=" + t.getAeroportoArrivo().getAeroportoId() + ",aereo =" + t.getAereo().getAereoId() + " WHERE codice_volo=" +id +";";
				System.out.println("***getAll***Selected records into the table Volo...");
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
	public ArrayList<Volo> getAll() {
		
		Statement stmt = null;
		Connection conn = null;
		ArrayList <Volo> lista = new ArrayList<Volo>();
		
		try {
			
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("***getAll***Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM volo;";
			System.out.println("***getAll***Selected records into the table getByPk Volo...");
			
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			
			while (myRs.next()) {
				int codiceVolo=myRs.getInt("codice_volo");
				Date dataPartenza=myRs.getDate("data_partenza");
				Date dataArrivo=myRs.getDate("data_arrivo");
				int numeroPasseggeri=myRs.getInt("numero_passeggeri");
				int aeroportoPartenza=myRs.getInt("aeroporto_partenza");
				int aeroportoArrivo=myRs.getInt("aeroporto_arrivo");
				int aereo = myRs.getInt("aereo");
				Volo volo=new Volo(codiceVolo,dataPartenza,dataArrivo,numeroPasseggeri,service.getAeroportoByPK(aeroportoPartenza),service.getAeroportoByPK(aeroportoArrivo),service.getAereoByPK(aereo));
				lista.add(volo);
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
	public Volo getByPk(Object id) {

		Statement stmt = null;
		Connection conn = null;
		Volo volo=null;
		
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			System.out.println("Connecting to a selected dabase...");
			conn= DriverManager.getConnection(DB_URL);
			String sql = "SELECT * FROM volo WHERE codice_volo="+ id + ";";
			System.out.println("Selected records into the table Volo...");
			stmt = conn.createStatement();
			ResultSet myRs =stmt.executeQuery(sql);
			
			while (myRs.next()) {
				int codiceVolo=myRs.getInt("codice_volo");
				Date dataPartenza=myRs.getDate("data_partenza");
				Date dataArrivo=myRs.getDate("data_arrivo");
				int numeroPasseggeri=myRs.getInt("numero_passeggeri");
				int aeroportoPartenza=myRs.getInt("aeroporto_partenza");
				int aeroportoArrivo=myRs.getInt("aeroporto_arrivo");
				int aereo=myRs.getInt("aereo");
				volo=new Volo(codiceVolo,dataPartenza,dataArrivo,numeroPasseggeri,service.getAeroportoByPK(aeroportoPartenza),service.getAeroportoByPK(aeroportoArrivo),service.getAereoByPK(aereo));
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

		if(volo==null) {
			System.out.println("Id Volo non trovato");
			return null;
		}
		else { 
			return volo;
		}
	}

}
