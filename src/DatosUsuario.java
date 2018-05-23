
public class DatosUsuario {

	String usuario1="";
	String pass1="";
	String[] userData = ReadExcel.readUserData();
	String User =  userData[0];
	String Pass =  userData[1];

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
