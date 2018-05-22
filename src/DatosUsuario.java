package abs;
public class DatosUsuario {
	
	String usuario1="";
	String pass1="";
	String User =  ventana_nuevoU.crearU();
	String Pass =  ventana_nuevoU.crearP();
	
	public int probarPass(){
		usuario1= ventana_usuario.txt_usuario.getText();
		pass1= ventana_usuario.pss_contrasena.getText();
		int key = 0;
		if(!(User.equals(""))&& !(Pass.equals(""))) {
			if(usuario1.equals(User) && pass1.equals(Pass)) {
				key = 1;
			}
		}
		return key;
	}

	
}
