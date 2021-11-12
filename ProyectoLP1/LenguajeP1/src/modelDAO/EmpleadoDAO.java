package modelDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelDTO.EmpleadoDTO;
import util.Conexion;

public class EmpleadoDAO {

	public static Conexion conexion=Conexion.obtenerCone();
	
	public List<EmpleadoDTO> listar(){
		
		ResultSet rs;
		PreparedStatement ps;
		List<EmpleadoDTO> lista=new ArrayList<EmpleadoDTO>();
		
		try {
			ps=conexion.conectBd().prepareStatement("Select * from empleado");
			rs=ps.executeQuery();
			if(rs.next()) {
				lista.add(new EmpleadoDTO("E01", "R1", "00000001111", "Pepito", "Perez Perea", "994432221", "aaaaaaa@gmail.com", new Date(2001,04,03)));
			}
			return lista;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}
	
	
	
}
