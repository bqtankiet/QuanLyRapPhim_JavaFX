package com.khanhnhi.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPanel extends JPanel {
	public JTextField loginUsername;
	public JPasswordField loginPassword;
	public JButton loginButton;
	public JPanel cardPanel;
	public JLabel createAccount1;
	
	public LoginPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public void render() {
		// Boder
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(170, 50, 170, 50));

		// Component " Dang nhap"
		JLabel titleLabel = new JLabel("ĐĂNG NHẬP");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(titleLabel);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Component "Ten dang nhap"
		JTextField loginUsername = createLabeledTextField("Tên đăng nhập");
		this.loginUsername = loginUsername;
		add(loginUsername);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Component "Mat khau"
		JPasswordField loginPassword = createLabeledPasswordField("Mật khẩu");
		this.loginPassword = loginPassword;
		add(loginPassword);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Component "Dang nhap"
		JButton loginButton = new JButton("Đăng nhập");
		this.loginButton = loginButton;
		loginButton.setBackground(Color.WHITE);
		loginButton.setBorder(new RoundedBorder(20));
		loginButton.setOpaque(true);
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(loginButton);

		add(Box.createRigidArea(new Dimension(0, 10)));

		// Component "Ban chua co tai khoan? Tao tai khoan"
		JPanel account = new JPanel(new FlowLayout());
		account.setBackground(Color.WHITE);

		JLabel dontalreadyHaveAccount = new JLabel("Bạn chưa có tài khoản?");
		dontalreadyHaveAccount.setForeground(new Color(0, 0, 0));

		createAccount1 = new JLabel("<html><u>Tạo tài khoản</u></html>");
//		createAccount1.setForeground(new Color(241, 171, 185));
		createAccount1.setForeground(Color.BLUE);
		createAccount1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		account.add(dontalreadyHaveAccount);
		account.add(createAccount1);

		add(account);
	}

	private JTextField createLabeledTextField(String label) {
		JTextField textField = new JTextField(20);
		textField.setBorder(BorderFactory.createTitledBorder(label));
		return textField;
	}

	private JPasswordField createLabeledPasswordField(String label) {
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setBorder(BorderFactory.createTitledBorder(label));
		return passwordField;
	}

	private static class RoundedBorder implements Border {
		private int radius;

		RoundedBorder(int radius) {
			this.radius = radius;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		public boolean isBorderOpaque() {
			return true;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y + 15, width - 1, height - 30, radius, radius);
		}
	}
}
