package modelDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelDTO.EmpleadoDTO;
import util.Conexion;

public class EmpleadoDAO {
	
	//public static final String SQL_CONSULTAR="SELECT * FROM Habitacion";

	public static Conexion conexion=Conexion.obtenerCone();
	
	public List<EmpleadoDTO> listar(){
		
		ResultSet rs;
		PreparedStatement ps;
		List<EmpleadoDTO> lista=new ArrayList<EmpleadoDTO>();
		
		try {
			ps=conexion.conectBd().prepareStatement("Select * from empleado");
			rs=ps.executeQuery();
			while(rs.next()) {
				lista.add(new EmpleadoDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
			rs.close();
			return lista;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}
	
	
	
}
