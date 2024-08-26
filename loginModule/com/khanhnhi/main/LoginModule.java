package com.khanhnhi.main;

import com.khanhnhi.controllers.MainController;
import com.khanhnhi.views.MainFrame;

public class LoginModule {
	public LoginModule(LoginModuleHandler module) {
		new MainController(new MainFrame(), module);
	}

}
