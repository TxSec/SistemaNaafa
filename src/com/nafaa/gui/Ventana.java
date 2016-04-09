package com.nafaa.gui;


import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import com.nafaa.componentes.TextField;
import com.nafaa.database.Database;
import com.nafaa.net.Client;
import com.nafaa.util.Secure;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;

public class Ventana extends JFrame implements MouseListener,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField passwordField;
	private JLabel lbleresNuevoRegistrate;
	private JLabel label;
	private JPanel panel;
	private NuevoRegistro nuevoRegistro;
	private OlvidaContraseña olvidaContraseña;
	private Connection connection = null;
	private Database database;
	private JButton button_1;
	private Principal principal;
	private JLabel lblSistemaMdicoNaafa;
	private JLabel lblUsuarioRegistradoCon;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setTitle("Sistema Médico NAFAA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800,600);
		setLocationRelativeTo(null);
		setFocusable(true);
		initPanels();
		initComponents();
		initDatabase();
	
	}
	
	private void initDatabase() {
		Database.getDatabase().conectar("jdbc:mysql://localhost:3306/mydb","root", "159951pro");
	}

	private void initPanels() {
		principal = new Principal();
		principal.getModificarUsuariso().addMouseListener(this);
		nuevoRegistro = new NuevoRegistro();
		nuevoRegistro.getLblRegresar().addMouseListener(this);
		nuevoRegistro.getBtnNewButton_1().addActionListener(this);
		olvidaContraseña = new OlvidaContraseña();
		olvidaContraseña.getLblReg().addMouseListener(this);
		
		
	}

	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 180, 30, 180));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		JCheckBox checkBox = new JCheckBox("Recordarme");
		
		label = new JLabel("¿Olvidaste la contraseña?");
		label.setForeground(new Color(0, 102, 204));
		label.addMouseListener(this);
		
		button_1 = new JButton("Acceder");
		button_1.addActionListener(this);
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(22, 137, 195));
		
		usuario = new JTextField();
		usuario.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton button_2 = new JButton();
		button_2.setVerticalAlignment(SwingConstants.TOP);
		button_2.setEnabled(false);
		button_2.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new File("image/hospital.png"));
			ImageIcon icon = new ImageIcon(img);
			button_2.setIcon(icon);
			button_2.setDisabledIcon(icon);
			setIconImage(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		lblUsuarioRegistradoCon = new JLabel("");
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(49)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(23))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(109)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUsuarioRegistradoCon)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addComponent(usuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addComponent(passwordField, 205, 205, 205))
							.addGap(124))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(163)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(272, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsuarioRegistradoCon)
					.addGap(19)
					.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkBox)
						.addComponent(label))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		lblSistemaMdicoNaafa = new JLabel("Sistema Médico NAAFA");
		lblSistemaMdicoNaafa.setBorder(new EmptyBorder(13,13,13,13));
		lblSistemaMdicoNaafa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaMdicoNaafa.setFont(new Font("Dialog", Font.BOLD, 21));
		
		lbleresNuevoRegistrate = new JLabel("¿Eres nuevo? Registrate.");
		lbleresNuevoRegistrate.setForeground(new Color(0, 102, 204));
		lbleresNuevoRegistrate.setBorder(new EmptyBorder(13,0,13,0));
		lbleresNuevoRegistrate.setHorizontalAlignment(SwingConstants.CENTER);
		lbleresNuevoRegistrate.addMouseListener(this);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(lblSistemaMdicoNaafa, BorderLayout.NORTH);
		contentPane.add(lbleresNuevoRegistrate, BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lbleresNuevoRegistrate){
            remove(panel);
            lbleresNuevoRegistrate.setVisible(false);
            getContentPane().add(nuevoRegistro,BorderLayout.CENTER);
            revalidate();
            repaint();
		} else if(e.getSource() == label){
            remove(panel);
            lbleresNuevoRegistrate.setVisible(false);
            getContentPane().add(olvidaContraseña,BorderLayout.CENTER);
            revalidate();
            repaint();
		} else if(e.getSource() == nuevoRegistro.getLblRegresar()){
            remove(nuevoRegistro);
            lbleresNuevoRegistrate.setVisible(true);
            getContentPane().add(panel,BorderLayout.CENTER);
            revalidate();
            repaint();
		} else if(e.getSource() == olvidaContraseña.getLblReg()){
            remove(olvidaContraseña);
            lbleresNuevoRegistrate.setVisible(true);
            getContentPane().add(panel,BorderLayout.CENTER);
            revalidate();
            repaint();
		} else if(e.getSource() == principal.getModificarUsuariso()){
			
            principal.remove(principal.getPanel_2());
            principal.add(new ModificarUsuarios(),BorderLayout.CENTER);
            revalidate();
            repaint();
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == lbleresNuevoRegistrate){
			lbleresNuevoRegistrate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		if(e.getSource() == label){
			label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} 
		if(e.getSource() == olvidaContraseña.getLblReg()){
			olvidaContraseña.getLblReg().setCursor(new Cursor(Cursor.HAND_CURSOR));
			Font font = olvidaContraseña.getLblReg().getFont();
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			olvidaContraseña.getLblReg().setFont(font.deriveFont(attributes));
		}
		if(e.getSource() == nuevoRegistro.getLblRegresar()){
			nuevoRegistro.getLblRegresar().setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		if(e.getSource() == principal.getModificarUsuariso()){
			principal.getModificarUsuariso().setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

	public void mouseExited(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevoRegistro.getBtnNewButton_1()){
			
			if(!nuevoRegistro.getNombre().getText().isEmpty() && !nuevoRegistro.getApellidos().getText().isEmpty() && !nuevoRegistro.getDireccion().getText().isEmpty()
					&& !nuevoRegistro.getUsuario().getText().isEmpty() && !nuevoRegistro.getTelefono().getText().isEmpty() && !nuevoRegistro.getEmail().getText().isEmpty() && !nuevoRegistro.getContraseña().getText().isEmpty() &&
					!nuevoRegistro.getConfirmarContraseña().getText().isEmpty()){
			if(nuevoRegistro.getContraseña().getText().equals(nuevoRegistro.getConfirmarContraseña().getText())){
			String hashed = "";
			try {
				hashed = Secure.getHashCodeFromString(nuevoRegistro.getContraseña().getText());
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			Database.getDatabase().queryDDL("INSERT INTO mydb.Usuario (tipoUsuario,nombre,apellidos,fechaNacimiento,sexo,contraseña,direccion,telefono,email,usuario) VALUES ('Paciente','"+nuevoRegistro.getNombre().getText()+"','"+nuevoRegistro.getApellidos().getText()+"','1994-02-28',"
					+ "'Masculino','"+hashed+"','"+nuevoRegistro.getDireccion().getText()+"','"+nuevoRegistro.getTelefono().getText()+"','"+nuevoRegistro.getEmail().getText()+"','"+nuevoRegistro.getUsuario().getText()+"');");
			remove(nuevoRegistro);
            lbleresNuevoRegistrate.setVisible(true);
            getContentPane().add(panel,BorderLayout.CENTER);
            revalidate();
            repaint();
            lblUsuarioRegistradoCon.setText("Usuario registrado con exito.");
			} else{
				nuevoRegistro.getError().setText("Las contraseñas no coinciden.");
			}
		} else{
			nuevoRegistro.getError().setText("Por favor llena todos los campos.");
		}
			}  else if(e.getSource() == button_1){
				
				String hash = "";
				try {
					hash = Secure.getHashCodeFromString(passwordField.getText());
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				
				int count = Database.getDatabase().queryDMLSize("SELECT usuario,contraseña FROM mydb.Usuario WHERE usuario='"+usuario.getText()+"' AND contraseña='"+hash+"'");
				String nombre = Database.getDatabase().queryDMLExtract("nombre","SELECT * FROM mydb.Usuario WHERE usuario='"+usuario.getText()+"' AND contraseña='"+hash+"'");
				String apellidos = Database.getDatabase().queryDMLExtract("apellidos","SELECT * FROM mydb.Usuario WHERE usuario='"+usuario.getText()+"' AND contraseña='"+hash+"'");
				String tipoUsuario = Database.getDatabase().queryDMLExtract("tipoUsuario","SELECT * FROM mydb.Usuario WHERE usuario='"+usuario.getText()+"' AND contraseña='"+hash+"'");
			if(count > 0){	
			client = new Client();
			principal.getLblBienvenido().setText("Bienvenido "+tipoUsuario+", "+nombre+" "+apellidos);
            remove(panel);
            lbleresNuevoRegistrate.setVisible(false);
            lblSistemaMdicoNaafa.setVisible(false); 
            contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
            setLocationRelativeTo(null);
            setSize(900,600);
            getContentPane().add(principal,BorderLayout.CENTER);
            //Cargar los componentes para cada Usuario.
            switch(tipoUsuario){
            case "Administrador":
            	principal.add(principal.getPanelAdmin(),BorderLayout.NORTH);
            	break;
            case "Paciente":
            	principal.add(new PanelPaciente(),BorderLayout.NORTH);
            	break;
            case "Auxiliar":
            	principal.add(new PanelPaciente(),BorderLayout.NORTH);
            	break;
            case "Laboratorista":
            	principal.add(new PanelPaciente(),BorderLayout.NORTH);
            	break;
            case "Farmaceutico":
            	principal.add(new PanelPaciente(),BorderLayout.NORTH);
            	break;
            case "Médico":
            	principal.add(new PanelPaciente(),BorderLayout.NORTH);
            	break;
            }
            revalidate();
            repaint();
			} else{
				lblUsuarioRegistradoCon.setText("Usuario o contraseña invalida");
				lblUsuarioRegistradoCon.setForeground(Color.red);
			}
		}
	}
}