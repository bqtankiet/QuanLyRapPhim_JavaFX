package com.khanhnhi.controllers;

import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.khanhnhi.views.LoginPanel;
import com.khanhnhi.views.Server;

public class LoginController {
	private MainController parent;
    private LoginPanel view;

    public static LoginController init(LoginPanel view) {
        return new LoginController(view);
    }

    private LoginController(LoginPanel view) {
        this.view = view;
        renderView();
        eventHandling();
    }

    private void renderView() {
        view.render();
    }

    public void setParent(MainController parent) {
    	this.parent = parent;
    }
    
    public void clearView() {
        view.loginUsername.setText("");
        view.loginPassword.setText("");
    }

    private void eventHandling() {
        view.loginButton.addActionListener(e -> handleLogin());
        view.createAccount1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleCreateAccount();
            }
        });
    }

    private void handleLogin() {
        String username = view.loginUsername.getText();
        String password = new String(view.loginPassword.getPassword());

        Map<String, String> userCredentials = Server.getInstance().getUserCredentials();
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            clearView();
            JOptionPane.showMessageDialog(view, "Đăng nhập thành công!");
            parent.view.dispose();
            SwingUtilities.invokeLater(() -> {
            	parent.handleLoginSuccess();
            });
        } else {
            JOptionPane.showMessageDialog(view, "Sai tên đăng nhập hoặc mật khẩu!");
        }
    }

    private void handleCreateAccount() {
        parent.switchToSignupPanel();
    }
}
