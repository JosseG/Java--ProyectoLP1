package modelDAO;

import java.sql.*;
import java.util.List;

import interfaces.ICrud;
import modelDTO.DireccionDTO;
import util.Conexion;

public class DireccionDAO implements ICrud<DireccionDTO> {
	
	private static final Conexion con=Conexion.obtenerCone();
	private static final String INSERTAR="insert into direccion values (?,?,?)";
	private static final String ACTUALIZAR="update direccion set descripcion_direccion=?,pais_direccion=? where id_direccion=? ";
	private static final String ELIMINAR="delete from direccion where id_direccion=? ";

	@Override
	public List<DireccionDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(DireccionDTO c) {
		// TODO Auto-generated method stub
		
		PreparedStatement cs;
		
		try {
			cs=con.conectBd().prepareStatement(INSERTAR);
			cs.setString(1, c.getId());
			cs.setString(2, c.getDescripcion());
			cs.setString(3, c.getPais());
			if(cs.execute()) {
				return true;
			}
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		
		return false;
	}

	@Override
	public boolean actualizar(DireccionDTO c) {

		PreparedStatement cs;
		
		try {
			cs=con.conectBd().prepareStatement(ACTUALIZAR);
			cs.setString(1, c.getDescripcion());
			cs.setString(2, c.getPais());
			cs.setString(3, c.getId());
			if(cs.execute()) {
				return true;
			}
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return false;
	}

	@Override
	public boolean eliminar(String s) {
		
		PreparedStatement cs;
		
		try {
			cs=con.conectBd().prepareStatement(ELIMINAR);
			cs.setString(1, s);
			if(cs.execute()) {
				return true;
			}
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		
		return false;
	}
	
	public String generarCodigo() {
		
		String SQL = "call GenerarCodigoDir()", nuevo = "";
		CallableStatement cs;
		ResultSet rs;
		
		try {
			
			cs=con.conectBd().prepareCall(SQL);
			rs=cs.executeQuery();
			if(rs.next()) {
				nuevo=rs.getString(1);
			}
			rs.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return nuevo;
	}

}
