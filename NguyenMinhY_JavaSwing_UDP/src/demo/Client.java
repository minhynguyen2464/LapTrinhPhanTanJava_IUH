package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWord = new JLabel("Word\r\n");
		lblWord.setBounds(10, 64, 45, 13);
		contentPane.add(lblWord);
		
		JLabel lblNewLabel = new JLabel("<html><h1 style=\"color=red;\">My Dictionary</h1></html>");
		lblNewLabel.setBounds(160, 10, 166, 49);
		contentPane.add(lblNewLabel);
		
		txtWord = new JTextField();
		txtWord.setBounds(65, 61, 361, 19);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning\r\n");
		lblNewLabel_1.setBounds(10, 134, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtMeaning = new JTextField();
		txtMeaning.setBounds(65, 131, 361, 49);
		contentPane.add(txtMeaning);
		txtMeaning.setColumns(10);
		
		JButton btnSearch = new JButton("Search\r\n");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Function here
				final String SERVER_ADDRESS = "localhost";
				final int SERVER_PORT = 5000;
				DatagramSocket clientSocket = null;
				String vietnamese = null;
				try {
				    clientSocket = new DatagramSocket();
				    String english = txtWord.getText();
				    byte[] sendBuffer = english.getBytes();
			        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,InetAddress.getByName(SERVER_ADDRESS),SERVER_PORT);
			        clientSocket.send(sendPacket);
			        //Receive
			        byte[] receiveBuffer = new byte[1024];
			        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
			        clientSocket.receive(receivePacket);
			        vietnamese = new String(receivePacket.getData(),0,receivePacket.getLength());
				    txtMeaning.setText(vietnamese);
				}
				catch(Exception e1) {
				    e1.printStackTrace();
				}
				finally {
				    if (clientSocket != null) {
				        clientSocket.close();
				    }
				}
			}
		});
		btnSearch.setBounds(176, 232, 85, 21);
		contentPane.add(btnSearch);
	}
}
