package code.Tablo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class Library extends JFrame {

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel modelim = new DefaultTableModel();
	
	Object [] kolonlar = {"BuchNr", "Sachgebiet", "Autor", "Titel", "Ort", "Jahr", "Verlag"};
	Object [] satirlar= new Object[7];
	private JTextField txt_BuchNr;
	private JTextField txt_Sachgebiet;
	private JTextField txt_Autor;
	private JTextField txt_Titel;
	private JTextField txt_Ort;
	private JTextField txt_Jahr;
	private JTextField txt_Verlag;
	private JTextField txt_searching;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 420);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 37, 624, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(289, 190, 249, 144);
		scrollPane.setViewportView(table);
		
		//---------------
		//Connectivity
		//---------------
		
		JButton btnListele = new JButton("List");
		btnListele.setBackground(SystemColor.inactiveCaption);
		btnListele.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				ResultSet rs = Link.baglan();
				
				try {
					while(rs.next()) {
						satirlar[0]=rs.getString("BuchNr");
						satirlar[1]=rs.getString("Sachgebiet");
						satirlar[2]=rs.getString("Autor");
						satirlar[3]=rs.getString("Titel");
						satirlar[4]=rs.getString("Ort");
						satirlar[5]=rs.getString("Jahr");
						satirlar[6]=rs.getString("Verlag");
						modelim.addRow(satirlar);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(10, 347, 289, 23);
		contentPane.add(btnListele);
		
		txt_BuchNr = new JTextField();
		txt_BuchNr.setBackground(Color.WHITE);
		txt_BuchNr.setBounds(10, 268, 147, 20);
		contentPane.add(txt_BuchNr);
		txt_BuchNr.setColumns(10);
		
		txt_Sachgebiet = new JTextField();
		txt_Sachgebiet.setBackground(Color.WHITE);
		txt_Sachgebiet.setBounds(10, 223, 103, 20);
		contentPane.add(txt_Sachgebiet);
		txt_Sachgebiet.setColumns(10);
		
		txt_Autor = new JTextField();
		txt_Autor.setBackground(Color.WHITE);
		txt_Autor.setBounds(123, 223, 176, 20);
		contentPane.add(txt_Autor);
		txt_Autor.setColumns(10);
		
		txt_Titel = new JTextField();
		txt_Titel.setBackground(Color.WHITE);
		txt_Titel.setBounds(309, 223, 325, 20);
		contentPane.add(txt_Titel);
		txt_Titel.setColumns(10);
		
		txt_Ort = new JTextField();
		txt_Ort.setBackground(Color.WHITE);
		txt_Ort.setBounds(173, 268, 147, 20);
		contentPane.add(txt_Ort);
		txt_Ort.setColumns(10);
		
		txt_Jahr = new JTextField();
		txt_Jahr.setBackground(Color.WHITE);
		txt_Jahr.setBounds(330, 268, 147, 20);
		contentPane.add(txt_Jahr);
		txt_Jahr.setColumns(10);
		
		txt_Verlag = new JTextField();
		txt_Verlag.setBackground(Color.WHITE);
		txt_Verlag.setBounds(487, 268, 147, 20);
		contentPane.add(txt_Verlag);
		txt_Verlag.setColumns(10);

		//----------
		//Insert InTo
		//----------
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sachgebiet, autor, titel, ort, verlag, sql;
				String buchNr, jahr;
				buchNr =txt_BuchNr.getText();
				sachgebiet =txt_Sachgebiet.getText();
				autor = txt_Autor.getText();
				titel=txt_Titel.getText();
				ort = txt_Ort.getText();
				jahr = txt_Jahr.getText();
				verlag=txt_Verlag.getText();
				
				sql = "INSERT INTO buecher (BuchNr, Sachgebiet, Autor, Titel, Ort, Jahr, Verlag) "
						+ "VALUES("+buchNr+",'"+sachgebiet+"',"+"'"+autor+"',"+"'"+titel+"',"+"'"+ort+"','"+jahr+"',"+"'"+verlag+"')";
				
				Link.add(sql);
			}
		});
		btnNewButton.setBounds(10, 313, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Registration Nu:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 288, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBoolName = new JLabel("Subject:");
		lblBoolName.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblBoolName.setBounds(10, 243, 89, 14);
		contentPane.add(lblBoolName);
		
		JLabel lblNewLabel1 = new JLabel("Author:");
		lblNewLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel1.setBounds(123, 243, 89, 14);
		contentPane.add(lblNewLabel1);
		
		JLabel lbllabel2 = new JLabel("Title:");
		lbllabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lbllabel2.setBounds(309, 243, 89, 14);
		contentPane.add(lbllabel2);
		
		JLabel lblNewLabel_3 = new JLabel("Place:");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(173, 288, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Year:");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(330, 288, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Company:");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(487, 288, 83, 14);
		contentPane.add(lblNewLabel_5);
		
		//-------------
		//Update 
		//-------------
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sachgebiet, autor, titel, ort, verlag, sql;
				String buchNr, jahr;
				buchNr =txt_BuchNr.getText();
				sachgebiet =txt_Sachgebiet.getText();
				autor = txt_Autor.getText();
				titel=txt_Titel.getText();
				ort = txt_Ort.getText();
				jahr = txt_Jahr.getText();
				verlag=txt_Verlag.getText();
				
				sql = "UPDATE buecher SET BuchNr="+buchNr+","+"Sachgebiet='"+sachgebiet+"',Autor='"+autor+"',Titel='"+titel+"',Ort='"+ort+"',Jahr='"+jahr+"',Verlag='"+verlag+"' WHERE BuchNr="+buchNr;
				
				Link.update(sql);
				
			}
		});
		btnNewButton_1.setBounds(112, 313, 89, 23);
		contentPane.add(btnNewButton_1);
		
		//----------
		// Delete 
		//----------
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String buchNr,sql;
				buchNr =txt_BuchNr.getText();
				
				sql= "DELETE FROM buecher WHERE BuchNr="+buchNr;
				Link.del(sql);
				
			}
		});
		btnNewButton_2.setBounds(211, 313, 89, 23);
		contentPane.add(btnNewButton_2);
		
		txt_searching = new JTextField();
		txt_searching.setBackground(Color.WHITE);
		txt_searching.setBounds(408, 313, 141, 23);
		contentPane.add(txt_searching);
		txt_searching.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Field");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(379, 317, 27, 14);
		contentPane.add(lblNewLabel_1);
		
		//--------------------
		// Search with ComboBox
		//--------------------
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BuchNr", "Sachgebiet", "Autor", "Titel", "Ort", "Jahr", "Verlag"}));
		comboBox.setBounds(566, 313, 68, 22);
		contentPane.add(comboBox);
		
		//----------
		//Search
		//-----------
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				String field = txt_searching.getText();
				
				String sql=null;
				
				ResultSet rs =null;
				
				int secilen = comboBox.getSelectedIndex();
				
				if(secilen==0) {
					sql = "SELECT * FROM buecher WHERE BuchNr like '"+field+"%'";
				}else if(secilen==1) {
					sql = "SELECT * FROM buecher WHERE Sachgebiet like'"+field+"%'";
				}else if(secilen==2) {
					sql = "SELECT * FROM buecher WHERE Autor like'"+field+"%'";
				}else if(secilen==3) {
					sql = "SELECT * FROM buecher WHERE Titel like'"+field+"%'";
				}else if(secilen==4) {
					sql = "SELECT * FROM buecher WHERE Ort like'"+field+"%'";
				}else if(secilen==5) {
					sql = "SELECT * FROM buecher WHERE Jahr like '"+field+"%'";
				}else if(secilen==6) {
					sql = "SELECT * FROM buecher WHERE Verlag like'"+field+"%'";
				}
				 
				rs = Link.search(sql);
				
				try {
					while(rs.next()) {
						satirlar[0]=rs.getString("BuchNr");
						satirlar[1]=rs.getString("Sachgebiet");
						satirlar[2]=rs.getString("Autor");
						satirlar[3]=rs.getString("Titel");
						satirlar[4]=rs.getString("Ort");
						satirlar[5]=rs.getString("Jahr");
						satirlar[6]=rs.getString("Verlag");
						modelim.addRow(satirlar);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnNewButton_3.setBounds(408, 347, 229, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("LIBRARY BUCH REGISTRATION AND SEARCH ENGINE");
		lblNewLabel_2.setBackground(new Color(175, 238, 238));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(156, 11, 321, 23);
		contentPane.add(lblNewLabel_2);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_BuchNr.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				txt_Sachgebiet.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				txt_Autor.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				txt_Titel.setText( (String) modelim.getValueAt(table.getSelectedRow(), 3));
				txt_Ort.setText( (String) modelim.getValueAt(table.getSelectedRow(), 4));
				txt_Jahr.setText( (String) modelim.getValueAt(table.getSelectedRow(), 5));
				txt_Verlag.setText( (String) modelim.getValueAt(table.getSelectedRow(), 6));
			}
		});
		
		
		
	}
}
