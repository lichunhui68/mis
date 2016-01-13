package com.sm.framework.control.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sm.framework.model.dao.impl.MisFunctionDAO;
import com.sm.framework.model.dao.impl.MisFunctionDAOImpl;
import com.sm.framework.model.entity.MisFunction;

public class MenuListener implements ActionListener {
	private JFrame mainFrame = null;
	private JPanel buttonPanel = null;
	
	private void inButtonPanel(String menuId) {
		MisFunctionDAO dao = new MisFunctionDAOImpl();
		this.buttonPanel = new JPanel(new GridLayout(6, 1));
		List<MisFunction> list = dao.findByMenuId(menuId);
		for (MisFunction misFunction : list) {
			JButton findButton = new JButton();
			findButton.setActionCommand(misFunction.getFunctionId());
			findButton.setText(misFunction.getFunctionName());
			findButton.setToolTipText(misFunction.getFunctionMemo());
			findButton.addActionListener(new FunctionListener(this.mainFrame));
			this.buttonPanel.add(findButton);
		}
	}
	
	public MenuListener() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuListener(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel bodyPanel = (JPanel)this.mainFrame.getContentPane();
		
		JPanel welcomePanel = (JPanel)bodyPanel.getComponent(1);
		welcomePanel.removeAll();
		welcomePanel.repaint();
		welcomePanel.setLayout(new BorderLayout());
		
		JPanel workPanel = new JPanel();
		workPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		welcomePanel.add(workPanel, BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
		
		this.inButtonPanel(e.getActionCommand());
		leftPanel.add(this.buttonPanel, BorderLayout.NORTH);
		welcomePanel.add(leftPanel, BorderLayout.WEST);
		
		this.mainFrame.setVisible(true);
	}
}