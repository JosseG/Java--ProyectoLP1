package util;

import java.sql.*;

public class Conexion {

	private static Conexion conexion;
	private Connection connection;
	
	private Conexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservahotel", "root", "mysql");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservahotel", "root", "user");
			System.out.println("Exitoso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static synchronized Conexion obtenerCone() {
		if(conexion==null) {
			conexion=new Conexion();
		}
		return conexion;
	}
	
	public Connection conectBd() {
		return connection;
	}
	
	public void cerrarConexion() {
		conexion=null;
	}
	
}
