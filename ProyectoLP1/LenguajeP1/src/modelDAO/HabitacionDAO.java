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
		List<HabitacionDTO> inventario=new ArrayList<HabitacionDTO>();
		ResultSet rs;
		try {
			ps=conexion.conectBd().prepareStatement(SQL_CONSULTAR);
			rs=ps.executeQuery();
			while(rs.next()) {
				inventario.add(new HabitacionDTO(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5)));
				System.out.println(rs.getDate(3));
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
			ps=conexion.conectBd().prepareCall("call AnadirHabitacion(?,?,?,?,?)");
			ps.setString(1, c.getId_hab());
			ps.setString(2, c.getTipo_hab());
			ps.setDate(3, c.getFecha_reserva());
			ps.setInt(4, c.getNum_dias());
			ps.setString(5, c.getDescripcion_hab());

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
