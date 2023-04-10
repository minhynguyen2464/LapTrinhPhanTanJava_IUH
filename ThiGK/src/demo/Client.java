package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
		
		JLabel lblNewLabel = new JLabel("<html><h1>My Dictionary</h1></html>");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Word\r\n");
		lblNewLabel_1.setBounds(20, 61, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		txtWord = new JTextField();
		txtWord.setBounds(109, 61, 317, 19);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Meaning\r\n");
		lblNewLabel_2.setBounds(20, 124, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		txtMeaning = new JTextField();
		txtMeaning.setBounds(109, 121, 317, 41);
		contentPane.add(txtMeaning);
		txtMeaning.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Registry registry = LocateRegistry.getRegistry(null); // Obtain a reference to the RMI registry
		            DictionaryInterface msg = (DictionaryInterface) registry.lookup("dictonaryBind"); // Look up the remote object's stub by name and cast it to the DicInterface

		            // Call the searchWord method on the remote object
		            String english = txtWord.getText();
		            String meaning = msg.searchWord(english);

		            // Display the meaning in the text field
		            txtMeaning.setText(meaning);
		        } catch (RemoteException | NotBoundException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnSearch.setBounds(176, 214, 85, 21);
		contentPane.add(btnSearch);
	}
}
