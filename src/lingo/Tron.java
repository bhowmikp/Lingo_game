/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import lingo.AIGame;
import lingo.Game;
import lingo.SingleGame;


/**
 *
 * @author prantar
 */
public class Tron extends JFrame implements ActionListener, ItemListener{
    JButton btn1Player, btn2Player, btnComputer, btnInstructions, btnOptions, btnCarnival, btnMainMenu;
    JLabel lblTitle, lblPlayer1, lblPlayer2, lblColour1, lblColour2;
    JTextArea txtInstructions;
    JTextField txtPlayer1, txtPlayer2;
    JRadioButton btnGreen, btnRed, btnYellow, btnMagenta, btnCyan, btnWhite;
    JToggleButton btnSound;
    
    GridBagConstraints layout = new GridBagConstraints();
    
    String name1="Player1", name2="Player2";
    String colour1= "green", colour2="yellow";
    String sound;
    
    int[] ch= new int[20];    
    int item,point;
    
    public Tron (int point,int item,int itemch[]){
        super("TRON");
        this.point= point;
        this.item=item;
        ch=itemch;
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(new GridBagLayout());
        
        menu();
        
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Tron (String name1, String colour1, String name2, String colour2, String sound,int point,int item,int itemch[]){
        super("TRON");
        
        this.name1=name1;
        this.name2=name2;
        this.colour1=colour1;
        this.colour2=colour2;
        this.sound=sound; 
        this.point= point;
        this.item=item;
        ch=itemch;
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(new GridBagLayout());
        
        menu();
        
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public Tron (String name1, String colour1, int point,int item,int itemch[]){
        super("TRON");
        
        this.name1=name1;
        this.colour1=colour1;
        this.point= point;
        this.item=item;
        ch=itemch;
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(new GridBagLayout());
        
        menu();
        
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void menu(){
        //makes Title
        lblTitle = new JLabel("TRON", JLabel.CENTER);
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 65));
        lblTitle.setForeground (Color.WHITE);
        lblTitle.setToolTipText ("Play to Win. No Mercy");
        lblTitle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 0;
        layout.gridy = -1;
        layout.insets = new Insets(10,-100,100,-100);
        add(lblTitle, layout);
        lblTitle.setVisible (true);
        
        // single player button
        btn1Player = new JButton ("1 PLAYER");
        btn1Player.setFont(new Font("Serif", Font.PLAIN, 25));
        btn1Player.setForeground (Color.WHITE);
        btn1Player.setBackground (Color.BLACK);
        btn1Player.setBorder(BorderFactory.createLineBorder(Color.RED));
        layout.gridx=0;
        layout.gridy=1;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(10,0,20,0);
        btn1Player.setActionCommand("1Player");
        btn1Player.addActionListener(new ButtonListener());
        add (btn1Player,layout);
        btn1Player.setVisible (true);
        
        //2 player button
        btn2Player = new JButton ("2 PLAYER");
        btn2Player.setFont(new Font("Serif", Font.PLAIN, 25));
        btn2Player.setForeground (Color.WHITE);
        btn2Player.setBackground (Color.BLACK);
        btn2Player.setBorder(BorderFactory.createLineBorder(Color.orange));
        layout.gridx=0;
        layout.gridy=2;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(10,0,20,0);
        btn2Player.setActionCommand("2Player");
        btn2Player.addActionListener(new ButtonListener());
        add (btn2Player,layout);
        btn2Player.setVisible (true);
        
        //Computer button
        btnComputer = new JButton ("COMPUTER");
        btnComputer.setFont(new Font("Serif", Font.PLAIN, 25));
        btnComputer.setForeground (Color.WHITE);
        btnComputer.setBackground (Color.BLACK);
        btnComputer.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        layout.gridx=0;
        layout.gridy=3;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(10,0,20,0);
        btnComputer.setActionCommand("computer");
        btnComputer.addActionListener(new ButtonListener());
        add (btnComputer,layout);
        btnComputer.setVisible (true);
        
        //Instruction button
        btnInstructions = new JButton ("INSTRUCTIONS");
        btnInstructions.setFont(new Font("Serif", Font.PLAIN, 25));
        btnInstructions.setForeground (Color.WHITE);
        btnInstructions.setBackground (Color.BLACK);
        btnInstructions.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        layout.gridx=0;
        layout.gridy=4;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(10,0,20,0);
        btnInstructions.setActionCommand("instructions");
        btnInstructions.addActionListener(new ButtonListener());
        add (btnInstructions,layout);
        btnInstructions.setVisible (true);
        
        //option button
        btnOptions = new JButton ("OPTIONS");
        btnOptions.setFont(new Font("Serif", Font.PLAIN, 25));
        btnOptions.setForeground (Color.WHITE);
        btnOptions.setBackground (Color.BLACK);
        btnOptions.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        layout.gridx=0;
        layout.gridy=5;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(10,0,20,0);
        btnOptions.setActionCommand("options");
        btnOptions.addActionListener(new ButtonListener());
        add (btnOptions,layout);
        btnOptions.setVisible (true);
        
        //carnival button
        btnCarnival = new JButton ("BACK TO CARNIVAL");
        btnCarnival.setFont(new Font("Serif", Font.PLAIN, 25));
        btnCarnival.setForeground (Color.WHITE);
        btnCarnival.setBackground (Color.BLACK);
        btnCarnival.setBorder(BorderFactory.createLineBorder(Color.red));
        layout.gridx=0;
        layout.gridy=6;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(100,0,20,0);
        btnCarnival.setActionCommand("carnival");
        btnCarnival.addActionListener(new ButtonListener());
        add (btnCarnival,layout);
        btnCarnival.setVisible (true);
        
        // main menu
        btnMainMenu = new JButton ("MAIN MENU");
        btnMainMenu.setFont(new Font("Serif", Font.PLAIN, 25));
        btnMainMenu.setForeground (Color.WHITE);
        btnMainMenu.setBackground (Color.BLACK);
        btnMainMenu.setBorder(BorderFactory.createLineBorder(Color.red));
        layout.gridx=0;
        layout.gridy=8;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(100,0,20,0);
        btnMainMenu.setActionCommand("mainMenu");
        btnMainMenu.addActionListener(new ButtonListener());
        add (btnMainMenu,layout);
        btnMainMenu.setVisible (false);
        
        //instructions
        txtInstructions = new JTextArea ();
        txtInstructions.append ("This game will test your reflexes\n\n");
        txtInstructions.append ("Rules: Do not crash against the light wall.\n\n");
        txtInstructions.append ("Controls: Use the arrow keys to move in the specified direction(1 player) \n");
        txtInstructions.append ("                Use W,A,S,D to move (2 player)\n\n");
        txtInstructions.append ("Winning: Do not hit the light wall or leave battefiled. Player who lasts the longest wins\n\n");
        txtInstructions.append ("Go easy on my computer baby its drunk. DONT DRINK AND DRIVE");
        txtInstructions.setFont(new Font("Serif", Font.PLAIN, 25));
        txtInstructions.setEnabled (false);
        txtInstructions.setForeground (Color.WHITE);
        txtInstructions.setBackground (Color.BLACK);
        layout.gridx=0;
        layout.gridy=1;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(100,0,20,0);
        add (txtInstructions,layout);
        txtInstructions.setVisible (false);
        
        //options
        btnSound = new JToggleButton ("SOUND ON");
        layout.gridx=0;
        layout.gridy=7;
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.insets = new Insets(100,0,20,0);
        btnSound.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange()==ItemEvent.SELECTED){
                    btnSound.setText ("SOUND OFF");
                    sound=("OFF");
                } 
                else if(ie.getStateChange()==ItemEvent.DESELECTED){
                    btnSound.setText ("SOUND ON");
                    sound=("ON");
                }
            }
        });
        add (btnSound,layout);
        btnSound.setVisible (false);
        
        //Player 1
        lblPlayer1 = new JLabel("PLAYER 1");
        lblPlayer1.setFont(new Font("Serif", Font.PLAIN, 15));
        lblPlayer1.setForeground (Color.GREEN);
        lblPlayer1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 1;
        layout.insets = new Insets(0,10,20,100);
        add(lblPlayer1, layout);
        lblPlayer1.setVisible (false);
        
        txtPlayer1 = new JTextField (name1);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 2;
        layout.insets = new Insets(0,10,20,100);
        add(txtPlayer1, layout);
        txtPlayer1.setVisible (false);
        
        lblColour1 = new JLabel("COLOUR");
        lblColour1.setFont(new Font("Serif", Font.PLAIN, 15));
        lblColour1.setForeground (Color.ORANGE);
        lblColour1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 3;
        layout.insets = new Insets(0,10,20,100);
        add(lblColour1, layout);
        lblColour1.setVisible (false);
        
        btnGreen = new JRadioButton("Green"); 
        btnGreen.setActionCommand("green");
        btnGreen.setBackground (Color.BLACK);
        btnGreen.setForeground (Color.GREEN);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 4;
        layout.insets = new Insets(0,-0,10,100);
        btnGreen.setSelected(true); 
        btnGreen.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
        btnGreen.setVisible(false);
        add(btnGreen,layout); 
        
        btnRed = new JRadioButton("Red"); 
        btnRed.setActionCommand("red"); 
        btnRed.setAlignmentX(JRadioButton.CENTER_ALIGNMENT); 
        btnRed.setBackground (Color.BLACK);
        btnRed.setForeground (Color.RED);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 5;
        btnRed.setVisible(false);
        add(btnRed,layout); 
        
        btnWhite = new JRadioButton("White"); 
        btnWhite.setActionCommand("white"); 
        btnWhite.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
        btnWhite.setBackground (Color.BLACK);
        btnWhite.setForeground (Color.WHITE);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = -1;
        layout.gridy = 6;
        btnWhite.setVisible(false);
        add(btnWhite,layout);
        
        ButtonGroup group = new ButtonGroup(); 
        group.add(btnGreen); 
        group.add(btnRed); 
        group.add(btnWhite);  
          
        //Register a listener for the radio buttons 
        btnGreen.addActionListener((ActionListener) this); 
        btnRed.addActionListener((ActionListener) this); 
        btnWhite.addActionListener((ActionListener) this);
        
        //Player 2
        lblPlayer2 = new JLabel("PLAYER 2");
        lblPlayer2.setFont(new Font("Serif", Font.PLAIN, 15));
        lblPlayer2.setForeground (Color.ORANGE);
        lblPlayer2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 1;
        layout.insets = new Insets(0,10,20,10);
        add(lblPlayer2, layout);
        lblPlayer2.setVisible (false);
        
        txtPlayer2 = new JTextField (name2);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 2;
        layout.insets = new Insets(0,10,20,10);
        add(txtPlayer2, layout);
        txtPlayer2.setVisible (false);
        
        lblColour2 = new JLabel("COLOUR");
        lblColour2.setFont(new Font("Serif", Font.PLAIN, 15));
        lblColour2.setForeground (Color.ORANGE);
        lblColour2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 3;
        layout.insets = new Insets(0,10,20,10);
        add(lblColour2, layout);
        lblColour2.setVisible (false);
        
        btnYellow = new JRadioButton("Yellow"); 
        btnYellow.setActionCommand("yellow");
        btnYellow.setBackground (Color.BLACK);
        btnYellow.setForeground (Color.YELLOW);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 4;
        layout.insets = new Insets(0,-0,10,100);
        btnYellow.setSelected(true); 
        btnYellow.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
        btnYellow.setVisible(false);
        add(btnYellow,layout); 
        
        btnMagenta = new JRadioButton("Magenta"); 
        btnMagenta.setActionCommand("magenta"); 
        btnMagenta.setAlignmentX(JRadioButton.CENTER_ALIGNMENT); 
        btnMagenta.setBackground (Color.BLACK);
        btnMagenta.setForeground (Color.MAGENTA);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 5;
        btnMagenta.setVisible(false);
        add(btnMagenta,layout); 
        
        btnCyan = new JRadioButton("Cyan"); 
        btnCyan.setActionCommand("cyan"); 
        btnCyan.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
        btnCyan.setBackground (Color.BLACK);
        btnCyan.setForeground (Color.CYAN);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 2;
        layout.gridy = 6;
        btnCyan.setVisible(false);
        add(btnCyan,layout);
        
        ButtonGroup group1 = new ButtonGroup(); 
        group1.add(btnYellow); 
        group1.add(btnMagenta); 
        group1.add(btnCyan);  
          
        //Register a listener for the radio buttons 
        btnYellow.addActionListener((ActionListener) this); 
        btnMagenta.addActionListener((ActionListener) this); 
        btnCyan.addActionListener((ActionListener) this);
    }

    private class ButtonListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent ae) {
            String eventName = ae.getActionCommand(); 
            if (eventName.equals("1Player")){
                name1=txtPlayer1.getText();
                
                if (name1==""){
                    name1="Player1";
                }
                
                dispose();
                SingleGame run = new SingleGame (name1, colour1,point,item,ch);
            } 
            if (eventName.equals("2Player")){
                name1=txtPlayer1.getText();
                name2=txtPlayer2.getText();
                
                if (name1==""){
                    name1="Player1";
                }
                
                if (name2==""){
                    name2="Player2";
                }
                
                dispose();
                Game run = new Game (name1, name2, colour1, colour2, sound,point,item,ch);
            } 
            else if (eventName.equals ("computer")) {
                if (name1==""){
                    name1="Player1";
                }
                
                if (name2==""){
                    name2="Player2";
                }
                
                dispose();
                AIGame run = new AIGame (name1, name2, colour1, colour2, sound,point,item,ch);
            }
            else if (eventName.equals ("instructions")) { 
                btn1Player.setVisible(false);
                btn2Player.setVisible(false);
                btnComputer.setVisible(false);
                btnInstructions.setVisible(false);
                btnOptions.setVisible(false);
                btnCarnival.setVisible(false);
                lblPlayer1.setVisible(false);
                lblPlayer2.setVisible(false);
                txtPlayer1.setVisible (false);
                txtPlayer2.setVisible (false);
                lblColour1.setVisible (false);
                lblColour2.setVisible (false);
                btnGreen.setVisible(false);
                btnRed.setVisible(false);
                btnWhite.setVisible(false);
                btnYellow.setVisible (false);
                btnMagenta.setVisible (false);
                btnCyan.setVisible (false);
                btnSound.setVisible (false);
                
                btnMainMenu.setVisible (true);
                txtInstructions.setVisible(true);
            }
            else if (eventName.equals ("options")) { 
                btn1Player.setVisible(false);
                btn2Player.setVisible(false);
                btnComputer.setVisible(false);
                btnInstructions.setVisible(false);
                btnOptions.setVisible(false);
                btnCarnival.setVisible(false);
                
                btnYellow.setVisible (true);
                btnMagenta.setVisible (true);
                btnCyan.setVisible (true);
                btnGreen.setVisible(true);
                btnRed.setVisible(true);
                btnWhite.setVisible(true);
                lblPlayer1.setVisible(true);
                lblPlayer2.setVisible(true);
                btnMainMenu.setVisible (true);
                txtPlayer1.setVisible (true);
                txtPlayer2.setVisible (true);
                lblColour1.setVisible (true);
                lblColour2.setVisible (true);
                btnSound.setVisible (true);
            }
            
            else if (eventName.equals ("carnival")){
                dispose();
                Lingo back= new Lingo(point,item,ch);
            }
            else if (eventName.equals ("mainMenu")){
                btnMainMenu.setVisible (false);
                txtInstructions.setVisible(false);
                lblPlayer1.setVisible(false);
                lblPlayer2.setVisible(false);
                txtPlayer1.setVisible (false);
                txtPlayer2.setVisible (false);
                lblColour1.setVisible (false);
                lblColour2.setVisible (false);
                btnGreen.setVisible(false);
                btnRed.setVisible(false);
                btnWhite.setVisible(false);
                btnYellow.setVisible (false);
                btnMagenta.setVisible (false);
                btnCyan.setVisible (false);
                btnSound.setVisible (false);
                
                btn1Player.setVisible(true);
                btn2Player.setVisible(true);
                btnComputer.setVisible(true);
                btnInstructions.setVisible(true);
                btnOptions.setVisible(true);
                btnCarnival.setVisible(true);
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        if (event.equals ("green")){
            lblPlayer1.setForeground (Color.GREEN);
            colour1= "green";
        }
        else if (event.equals ("red")){
            lblPlayer1.setForeground (Color.RED);
            colour1= "red";
        }
        else if (event.equals ("white")){
            lblPlayer1.setForeground (Color.white);
            colour1= "white";
        }
        else if (event.equals ("yellow")){
            lblPlayer2.setForeground (Color.yellow);
            colour2= "yellow";
        }
        else if (event.equals ("magenta")){
            lblPlayer2.setForeground (Color.magenta);
            colour2= "magenta";
        }
        else if (event.equals ("cyan")){
            lblPlayer2.setForeground (Color.cyan);
            colour2= "cyan";
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
