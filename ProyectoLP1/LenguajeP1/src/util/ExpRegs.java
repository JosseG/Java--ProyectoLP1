package util;

public class ExpRegs {
	
	public static final String REGULAREXP_NOMBRE_APELLIDO="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò ,.'-]+";
	public static final String REGULAREXP_TELEFONO="[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{3}";
	public static final String REGULAREXP_CORREO="[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*";
	public static final String REGULAREXP_DOCUMENTO="0{3}[0-9]{8}";
	
}
