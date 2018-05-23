
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class crear_potrero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crear_potrero frame = new crear_potrero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	public crear_potrero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombrePotrero = new JLabel("Nombre potrero");
		lblNombrePotrero.setBounds(40, 25, 100, 25);
		contentPane.add(lblNombrePotrero);

		textField = new JTextField();
		textField.setBounds(154, 26, 124, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paddockname = textField.getText();
				CrearDocExcel.crearPotrero(Principal.NOM_FINCA, paddockname);
				final ventana_potreros regreso = new ventana_potreros();
				regreso.setVisible(true);
				dispose();
			}
		});

		btnCrear.setBounds(118, 93, 89, 23);
		contentPane.add(btnCrear);
	}

	public static String getNewPaddock() {
		String nom = textField.getText();
		return nom;
	}


}
