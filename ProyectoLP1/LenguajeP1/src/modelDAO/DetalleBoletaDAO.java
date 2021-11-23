package modelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelDTO.DetalleBoletaDTO;
import util.Conexion;

public class DetalleBoletaDAO {

	private static final Conexion conexion=Conexion.obtenerCone();
	
	
	public List<DetalleBoletaDTO> listar() {
		
		PreparedStatement ps;
		List<DetalleBoletaDTO> listDetBol=new ArrayList<DetalleBoletaDTO>();
		ResultSet rs;
		try {
			ps=conexion.conectBd().prepareStatement("Select * from DetalleBoleta");
			rs=ps.executeQuery();
			while(rs.next()) {
				listDetBol.add(new DetalleBoletaDTO(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5)));
			}
			rs.close();
			return listDetBol;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		
		
		return null;
	}	
	
}
