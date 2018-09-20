package sala_biliardi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Connessione;
import model.Utente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 623);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		final JTextArea textArea = new JTextArea();
		textArea.setSelectionColor(new Color(0, 0, 255));
		
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 255, 255));
		
		textArea.setBounds(21, 35, 733, 199);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(5, 5, 789, 268);
		contentPane.add(scrollPane);
		
		final JLabel lblInserisciNomeE = new JLabel("INSERISCI NOME E COGNOME UTENTE");
		lblInserisciNomeE.setBackground(new Color(255, 0, 0));
		lblInserisciNomeE.setBounds(196, 566, 247, 16);
		contentPane.add(lblInserisciNomeE);
		
		final JButton btnElimina = new JButton("ELIMINA");
		btnElimina.setBackground(new Color(255, 0, 0));
		btnElimina.setVisible(false);
		btnElimina.setBackground(new Color(64, 224, 208));
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connessione c = new Connessione();
				String n= textField.getText().toString().toUpperCase();
				String cog= textField_1.getText().toString().toUpperCase();
				try {
					c.eliminaUtente(n, cog);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(rootPane, "UTENTE ELIMINATO", "ELIMINAZIONE", getDefaultCloseOperation() );
				
			btnElimina.setVisible(false);			lblInserisciNomeE.setVisible(false);
			textField.setText("");
			textField_1.setText("");
			

			
			}
		});
		btnElimina.setBounds(455, 561, 117, 29);
		contentPane.add(btnElimina);
		lblInserisciNomeE.setVisible(false);
		
		
		
		JLabel label = new JLabel("Fibis Tesseramento");
		label.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(58, 281, 308, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(58, 320, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Cognome");
		label_2.setBounds(58, 355, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Data");
		label_3.setBounds(58, 432, 61, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Telefono");
		label_4.setBounds(58, 397, 61, 16);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 309, 458, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 345, 458, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 387, 458, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 427, 458, 26);
		contentPane.add(textField_3);
		
		JButton button = new JButton("Inserisci");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connessione con= new Connessione();
				String n= textField.getText().toString().toUpperCase();
				String c= textField_1.getText().toString().toUpperCase();
				String t= textField_2.getText().toString().toUpperCase();
				String d= textField_3.getText().toString().toUpperCase();
				String m= textField_4.getText().toString().toUpperCase();

				Utente u = new Utente();
				u.setNome(n);
				u.setCognome(c);
				u.setTelefono(t);
				u.setData(d);
				u.setMatricola(m);
				
				try {
					con.inserisci(u);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(contentPane, "Inserimento Effettuato");
				textField.setText("");			
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");

				
			
				
				
			}
		});
		button.setBounds(295, 501, 110, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Visualizza");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
				Connessione c= new Connessione();
				ArrayList<Utente> list = new ArrayList<Utente>();
				try {
					list=c.getUtenti();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int i=0;
				textArea.setDisabledTextColor(new Color(0, 0, 255));
				textArea.append("\n     NOME\t   COGNOME\t   Telefono\t   DATA\t   MATRICOLA\n");
				textArea.setDisabledTextColor(new Color(0, 0, 0));
				for (Utente u : list) {
					


					String n=u.getNome();
					String cg=u.getCognome();
					String t=u.getTelefono();
					String d=u.getData();
					String m=u.getMatricola();
					
					textArea.append("\n "+n+"\t"+cg+"\t"+t+"\t"+d+"\t"+m+"\n");
					textArea.append("--------------------------------------------------------------------------------------------------");
				
				}
				
				
			}
		});
		
				
		
		button_1.setBounds(417, 502, 110, 26);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Elimina");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInserisciNomeE.setVisible(true);
				btnElimina.setVisible(true);
				textField.setText("");
				textField_1.setText("");
				
				
			}
		});
		button_2.setBounds(166, 501, 117, 29);
		contentPane.add(button_2);
		
		JLabel label_5 = new JLabel("Matricola");
		label_5.setBounds(58, 469, 61, 19);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(156, 463, 458, 26);
		contentPane.add(textField_4);
		
		JButton btnNew = new JButton("new");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame2 fr;
				try {
					fr = new Frame2();
					fr.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNew.setBounds(535, 501, 117, 29);
		contentPane.add(btnNew);
		
		
		
	}
}
