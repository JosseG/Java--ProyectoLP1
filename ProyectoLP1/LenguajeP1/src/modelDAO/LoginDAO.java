package modelDAO;

import java.sql.PreparedStatement;
import java.util.List;

import interfaces.ICrud;
import modelDTO.LoginDTO;
import util.Conexion;

public class LoginDAO implements ICrud<LoginDTO>{
	
	private static final Conexion con=Conexion.obtenerCone();
	
	@Override
	public List<LoginDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(LoginDTO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(LoginDTO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eliminarPorCuenta(String a) {
		PreparedStatement ps;
		try {
			ps=con.conectBd().prepareStatement("delete from Login where id_cuenta=?");
			ps.setString(1, a);
			if(ps.execute()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return false;
	}
	
}
