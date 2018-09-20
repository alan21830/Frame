package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Utente;


public class Connessione {
	
	public void inserisci(Utente u) throws SQLException {
		
		
		
		String n =u.getNome();
		
		String c=u.getCognome();
		
		String t=u.getTelefono();
		String d=u.getData();
		String m=u.getMatricola();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Connection connection=null;
	connection=DriverManager.getConnection("jdbc:sqlite:/Users/macmac/Desktop/fibis");
		
		
		System.out.println("\nconnessione al db effettuata");
		
		
String query="INSERT INTO `tesserato`(`nome`,`cognome`,`telefono`,`data`,`matricola`) VALUES ('"+n+"','"+c+"','"+t+"','"+d+"','"+m+"')";
Statement statement = connection.createStatement();
statement.executeUpdate(query);
System.out.println("query ex\n!");
		
		
		connection.close();
	}


	public ArrayList<Utente> getUtenti() throws ClassNotFoundException, SQLException{
		ArrayList<Utente> lista = new ArrayList<Utente>(); 
		Utente utente;
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("org.sqlite.JDBC");
		
		Connection con = null;
		//con= DriverManager.getConnection("jdbc:mysql://localhost/fibis","root","root");
		String ConnectionString = "jdbc:sqlite:fibis.db";
		con =DriverManager.getConnection(ConnectionString);
		
		System.out.println("\nconn eff");
		
		String query="select * from tesserato";
		ResultSet rs ;
		Statement stm=null;
		stm = con.createStatement();
		rs=stm.executeQuery(query);
		while(rs.next()) {
			utente = new Utente();
			utente.setNome(rs.getString("nome"));
			utente.setCognome(rs.getString("cognome"));
			utente.setTelefono(rs.getString("telefono"));
			utente.setData(rs.getString("data"));
			utente.setMatricola(rs.getString("matricola"));
			
			lista.add(utente);
			
			
		}
		con.close();
		return lista;
		
		
	}
	
	public void eliminaUtente(String nome , String cognome) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con= DriverManager.getConnection("jdbc:mysql://localhost/fibis","root","root");
		Statement stm = con.createStatement();
		stm.executeUpdate("delete from tesserato where nome ='"+nome+"' and cognome ='"+cognome+"'");
		con.close();
		
		
		
		
		
	}
}
