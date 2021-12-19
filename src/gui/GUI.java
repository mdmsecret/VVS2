package gui;

import src.MyWebServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI {


	private final JFrame frame;
	private final JPanel panel;
	public JLabel label;
	public JButton startServerButton;
	public JButton maintenanceServerButton;
	public JButton stopServerButton;



	public GUI() {

		frame = new JFrame();

		startServerButton = new JButton("Start server");
//		startServerButton.addActionListener(this);
		startServerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//start action logic here
				Thread hilo = new Thread(new Runnable() {

					@Override
					public void run() {


						try {
							MyWebServer.activ(1);

						} catch (IOException ioException) {
							ioException.printStackTrace();
						}

					}
				});
				hilo.start();


				label.setText("Server is running on port 8080 ");
			}


		});
		maintenanceServerButton = new JButton("Start maintenance for the server");
//		maintenanceServerButton.addActionListener(this);
		maintenanceServerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Thread hilo2 = new Thread(new Runnable() {

					@Override
					public void run() {


						try {
							MyWebServer.activ(2);

						} catch (IOException ioException) {
							ioException.printStackTrace();
						}

					}
				});
				hilo2.start();

				//srv();
				label.setText("Server is in maintenance ");
			}
		});
		stopServerButton = new JButton("Stop server");
//		stopServerButton.addActionListener(this);
		stopServerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//start action logic here

				Thread hilo3 = new Thread(new Runnable() {

					@Override
					public void run() {


						try {
							MyWebServer.activ(3);

						} catch (IOException ioException) {
							ioException.printStackTrace();
						}

					}
				});
				hilo3.start();

				//srv();
				label.setText("Server is stopped ");
			}
		});
		label = new JLabel("Server is not running");
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(startServerButton);
		panel.add(maintenanceServerButton);
		panel.add(stopServerButton);
		panel.add(label);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("VVS Project GUI");
		frame.pack();
		frame.setVisible(true);


	}

	public static void main(String[] args) {
		new GUI();

	}
}




