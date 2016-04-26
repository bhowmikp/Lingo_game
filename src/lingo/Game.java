/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author prantar
 */
public class Game extends JFrame implements KeyListener, Runnable {
    
    JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = screenSize.width, y = screenSize.height;      // contentPane
    int speed = 15;             // speed of game
    Thread thread; 
    boolean start=true;
    
    // same for both bike
    int bikeSpeed = 10, bikeLength1=3, bikeLength2=3;   // speed and length of bike
    
    // player 1
    int direction1x=0, direction1y=0;
    boolean runLeft1, runRight1, runUp1, runDown1;
    int[] lbx1 = new int[3000];
    int[] lby1 = new int[3000];
    Point[] lbp1 = new Point[3000];
    JButton[] player1 = new JButton[3000];
    
    // player 2
    int direction2x=0, direction2y=0;
    boolean runLeft2, runRight2, runUp2, runDown2;
    int[] lbx2 = new int[3000];
    int[] lby2 = new int[3000];
    Point[] lbp2 = new Point[3000];
    JButton[] player2 = new JButton[3000];
    
    String name1, name2, colour1, colour2, sound;
    int[] ch= new int[20];    
    int item,point;
    

    public Game(String name1, String name2, String colour1, String colour2, String sound,int point,int item,int itemch[]){
        super("TRON");
         this.point= point;
        this.item=item;
        ch=itemch;
        this.name1=name1;
        this.name2=name2;
        this.colour1=colour1;
        this.colour2=colour2;
        this.sound=sound;
        
        reset1();
        reset2();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        
        // will make the player 
        Bike1(colour1);
        Bike2 (colour2);

        contentPane.setLayout(null);
        contentPane.setBounds(0,0, x, y);       
        contentPane.setBackground(Color.black);     
        getContentPane().setLayout(null);       
        getContentPane().add(contentPane);       
        show();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setFocusable(true);
        addKeyListener(this);        
        // start thread
        thread = new Thread(this);
        thread.start(); // go to run() method
    }
    
    
    public void reset1() {
        lbx1[0] = x-1200;
        lby1[0] = y-500;
        direction1x = bikeSpeed;
        direction1y = 0;
        runLeft1 = false;
        runRight1 = false;
        runUp1 = true;
        runDown1 = true;
    }
    
    public void light1() {
        player1[bikeLength1] = new JButton();        
        player1[bikeLength1].setEnabled(false);
        contentPane.add(player1[bikeLength1]);       
        
        lbx1[bikeLength1] = 10;
        lby1[bikeLength1] = 10;
        player1[bikeLength1].setBounds(10, 10, 10, 10);
 
        bikeLength1++;
    }
        
    public void Bike1(String colour1) {
        for (int count =0; count<3; count++){
            player1[count] = new JButton();
            player1[count].setEnabled(false);
            if (colour1.equals("green")){
                player1[count].setBackground(Color.GREEN);
            }
            else if(colour1.equals("red")){
                player1[count].setBackground(Color.RED);
            }
            else if (colour1.equals("white")){
                player1[count].setBackground(Color.WHITE);
            }
            contentPane.add(player1[count]);
            player1[count].setBounds(lbx1[count], lby1[count], 10, 10);
            lbx1[count + 1] = lbx1[count] - 10;
            lby1[count + 1] = lby1[count];
        }
    }
    
    public void moveForward1() {      
        light1();
        for (int i = 0; i < bikeLength1; i++) {
            lbp1[i] = player1[i].getLocation();
        }
 
       for (int i = bikeLength1-1; i < bikeLength1; i++) {
            player1[i].setBackground(Color.ORANGE);
        }
                
        lbx1[0] += direction1x;
        lby1[0] += direction1y;
        player1[0].setBounds(lbx1[0], lby1[0], 10, 10);
 
        for (int i = 1; i < bikeLength1; i++) {
            player1[i].setLocation(lbp1[i - 1]);
        }
        
        collision();
    }
    
    public void reset2() {
        lbx2[0] = x-100;
        lby2[0] = y-500;
        direction2x = -bikeSpeed;
        direction2y = 0;
        runLeft2 = false;
        runRight2 = false;
        runUp2 = true;
        runDown2 = true;
    }
    
    public void light2() {
        player2[bikeLength2] = new JButton();        
        player2[bikeLength2].setEnabled(false);
        contentPane.add(player2[bikeLength2]);       
        
        lbx2[bikeLength2] = 10;
        lby2[bikeLength2] = 10;
        player2[bikeLength2].setBounds(10, 10, 10, 10);
 
        bikeLength2++;
    }
        
    public void Bike2(String colour2) {
        for (int count =0; count<3; count++){
            player2[count] = new JButton();
            player2[count].setEnabled(false);
            if (colour2.equals("yellow")){
                player2[count].setBackground(Color.YELLOW);
            }
            else if(colour2.equals("magenta")){
                player2[count].setBackground(Color.MAGENTA);
            }
            else if (colour2.equals("cyan")){
                player2[count].setBackground(Color.CYAN);
            }
            contentPane.add(player2[count]);
            player2[count].setBounds(lbx2[count], lby2[count], 10, 10);
            lbx2[count + 1] = lbx2[count] + 10;
            lby2[count + 1] = lby2[count];
        }
    }
    
    public void moveForward2() {      
        light2();
        for (int i = 0; i < bikeLength2; i++) {
            lbp2[i] = player2[i].getLocation();
        }
 
        for (int i = bikeLength2-1; i < bikeLength2; i++) {
            player2[i].setBackground(Color.BLUE);
        }
                
        lbx2[0] += direction2x;
        lby2[0] += direction2y;
        player2[0].setBounds(lbx2[0], lby2[0], 10, 10);
 
        for (int i = 1; i < bikeLength2; i++) {
            player2[i].setLocation(lbp2[i - 1]);
        }
        
        collision();
    }
    
    public void collision(){
        for (int i = 1; i < bikeLength2; i++) {
            if (player1[0].getLocation().equals( player1[i].getLocation() )) {// Self inflict 1st player
                JOptionPane.showMessageDialog(null, name1+" LOSE (HIT HIMSELF)");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
            
            if ((lbx1[0] <= 0)||(lbx1[0] >= x)||(lby1[0] <= 0)||(lby1[0] >= y)) {      // player 1 boundaries
                JOptionPane.showMessageDialog(null, name1+" LOSE (HIT BOUNDARY)");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
            
           if (player1[0].getLocation().equals( player2[0].getLocation() )) {  // Head on 
                JOptionPane.showMessageDialog(null, "BOTH LOSE (HEAD ON COLLISION)");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
                    
            if (player2[0].getLocation().equals(player2[i].getLocation() )) {// Self inflict 2nd player
                JOptionPane.showMessageDialog(null, name2+" LOSE (HIT HIMSELF)");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
                       
            if ((lbx2[0] <= 0)||(lbx2[0] >= x)||(lby2[0] <= 0)||(lby2[0] >=y)) {      // player 2 boundaries
                JOptionPane.showMessageDialog(null, name2+" LOSE (HIT BOUNDARY)");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
            
            if (player1[0].getLocation().equals( player2[i].getLocation() )) {// 1st player touch second player
                JOptionPane.showMessageDialog(null, name1+ " LOSE (HIT "+ name2 +")");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                } 
                break;
            }
            
            if (player2[0].getLocation().equals( player1[i].getLocation() )) {// Second player touch 1st player
                JOptionPane.showMessageDialog(null, name2+ " LOSE (HIT "+ name1 +")");
                Tron run = new Tron (name1, colour1, name2, colour2, sound,point,item,ch);
                dispose();
                
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //  move to left when player pressed left arrow
        if (runLeft2 == true && e.getKeyCode() == 37) {
            direction2x = -bikeSpeed; // means snake move right to left by 10pixels
            direction2y = 0;
            runRight2 = false;     // run right(runr) means snake cant move from left to right
            runUp2 = true;      // run up   (runu) means snake can move from down to up
            runDown2 = true;      // run down (run down) means snake can move from up to down
        }
        // snake move to up when player pressed up arrow
        if (runUp2 == true && e.getKeyCode() == 38) {
            direction2x = 0;
            direction2y = -bikeSpeed; // means snake move from down to up by 10 pixel
            runDown2 = false;     // run down (run down) means snake can move from up to down
            runRight2 = true;      // run right(runr) means snake can move from left to right
            runLeft2 = true;      // run left (runl) means snake can move from right to left
        }
        // snake move to right when player pressed right arrow
        if (runRight2 == true && e.getKeyCode() == 39) {
            direction2x = +bikeSpeed; // means snake move from left to right by 10 pixel
            direction2y = 0;
            runLeft2 = false;
            runUp2 = true;
            runDown2 = true;
        }
        // snake move to down when player pressed down arrow
        if (runDown2 == true && e.getKeyCode() == 40) {
            direction2x = 0;
            direction2y = +bikeSpeed; // means snake move from left to right by 10 pixel
            runUp2 = false;
            runRight2 = true;
            runLeft2 = true;
        }
        
        // A=left
        if (runLeft1 == true && e.getKeyCode() == 65) {
            direction1x = -bikeSpeed; // means snake move right to left by 10pixels
            direction1y = 0;
            runRight1 = false;     // run right(runr) means snake cant move from left to right
            runUp1 = true;      // run up   (runu) means snake can move from down to up
            runDown1 = true;      // run down (run down) means snake can move from up to down
        }
        // W=up
        if (runUp1 == true && e.getKeyCode() == 87) {
            direction1x = 0;
            direction1y = -bikeSpeed; // means snake move from down to up by 10 pixel
            runDown1 = false;     // run down (run down) means snake can move from up to down
            runRight1 = true;      // run right(runr) means snake can move from left to right
            runLeft1 = true;      // run left (runl) means snake can move from right to left
        }
        // D= right
        if (runRight1 == true && e.getKeyCode() == 68) {
            direction1x = +bikeSpeed; // means snake move from left to right by 10 pixel
            direction1y = 0;
            runLeft1 = false;
            runUp1 = true;
            runDown1 = true;
        }
        // S=down
        if (runDown1 == true && e.getKeyCode() == 83) {
            direction1x = 0;
            direction1y = +bikeSpeed; // means snake move from left to right by 10 pixel
            runUp1 = false;
            runRight1 = true;
            runLeft1 = true;
        }
     }
    
    @Override
    public void keyReleased(KeyEvent e) {} 
    @Override
    public void keyTyped(KeyEvent e) {} 
    
    @Override
    public void run() {
       while(start) {
           
           moveForward1();
           moveForward2();
           try {
                Thread.sleep(speed);
           } 
           catch (InterruptedException ie) {
           }                      
       }
       
    } 
}

