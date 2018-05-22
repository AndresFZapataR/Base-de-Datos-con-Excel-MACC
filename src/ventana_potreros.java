package abs;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class ventana_potreros extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_potreros frame = new ventana_potreros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static JComboBox cmbPotrero = new JComboBox();


	public ventana_potreros() {
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
		
		
		cmbPotrero.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!cmbPotrero.getSelectedItem().toString().equals("")) {
					final ventana_potrero potreroFinca = new ventana_potrero();
					potreroFinca.setVisible(true);
				}
			}
			
		});
			
		cmbPotrero.setModel(new DefaultComboBoxModel(new String[] {"","Potrero 1", "Potrero 2", "Potrero 3"}));
		cmbPotrero.setBounds(134, 46, 148, 24);
		contentPane.add(cmbPotrero);
		
		
		JButton btnAadirPotrero = new JButton("AGREGAR POTRERO");
		btnAadirPotrero.setBounds(49, 175, 135, 24);
		contentPane.add(btnAadirPotrero);
		
		JButton btnEliminarPotrero = new JButton("ELIMINAR POTRERO");
		btnEliminarPotrero.setBounds(223, 175, 142, 24);
		contentPane.add(btnEliminarPotrero);
	}
	
	public static String selectedPaddock() {
		String paddock = cmbPotrero.getSelectedItem().toString();
		return paddock;
	}
}

