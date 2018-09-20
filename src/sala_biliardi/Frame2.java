package sala_biliardi;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import model.Utente;

import control.Connessione;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Frame2 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Frame2() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFrame = new JLabel("Frame2");
		
		lblFrame.setBounds(175, 35, 63, 16);
		contentPane.add(lblFrame);
		
		String [] mColumns= {"Nome","Cognome","Telefono","Data","Matricola"};
		 
		
		//Object [][] mData= {{"Andrea", "Graziani", "0189326"}, {"Alessandro", "La Selva", "0193231"}};
		Connessione  c = new Connessione();
		
		ArrayList <Utente> utente = new ArrayList<Utente>();
		utente=c.getUtenti();
		int i =0;
		int dim=utente.size();
		Object[] [] ob= new Object[dim][5];
		
		for (Utente u : utente)
		{
			ob[i][0]=u.getNome();
			ob[i][1]=u.getCognome();
			ob[i][2]=u.getTelefono();

			ob[i][3]=u.getData();
			ob[i][4]=u.getMatricola();


			i++;
		}
		
		table = new JTable(ob, mColumns);
		this.add(new JScrollPane(table));
		this.setVisible(true);
		this.pack();
		
		
		
	}
}
