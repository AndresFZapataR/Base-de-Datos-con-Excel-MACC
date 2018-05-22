

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class crear_finca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField = new JTextField();;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crear_finca frame = new crear_finca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	final crear_potrero crearpotrero = new crear_potrero();
			

	
	public crear_finca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreFinca = new JLabel("Nombre finca");
		lblNombreFinca.setBounds(24, 11, 82, 22);
		contentPane.add(lblNombreFinca);
		
		
		textField.setBounds(130, 12, 121, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrearp = new JButton("CREAR");
		btnCrearp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearDocExcel.crearFinca(textField.getText());
				crearpotrero.setVisible(true);
			}
		});
		btnCrearp.setBounds(102, 64, 89, 23);
		contentPane.add(btnCrearp);
		
	}
	
	public static String getNewLand() {
		String nameLand = textField.getText();
		return nameLand;
	}
}
