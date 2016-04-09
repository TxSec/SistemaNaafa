package com.nafaa.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ModificarUsuarios extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton lblNewLabel;
	private JButton lblNewLabel_1;
	private JButton lblNewLabel_2;
	private ModificarUsuarioJDialog dialog;
	private JTable table_1;
	
	
	/**
	 * Create the panel.
	 */
	public ModificarUsuarios() {
		loadDialogs();
		setBackground(Color.WHITE);
		
		JLabel lblModificarUsuarios = new JLabel("Modificar Usuarios");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblNewLabel = new JButton("Agregar Usuario");
		lblNewLabel.addActionListener(this);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(154, 205, 50));
		
		lblNewLabel_1 = new JButton("Editar");
		lblNewLabel_1.setBackground(new Color(100, 149, 237));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_2 = new JButton("Eliminar");
		lblNewLabel_2.setBackground(new Color(204, 51, 0));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblModificarUsuarios)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
							.addGap(31))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblModificarUsuarios)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(63))
		);
		
		table_1 = new JTable(){
			public boolean isCellEditable(int row, int column) {      
	        	if(column == 0)
	        		return true;
	        		else 
	            return false;     
	        }
	        
	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if(columnIndex == 0){
	                return Boolean.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
		};
		scrollPane.setViewportView(table_1);
		setLayout(groupLayout);
		

    //table.setFillsViewportHeight(true);
    //table.setSurrendersFocusOnKeystroke(true);
    DefaultTableModel dtm = new DefaultTableModel(0, 0);
    String header[] = new String[] { "#", "Nombre", "Apellidos",
            "Usuario","Grupo","Ultima Conexión"};
    dtm.setColumnIdentifiers(header);
    table_1.setModel(dtm);
    //table.getColumnModel().getColumn(3).setResizable(false);
    table_1.getTableHeader().setReorderingAllowed(false);
    table_1.getTableHeader().setResizingAllowed(false);
    //table.setCellSelectionEnabled(false);
    dtm.addRow(new Object[]{null,"TEXT","TEXT","TEXT","SOON.","SOON..."});

	


	}

	private void loadDialogs() {
		dialog = new ModificarUsuarioJDialog();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lblNewLabel){
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		
	}
}
