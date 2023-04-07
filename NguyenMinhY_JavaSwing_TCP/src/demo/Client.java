package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtWord;
	private JTextField txtMeaning;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Dictionary");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 416, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Word\r\n");
		lblNewLabel_1.setBounds(10, 60, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtWord = new JTextField();
		txtWord.setBounds(65, 60, 361, 40);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Meaning\r\n");
		lblNewLabel_2.setBounds(10, 150, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSearch = new JButton("Search\r\n");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int SERVER_PORT = 6666;
				final String SERVER_NAME = "localhost";
				Socket clientSocket = null;
				try {
					clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
					//Send
					String english = txtWord.getText();
					PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
					output.println(english);
					//Receive
					BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					String vietnamese = input.readLine();
					txtMeaning.setText(vietnamese);
					clientSocket.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(177, 215, 85, 21);
		contentPane.add(btnSearch);
		
		txtMeaning = new JTextField();
		txtMeaning.setBounds(65, 147, 361, 40);
		contentPane.add(txtMeaning);
		txtMeaning.setColumns(10);
	}
}
