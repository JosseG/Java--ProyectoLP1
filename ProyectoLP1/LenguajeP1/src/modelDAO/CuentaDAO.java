package modelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.List;

import interfaces.ICrud;
import modelDTO.CuentaDTO;
import util.Conexion;

public class CuentaDAO implements ICrud<CuentaDTO> {
	
	private static final String GENERAR_CODIGO="call GenerarCodigoCuenta()";
	
	private static final Conexion con=Conexion.obtenerCone();

	@Override
	public List<CuentaDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(CuentaDTO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(CuentaDTO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String generarCodigo() {
		String nuevo="";
		CallableStatement cs;
		ResultSet rs;
		
		try {
			cs=con.conectBd().prepareCall(GENERAR_CODIGO);
			rs=cs.executeQuery();
			
			if(rs.next()) {
				nuevo=rs.getString(1);
			}
	
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			con.cerrarConexion();
		}
		
		
		return nuevo;
	}

	
}
