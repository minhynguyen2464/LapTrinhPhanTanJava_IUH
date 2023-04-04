package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWord;
	private JTextField txtMeaning;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><span style='color: red; font-size:20px;'>My Dictionary</span></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 404, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblWord = new JLabel("Word");
		lblWord.setBounds(10, 59, 45, 13);
		contentPane.add(lblWord);
		
		txtWord = new JTextField();
		txtWord.setBounds(65, 56, 349, 19);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		txtMeaning = new JTextField();
		txtMeaning.setBounds(65, 111, 349, 73);
		contentPane.add(txtMeaning);
		txtMeaning.setColumns(10);
		
		JLabel lblMeanning = new JLabel("Meaning");
		lblMeanning.setBounds(10, 111, 45, 13);
		contentPane.add(lblMeanning);
		
		JButton btnSearch = new JButton("Search\r\n");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            Registry registry = LocateRegistry.getRegistry(null); // Obtain a reference to the RMI registry
			            DicInterface msg = (DicInterface) registry.lookup("dictonaryBind"); // Look up the remote object's stub by name and cast it to the DicInterface

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
		btnSearch.setBounds(65, 200, 85, 21);
		contentPane.add(btnSearch);
	}
}
