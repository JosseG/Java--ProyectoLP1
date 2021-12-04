package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.ConsultaHabitacionDTO;
import util.Conexion;

public class ConsultaHabitacionDAO implements ICrud<ConsultaHabitacionDTO> {

	private Conexion con=Conexion.obtenerCone();

	@Override
	public List<ConsultaHabitacionDTO> listar() {
		List<ConsultaHabitacionDTO> cHab=new ArrayList<ConsultaHabitacionDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarHabitacion()");
			rs=ps.executeQuery();
			while(rs.next()) {
				cHab.add(new ConsultaHabitacionDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).charAt(0)));
			}
			rs.close();
			return cHab;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return null;
	}

	@Override
	public boolean insertar(ConsultaHabitacionDTO c) {

		return false;
	}

	@Override
	public boolean actualizar(ConsultaHabitacionDTO c) {

		return false;
	}

	@Override
	public boolean eliminar(String s) {

		return false;
	}
	
	public List<ConsultaHabitacionDTO> filtrarId(String a) {

		List<ConsultaHabitacionDTO> cHab=new ArrayList<ConsultaHabitacionDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarHabitacionId(?)");
			ps.setString(1, a);
			rs=ps.executeQuery();
			while(rs.next()) {
				cHab.add(new ConsultaHabitacionDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).charAt(0)));
			}
			rs.close();
			return cHab;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return null;
	}
	
	public List<ConsultaHabitacionDTO> filtrarTipo(String a) {

		List<ConsultaHabitacionDTO> cHab=new ArrayList<ConsultaHabitacionDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarHabitacionTipo(?)");
			ps.setString(1, a);
			rs=ps.executeQuery();
			while(rs.next()) {
				cHab.add(new ConsultaHabitacionDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).charAt(0)));
			}
			rs.close();
			return cHab;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return null;
	}
	
	
	
}
