package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ClockListener;
import test.Main;
import thread.ThreadOfEveryClock;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class ClockMainView extends JFrame {
	public JTextField textField_Choose;
	public JLabel label_FaceOfClock;
	public String zone;
	public ClockMainView(String zone) {
		this.zone = zone;
		this.init();
		this.setVisible(true);
		ThreadOfEveryClock clockThread1 = new ThreadOfEveryClock(this, this.textField_Choose.getText());
		clockThread1.start();
	}

	public void init() {
		this.setTitle("Clock");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setSize(350, 242);

		ClockListener listen = new ClockListener(this);

		label_FaceOfClock = new JLabel("00 : 00 : 00");
		label_FaceOfClock.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_FaceOfClock.setBackground(Color.WHITE);
		label_FaceOfClock.setForeground(Color.BLACK);
		label_FaceOfClock.setOpaque(true);
		label_FaceOfClock.setHorizontalAlignment(SwingConstants.CENTER);
		label_FaceOfClock.setBounds(30, 28, 275, 81);
		getContentPane().add(label_FaceOfClock);

		JLabel label_BackgroundFaceOfClock = new JLabel("");
		label_BackgroundFaceOfClock.setBackground(Color.GREEN);
		label_BackgroundFaceOfClock.setOpaque(true);
		label_BackgroundFaceOfClock.setBounds(10, 10, 316, 120);
		getContentPane().add(label_BackgroundFaceOfClock);

		textField_Choose = new JTextField();
		textField_Choose.setText(zone);
		textField_Choose.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Choose.setBackground(Color.WHITE);
		textField_Choose.setBounds(30, 151, 185, 33);
		getContentPane().add(textField_Choose);
		textField_Choose.setColumns(10);

		JButton button_Open = new JButton("Open");
		button_Open.setForeground(Color.RED);
		button_Open.setBackground(Color.WHITE);
		button_Open.setBounds(230, 151, 75, 33);
		button_Open.addActionListener(listen);
		getContentPane().add(button_Open);

		JLabel label_SubBackground = new JLabel("");
		label_SubBackground.setBackground(Color.GREEN);
		label_SubBackground.setOpaque(true);
		label_SubBackground.setBounds(10, 140, 316, 55);
		getContentPane().add(label_SubBackground);
	}

	public void callOtherView() {
		ClockMainView newClockView = new ClockMainView(this.textField_Choose.getText());
		ThreadOfEveryClock clockThread = new ThreadOfEveryClock(newClockView, newClockView.textField_Choose.getText());
		clockThread.start();
	}

	public void updateTime(String format) {
		this.label_FaceOfClock.setText(format);
	}

}
