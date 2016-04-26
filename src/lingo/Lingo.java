/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;

/**
 *
 * @author nacun6967
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author nayden cuncins
 */
public class Lingo extends JFrame implements KeyListener, Runnable  {
    
    JPanel panel1, panel2;
    JLabel player = new JLabel();    
    JTextArea text;
    ImageIcon icon = new ImageIcon("img/lingo ent.png");
    JLabel background= new JLabel(icon);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();    
    int x = screenSize.width, y = screenSize.height,speed = 10;
    int playerx=screenSize.width/2-40;
    int playery= 100;     
    Thread run;    
    
    JMenuBar mymbar;
    JMenu game, help, level;
    JButton duck,store,space;
    protected boolean start=true;
    int[] ch= new int[20];    
    int item=0,point=0;
    
    ImageIcon icon1 = new ImageIcon("img/square.png");
    JLabel square = new JLabel(icon1);
    ImageIcon icon2 = new ImageIcon("img/Spaceship.jpg");
    JLabel spaceship = new JLabel(icon2);
    ImageIcon icon3 = new ImageIcon("img/cow.png");
    JLabel cow = new JLabel(icon3);
    ImageIcon icon4 = new ImageIcon("img/fish.png");
    JLabel fish= new JLabel(icon4);
    ImageIcon icon5 = new ImageIcon("img/bird.png");
    JLabel bird= new JLabel(icon5);
    ImageIcon icon6 = new ImageIcon("img/red shp.png");
    JLabel red = new JLabel(icon6);
    ImageIcon icon7 = new ImageIcon("img/mario.gif");
    JLabel mario = new JLabel(icon7);
    ImageIcon icon8 = new ImageIcon("img/happy black.png");
    JLabel happyblack= new JLabel(icon8);
    ImageIcon icon9 = new ImageIcon("img/Mushroom.png");
    JLabel Mushroom = new JLabel(icon9);
    ImageIcon icon10 = new ImageIcon("img/cod.png");
    JLabel cod= new JLabel(icon10);
    ImageIcon icon11 = new ImageIcon("img/creeper.png");
    JLabel creeper = new JLabel(icon11);
    ImageIcon icon12 = new ImageIcon("img/squirtle.png");
    JLabel squirtle = new JLabel(icon12);
    ImageIcon icon13 = new ImageIcon("img/cry.gif");
    JLabel cry = new JLabel(icon13);
    ImageIcon icon14 = new ImageIcon("img/sonic.gif");
    JLabel sonic = new JLabel(icon14);
    ImageIcon icon15 = new ImageIcon("img/little big planet.png");
    JLabel planet = new JLabel(icon15); 
    ImageIcon icon16 = new ImageIcon("img/troll.gif");
    JLabel troll= new JLabel(icon16);
    ImageIcon icon17 = new ImageIcon("img/psy.gif");
    JLabel psy= new JLabel(icon17);
    ImageIcon icon18 = new ImageIcon("img/yes.gif");
    JLabel yes= new JLabel(icon18);
     ImageIcon icon19 = new ImageIcon("img/walk.gif");
    JLabel walk = new JLabel(icon19);
    ImageIcon icon20 = new ImageIcon("img/spg.gif");
    JLabel spg= new JLabel(icon20);
    
    public Lingo(){
        super("Lingo Ent.");        
        setSize(x, y-30);
        if(!(x==1440)){
         JOptionPane.showMessageDialog(null, "Please put the screen resolution\nto 1440,900");
        }
        //setLocationRelativeTo(null);
        panel1 = new JPanel();
        panel2 = new JPanel();       
        text = new JTextArea("\t\t\tWelcome to Lingo enteraimnent");
        text.setFont(text.getFont().deriveFont(25.0f));
        text.setEnabled(false);
        text.setBackground(Color.black);               
        // will make the player 
        Player();        
        //paint the background      
        background.setEnabled(true);
        background.setBounds(0,-80,x, y);
        background.setVisible(true);

        space= new JButton();
//        space.setBounds(100,460, 80, 80);        
//        space.setBackground(Color.green);
//        space.setEnabled(false);
//        panel1.add(space);
        panel1.add(background); 
        panel1.setLayout(null);
        panel2.setLayout(new GridLayout(0, 1));
        panel1.setBounds(0,0, x, y-150);       
        panel1.setBackground(Color.black);
        panel2.setBounds(0, y-150, x, 90);      
        panel2.setBackground(Color.RED);
        panel2.add(text);       
        getContentPane().setLayout(null);        
        add(panel1);       
        add(panel2); 
        //show();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        addKeyListener(this);        
        // start thread
        run = new Thread(this);
        run.start(); // go to run() method
        
    }   
    public Lingo(int point,int item,int itemch[]){
        super("Lingo Ent.");
        this.point= point;
        this.item=item;
        ch=itemch;
        
        setSize(x, y-30);
        //setLocationRelativeTo(null);
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        text = new JTextArea("\t\t\tWelcome to Lingo enteraimnent");
        text.setFont(text.getFont().deriveFont(25.0f));
        text.setEnabled(false);
        text.setBackground(Color.blue);               
        // will make the player 
        Player();
        
        background.setEnabled(true);
        background.setBounds(0,-80,x, y);
        background.setVisible(true);     

        panel1.add(background); 
        panel1.setLayout(null);
        
        panel2.setLayout(new GridLayout(0, 1));
        
        panel1.setBounds(0,0, x, y-150);        
        panel1.setBackground(Color.black);
        
        panel2.setBounds(0, y-150, x, 90);       
        panel2.add(text);
        
        getContentPane().setLayout(null);        
        add(panel1);       
        add(panel2); 
        //show();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        addKeyListener(this);        
        // start thread
        run = new Thread(this);
        run.start(); // go to run() method
        
    }   
    public void Player() {
        //player selected in the store
       if(item==0){
           player=square;
           panel1.add(player);
           player.setBounds(playerx, playery, 50, 50);
       }
        if(item==1){
           player=spaceship;
           panel1.add(player);
           player.setBounds(playerx, playery, 50, 50);
       }
        if(item==2){
            player=cow;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==3){
            player=fish;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==4){
            player=bird;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==5){
            player=red;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==6){
            player=mario;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==7){
            player=happyblack;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==8){
            player=Mushroom;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==9){
            player=cod;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==10){
            player=creeper;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==11){
            player=squirtle;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==12){
            player=cry;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==13){
            player=sonic;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==14){
            player=planet;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==15){
            player=troll;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==16){
            player=psy;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==17){
            player=yes;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==18){
            player=walk;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
        if(item==19){
            player=spg;
            panel1.add(player);
            player.setBounds(playerx, playery, 50, 50);            
        }
    }   
     void moveForward() {       
       
        player.setBounds(playerx, playery, 50, 50);
        panel1.repaint();
        show();
        
               
    }
    @Override
    public void keyPressed(KeyEvent e) {
        text.setText("\t\t\tPoints--->"+point);
        text.setFont(text.getFont().deriveFont(25.0f));
        //left
        if ( e.getKeyCode() == 37) {
            playerx+= -20;
            if (playerx <= 10) {
            playerx = 10;
            }
            player.setBounds(playerx, playery, 50, 50);
            
        }
         
        // move to up when plazyer pressed up arrow
        if (e.getKeyCode() == 38) {            
            playery += -20;
            if (playery<=10) {
            playery = 10;
            }
            player.setBounds(playerx, playery, 50, 50);
           
        }
        //  move to right when player pressed right arrow
        if (e.getKeyCode() == 39) {
            playerx += 20;
             if (playerx >= x-90) {
                   playerx = x-90;
             }
            player.setBounds(playerx, playery, 50, 50);
            
        }
        // move to down when player pressed down arrow
        if (e.getKeyCode() == 40) {            
            playery += 20;
            if (playery>= y-200) {
                 playery =y-200;
            }
            player.setBounds(playerx, playery, 50, 50);
        }
        //starts the duck game if player goes through here
        if(playerx<=1280 && playerx>=1200 && playery<=250 && playery>=170||playerx+50<=1280 && playerx+50>=1200 && playery+50<=250 && playery+50>=170){
            start=false;
            dispose();
            DuckHunt newGame= new DuckHunt(point,item,ch);           
        }
        //starts the store
        if(playerx<=1210 && playerx>=1130&& playery<=600 && playery>=520||playerx+50<=1210 && playerx+50>=1130 && playery+50<=600 && playery+50>=520){
            start=false;
            dispose();
            Store getStuff= new Store(point,item,ch);
        }
        //starts space flight
        if(playerx<=210 && playerx>=130 && playery<=220 && playery>=140||playerx+50<=210 && playerx+50>=130 && playery+50<=220 && playery+50>=140){
            start=false;
            dispose();
           Space newGame= new Space(point,item,ch);
        }
        //tron
        if(playerx<=180 && playerx>=100 && playery<=540 && playery>=460||playerx+50<=180 && playerx+50>=100 && playery+50<=540 && playery+50>=460){
            start=false;
            dispose();
            Tron run= new Tron(point,item,ch);
        }             
     }   
    @Override
    public void keyReleased(KeyEvent e) {} 
    @Override
    public void keyTyped(KeyEvent e) {} 
    
    @Override
    public void run() {
       while(start) {
           
           moveForward();
           try {
                Thread.sleep(speed);
           } 
           catch (InterruptedException ie) {
           }                      
       }
    }
  
    public static void main(String[] args) {
        Lingo start= new Lingo();        
     }    
}

