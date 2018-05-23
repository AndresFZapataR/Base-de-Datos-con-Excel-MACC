
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class crear_animal extends JFrame {

	private static final long serialVersionUID = 1L;

	public Vector<String> data = new Vector<String>();

	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtanimal;
	private JTextField txtpeso;
	private JTextField txtraza;
	private JTextField txtcolor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crear_animal frame = new crear_animal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public crear_animal() {
		setTitle("CREAR ANIMAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNoAnimal = new JLabel("No Animal:");
		lblNoAnimal.setBounds(10, 27, 78, 31);
		contentPane.add(lblNoAnimal);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 75, 46, 14);
		contentPane.add(lblPeso);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(10, 113, 46, 14);
		contentPane.add(lblRaza);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(240, 35, 46, 14);
		contentPane.add(lblSexo);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(240, 75, 46, 14);
		contentPane.add(lblColor);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "H", "M"}));
		comboBox.setBounds(315, 32, 68, 20);
		contentPane.add(comboBox);

		JButton btnAgregar = new JButton("AGREGAR ANIMAL");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data.addElement(txtanimal.getText());
				data.addElement(comboBox.getSelectedItem().toString());
				data.addElement(txtpeso.getText());
				data.addElement(txtraza.getText());
				data.addElement(txtcolor.getText());
				data.addElement(txtFecha.getText());
				txtcolor.setText("");
				txtraza.setText("");
				txtpeso.setText("");
				txtanimal.setText("");
				txtFecha.setText("");

			}
		});
		btnAgregar.setBounds(54, 190, 133, 23);
		contentPane.add(btnAgregar);

		JButton btnGuardarCambios = new JButton("GUARDAR CAMBIOS ");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearDocExcel.editarPotrero(Principal.NOM_FINCA , ventana_potreros.selectedPaddock() , data );
				final ventana_potreros ventana = new ventana_potreros();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnGuardarCambios.setBounds(250, 190, 133, 23);
		contentPane.add(btnGuardarCambios);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(240, 113, 46, 14);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(310, 110, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		txtanimal = new JTextField();
		txtanimal.setBounds(79, 32, 86, 20);
		contentPane.add(txtanimal);
		txtanimal.setColumns(10);

		txtpeso = new JTextField();
		txtpeso.setBounds(79, 69, 86, 20);
		contentPane.add(txtpeso);
		txtpeso.setColumns(10);

		txtraza = new JTextField();
		txtraza.setBounds(79, 110, 86, 20);
		contentPane.add(txtraza);
		txtraza.setColumns(10);

		txtcolor = new JTextField();
		txtcolor.setBounds(310, 72, 86, 20);
		contentPane.add(txtcolor);
		txtcolor.setColumns(10);

	}
}
