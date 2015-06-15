package frontendPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    Front     	Front;
    MenuExp     newFrame    = new MenuExp();
    JButton     enviarComando;
    JTextField  mensajeComando;
    JTextArea   commandBox;
    JTextField  usernameChooser;
    JPanel      panelGraficos;
    JLabel 		picLabel;
    JPanel 		panelCentral;
    Graph 		grafico;

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
    JButton botonGrafico;
    public void display() {

    	newFrame.setSize(820, 600);
    	newFrame.setTitle(appName);
    	panelCentral = new JPanel(new BorderLayout());
    	panelCentral.setBackground(Color.WHITE);

        JPanel panelMensajes = new JPanel(new BorderLayout());
        JPanel panelGraficos = new JPanel(new BorderLayout());

        commandBox = new JTextArea();
        commandBox.setTabSize(6);
        commandBox.setEditable(false);
        commandBox.setFont(new Font("Serif", Font.PLAIN, 15));
      
        commandBox.setLineWrap(true);
        commandBox.setSize(300, 500);
        commandBox.setBackground(Color.WHITE);

        panelMensajes.add(new JScrollPane(commandBox), BorderLayout.WEST);
        panelGraficos.setBackground(Color.BLACK);
        panelCentral.getPreferredSize();
        
                JPanel southPanel = new JPanel(new BorderLayout());
                newFrame.getContentPane().add(southPanel, BorderLayout.SOUTH);
                southPanel.setBackground(Color.GRAY);
                
        mensajeComando = new JTextField(10);
        mensajeComando.requestFocusInWindow();
        
                enviarComando = new JButton("Send Command");
                enviarComando.addActionListener(new EnviarComandoButtonListener());
                
                
                        southPanel.add(mensajeComando, BorderLayout.CENTER);
                        southPanel.add(enviarComando, BorderLayout.WEST);
                        botonGrafico = new JButton("Graficar");
                        botonGrafico.setVisible(false);
                        southPanel.add(botonGrafico, BorderLayout.EAST);
                        botonGrafico.setSize(15, 15);
                        
                                botonGrafico.addActionListener(new EntregarGrafico());

        newFrame.getContentPane().add(BorderLayout.LINE_END,panelGraficos);
        newFrame.getContentPane().add(panelCentral);
        newFrame.getContentPane().add(panelMensajes, BorderLayout.BEFORE_LINE_BEGINS);
        newFrame.setDefaultCloseOperation(MenuExp.EXIT_ON_CLOSE);
        newFrame.setVisible(true);    	
 
    }
    
    class EnviarComandoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
        	botonGrafico.setVisible(false);
            if (mensajeComando.getText().length() < 1) {
                // do nothing
            } 
            else if (mensajeComando.getText().equals(".clear")) { //borro todo el contenido
                commandBox.setText("Cleared all messages\n");
                mensajeComando.setText("");
                //grafico.renovarGrafico();
                
                
            }
            else {
                commandBox.append(mensajeComando.getText()
                        + "\n");               
               // Aqui est‡ el string que hay que enviar al backend
                System.out.println(mensajeComando.getText());              
                commandBox.append("> "+BackendMain.main(mensajeComando.getText())+ "\n");
                if(mensajeComando.getText().startsWith("fun")){
                	botonGrafico.setVisible(true);

                }
                //Aqui est‡ el string que hay que enviar al backend
                
                mensajeComando.setText("");
            }     
            mensajeComando.requestFocusInWindow();
        }  
    }
    String  lineaComando;

    class EntregarGrafico implements ActionListener{
    	public void actionPerformed(ActionEvent event){
    		//picLabel.setVisible(true);//AQUI DEBO CREAR EL GRAFICO E IMPLEMENTARLO
    		double y;
            grafico = new Graph(10,10, panelCentral);
            
            for ( double x =0; x<=10; x+=0.01 )//aqui se grafica 
            {    
            	try{
            	y=Double.parseDouble(BackendMain.main("eval f("+String.valueOf(x)+")"));			
                grafico.drawPoint(x,y);
            	}
            	catch(Exception e){}
            }
            for ( double x =-10; x<0; x+=0.01 )
            {    
            	try{
            	y=Double.parseDouble(BackendMain.main("eval f("+String.valueOf(x)+")"));
                grafico.drawPoint(x,y);
            	}
            	catch(Exception e){}
            	panelCentral.updateUI(); //actualizo el grafico
            }
    	}
    }   
}