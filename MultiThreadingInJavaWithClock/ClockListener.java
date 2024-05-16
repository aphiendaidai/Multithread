package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ClockMainView;

public class ClockListener implements ActionListener {
	ClockMainView view;

	public ClockListener(ClockMainView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.callOtherView();
	}

}
