package modelDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.HabitacionDTO;
import util.Conexion;

public class HabitacionDAO implements ICrud<HabitacionDTO> {
	
	private static final String GENERAR_CODIGO="call GenerarCodigoHab()";

	public static final String SQL_CONSULTAR="SELECT * FROM Habitacion";
	
	private static final Conexion conexion=Conexion.obtenerCone();
	
	
	public List<HabitacionDTO> listar() {
		
		PreparedStatement ps;
		List<HabitacionDTO> inventario=new ArrayList<HabitacionDTO>();
		ResultSet rs;
		try {
			ps=conexion.conectBd().prepareStatement(SQL_CONSULTAR);
			rs=ps.executeQuery();
			while(rs.next()) {
				inventario.add(new HabitacionDTO(rs.getString(1),rs.getString(2).charAt(0),rs.getString(3)));
				
			}
			rs.close();
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
		
		CallableStatement ps;
		try {
			ps=conexion.conectBd().prepareCall("call AnadirHabitacion(?,?,?)");
			ps.setString(1, c.getId());
			ps.setString(2, String.valueOf(c.getTipo()));
			ps.setString(3, c.getDescripcion());

			if(ps.execute()){
				return true;
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			conexion.cerrarConexion();
		}

		return false;
	}


	@Override
	public boolean actualizar(HabitacionDTO c) {

		CallableStatement ps;
		try {
			ps = conexion.conectBd().prepareCall("call ModificarHabitacion(?,?,?)");
			
			ps.setString(1, String.valueOf(c.getTipo()));
			ps.setString(2, c.getDescripcion());
			ps.setString(3, c.getId());

			if(ps.execute()) {
				return true;
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
		return false;
		
	}


	@Override
	public boolean eliminar(String s) {
		
		CallableStatement ps;
		try {
			ps = conexion.conectBd().prepareCall("call EliminarHabitacion(?)");
			ps.setString(1, s);
			if(ps.execute()) {
				return true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return false;
		
	}
	
	
	public List<HabitacionDTO> filtrarId(String f){
		
		CallableStatement ps;
		ResultSet rs;
		List<HabitacionDTO> hab = new ArrayList<HabitacionDTO>();
		try {
			
			ps = conexion.conectBd().prepareCall("call ConsultarHabitacionId(?)");
			ps.setString(1, f);
			rs = ps.executeQuery();
			while(rs.next()) {
				hab.add(new HabitacionDTO(rs.getString(1),rs.getString(2).charAt(0),rs.getString(3)));
			}
			rs.close();
			return hab;			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
		
		return null;
	}
	
	public List<HabitacionDTO> filtrarTipo(String f){
		
		CallableStatement ps;
		ResultSet rs;
		List<HabitacionDTO> hab = new ArrayList<HabitacionDTO>();
		try {
			
			ps = conexion.conectBd().prepareCall("call ConsultarHabitacionTipo(?)");
			ps.setString(1, f);
			rs = ps.executeQuery();
			while(rs.next()) {
				hab.add(new HabitacionDTO(rs.getString(1),rs.getString(2).charAt(0),rs.getString(3)));
			}
			return hab;
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
		
		return null;
	}

	
	public String generarCodigo() {
		String nuevoCod="";
		CallableStatement cs;
		ResultSet rs;
		
		try {
			cs=conexion.conectBd().prepareCall(GENERAR_CODIGO);
			rs=cs.executeQuery();
			
			if(rs.next()) {
				nuevoCod=rs.getString(1);
			}
	
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			conexion.cerrarConexion();
		}
		
		return nuevoCod;
		
	}
	
	
}
