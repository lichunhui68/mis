package com.sm.framework.view;

import java.awt.Container;
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
		Container content = this.getContentPane();
		this.bodyPanel = new WelcomePanel();
		this.bodyPanel.setLayout(new GridBagLayout());
		content.add(this.bodyPanel);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.titleLabel = new JLabel("用户登录");
		this.titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.titleLabel, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		
		this.nameLabel = new JLabel("用户名：");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.nameLabel, gbc);
		
		this.nameField = new JTextField(16);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.nameField, gbc);
		
		this.passwordLabel = new JLabel("密    码：");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordLabel, gbc);
		
		this.passwordField = new JPasswordField(16);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordField, gbc);
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setOpaque(false);
		this.loginButton = new JButton("登录");
		this.loginButton.addActionListener(this);
		this.resetButton = new JButton("重置");
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
				JOptionPane.showMessageDialog(this, "用户名密码不能为空！");
			} else if (this.checkUser(newUser)) {
				JOptionPane.showMessageDialog(this, "登录成功！");
				this.dispose();
				MainFrame mainFrame = new MainFrame(this.loginUser);
				mainFrame.setBounds(250, 120, 780, 540);
				mainFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "用户名密码错误");
			}
		} else if (e.getSource() == this.resetButton) {
			this.nameField.setText("");
			this.passwordField.setText("");
		}
		
	}

}

