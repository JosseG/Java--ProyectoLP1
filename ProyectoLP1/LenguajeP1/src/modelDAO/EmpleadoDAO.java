package modelDAO;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.EmpleadoDTO;
import util.Conexion;

public class EmpleadoDAO implements ICrud<EmpleadoDTO> {
	
	//public static final String SQL_CONSULTAR="SELECT * FROM Habitacion";

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
				System.out.println("Exitoso agregado");
			}
			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}

		return false;
	}

	@Override
	public boolean eliminar(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(EmpleadoDTO c) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
}
