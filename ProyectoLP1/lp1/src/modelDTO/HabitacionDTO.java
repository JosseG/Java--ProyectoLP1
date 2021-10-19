package modelDTO;

public class HabitacionDTO {

	public String id_hab;
	public char disp_hab;
	public String descripcion_hab;
	public String tipo_hab;
	
	public HabitacionDTO(String id_hab, char disp_hab, String descripcion_hab, String tipo_hab) {
		super();
		this.id_hab = id_hab;
		this.disp_hab = disp_hab;
		this.descripcion_hab = descripcion_hab;
		this.tipo_hab = tipo_hab;
	}
	
	public String getId_hab() {
		return id_hab;
	}
	
	public void setId_hab(String id_hab) {
		this.id_hab = id_hab;
	}
	
	public char getDisp_hab() {
		return disp_hab;
	}
	
	public void setDisp_hab(char disp_hab) {
		this.disp_hab = disp_hab;
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
	
}
