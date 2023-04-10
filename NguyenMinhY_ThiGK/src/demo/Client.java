package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtCompany;
	private JLabel lblNewLabel_4;
	private JTextField txtPrice;

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
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("UPDATE PRODUCTS");
		lblHeader.setForeground(new Color(255, 0, 0));
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(10, 10, 616, 29);
		contentPane.add(lblHeader);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID\r\n");
		lblNewLabel_1.setBounds(10, 49, 113, 13);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setBounds(265, 46, 361, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter new product name\r\n");
		lblNewLabel_2.setBounds(10, 88, 113, 13);
		contentPane.add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setBounds(265, 85, 361, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter new product company");
		lblNewLabel_3.setBounds(10, 123, 162, 13);
		contentPane.add(lblNewLabel_3);
		
		txtCompany = new JTextField();
		txtCompany.setBounds(265, 120, 361, 19);
		contentPane.add(txtCompany);
		txtCompany.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Enter new product price\r\n");
		lblNewLabel_4.setBounds(10, 152, 162, 13);
		contentPane.add(lblNewLabel_4);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(265, 149, 361, 19);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE\r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry re = LocateRegistry.getRegistry(null);
					ProductInterface msg = (ProductInterface)re.lookup("updateDB");
					int product_id = Integer.parseInt(txtID.getText());
					String product_name = txtName.getText();
					String product_company = txtCompany.getText();
					int product_price = Integer.parseInt(txtPrice.getText());
					if(msg.updateProduct(product_id, product_name, product_company, product_price)==1) {
						//
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(265, 232, 85, 21);
		contentPane.add(btnUpdate);
	}
}
