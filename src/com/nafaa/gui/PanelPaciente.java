package com.nafaa.gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelPaciente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPaciente() {
		
		JLabel actualizarDatos = new JLabel("Actualizar Datos");
		
		JLabel expedienteMédico = new JLabel("Expediente Médico");
		
		JLabel lblAgendaDeCitas = new JLabel("Agenda de citas médicas");
		
		JLabel lblFarmacia = new JLabel("Farmacia");
		
		JLabel lblChat = new JLabel("Chat");
		
		JLabel lblCerrarSecion = new JLabel("Cerrar Secion");
		
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
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(actualizarDatos)
					.addGap(18)
					.addComponent(expedienteMédico)
					.addGap(18)
					.addComponent(lblAgendaDeCitas)
					.addGap(18)
					.addComponent(lblFarmacia)
					.addGap(18)
					.addComponent(lblChat)
					.addGap(18)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCerrarSecion)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(expedienteMédico)
								.addComponent(actualizarDatos)
								.addComponent(lblAgendaDeCitas)
								.addComponent(lblFarmacia)
								.addComponent(lblChat)
								.addComponent(lblCerrarSecion)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
