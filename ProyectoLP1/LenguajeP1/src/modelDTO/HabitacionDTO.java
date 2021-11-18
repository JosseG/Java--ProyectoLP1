package modelDTO;

import java.sql.Date;
import java.util.List;

import modelDAO.HabitacionDAO;

public class HabitacionDTO {

	public String id_hab;
	public Date fecha_reserva;
	public int num_dias;
	public String descripcion_hab;
	public String tipo_hab;
	
	public HabitacionDAO dao=new HabitacionDAO();
	
	public HabitacionDTO() {
		
	}
	
	public HabitacionDTO(String id_hab,String tipo_hab,Date fecha_reserva, int num_dias, String descripcion_hab) {
		super();
		this.id_hab = id_hab;
		this.tipo_hab = tipo_hab;
		this.fecha_reserva=fecha_reserva;
		this.num_dias=num_dias;
		this.descripcion_hab = descripcion_hab;

	}
	
	public int getNum_dias() {
		return num_dias;
	}

	public void setNum_dias(int num_dias) {
		this.num_dias = num_dias;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public String getId_hab() {
		return id_hab;
	}
	
	public void setId_hab(String id_hab) {
		this.id_hab = id_hab;
	}
	
	public String getDescripcion_hab() {
		return descripcion_hab;
	}
	
	public void setDescripcion_hab(String descripcion_hab) {
		this.descripcion_hab = descripcion_hab;
	}
	
	public String getTipo_hab() {
		return tipo_hab;
	}
	
	public void setTipo_hab(String tipo_hab) {
		this.tipo_hab = tipo_hab;
	}
	
	public List<HabitacionDTO> listar(){
		return dao.listar();
	}
	
}
