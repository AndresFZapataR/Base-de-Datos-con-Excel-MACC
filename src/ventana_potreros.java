
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ventana_potreros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		cmbPotrero.setModel(new DefaultComboBoxModel(ReadExcel.getPaddocks(Principal.NOM_FINCA)));
		cmbPotrero.setBounds(134, 46, 148, 24);
		contentPane.add(cmbPotrero);

		cmbPotrero.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!cmbPotrero.getSelectedItem().toString().equals("")) {
					ventana_potrero potreroFinca = new ventana_potrero();
					potreroFinca.setVisible(true);
					dispose();
				}
			}

		});

		JButton btnAnadirPotrero = new JButton("AGREGAR POTRERO");
		btnAnadirPotrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final crear_potrero ventana = new crear_potrero();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnAnadirPotrero.setBounds(49, 175, 135, 24);
		contentPane.add(btnAnadirPotrero);

		JButton btnEliminarPotrero = new JButton("ELIMINAR POTRERO");
		btnEliminarPotrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearDocExcel.deletePaddock(Principal.NOM_FINCA, cmbPotrero.getSelectedItem().toString());
				final ventana_potreros  ventana = new ventana_potreros();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnEliminarPotrero.setBounds(223, 175, 142, 24);
		contentPane.add(btnEliminarPotrero);

		JButton btnEditarPotrero = new JButton("EDITAR POTRERO");
		btnEditarPotrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final crear_animal crearanimal = new crear_animal ();
				crearanimal.setVisible(true);
				dispose();
			}
		});
		btnEditarPotrero.setBounds(135, 215, 135, 23);
		contentPane.add(btnEditarPotrero);
	}

	public static String selectedPaddock() {
		String paddock = cmbPotrero.getSelectedItem().toString();
		return paddock;
	}
}
