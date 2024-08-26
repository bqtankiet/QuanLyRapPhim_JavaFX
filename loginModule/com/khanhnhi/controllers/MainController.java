package com.khanhnhi.controllers;

import java.awt.CardLayout;

import com.khanhnhi.main.LoginModuleHandler;
import com.khanhnhi.views.MainFrame;

public class MainController {
	public SignupController signupController;
	public LoginController loginController;
	public MainFrame view;
	private LoginModuleHandler module;

	public MainController(MainFrame view, LoginModuleHandler module) {
		super();
		this.module = module;
		this.view = view;
		this.signupController = SignupController.init(view.signupPanel);
		this.signupController.setParent(this);
		this.loginController = LoginController.init(view.loginPanel);
		this.loginController.setParent(this);
	}

	public void switchToLoginPanel() {
		CardLayout cl = (CardLayout) (view.cardPanel.getLayout());
		signupController.clearView();
		cl.show(view.cardPanel, "loginPanel");
	}

	public void switchToSignupPanel() {
		CardLayout cl = (CardLayout) view.cardPanel.getLayout();
		loginController.clearView();
		cl.show(view.cardPanel, "signupPanel");
	}
	
	public void handleLoginSuccess() {
		module.handle();
	}
}
