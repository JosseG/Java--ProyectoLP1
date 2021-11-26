package modelDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.ClienteDTO;
import util.Conexion;

public class ClienteDAO implements ICrud<ClienteDTO> {
	
	private static final String USP_LISTAR_CLIENTE="call ListarCliente()";
	private static final String USP_INSERTAR_CLIENTE="call AnadirCliente(?,?,?,?,?,?,?)";
	private static final String USP_MODIFICAR_CLIENTE="call ModificarCliente(?,?,?,?,?,?,?)";
	private static final String USP_CONSULTAR_CLIENTE="call ConsultarCliente(?)";
	private static final String USP_ELIMINAR_CLIENTE="call EliminarCliente(?)";
	private static final Conexion con=Conexion.obtenerCone();

	public List<ClienteDTO> listar() {
		// TODO Auto-generated method stub
		CallableStatement cs;
		ResultSet rs;
		List<ClienteDTO> listCl=new ArrayList<ClienteDTO>();
		
		try {
			
			cs=con.conectBd().prepareCall(USP_LISTAR_CLIENTE);
			rs=cs.executeQuery();
			
			while(rs.next()) {
				listCl.add(new ClienteDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
			
			rs.close();
			return listCl;

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			con.cerrarConexion();
			
		}
		
		return null;
	}

	@Override
	public boolean insertar(ClienteDTO c) {
		// TODO Auto-generated method stub
		
		CallableStatement cs;
		
		try {
			
			cs=con.conectBd().prepareCall(USP_INSERTAR_CLIENTE);
			cs.setInt(1, c.getId());
			cs.setString(2, c.getNombre());
			cs.setString(3, c.getApellidos());
			cs.setString(4, c.getDi());
			cs.setString(5, c.getTelefono());
			cs.setString(6, c.getCorreo());
			cs.setString(7, c.getIdDireccion());
			
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
	public boolean actualizar(ClienteDTO c) {
		// TODO Auto-generated method stub
		CallableStatement cs;
		
		try {
			
			cs=con.conectBd().prepareCall(USP_MODIFICAR_CLIENTE);
			cs.setInt(1, c.getId());
			cs.setString(2, c.getNombre());
			cs.setString(3, c.getApellidos());
			cs.setString(4, c.getDi());
			cs.setString(5, c.getTelefono());
			cs.setString(6, c.getCorreo());
			cs.setString(7, c.getIdDireccion());
			
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
		// TODO Auto-generated method stub
		
		CallableStatement cs;
		
		try {
			
			cs=con.conectBd().prepareCall(USP_ELIMINAR_CLIENTE);
			cs.setInt(1, Integer.parseInt(s));
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
	
	public List<ClienteDTO> filtrarId(Object o){
		
		CallableStatement cs;
		ResultSet rs;
		List<ClienteDTO> filtrarCl=new ArrayList<ClienteDTO>();
		
		try {
			
			cs=con.conectBd().prepareCall(USP_CONSULTAR_CLIENTE);
			cs.setInt(1, Integer.parseInt(o.toString()));
			rs=cs.executeQuery();
			
			while(rs.next()) {
				filtrarCl.add(new ClienteDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
			
			rs.close();

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			con.cerrarConexion();
			
		}
		return null;
	}
	
	

	

}
