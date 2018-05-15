import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ventana_potrero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_potrero frame = new ventana_potrero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana_potrero() {
		setTitle("Potreros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionePotrero = new JLabel("Seleccione potrero:");
		lblSeleccionePotrero.setBounds(146, 11, 142, 24);
		contentPane.add(lblSeleccionePotrero);
		
		JComboBox cmbProtrero = new JComboBox();
		cmbProtrero.setModel(new DefaultComboBoxModel(new String[] {"Potrero 1", "Potrero 2", "Potrero 3"}));
		cmbProtrero.setBounds(134, 46, 148, 24);
		contentPane.add(cmbProtrero);
		
		JButton btnAadirPotrero = new JButton("A\u00D1ADIR POTRERO");
		btnAadirPotrero.setBounds(49, 175, 135, 24);
		contentPane.add(btnAadirPotrero);
		
		JButton btnEliminarPotrero = new JButton("ELIMINAR POTRERO");
		btnEliminarPotrero.setBounds(223, 175, 142, 24);
		contentPane.add(btnEliminarPotrero);
	}

}
