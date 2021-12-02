package modelDTO;

public class CuentaDTO {

	private String id,idEmp,username,password;
	
	public CuentaDTO() {
		
	}

	public CuentaDTO(String id, String idEmp, String username, String password) {
		super();
		this.id = id;
		this.idEmp = idEmp;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(String idEmp) {
		this.idEmp = idEmp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
