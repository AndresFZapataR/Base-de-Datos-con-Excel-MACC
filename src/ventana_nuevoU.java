

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ventana_nuevoU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_nuevoU frame = new ventana_nuevoU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static JTextField textPassword = new JTextField();
	static JTextField textUsuario = new JTextField();

	public ventana_nuevoU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(42, 34, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(42, 94, 80, 16);
		contentPane.add(lblContrasea);
		
		JButton btnCrear = new JButton("Crear ");
		btnCrear.setBounds(31, 180, 117, 29);
		contentPane.add(btnCrear);
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_usuario vent = new ventana_usuario();
				vent.setVisible(true);
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(273, 180, 117, 29);
		contentPane.add(btnSalir);
		
		textPassword.setBounds(146, 89, 130, 26);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textUsuario.setBounds(146, 29, 130, 26);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
	}
	
	public static String crearP() {
		String pass = textPassword.getText();
		return pass;
		
	}
	
	public static String crearU() {
		String user = textUsuario.getText();
		return user;
	}
}
