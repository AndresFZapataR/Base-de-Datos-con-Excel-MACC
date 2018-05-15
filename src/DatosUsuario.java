
public class DatosUsuario {
	
	String usuario1="";
	String pass1="";
	public int probarPass(){
		usuario1= ventana_usuario.txt_usuario.getText();
		pass1= ventana_usuario.pss_contrasena.getText();
		if(usuario1.equals("O")&&pass1.equals("1")) {
			return 1;
			
		}
		else
			return 0;
		
	}

}
