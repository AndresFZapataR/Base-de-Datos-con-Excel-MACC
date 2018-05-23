
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana_usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txt_usuario;
	public static JPasswordField pss_contrasena;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_usuario frame = new ventana_usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ventana_usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(55, 49, 46, 14);
		contentPane.add(lblUsuario);

		txt_usuario = new JTextField();
		txt_usuario.setBounds(128, 46, 134, 20);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrasena:");
		lblContrasea.setBounds(55, 126, 74, 14);
		contentPane.add(lblContrasea);

		pss_contrasena = new JPasswordField();
		pss_contrasena.setBounds(139, 123, 123, 20);
		contentPane.add(pss_contrasena);

		final DatosUsuario data= new DatosUsuario();
		final ventana_potreros ventanaPotreros= new ventana_potreros();
		final ventana_nuevoU ventanacrear = new ventana_nuevoU();


		JButton btnIngresar = new JButton("ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(data.probarPass()==1) {
				   JOptionPane.showMessageDialog(null,"Bienvenido usuario");
				   ventanaPotreros.setVisible(true);
				   dispose();

				}
				else {
					JOptionPane.showMessageDialog(null,"error");
				}
			}
		});
		btnIngresar.setBounds(37, 206, 89, 23);
		contentPane.add(btnIngresar);

		JButton btnCrear = new JButton("Crear Usuario");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanacrear.setVisible(true);
				dispose();
			}
		});
		btnCrear.setBounds(293, 206, 100, 25);
		contentPane.add(btnCrear);
	}

}
