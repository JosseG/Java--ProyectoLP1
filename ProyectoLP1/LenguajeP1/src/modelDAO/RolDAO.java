package modelDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICrud;

import modelDTO.RolDTO;
import util.Conexion;

public class RolDAO implements ICrud<RolDTO> {

	private static final Conexion con=Conexion.obtenerCone();
	
	@Override
	public List<RolDTO> listar() {
		
		PreparedStatement ps;
		ResultSet rs;
		List<RolDTO> listRol=new ArrayList<RolDTO>();
		
		try {
		
			ps=con.conectBd().prepareStatement("select * from rol");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				listRol.add(new RolDTO(rs.getString(1),rs.getString(2)));
			}
			
			rs.close();
			return listRol;

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			con.cerrarConexion();
			
		}
		
		return null;
	}

	@Override
	public boolean insertar(RolDTO c) {
		PreparedStatement ps;
		try {
			ps=con.conectBd().prepareStatement("insert into Rol values(?,?)");
			
			ps.setString(1, c.getId());
			ps.setString(2, c.getNombre());
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
	public boolean actualizar(RolDTO c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
