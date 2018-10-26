package scratch;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.BorderLayout;


public class Gamble extends JFrame {
	
	private JFrame frame = new JFrame();
	private JTextField jtext = new JTextField();
	private JButton tryluck = new JButton("Gamble!");
	private double dollar = 1;
	
	public Gamble() {
		super("Try your luck!!");
		setLocationRelativeTo(null);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tryluck, BorderLayout.SOUTH);
		getContentPane().add(jtext, BorderLayout.CENTER);
		jtext.setText("Current Balance: $" + dollar);
		setJMenuBar(getMenu());
		setVisible(true);
	}
	
	private JMenuBar getMenu(){
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		
		JMenu save = new JMenu("Save");
		file.add(save);
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				saveFile();
			}
		});
		
		
		
		return menubar;
	}
	
	tryluck.addActionListener(new ActionListener());
	
	private void money() {
		
		dollar = Math.random();
	}
	
	
	private void saveFile() {
		JFileChooser j = new JFileChooser();
		if(j.showSaveDialog(this) != JFileChooser.APPROVE_OPTION){
			return;
		}if(j.getSelectedFile() == null) {
			return;
		}
		File x = j.getSelectedFile();
		if(j.getSelectedFile().exists()) {
			String message = "Do you want to overwrite" + j.getSelectedFile().getName() + "?";
			if(JOptionPane.showConfirmDialog(this, message) != JOptionPane.YES_OPTION) {
				return;
			}
		}
		try{
			BufferedWriter filewrite = new BufferedWriter(new FileWriter(x));
			filewrite.write(this.dollar+"\n");
			filewrite.flush(); filewrite.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage(), "There was an error in writing, please try again.", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	public static void main(String[] args) {
		
		new Gamble();
		

	}

}
