package com.khanhnhi.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignupPanel extends JPanel {
	public JPanel cardPanel;
	public JButton signupButton;
	public JTextField signupUsername;
	public JTextField signupPhone;
	public JTextField signupEmail;
	public JPasswordField signupPassword;
	public JPasswordField signupConfirmPassword;
	public JLabel signup;

	public SignupPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
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

	public void render() {
		// Icon path
		ImageIcon FacebookIcon = new ImageIcon(getClass().getClassLoader().getResource("face.png"));
		ImageIcon GoogleIcon = new ImageIcon(getClass().getClassLoader().getResource("google.png"));

		// Boder
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

		// Component "TAO TAI KHOAN"
		JLabel titleLabel = new JLabel("TẠO TÀI KHOẢN");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(titleLabel);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Panel "top panel contain 2 reigster button"
		JPanel topPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		topPanel.setBackground(Color.white);
		add(topPanel);

		// Component "Dang ki voi Google"
		int width = 200, height = 30;
		JButton googleSignup = new JButton("Đăng kí với Google");
		googleSignup.setIcon(GoogleIcon);
		googleSignup.setBackground(Color.WHITE);
		googleSignup.setAlignmentX(Component.CENTER_ALIGNMENT);
		googleSignup.setPreferredSize(new Dimension(width, height));
		topPanel.add(googleSignup);

		add(Box.createRigidArea(new Dimension(0, 10)));

		// Component "Dang ki voi Facebook"
		JButton facebookSignup = new JButton("Đăng kí với Facebook");
		facebookSignup.setIcon(FacebookIcon);
		facebookSignup.setBackground(Color.WHITE);
		facebookSignup.setAlignmentX(Component.CENTER_ALIGNMENT);
		facebookSignup.setPreferredSize(new Dimension(width, height));
		topPanel.add(facebookSignup);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Component "Ten dang nhap"
		signupUsername = createLabeledTextField("Tên đăng nhập");
		add(signupUsername);

		// Component "So dien thoai"
		signupPhone = createLabeledTextField("Số điện thoại");
		add(signupPhone);

		// Component "Dia chi email"
		signupEmail = createLabeledTextField("Địa chỉ email");
		add(signupEmail);

		// Component "Mat khau"
		signupPassword = createLabeledPasswordField("Mật khẩu");
		add(signupPassword);

		// Component "Nhap lai mat khau"
		signupConfirmPassword = createLabeledPasswordField("Nhập lại mật khẩu");
		add(signupConfirmPassword);

		add(Box.createRigidArea(new Dimension(0, 20)));

		// Component "Tao tai khoan"
		signupButton = new JButton("Tạo tài khoản");
		signupButton.setBackground(Color.WHITE);
		signupButton.setBorder(new RoundedBorder(20));
		signupButton.setOpaque(true);
		signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(signupButton);

		add(Box.createRigidArea(new Dimension(0, 10)));

		// Component "Ban da co tai khoan? Dang nhap"
		JPanel account = new JPanel(new FlowLayout());
		account.setBackground(Color.WHITE);

		JLabel alreadyHaveAccount = new JLabel("Bạn đã có tài khoản?");
		alreadyHaveAccount.setForeground(new Color(0, 0, 0));

		signup = new JLabel("<html><u>Đăng nhập</u></html>");
//				signup.setForeground(new Color(241, 171, 185));
		signup.setForeground(Color.BLUE);
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		account.add(alreadyHaveAccount);
		account.add(signup);

		add(account);
	}

}
