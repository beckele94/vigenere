import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class vigenere extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnDcrypter;
	private JLabel lblRsulat;
	private JTextField textField_3;
	private JLabel lblClAdapte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vigenere frame = new vigenere();
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
	public vigenere() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(138, 35, 300, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 68, 300, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(138, 178, 300, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Crypter");
		
		btnNewButton.addActionListener(new ActionListener() { //bouton encrypter
			public void actionPerformed(ActionEvent e) {
				
				String clee = textField.getText().toLowerCase();
				String message = textField_1.getText().toLowerCase();;

				char tabClee[] = clee.toCharArray();
				char tabCleeEspace[] = new char[message.length()];
				char tabMessage[] = message.toCharArray();
				char tabMessageEncrypt[] = new char[message.length()];
				int cptEspace = 0;
				
				for(int i = 0; i < message.length(); i++) {
					if(tabMessage[i] == ' ') {
						tabCleeEspace[i] = ' ';
						cptEspace++;
					} else {
						tabCleeEspace[i] = tabClee[(i - cptEspace)%clee.length()];
					}
				}
				
				for(int i = 0; i < message.length(); i++) {
					if(tabMessage[i] == ' ') {
						tabMessageEncrypt[i] = tabMessage[i];
					} else {
						tabMessageEncrypt[i] = (char)(((tabMessage[i] - 97) + (tabCleeEspace[i] - 97))%26 + 97);
					}
				}
				
				String messageEncrypt = new String(tabMessageEncrypt);
				String cleeEspace = new String(tabCleeEspace);
				textField_2.setText(messageEncrypt);
				textField_3.setText(cleeEspace);
			}
		});
		
		
		
		btnNewButton.setBounds(138, 109, 117, 25);
		contentPane.add(btnNewButton);
		
		btnDcrypter = new JButton("Décrypter");
		btnDcrypter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clee = textField.getText().toLowerCase();
				String message = textField_1.getText().toLowerCase();;

				char tabClee[] = clee.toCharArray();
				char tabCleeEspace[] = new char[message.length()];
				char tabMessage[] = message.toCharArray();
				char tabMessageEncrypt[] = new char[message.length()];
				int cptEspace = 0;
				
				for(int i = 0; i < message.length(); i++) {
					if(tabMessage[i] == ' ') {
						tabCleeEspace[i] = ' ';
						cptEspace++;
					} else {
						tabCleeEspace[i] = tabClee[(i - cptEspace)%clee.length()];
					}
				}
				
				for(int i = 0; i < message.length(); i++) {
					if(tabMessage[i] == ' ') {
						tabMessageEncrypt[i] = tabMessage[i];
					} else {
						tabMessageEncrypt[i] = (char)(((tabMessage[i]) - (tabCleeEspace[i]) + 26 )%26 + 97);
					}
				}
				
				String messageEncrypt = new String(tabMessageEncrypt);
				String cleeEspace = new String(tabCleeEspace);
				textField_2.setText(messageEncrypt);
				textField_3.setText(cleeEspace);
				
				
			}
		});
		btnDcrypter.setBounds(321, 109, 117, 25);
		contentPane.add(btnDcrypter);
		
		lblRsulat = new JLabel("Résulat :");
		lblRsulat.setBounds(24, 180, 70, 15);
		contentPane.add(lblRsulat);
		
		JLabel lblCl = new JLabel("Clé :");
		lblCl.setBounds(24, 39, 70, 15);
		contentPane.add(lblCl);
		
		JLabel lblMessage = new JLabel("Texte :");
		lblMessage.setBounds(24, 70, 70, 15);
		contentPane.add(lblMessage);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(138, 209, 300, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblClAdapte = new JLabel("Clé répétée :");
		lblClAdapte.setBounds(24, 211, 100, 15);
		contentPane.add(lblClAdapte);
		
		
	}
}
