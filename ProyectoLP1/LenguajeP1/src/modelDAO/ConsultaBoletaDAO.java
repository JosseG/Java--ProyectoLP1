package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.ConsultaBoletaDTO;
import modelDTO.ConsultaHabitacionDTO;
import util.Conexion;

public class ConsultaBoletaDAO implements ICrud<ConsultaBoletaDTO> {

	private Conexion con=Conexion.obtenerCone();

	@Override
	public List<ConsultaBoletaDTO> listar() {
		List<ConsultaBoletaDTO> cBol=new ArrayList<ConsultaBoletaDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarBoleta()");
			rs=ps.executeQuery();
			while(rs.next()) {
				cBol.add(new ConsultaBoletaDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9)));
			}
			rs.close();
			return cBol;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return null;
	}

	@Override
	public boolean insertar(ConsultaBoletaDTO c) {

		return false;
	}

	@Override
	public boolean actualizar(ConsultaBoletaDTO c) {

		return false;
	}

	@Override
	public boolean eliminar(String s) {

		return false;
	}
	
	public List<ConsultaBoletaDTO> filtrarIdBoleta(String a) {

		List<ConsultaBoletaDTO> cBol=new ArrayList<ConsultaBoletaDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarBoletaIdBoleta(?)");
			ps.setString(1, a);
			rs=ps.executeQuery();
			while(rs.next()) {
				cBol.add(new ConsultaBoletaDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9)));
			}
			rs.close();
			return cBol;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return null;
	}
	
	public List<ConsultaBoletaDTO> filtrarIdCliente(Object a) {

		List<ConsultaBoletaDTO> cBol=new ArrayList<ConsultaBoletaDTO>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=con.conectBd().prepareStatement("call ConsultaBuscarBoletaIdCliente(?)");
			ps.setInt(1, Integer.parseInt(a.toString()));
			rs=ps.executeQuery();
			while(rs.next()) {
				cBol.add(new ConsultaBoletaDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9)));
			}
			rs.close();
			return cBol;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return null;
		
	}


	
}
