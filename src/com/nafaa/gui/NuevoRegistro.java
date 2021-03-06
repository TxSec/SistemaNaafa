package com.nafaa.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.nafaa.database.Database;
import com.nafaa.util.Secure;
/**
 * GUI para el registro de nuevos Usuarios.
 * @author txsec
 *
 */
public class NuevoRegistro extends JPanel implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField direccion;
	private JTextField telefono;
	private JPasswordField contraseña;
	private JTextField usuario;
	private JTextField email;
	private JPasswordField confirmarContraseña;
	private JLabel lbl;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField apellidos;
	private JTextField nombre;
	private JLabel error;
	private JLabel lblRegresar;
	private Ventana ventana;
	
	public JPasswordField getConfirmarContraseña() {
		return confirmarContraseña;
	}
	
	public JTextField getNombre() {
		return nombre;
	}
	
	public JTextField getApellidos() {
		return apellidos;
	}


	public JTextField getDireccion() {
		return direccion;
	}


	public JTextField getTelefono() {
		return telefono;
	}


	public JPasswordField getContraseña() {
		return contraseña;
	}


	public JTextField getUsuario() {
		return usuario;
	}


	public JTextField getEmail() {
		return email;
	}



	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}


	public JLabel getLbl() {
		return lbl;
	}


	public void setLbl(JLabel lblRegresar) {
		this.lblRegresar = lblRegresar;
	}

	public NuevoRegistro(){
		initComponentes();
	}

	/**
	 * Create the panel.
	 */
	public NuevoRegistro(Ventana ventana) {
		this.ventana = ventana;
		initComponentes();

	}
	
	private void initComponentes(){
		btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setBackground(new Color(22, 137, 195));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(this);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		
		lblRegresar = new JLabel("Regresar");
		lblRegresar.addMouseListener(this);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		JComboBox comboBox_3 = new JComboBox();
		String model[] = new String[113];
		model[0] = "Año";
		int count = 112;
		for(int i = 1905;i < 2017;i++){
			model[count] = ""+i;
					count--;
		}
		comboBox_3.setModel(new DefaultComboBoxModel(model));
		
		btnNewButton = new JButton();
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setEnabled(false);
		btnNewButton.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new File("image/hospital.png"));
			ImageIcon icon = new ImageIcon(img);
			btnNewButton.setIcon(icon);
			btnNewButton.setDisabledIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		
		contraseña = new JPasswordField();
		contraseña.setColumns(10);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		confirmarContraseña = new JPasswordField();
		confirmarContraseña.setColumns(10);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRegresar)
							.addGap(59)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(confirmarContraseña, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(apellidos, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(telefono, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(email, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(error)
					.addContainerGap(308, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(172))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(error)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(apellidos, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(telefono, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmarContraseña, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRegresar))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

	public JLabel getError() {
		return error;
	}

	public JLabel getLblRegresar() {
		return lblRegresar;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == getLblRegresar()){
            ventana.remove(this);
            ventana.getLbleresNuevoRegistrate().setVisible(true);
            ventana.getContentPane().add(ventana.getPanel(),BorderLayout.CENTER);
            ventana.revalidate();
            ventana.repaint();
		} 		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == getLblRegresar()){
			getLblRegresar().setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getBtnNewButton_1()){
			
			if(!getNombre().getText().isEmpty() && !getApellidos().getText().isEmpty() && !getDireccion().getText().isEmpty()
					&& !getUsuario().getText().isEmpty() && !getTelefono().getText().isEmpty() && !getEmail().getText().isEmpty() 
					&& !getContraseña().getText().isEmpty() &&
					!getConfirmarContraseña().getText().isEmpty()){
			if(getContraseña().getText().equals(getConfirmarContraseña().getText())){
			String hashed = "";
			try {
				hashed = Secure.getHashCodeFromString(getContraseña().getText());
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			Database.getDatabase().queryDDL("INSERT INTO mydb.Usuario (tipoUsuario,nombre,apellidos,fechaNacimiento,sexo,contraseña,direccion,telefono,email,usuario) VALUES ('Paciente','"+getNombre().getText()+"','"+getApellidos().getText()+"','1994-02-28',"
					+ "'Masculino','"+hashed+"','"+getDireccion().getText()+"','"+getTelefono().getText()+"','"+getEmail().getText()+"','"+getUsuario().getText()+"');");
			ventana.remove(this);
            ventana.getLbleresNuevoRegistrate().setVisible(true);
            ventana.getContentPane().add(ventana.getPanel(),BorderLayout.CENTER);
            ventana.revalidate();
            ventana.repaint();
            ventana.getLblUsuarioRegistradoCon().setText("Usuario registrado con exito.");
			} else{
				getError().setText("Las contraseñas no coinciden.");
			}
		} else{
			getError().setText("Por favor llena todos los campos.");
		}
			}  
		
	}
}
