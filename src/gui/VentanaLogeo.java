package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogeo {

	private JFrame frame;
	private GridBagConstraints gbc_usuario; 
	private JTextField usuario;
	private JPasswordField contrasenia;
	private JLabel labelUsuario; 
	private JLabel labelContra;
	private JButton botonProceder;

	protected static final String CONTRA="amistaaaad";
	protected static final String USUARIO="BvrguilillX";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogeo window = new VentanaLogeo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogeo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setForeground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{64, 76, 86, 0};
		gridBagLayout.rowHeights = new int[]{95, 23, 27, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBackground(new Color(0, 102, 102));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.NORTH;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 1;
		frame.getContentPane().add(labelUsuario, gbc_labelUsuario);
		
		usuario = new JTextField();
		usuario.setText("Usuario");
		usuario.setToolTipText("");
		gbc_usuario = new GridBagConstraints();
		gbc_usuario.anchor = GridBagConstraints.SOUTHWEST;
		gbc_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_usuario.gridx = 2;
		gbc_usuario.gridy = 1;
		frame.getContentPane().add(usuario, gbc_usuario);
		usuario.setColumns(10);
		
		labelContra = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_labelContra = new GridBagConstraints();
		gbc_labelContra.fill = GridBagConstraints.VERTICAL;
		gbc_labelContra.insets = new Insets(0, 0, 5, 5);
		gbc_labelContra.gridx = 1;
		gbc_labelContra.gridy = 2;
		frame.getContentPane().add(labelContra, gbc_labelContra);
		
		contrasenia = new JPasswordField();
		contrasenia.setText("Contrase\u00F1a");
		GridBagConstraints gbc_contrasenia = new GridBagConstraints();
		gbc_contrasenia.insets = new Insets(0, 0, 5, 0);
		gbc_contrasenia.anchor = GridBagConstraints.NORTHWEST;
		gbc_contrasenia.gridx = 2;
		gbc_contrasenia.gridy = 2;
		frame.getContentPane().add(contrasenia, gbc_contrasenia);
		contrasenia.setColumns(10);
		
		botonProceder = new JButton("Dale Duro");
		botonProceder.setBackground(new Color(153, 0, 153));
		GridBagConstraints gbc_botonProceder = new GridBagConstraints();
		gbc_botonProceder.gridx = 2;
		gbc_botonProceder.gridy = 3;
		frame.getContentPane().add(botonProceder, gbc_botonProceder);
		frame.setResizable(false);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 358, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usuario.setText("");
			}
		});
		usuario.setBackground(new Color(255, 255, 255));

		
		contrasenia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contrasenia.setText("");
			}
		});

		
		botonProceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (usuario.getText().equals(USUARIO) && new String(contrasenia.getPassword()).equals(CONTRA)){
					frame.dispose();
					CreaPersona p = new CreaPersona();
					p.frame2.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(frame,
						    "Los Bvrguillx no son dividibles por Tribogas.",
						    "Insane error",
						    JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogeo window = new VentanaLogeo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}

