package com.bit2016.mysite.action.main;

import com.bit2016.web.*;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		return new MainAction();
	}

}
