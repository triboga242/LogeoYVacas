package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import models.Persona;
import javax.swing.JPanel;

public class CreaPersona {

	JFrame frame2;
	private JTextField nombre_;
	private JTextField apellido_;
	private JTextField comentarios_;
	private JLabel lblGestion;
	private JLabel lbNombre;
	private JLabel lbApellido;
	private JSlider sliderSueldo;
	private JToggleButton btnVacaciones;
	private JRadioButton rbSexoM;
	private JRadioButton rbSexoH;
	private JList puesto;
	private JLabel lbAntiguedad;
	private JMenuBar menuBar;
	private JMenu Menu1;
	private JMenuItem menu1_1;
	private JMenuItem menu1_2;
	private JMenu Menu2;
	private JMenuItem menu2_1;
	private SpinnerModel model1;
	private JSpinner spinnerAntiguedad;
	private Panel panel;
	private ButtonGroup buttonGroup;
	private JButton btnCrear;
	private JLabel lbComentario;
	private SimpleDateFormat model;
	private String error;
	private JButton btnAnt;
	private JButton btnSig;
	private JLabel lblContador;
	private List<Persona> empleados = new ArrayList<Persona>();
	private int indice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaPersona window = new CreaPersona();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreaPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame2.setResizable(false);
		frame2.setBounds(100, 100, 523, 348);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		lblGestion = new JLabel("GEstion de los Hippies - modo crear");
		lblGestion.setBounds(10, 11, 275, 14);
		lblGestion.setFont(lblGestion.getFont().deriveFont(lblGestion.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		frame2.getContentPane().add(lblGestion);

		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(20, 36, 70, 14);
		frame2.getContentPane().add(lbNombre);

		nombre_ = new JTextField();
		nombre_.setBounds(95, 33, 101, 20);
		frame2.getContentPane().add(nombre_);
		nombre_.setColumns(2);

		lbApellido = new JLabel("Apellido");
		lbApellido.setBounds(20, 62, 70, 14);
		frame2.getContentPane().add(lbApellido);

		apellido_ = new JTextField();
		apellido_.setBounds(95, 58, 101, 20);
		frame2.getContentPane().add(apellido_);
		apellido_.setColumns(2);

		btnVacaciones = new JToggleButton("��Vacaiones??");
		btnVacaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVacaciones.setBounds(265, 22, 164, 44);
		frame2.getContentPane().add(btnVacaciones);

		rbSexoM = new JRadioButton("Machote");
		rbSexoM.setBounds(31, 100, 109, 23);
		frame2.getContentPane().add(rbSexoM);

		rbSexoH = new JRadioButton("Hembra");
		rbSexoH.setBounds(147, 100, 109, 23);
		frame2.getContentPane().add(rbSexoH);

		puesto = new JList();
		puesto.setBounds(137, 130, 99, 89);
		frame2.getContentPane().add(puesto);

		lbAntiguedad = new JLabel("Antig\u00FCedad");
		lbAntiguedad.setBounds(278, 167, 74, 14);
		frame2.getContentPane().add(lbAntiguedad);

		menuBar = new JMenuBar();
		frame2.setJMenuBar(menuBar);

		Menu1 = new JMenu("Modo");
		menuBar.add(Menu1);

		menu1_1 = new JMenuItem("Leer");

		Menu1.add(menu1_1);

		menu1_2 = new JMenuItem("Crear");

		Menu1.add(menu1_2);

		Menu2 = new JMenu("New menu");
		menuBar.add(Menu2);

		menu2_1 = new JMenuItem("Sacame de aqui");
		Menu2.add(menu2_1);

		model1 = new SpinnerDateModel();

		spinnerAntiguedad = new JSpinner(model1);
		model = new SimpleDateFormat("dd/MM/yy");
		spinnerAntiguedad.setEditor(new JSpinner.DateEditor(spinnerAntiguedad, model.toPattern()));

		panel = new Panel();
		panel.setBounds(351, 155, 129, 44);
		frame2.getContentPane().add(panel);

		panel.add(spinnerAntiguedad, BorderLayout.CENTER);
		spinnerAntiguedad.setBounds(70, 230, 46, 20);
		frame2.getContentPane().add(panel, BorderLayout.CENTER);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbSexoM);
		buttonGroup.add(rbSexoH);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(418, 250, 89, 23);
		frame2.getContentPane().add(btnCrear);

		comentarios_ = new JTextField();
		comentarios_.setBounds(108, 227, 164, 61);
		frame2.getContentPane().add(comentarios_);
		comentarios_.setColumns(10);

		lbComentario = new JLabel("Comentarios");
		lbComentario.setBounds(31, 254, 67, 14);
		frame2.getContentPane().add(lbComentario);

		puesto.setModel(new AbstractListModel() {
			String[] values = new String[] { "Jefe Supremo", "Currela", "Machaca", "Picaor" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JLabel lbPuestazo = new JLabel("Puestazo");
		lbPuestazo.setBounds(63, 130, 46, 14);
		frame2.getContentPane().add(lbPuestazo);

		JPanel sueldo_ = new JPanel();
		sueldo_.setBounds(265, 76, 215, 68);
		frame2.getContentPane().add(sueldo_);

		sliderSueldo = new JSlider();
		sliderSueldo.setMaximum(10000);
		sueldo_.add(sliderSueldo);
		sliderSueldo.setPaintTicks(true);

		JLabel lblSueldo = new JLabel("Sueldo (0-10000)");
		sueldo_.add(lblSueldo);

		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetTextFields(frame2);
			}
		});
		btnReset.setBounds(299, 247, 117, 29);
		frame2.getContentPane().add(btnReset);

		btnAnt = new JButton("Ant");
		btnAnt.setBounds(441, 5, 32, 29);
		frame2.getContentPane().add(btnAnt);
		btnAnt.setVisible(false);

		btnSig = new JButton("Sig");
		btnSig.setBounds(485, 5, 32, 29);
		frame2.getContentPane().add(btnSig);
		btnSig.setVisible(false);

		lblContador = new JLabel("0");
		lblContador.setBounds(446, 35, 61, 16);
		frame2.getContentPane().add(lblContador);
		lblContador.setVisible(false);

		btnCrear.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int cont = 0;

				String nombre = null;
				String apellido = null;
				float sueldo = 0;
				String vacaciones = null;
				String sexo = null;
				String comentario = null;
				int antiguedad = 0;

				cont += validarString(nombre_.getText());
				cont += validarString(apellido_.getText());
				vacaciones = leerBool();
				cont += validarString(leerSexo());
				error = "hay " + (3-cont) + " errores";

				if (cont == 3) {

					Date today = new Date();

					Date desde = (Date) spinnerAntiguedad.getValue();

					nombre = nombre_.getText();
					apellido = apellido_.getText();
					sueldo = sliderSueldo.getValue();
					sexo = leerSexo();
					comentario = comentarios_.getText();
					antiguedad = today.getYear() - desde.getYear();

					Persona p = new Persona(nombre, apellido, sueldo, vacaciones, sexo, comentario, antiguedad);
					empleados.add(p);
					indice = empleados.size() - 1;
					limpia();
				} else {
					JOptionPane.showMessageDialog(frame2, error, "Insane error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		menu2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		sliderSueldo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sueldo = sliderSueldo.getValue();
				if (sueldo < 3000) {
					sueldo_.setBackground(Color.GREEN);
				} else if (sueldo < 5000) {
					sueldo_.setBackground(Color.YELLOW);
				} else if (sueldo < 8000) {
					sueldo_.setBackground(Color.ORANGE);
				} else {
					sueldo_.setBackground(Color.RED);
				}

				lblSueldo.setText(sliderSueldo.getValue() + "� al mes");
			}
		});

		menu1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestion.setText("GEstion de los Hippies - modo leer");

				btnAnt.setVisible(true);
				btnSig.setVisible(true);
				lblContador.setVisible(true);
				btnAnt.setEnabled(true);
				btnSig.setEnabled(true);
				lblContador.setEnabled(true);

				nombre_.setEnabled(false);
				apellido_.setEnabled(false);
				comentarios_.setEnabled(false);
				lbNombre.setEnabled(false);
				lbApellido.setEnabled(false);
				lbComentario.setEnabled(false);
				rbSexoH.setEnabled(false);
				rbSexoM.setEnabled(false);
				lblSueldo.setEnabled(false);
				lbPuestazo.setEnabled(false);
				lbAntiguedad.setEnabled(false);
				btnReset.setEnabled(false);
				btnCrear.setEnabled(false);
				btnVacaciones.setEnabled(false);
				spinnerAntiguedad.setEnabled(false);
				puesto.setEnabled(false);
				indice = empleados.size() - 1;
				mostrarEmpleado();

			}
		});

		menu1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestion.setText("GEstion de los Hippies - modo crear");

				btnAnt.setVisible(false);
				btnSig.setVisible(false);
				lblContador.setVisible(false);
				btnAnt.setEnabled(false);
				btnSig.setEnabled(false);
				lblContador.setEnabled(false);

				nombre_.setEnabled(true);
				apellido_.setEnabled(true);
				comentarios_.setEnabled(true);
				lbNombre.setEnabled(true);
				lbApellido.setEnabled(true);
				lbComentario.setEnabled(true);
				rbSexoH.setEnabled(true);
				rbSexoM.setEnabled(true);
				lblSueldo.setEnabled(true);
				lbPuestazo.setEnabled(true);
				lbAntiguedad.setEnabled(true);
				btnReset.setEnabled(true);
				btnCrear.setEnabled(true);
				btnVacaciones.setEnabled(true);
				spinnerAntiguedad.setEnabled(true);
				puesto.setEnabled(true);

				indice = empleados.size() - 1;
				limpia();
			}
		});
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextEmployee();
				mostrarEmpleado();
				updateContador();
			}
		});
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevEmployee();
				mostrarEmpleado();
				updateContador();
			}
		});
	}

	private void updateContador() {
		lblContador.setText((indice + 1) + " de " + empleados.size());
	}

	private int nextEmployee() {
		++indice;
		if (indice == empleados.size()) {
			indice = 0;
		}
		return indice;
	}

	private int prevEmployee() {
		--indice;
		if (indice < 0) {
			indice = empleados.size() - 1;
		}
		return indice;
	}

	public void mostrarEmpleado() {
		if (!empleados.isEmpty()) {
			Persona p = empleados.get(indice);
			nombre_.setText(p.getNombre());
			apellido_.setText(p.getApellido());
			comentarios_.setText(p.getApellido());

			if (p.getSexo() == "H")
				rbSexoH.setSelected(true);
			else {
				rbSexoM.setSelected(true);
				rbSexoH.setSelected(false);
			}

			if (p.isVacaciones() == "Sepvta")
				btnVacaciones.setSelected(true);
			else
				btnVacaciones.setSelected(false);

			sliderSueldo.setValue((int) p.getSueldo());

		}

	}

	public void limpia() {
		nombre_.setText("");
		apellido_.setText("");
		comentarios_.setText("");
		rbSexoM.setSelected(false);
		rbSexoH.setSelected(false);
		btnVacaciones.setSelected(false);
		sliderSueldo.setValue(0);
		puesto.setSelectedIndex(0);

	}

	public byte validarString(String cadena) {

		if (cadena.isEmpty() || cadena.equals(null)) {
			return 0;
		} else {
			return 1;
		}
	}

	public String leerBool() {

		if (btnVacaciones.isSelected())
			return "Sepvta";
		return "Nopvta";
	}

	public String leerSexo() {

		String sexo = "";

		if (rbSexoM.isSelected())
			sexo = "M";
		else if (rbSexoH.isSelected())
			sexo = "H";

		return sexo;
	}

	public static void resetTextFields(JFrame c) {
		Component[] components = c.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JFrame)
				resetTextFields((JFrame) components[i]);
			else if (components[i] instanceof TextField)
				((TextField) components[i]).setText("");
		}
	}
}
