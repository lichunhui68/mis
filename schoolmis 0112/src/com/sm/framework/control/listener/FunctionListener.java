package com.sm.framework.control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sm.action.org.FunctionAction;
import com.sm.framework.model.dao.impl.MisFunctionDAO;
import com.sm.framework.model.dao.impl.MisFunctionDAOImpl;
import com.sm.framework.model.entity.MisFunction;

public class FunctionListener implements ActionListener {
	private JFrame mainFrame = null;
	
	public FunctionListener() {
		// TODO Auto-generated constructor stub
	}
	
	public FunctionListener(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel bodyPanel = (JPanel)this.mainFrame.getContentPane();
		
		JPanel welcomePanel = (JPanel)bodyPanel.getComponent(1);
		
		JPanel workPanel = (JPanel)welcomePanel.getComponent(0);
		workPanel.removeAll();
		workPanel.repaint();
		
		MisFunctionDAO dao = new MisFunctionDAOImpl();
		MisFunction function = dao.findById(e.getActionCommand());
		String functionClass = function.getFunctionClass();
		FunctionAction action = null;
		
		try {
			Class actionClass = Class.forName(functionClass);
			action = (FunctionAction)actionClass.newInstance();
			action.execute(workPanel);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.mainFrame.setVisible(true);
	}
}