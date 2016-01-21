package com.sm.framework.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	private ImageIcon imageIcon = null;
	
	public WelcomePanel() {
		this.imageIcon = new ImageIcon("./images/welcome.jpg");
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
}
