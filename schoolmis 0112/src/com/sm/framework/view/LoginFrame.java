package com.sm.framework.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sm.framework.model.dao.impl.MisUserDAO;
import com.sm.framework.model.dao.impl.MisUserDAOImpl;
import com.sm.framework.model.entity.MisUser;

public class LoginFrame extends JFrame implements ActionListener {
	private MisUser loginUser = null;
	
	private JPanel bodyPanel = null;
	private JLabel titleLabel = null;
	private JLabel nameLabel = null;
	private JTextField nameField = null;
	private JLabel passwordLabel = null;
	private JPasswordField passwordField = null;
	private JPanel buttonPanel = null;
	private JButton loginButton = null;
	private JButton resetButton = null;
	
	private boolean checkUser(MisUser misUser) {
		MisUserDAO misUserDAO = new MisUserDAOImpl();
		MisUser findUser = misUserDAO.findById(misUser.getUserId());
		if (findUser != null && findUser.getUserPwd().equals(misUser.getUserPwd())) {
			this.loginUser = findUser;
			return true;
		}
		return false;
	}
	
	private void init() {
		this.bodyPanel = (JPanel)this.getContentPane();
		this.bodyPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.titleLabel = new JLabel("�û���¼");
		this.titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.titleLabel, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		
		this.nameLabel = new JLabel("�û�����");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.nameLabel, gbc);
		
		this.nameField = new JTextField(16);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.nameField, gbc);
		
		this.passwordLabel = new JLabel("��    �룺");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordLabel, gbc);
		
		this.passwordField = new JPasswordField(16);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordField, gbc);
		
		this.buttonPanel = new JPanel();
		this.loginButton = new JButton("��¼");
		this.loginButton.addActionListener(this);
		this.resetButton = new JButton("����");
		this.resetButton.addActionListener(this);
		this.buttonPanel.add(this.loginButton);
		this.buttonPanel.add(this.resetButton);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.bodyPanel.add(this.buttonPanel, gbc);
		
		this.setTitle("login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public LoginFrame() {
		this.init();
	}
	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setBounds(450, 280, 300, 200);
		loginFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.loginButton) {
			String id = this.nameField.getText();
			String pwd = new String(this.passwordField.getPassword());
			MisUser newUser = new MisUser();
			newUser.setUserId(id);
			newUser.setUserPwd(pwd);
			if (id.equals("") || pwd.equals("")) {
				JOptionPane.showMessageDialog(this, "�û������벻��Ϊ�գ�");
			} else if (this.checkUser(newUser)) {
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
				this.dispose();
				MainFrame mainFrame = new MainFrame(this.loginUser);
				mainFrame.setBounds(250, 120, 780, 540);
				mainFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "�û����������");
			}
		} else if (e.getSource() == this.resetButton) {
			this.nameField.setText("");
			this.passwordField.setText("");
		}
		
	}

}

