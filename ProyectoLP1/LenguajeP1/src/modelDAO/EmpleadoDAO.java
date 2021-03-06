package modelDAO;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.EmpleadoDTO;
import modelDTO.HabitacionDTO;
import util.Conexion;

public class EmpleadoDAO implements ICrud<EmpleadoDTO> {
	
	private static final String USP_MODIFICAR_EMPLEADO="call ModificarEmpleado(?,?,?,?,?,?,?)";
	private static final String USP_ELIMINAR_EMPLEADO="call EliminarEmpleado(?)";
	private static final String GENERAR_CODIGO="call GenerarCodigoEmp()";
	
	
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
	
	public boolean insertar(EmpleadoDTO emp) {

		CallableStatement ps;
		try {
			ps=conexion.conectBd().prepareCall("call AnadirEmpleado(?,?,?,?,?,?,?)");
			ps.setString(1, emp.getId());
			ps.setString(2, emp.getIdRol());
			ps.setString(3, emp.getDi());
			ps.setString(4, emp.getNombre());
			ps.setString(5, emp.getApellidos());
			ps.setString(6, emp.getTelefono());
			ps.setString(7, emp.getCorreo());
			if(ps.execute()){
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			System.out.println("Se cerro");
			conexion.cerrarConexion();
		}

		return false;
		
	}

	@Override
	public boolean eliminar(String s) {
		CallableStatement cs;
		
		try {
			
			cs=conexion.conectBd().prepareCall(USP_ELIMINAR_EMPLEADO);
			cs.setString(1, s);
			if(cs.execute()) {
				return true;
			}

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean actualizar(EmpleadoDTO c) {
		// TODO Auto-generated method stub
		CallableStatement cs;
		
		try {
			
			cs=conexion.conectBd().prepareCall(USP_MODIFICAR_EMPLEADO);
			cs.setString(1, c.getId());
			cs.setString(2, c.getIdRol());
			cs.setString(3, c.getDi());
			cs.setString(4, c.getNombre());
			cs.setString(5, c.getApellidos());
			cs.setString(6, c.getTelefono());
			cs.setString(7, c.getCorreo());

			if(cs.execute()) {
				return true;
			}

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			conexion.cerrarConexion();
		}
		return false;	
	}

	
	
	
	
	public List<EmpleadoDTO> filtrarId(String f){
		
		ResultSet rs;
		PreparedStatement ps;
		List<EmpleadoDTO> lista=new ArrayList<EmpleadoDTO>();
		
		try {
			ps=conexion.conectBd().prepareStatement("Select * from empleado where id_emp=?");
			ps.setString(1, f);
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
