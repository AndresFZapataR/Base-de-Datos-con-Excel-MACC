

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventana_fincas extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_fincas frame = new ventana_fincas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	final crear_finca crearFinca = new crear_finca();


	public ventana_fincas() {
		setTitle("FINCAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneFinca = new JLabel("Seleccione finca:");
		lblSeleccioneFinca.setBounds(161, 11, 134, 30);
		contentPane.add(lblSeleccioneFinca);
		

		JComboBox listaFincas = new JComboBox();
		listaFincas.setModel(new DefaultComboBoxModel(new String[] {"", "FINCA 1", "FINCA 2", "FINCA 3"}));
		listaFincas.setBounds(122, 59, 164, 20);
		contentPane.add(listaFincas);
	
		
		listaFincas.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent e) {
				if (!listaFincas.getSelectedItem().toString().equals("")) {
					final ventana_potreros potrerosFinca1 = new ventana_potreros();
					potrerosFinca1.setVisible(true);
				}
			}
		});
		
		JButton btnCrearFinca = new JButton("NUEVA FINCA");
		btnCrearFinca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearFinca.setVisible(true);
				dispose();
				
				
			}
		});
		btnCrearFinca.setBounds(50, 130, 134, 23);
		contentPane.add(btnCrearFinca);
		
		JButton btnEliminarFinca = new JButton("ELIMINAR FINCA");
		btnEliminarFinca.setBounds(209, 130, 146, 23);
		contentPane.add(btnEliminarFinca);
	}
}
