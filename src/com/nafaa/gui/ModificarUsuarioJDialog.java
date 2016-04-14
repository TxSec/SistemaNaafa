package com.nafaa.gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class ModificarUsuarioJDialog extends JDialog {

	private AgregarAdmin agregarAdmin;

	/**
	 * Create the dialog.
	 */

	public ModificarUsuarioJDialog(ModificarUsuarios modificarUsuarios) {
		super(null,"Agregar Usuario",Dialog.ModalityType.MODELESS);
		agregarAdmin = new AgregarAdmin(this,modificarUsuarios);
		agregarAdmin.getLblRegresar().setVisible(false);
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(agregarAdmin,BorderLayout.CENTER);
	}

}
