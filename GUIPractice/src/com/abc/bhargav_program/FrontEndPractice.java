package com.abc.bhargav_program;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontEndPractice extends JFrame {
	private static final String GET_STUDENT_RECORD ="SELECT SID,SNAME,SADDRESS,SAVG FROM STUDENT";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEndPractice frame = new FrontEndPractice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection  =null;
	PreparedStatement pstmt = null;
	ResultSet resultSet=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private void JdbcInitialize() {
		try {
			String url="jdbc:mysql://localhost:3309/xyz";
			String username="root";
			String password="admin";

			connection = DriverManager.getConnection(url,username,password);
			if(connection != null) {
				pstmt = connection.prepareStatement(GET_STUDENT_RECORD,resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_UPDATABLE);
			}
			if(pstmt !=null) {
				resultSet = pstmt.executeQuery();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public FrontEndPractice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SID");
		lblNewLabel.setBounds(39, 40, 66, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(86, 37, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("SNAME");
		lblNewLabel_1.setBounds(22, 83, 56, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(86, 80, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("SADDRESS");
		lblNewLabel_2.setBounds(22, 125, 56, 14);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(86, 122, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("SAVG");
		lblNewLabel_3.setBounds(22, 170, 49, 14);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(86, 167, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("first");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultSet.first();
					textField.setText(resultSet.getString(1));
					textField_1.setText(resultSet.getString(2));
					textField_2.setText(resultSet.getString(3));
					textField_3.setText(resultSet.getString(4));

				}catch(SQLException se) {
					se.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(10, 218, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!resultSet.isLast()) {
						resultSet.next();
						textField.setText(resultSet.getString(1));
						textField_1.setText(resultSet.getString(2));
						textField_2.setText(resultSet.getString(3));
						textField_3.setText(resultSet.getString(4));
					}
				}catch(SQLException se ) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(117, 218, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("previous");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!resultSet.isFirst()) {
						resultSet.previous();
						textField.setText(resultSet.getString(1));
						textField_1.setText(resultSet.getString(2));
						textField_2.setText(resultSet.getString(3));
						textField_3.setText(resultSet.getString(4));
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(217, 218, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("last");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultSet.last();
					textField.setText(resultSet.getString(1));
					textField_1.setText(resultSet.getString(2));
					textField_2.setText(resultSet.getString(3));
					textField_3.setText(resultSet.getString(4));

				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(321, 218, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JdbcInitialize();
	}
}
