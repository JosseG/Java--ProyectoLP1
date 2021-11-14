package modelDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelDTO.HabitacionDTO;
import util.Conexion;

public class HabitacionDAO {

	public static final String SQL_CONSULTAR="SELECT * FROM Habitacion";
	
	private static final Conexion conexion=Conexion.obtenerCone();
	
	
	public List<HabitacionDTO> listar() {
		
		PreparedStatement ps;
		ArrayList<HabitacionDTO> inventario=new ArrayList<HabitacionDTO>();
		ResultSet rs;
		try {
			ps=conexion.conectBd().prepareStatement(SQL_CONSULTAR);
			rs=ps.executeQuery();
			while(rs.next()) {
				inventario.add(new HabitacionDTO(rs.getString(1),rs.getString(2).charAt(0),rs.getString(3),rs.getString(4)));
			}
			return inventario;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
}
