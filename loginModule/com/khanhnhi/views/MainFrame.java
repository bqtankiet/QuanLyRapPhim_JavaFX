package com.khanhnhi.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.security.auth.login.LoginContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.khanhnhi.controllers.LoginController;
import com.khanhnhi.controllers.SignupController;

public class MainFrame extends JFrame {
	public LoginPanel loginPanel;
	public SignupPanel signupPanel;
	public JPanel cardPanel;
	public JPanel mainPanel;

	public MainFrame() {
		setTitle("Login and Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new CardLayout());

		mainPanel = new JPanel(new BorderLayout());
		cardPanel = new JPanel(new CardLayout());
		JPanel imagePanel = new ImagePanel("background1.jpg",getHeight(),getHeight());

		loginPanel = new LoginPanel(cardPanel);
		signupPanel = new SignupPanel(cardPanel);

		cardPanel.add(loginPanel, "loginPanel");
		cardPanel.add(signupPanel, "signupPanel");

		loginPanel.setBackground(Color.WHITE);
		signupPanel.setBackground(Color.WHITE);

		// mainPanel "add cardPanel to WEST"
		cardPanel.setPreferredSize(new Dimension(400, 600));
		mainPanel.add(cardPanel, BorderLayout.WEST);

		// mainPanel "add image to CENTER"
		mainPanel.add(imagePanel, BorderLayout.CENTER);

		add(mainPanel);
		setVisible(true);
	}

	class ImagePanel extends JPanel {
		private ImageIcon imageIcon;
		private int width, height;

		public ImagePanel(String imagePath, int width, int height) {
			this.imageIcon = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
			this.width = width;
			this.height = height;
			this.setBackground(Color.WHITE);
			setupImage();
		}

		private void setupImage() {
			Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(image);
			JLabel imgLabel = new JLabel(imageIcon);
			imgLabel.setAlignmentY(CENTER_ALIGNMENT);
			this.add(imgLabel);
		}
	}

}
