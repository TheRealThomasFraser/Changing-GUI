import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class MainGUI implements ActionListener, ItemListener{
	
	
	// ------------------- Initialising components ---------------------
	
	
	JPanel totalGUI, mainGUI, startGUI, previewGUI, nonPreviewGUI, panelForPanels, loginPanel, blankPanel, redPanel, bluePanel, purplePanel, orangePanel, blue2Panel, goldPanel, red2Panel, pinkPanel, greenPanel, yellowPanel, blue3Panel, red3Panel, greyPanel, brownPanel, brown2Panel;
	JToggleButton previewButton;
    JButton loginButton, blankButton, redButton, blueButton, purpleButton, orangeButton, blue2Button, goldButton, red2Button, pinkButton, greenButton, yellowButton, blue3Button, red3Button, greyButton, brownButton, brown2Button; 
    JComboBox<String> colourChooser;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel usernameLabel, passwordLabel;
    JTextArea x;
    String username;
    JButton buttons[] = {blankButton, redButton,  blueButton, purpleButton, orangeButton, blue2Button, goldButton, red2Button, pinkButton, greenButton, yellowButton, blue3Button, red3Button, greyButton, brownButton, brown2Button};
    JPanel panels[] = {blankPanel, redPanel, bluePanel, purplePanel, orangePanel, blue2Panel, goldPanel, red2Panel, pinkPanel, greenPanel, yellowPanel, blue3Panel, red3Panel, greyPanel, brownPanel, brown2Panel};
	Color rgbColors[] = {Color.WHITE, new java.awt.Color(213, 56, 65), new java.awt.Color(54, 133, 191), new java.awt.Color(148, 48, 110), new java.awt.Color(245, 140, 90), new java.awt.Color(19, 50, 189), new java.awt.Color(194, 162, 101), new java.awt.Color(254, 2, 1), new java.awt.Color(236, 0, 141), new java.awt.Color(57, 232, 112), new java.awt.Color(252, 191, 78), new java.awt.Color(108, 179, 183), new java.awt.Color(217, 41, 43), new java.awt.Color(194, 205, 207),new java.awt.Color(61, 20, 22),  new java.awt.Color(99, 57, 36)};
    
	
    // ------------------------------ Main ------------------------------
    
    
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	// ---------------------- Setting Up The Frame ---------------------
	
	
	private static void createAndShowGUI() {
		
		JFrame.setDefaultLookAndFeelDecorated(true); // Makes frame appear the same across different OS
		JFrame frame = new JFrame("2024");
		MainGUI demo = new MainGUI();
		frame.setContentPane(demo.createContentPane()); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Customising Frame:
		frame.setSize(500, 530);
		frame.setVisible(true);
		}
	
	
	// ---------------------- Setting Up The GUI ----------------------
	
	
	public JPanel createContentPane() {
		
		// Overall GUI Setup:
		totalGUI = new JPanel();
		totalGUI.setLayout(null);
		
		startGUI = new JPanel();
		startGUI.setLayout(null);
		startGUI.setBounds(0, 0, 500 , 530);
		
		mainGUI = new JPanel();
		mainGUI.setLayout(null);
		mainGUI.setBounds(0, 0, 500 , 530);
		
		// GUI With Previews Setup:
		previewGUI = new JPanel();
		previewGUI.setLayout(null);
		previewGUI.setBounds(0, 0, 500 , 530);
		
		// GUI Without Previews setup:
		nonPreviewGUI = new JPanel();
		nonPreviewGUI.setLayout(null);
		nonPreviewGUI.setBounds(0, 0, 500 , 530);
		
		// ------- Starting GUI Setup: -------
		
		loginPanel= new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 500 , 530);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setLocation(0, 0);
		usernameLabel.setSize(100, 30);
		usernameLabel.setHorizontalAlignment(0);
		loginPanel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setLocation(0, 60);
		passwordLabel.setSize(100, 30);
		passwordLabel.setHorizontalAlignment(0);
		loginPanel.add(passwordLabel);
		
		usernameField = new JTextField(12);
        usernameField.setLocation(0, 30);
        usernameField.setSize(150, 30);
        loginPanel.add(usernameField);
        
        passwordField = new JPasswordField(12);
        passwordField.setLocation(0, 90);
        passwordField.setSize(150, 30);
        loginPanel.add(passwordField);
        
        loginButton = new JButton("Login");
        loginButton.setLocation(130, 120);
        loginButton.setSize(80, 30);
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);
		
		// ------- GUI With Previews: -------
		
		// Layout Setup:
        panelForPanels = new JPanel(new GridLayout(4, 4, 20, 20));
        panelForPanels.setBounds(20, 50, 460 , 460);
        previewGUI.add(panelForPanels);
        
        for(int i=0; i < panels.length; i++) {
      
        panels[i] = createPreview(rgbColors[i], 100);
        if (i == 0) {
        	buttons[i] = createButton(Color.BLACK, 100, 30, 0, 35);}
        else {
    		buttons[i] = createButton(rgbColors[i], 100, 30, 0, 35);}
			panels[i].add(buttons[i]);
		panelForPanels.add(panels[i]);
        }
        
		
		// ------ GUI Without Previews: ------
		
		// Combo box Options:
		String colours[] = {"Blank", "MBDTF Red", "MBDTF Blue", "GRAD Purple", "TLOP Orange", "JIK Blue", "WTT Gold", "Yeezus Red", "GRAD Pink", "YE Green", "KSG Yellow", "KSG Blue", "808s Red", "808s Grey", "TCD Brown", "LR Brown"};
		// Combo Box Setup:
	    colourChooser = new JComboBox<String>(colours);
	    colourChooser.addActionListener(this);
	    colourChooser.setLocation(0, 50);
	    colourChooser.setSize(150, 30);
	    nonPreviewGUI.add(colourChooser);
        
	 // -------- Shared GUI: --------
	    
	    //Preview Button Setup:
        previewButton = new JToggleButton("Preview Mode On");
        previewButton.setLocation(20, 0);
        previewButton.setSize(150, 30);
        previewButton.addItemListener(this);
        mainGUI.add(previewButton);
        
     // ---- Finishing GUI Setup: ----
        
        totalGUI.add(startGUI);
		totalGUI.add(mainGUI);
		totalGUI.setOpaque(true);
		
		startGUI.add(loginPanel);
		startGUI.setOpaque(true);
		startGUI.setVisible(true);
		
		mainGUI.add(previewGUI);
		mainGUI.add(nonPreviewGUI);
		mainGUI.setOpaque(true);
		mainGUI.setVisible(false);
		
		previewGUI.setOpaque(true);
		previewGUI.setVisible(true);
		
		nonPreviewGUI.setOpaque(true);
		nonPreviewGUI.setVisible(false);
		
		return totalGUI;
	}
	
	
	// --------------------- Customising Previews: ---------------------
	
	
	private JPanel createPreview(Color color, int size) {
		
		JPanel tempPanel = new JPanel();
		
		tempPanel.setBackground(color);
		tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
		tempPanel.setLayout(null);
		
		return tempPanel;
	}
	
	
	// --------------------- Customising Buttons: ---------------------
	
	
	private JButton createButton(Color color, int sizeX, int sizeY, int locX, int locY) {
		
		JButton tempButton = new JButton("Choose");
		
		tempButton.setBackground(color);
		tempButton.setForeground(color);
		tempButton.setSize(sizeX, sizeY);
		tempButton.setLocation(locX, locY);
		tempButton.addActionListener(this);
		
		return tempButton;
	}
	
	
	// ---------- Detecting If Background Change Requested: ----------
	
	
	public void actionPerformed(ActionEvent e) {
		
		int colourChoice = colourChooser.getSelectedIndex();
		
		for(int i=0; i < panels.length; i++) {
			if((e.getSource() == buttons[i]) || ((e.getSource() == colourChooser) && (colourChoice == i))) {
				changeBackground(rgbColors[i]);
				changeChoice(i);
			}
		}
		char[] answer = {'V', 'U', 'L', 'T', 'U', 'R', 'E', 'S'};
        char[] guess = passwordField.getPassword();
        if(e.getSource() == loginButton) {
        if(Arrays.equals(guess, answer) && (usernameField.getText().length() <= 12)) {
        	startGUI.setVisible(false);
        	mainGUI.setVisible(true);
        	username = usernameField.getText();
        	String y = "hello " + username;
    	    x = new JTextArea(y, 150, 30);
    	    x.setEditable(false);	  
    	    x.setLocation(200, 0);
    	    x.setSize(150, 30);
    	    mainGUI.add(x);
        }
        }
	}
	
	
	// ------------------- Changing Background Colour: -------------------
	
	
	private void changeBackground(Color color) {
		
		totalGUI.setBackground(color);
		totalGUI.setBackground(color);
		previewGUI.setBackground(color);
		nonPreviewGUI.setBackground(color);
		panelForPanels.setBackground(color);
		x.setBackground(color);
	}
	
	
// ------------- Switching Between With & Without Preview GUI: -------------
	
	
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			previewButton.setText("Preview Mode Off");
			previewGUI.setVisible(false);
			nonPreviewGUI.setVisible(true);
		}
		
		else {
			previewButton.setText("Preview Mode On");
			previewGUI.setVisible(true);
			nonPreviewGUI.setVisible(false);
		}
	}
	
	private void changeChoice(int choice) {
		
		colourChooser.setSelectedIndex(choice);
	}
}