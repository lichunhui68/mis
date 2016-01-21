package com.sm.framework.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.sm.framework.control.listener.MenuListener;
import com.sm.framework.model.dao.impl.MenuDAO;
import com.sm.framework.model.dao.impl.MenuDAOImpl;
import com.sm.framework.model.entity.Menu;
import com.sm.framework.model.entity.MisUser;

public class MainFrame extends JFrame{
	private MisUser misUser = null;
	
	private JMenuBar menuBar = null;
	private JMenu helpMenu = null;
	private JMenuItem aboutItem = null;
	private JMenuItem contentItem = null;
	
	private JPanel bodyPanel = null;
	private JToolBar toolBar = null;
	private JLabel welcomeLabel = null;
	private JLabel nameLabel = null;
	private JButton relogButton = null;
	private JButton exitButton = null;
	
	private JPanel welcomePanel = null;
	private JLabel stateLabel = null;
	
	private void createMenu() {
		String sql1 = "select * from menu where menuId like '__'";
		MenuDAO dao = new MenuDAOImpl();
		List<Menu> list1 = dao.findBySql(sql1);
		for (Menu menu1 : list1) {
			JMenu findMenu = new JMenu();
			findMenu.setActionCommand(menu1.getMenuId());
			findMenu.setText(menu1.getMenuName());
			findMenu.setToolTipText(menu1.getMenuMemo());
			String sql2 = "select * from menu where menuId like '" + menu1.getMenuId()+ "__'";
			List<Menu> list2 = dao.findBySql(sql2);
			for (Menu menu2 : list2) {
				JMenuItem findItem = new JMenuItem();
				findItem.setActionCommand(menu2.getMenuId());
				findItem.setText(menu2.getMenuName());
				findItem.setToolTipText(menu2.getMenuMemo());
				findItem.addActionListener(new MenuListener(this, this.misUser));
				findMenu.add(findItem);
			}
			this.menuBar.add(findMenu);
		}
	}
	
	private void init() {
		this.menuBar = new JMenuBar();
		this.createMenu();
		
		this.helpMenu = new JMenu("帮助");
		this.aboutItem = new JMenuItem("关于");
		this.contentItem = new JMenuItem("内容");
		this.helpMenu.add(this.aboutItem);
		this.helpMenu.add(this.contentItem);
		this.menuBar.add(this.helpMenu);
		this.setJMenuBar(this.menuBar);
		
		this.bodyPanel = (JPanel)this.getContentPane();
		this.bodyPanel.setLayout(new BorderLayout());
		
		this.toolBar = new JToolBar();
		this.toolBar.setFloatable(false);
		this.toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.welcomeLabel = new JLabel("欢迎您：");
		this.toolBar.add(this.welcomeLabel);
		this.nameLabel = new JLabel(this.misUser.getUserName());
		this.toolBar.add(this.nameLabel);
		this.relogButton = new JButton("重新登录");
		this.toolBar.add(this.relogButton);
		this.exitButton = new JButton("退出");
		this.toolBar.add(this.exitButton);
		this.bodyPanel.add(this.toolBar, BorderLayout.NORTH);
		
		this.welcomePanel = new WelcomePanel();
		this.welcomePanel.setBackground(Color.LIGHT_GRAY);
		this.bodyPanel.add(this.welcomePanel, BorderLayout.CENTER);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.stateLabel = new JLabel(sdf.format(new Date()) + "    版本信息V2.0", JLabel.CENTER);
		this.bodyPanel.add(this.stateLabel, BorderLayout.SOUTH);
		
		
		this.setTitle("管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MainFrame() {
		
	}
	
	public MainFrame(MisUser misUser) {
		this.misUser = misUser;
		this.init();
	}
}
