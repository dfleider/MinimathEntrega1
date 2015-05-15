package frontendPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import backendPackage.BackendMain;

public class Front {

    String      appName     = "MiniMath";
    Front     Front;
    MenuExp     newFrame    = new MenuExp();
    JButton     enviarComando;
    JTextField  mensajeComando;
    JTextArea   commandBox;
    JTextField  usernameChooser;
   // MenuExp     preFrame;
    JPanel      panelGraficos;
    JLabel 		picLabel;

    public static void main(String[] args) {
    	

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Front Front = new Front();
                Front.display();
                
            }
        });
    }


    
    BufferedImage logo;
//    public void preDisplay() {
//        newFrame.setVisible(false);
//        //newFrame.setResizable(false);
//        newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//
//        preFrame = new MenuExp();
//        preFrame.setSize(300, 300);
//        JButton enterServer = new JButton("Ingresar a MiniMath");
//        enterServer.addActionListener(new EntrarProgramaButtonListener());
//        JPanel prePanel = new JPanel(new BorderLayout());
//
//        
//    	try {
//    		
//    		logo = ImageIO.read(new File("logo.jpg"));
//    		
//    	    JLabel picLogo = new JLabel(new ImageIcon(logo));
//
//    	    prePanel.add(picLogo,BorderLayout.CENTER);
//
//    	    System.out.println("Funco");
//    
//    	} catch (IOException e) {
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    		System.out.println("no abrio");
//    	}
//
//        preFrame.add(BorderLayout.CENTER, prePanel);
//        preFrame.add(BorderLayout.SOUTH, enterServer);
//       
//        preFrame.setVisible(true);
//        
//    }
//    public Dimension getPreferredSize() {
//        return new Dimension(100, 100);
//    }
    public void display() {
//    	try {
//    		
//    		//logo = ImageIO.read(new File("logo.jpg"));
//    		
//    	    //JLabel picLogo = new JLabel(new ImageIcon(logo));
//
//    	    
//
//    	    System.out.println("Funco");
//    
//    	} catch (IOException e) {
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    		System.out.println("no abrio");
//    	}
    	//preFrame.setVisible(true);
    	newFrame.setSize(800, 600);
    	JPanel panelCentral = new JPanel(new BorderLayout());
    	panelCentral.setBackground(Color.WHITE);

        JPanel panelMensajes = new JPanel(new BorderLayout());
        JPanel panelGraficos = new JPanel(new BorderLayout());

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.GRAY);
                
        mensajeComando = new JTextField(10);
        mensajeComando.requestFocusInWindow();

        enviarComando = new JButton("Send Command");
        enviarComando.addActionListener(new EnviarComandoButtonListener());

        commandBox = new JTextArea();
        commandBox.setTabSize(6);
        commandBox.setEditable(false);
        commandBox.setFont(new Font("Serif", Font.PLAIN, 15));
      
        commandBox.setLineWrap(true);
        commandBox.setSize(300, 500);
        commandBox.setBackground(Color.GRAY);

        panelMensajes.add(new JScrollPane(commandBox), BorderLayout.WEST);


        southPanel.add(mensajeComando, BorderLayout.EAST);
        southPanel.add(enviarComando, BorderLayout.WEST);
        panelMensajes.add(southPanel,BorderLayout.SOUTH);
        JButton botonGrafico = new JButton();

        try {
            Image img = ImageIO.read(getClass().getResource("play.png"));
            botonGrafico.setIcon(new ImageIcon(img));
          } catch (IOException ex) 
          {
          }  
        
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.WHITE);
        
        panelCentral.add(subPanel, BorderLayout.CENTER);


        botonGrafico.addActionListener(new EntregarGrafico());
        panelGraficos.setBackground(Color.BLACK);
        panelCentral.getPreferredSize();
//        JLabel prueba = new JLabel();
//        prueba.setBackground(Color.WHITE);
//        panelGraficos.add(prueba,BorderLayout.CENTER);
        //JLabel picLogo = new JLabel(new ImageIcon(logo));
//
//        picLogo.setBackground(Color.WHITE);
//        panelCentral.add(picLogo,BorderLayout.NORTH);
        BufferedImage espacioGraficos;
        try{ 
        	espacioGraficos = ImageIO.read(new File("play.jpg"));
        	JLabel espGraf = new JLabel (new ImageIcon(espacioGraficos.getSubimage(0, 0, 600, 1)));
        	
        	panelCentral.add(espGraf, BorderLayout.SOUTH);
        
	    System.out.println("Funco");
	    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("no abrio");
	}
        
        //newFrame.add(panelGraficos);
        newFrame.getContentPane().add(BorderLayout.LINE_END,panelGraficos);
        panelCentral.add(botonGrafico,BorderLayout.SOUTH);
        newFrame.getContentPane().add(panelCentral);

       

        
        newFrame.getContentPane().add(panelMensajes, BorderLayout.BEFORE_LINE_BEGINS);
        newFrame.setDefaultCloseOperation(MenuExp.EXIT_ON_CLOSE);

        newFrame.setVisible(true);
        
        
		BufferedImage imagenWn;
    	try {
    		
    		imagenWn = ImageIO.read(new File("felipe.jpg"));
    		
    	    picLabel = new JLabel(new ImageIcon(imagenWn.getSubimage(300, 100, 500, 500)));
    	    picLabel.setVisible(false);
    	    panelCentral.add(picLabel,BorderLayout.NORTH);
    	    picLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	    System.out.println("Funco");
    
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("no abrio");
    	}
 
    }
    

    class EnviarComandoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (mensajeComando.getText().length() < 1) {
                // do nothing
            } else if (mensajeComando.getText().equals(".clear")) {
                commandBox.setText("Cleared all messages\n");
                mensajeComando.setText("");
            } else {
                commandBox.append(mensajeComando.getText()
                        + "\n");
                
               // Aqui est‡ el string que hay que enviar al backend
                System.out.println(mensajeComando.getText());              
                commandBox.append(BackendMain.main(mensajeComando.getText())+ "\n");
                //Aqui est‡ el string que hay que enviar al backend
                
                mensajeComando.setText("");
            }
            
            mensajeComando.requestFocusInWindow();
        }  
    }
    String  lineaComando;

    class EntregarGrafico implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		picLabel.setVisible(true);
    	}
    }   
}