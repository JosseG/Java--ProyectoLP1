package modelDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.HabitacionDTO;
import util.Conexion;

public class HabitacionDAO implements ICrud<HabitacionDTO> {

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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		
		
		return null;
	}


	
	public boolean insertar(HabitacionDTO c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean actualizar(HabitacionDTO c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean eliminar(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
