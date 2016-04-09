package com.nafaa.gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.nafaa.model.World;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;

public class Principal extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblOnline;
	private JLabel lblBienvenido;
	private JPanel panelPaciente;
	private JPanel panelAdmin;
	private JLabel modificarUsuariso; 
	private JPanel panel_2;
	
	public JPanel getPanelPaciente() {
		return panelPaciente;
	}

	public JPanel getPanelAdmin() {
		return panelAdmin;
	}

	public JLabel getLblBienvenido() {
		return lblBienvenido;
	}

	public JLabel getModificarUsuariso() {
		return modificarUsuariso;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	/**
	 * Create the panel.
	 */
	public Principal() {
		setBackground(Color.WHITE);
		
		panelPaciente = new JPanel();
		panelPaciente.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		panelAdmin = new JPanel();
		panelAdmin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 2, 0, 0, (Color) null));
		
		lblOnline = new JLabel("Online: "+World.getPlayersSize());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOnline)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOnline)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setEnabled(false);
		btnNewButton.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new File("image/rsz_hospital.png"));
			ImageIcon icon = new ImageIcon(img);
			btnNewButton.setIcon(icon);
			btnNewButton.setDisabledIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
		
		JLabel lblChat = new JLabel("Chat");
		
		modificarUsuariso = new JLabel("Modificar Usuarios");
		
		
		GroupLayout gl_panelAdmin = new GroupLayout(panelAdmin);
		gl_panelAdmin.setHorizontalGroup(
			gl_panelAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdmin.createSequentialGroup()
					.addGap(19)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(modificarUsuariso)
					.addPreferredGap(ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
					.addComponent(lblChat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCerrarSesin)
					.addGap(30))
		);
		gl_panelAdmin.setVerticalGroup(
			gl_panelAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdmin.createSequentialGroup()
					.addGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdmin.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCerrarSesin)
								.addComponent(lblChat)
								.addComponent(modificarUsuariso)))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAdmin.setLayout(gl_panelAdmin);
		
		
		GroupLayout gl_panel = new GroupLayout(panelPaciente);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modificarUsuariso)
					.addPreferredGap(ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
					.addComponent(lblChat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCerrarSesin)
					.addGap(30))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCerrarSesin)
								.addComponent(lblChat)
								.addComponent(modificarUsuariso))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelPaciente.setLayout(gl_panel);
		
		
		add(panelAdmin, BorderLayout.NORTH);
		add(panel_1, BorderLayout.EAST);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.CENTER);
		
		lblBienvenido = new JLabel("");
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblSistemaMdicoNaafa = new JLabel("Sistema Médico NAAFA");
		lblSistemaMdicoNaafa.setFont(new Font("Dialog", Font.BOLD, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(52)
					.addComponent(lblSistemaMdicoNaafa)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addComponent(lblBienvenido, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblSistemaMdicoNaafa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBienvenido, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(160))
		);
		panel_2.setLayout(gl_panel_2);

	}
}
