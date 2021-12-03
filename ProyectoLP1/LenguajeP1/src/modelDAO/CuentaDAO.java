package modelDAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;
import modelDTO.CuentaDTO;
import modelDTO.RolDTO;
import util.Conexion;

public class CuentaDAO implements ICrud<CuentaDTO> {

	
	private static final String GENERAR_CODIGO="call GenerarCodigoCuenta()";
	
	private static final Conexion con=Conexion.obtenerCone();

	@Override
	public List<CuentaDTO> listar() {
		PreparedStatement ps;
		ResultSet rs;
		List<CuentaDTO> listCt=new ArrayList<CuentaDTO>();
		
		try {
			
			ps=con.conectBd().prepareStatement("select * from cuenta");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				listCt.add(new CuentaDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
			rs.close();
			return listCt;

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			con.cerrarConexion();
			
		}
		
		return null;
	}

	@Override
	public boolean insertar(CuentaDTO c) {
		PreparedStatement ps;
		try {
			ps=con.conectBd().prepareStatement("insert into Cuenta values(?,?,?,?)");
			
			ps.setString(1, c.getId());
			ps.setString(2, c.getIdEmp());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			if(ps.execute()){
				return true;
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			con.cerrarConexion();
		}

		return false;
	}

	@Override
	public boolean actualizar(CuentaDTO c) {
		PreparedStatement ps;
		
		try {
			
			ps=con.conectBd().prepareStatement("update Cuenta set id_emp=?,username_cuenta=?,password_cuenta=?  where id_cuenta=?");
			ps.setString(1, c.getIdEmp());
			ps.setString(2, c.getUsername());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getId());

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

	@Override
	public boolean eliminar(String s) {
		PreparedStatement ps;
		
		try {
			
			ps=con.conectBd().prepareStatement("delete from Cuenta where id_cuenta=?");
			ps.setString(1, s);
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
