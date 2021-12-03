package modelDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelDTO.BoletaDTO;
import util.Conexion;

public class BoletaDAO {
	
	
	private static final Conexion conexion=Conexion.obtenerCone();
	
	
	public List<BoletaDTO> listar() {
		
		PreparedStatement ps;
		List<BoletaDTO> listBol=new ArrayList<BoletaDTO>();
		ResultSet rs;
		try {
			ps=conexion.conectBd().prepareStatement("Select * from Boleta");
			rs=ps.executeQuery();
			while(rs.next()) {
				listBol.add(new BoletaDTO(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5)));
			}
			rs.close();
			return listBol;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}

		return null;
	}
	public boolean eliminarPorEmp(String a) {
		PreparedStatement ps;
		try {
			ps=conexion.conectBd().prepareStatement("Delete from Boleta where id_emp=?");
			ps.setString(1, a);
			if(ps.execute()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}
	
	
	

}
