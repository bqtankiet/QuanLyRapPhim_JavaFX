package com.khanhnhi.controllers;

import java.util.Map;

import javax.swing.JOptionPane;

import com.khanhnhi.views.Server;
import com.khanhnhi.views.SignupPanel;

public class SignupController {
	private MainController parent;
    private SignupPanel view;

    public static SignupController init(SignupPanel view) {
        return new SignupController(view);
    }

    private SignupController(SignupPanel view) {
        this.view = view;
        renderView();
        eventHandling();
    }

    public void setParent(MainController parent) {
    	this.parent = parent;
    }
    
    private void renderView() {
        view.render();
    }

    private void eventHandling() {
        view.signupButton.addActionListener(e -> handleSignup());
        view.signup.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parent.switchToLoginPanel();
            }
        });
    }

    private void handleSignup() {
        String username = view.signupUsername.getText();
        String password = new String(view.signupPassword.getPassword());
        String confirmPassword = new String(view.signupConfirmPassword.getPassword());

        if (isInputValid(username, password, confirmPassword)) {
            Server.getInstance().getUserCredentials().put(username, password);
            JOptionPane.showMessageDialog(view, "Đăng ký thành công!");
            parent.switchToLoginPanel();
        }
    }

    private boolean isInputValid(String username, String password, String confirmPassword) {
        Map<String, String> userCredentials = Server.getInstance().getUserCredentials();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        if (userCredentials.containsKey(username)) {
            JOptionPane.showMessageDialog(view, "Tên đăng nhập đã tồn tại. Vui lòng chọn tên đăng nhập khác");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(view, "Xác nhận mật khẩu sai");
            return false;
        }

        if (password.length() <= 5) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu có nhiều hơn 5 kí tự");
            return false;
        }

        return true;
    }

    public void clearView() {
        view.signupUsername.setText("");
        view.signupPhone.setText("");
        view.signupEmail.setText("");
        view.signupPassword.setText("");
        view.signupConfirmPassword.setText("");
    }
}
