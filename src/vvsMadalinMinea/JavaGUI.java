package vvsMadalinMinea;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.net.UnknownHostException;
class JavaGUI extends EchoClient{
	 public JTextField tf;
    public static void createGUI(String args[])  {

        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               String str = event.getActionCommand();
               JavaGUI ac=new JavaGUI();
               String getValue = tf.getText();
              try {
				ac.action(getValue);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
         };
         send.setActionCommand("FirstButton");
         send.addActionListener(actionListener);
        
        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
    public String action(String txt) throws UnknownHostException, IOException {
    	EchoClient client1 = new EchoClient();
 	    client1.startConnection("127.0.0.1", 5555);
        String resp=client1.sendMessage(txt);
        System.out.println(txt);
        return resp;
    }
}