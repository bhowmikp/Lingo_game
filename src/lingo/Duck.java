/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Nayden cuncins
 * starting code for the ai
 * http://zetcode.com/tutorials/javagamestutorial/snake/
 */
public class Duck extends JFrame implements MouseListener, Runnable {
    
    JPanel panel1, panel2,panel3;        
    JTextArea t;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int  speed = 100, score =0,diff=500,flightlength=30;
    //int x=600,y=500;
    int x = screenSize.width, y = screenSize.height-40;
    int duckx,ducky,miss=0,duckCount=0,hit=0,point,duckleft=10;
    int rand=(int)(Math.random()*8);   
    Thread run = new Thread(this);
    ImageIcon icon = new ImageIcon("img/duck-hunt.png");
    JLabel duck = new JLabel(icon);
    ImageIcon iconBullet = new ImageIcon("img/Bullet.jpg");
    JLabel bullet= new JLabel(iconBullet);
    JLabel bullet2= new JLabel(iconBullet);
    JLabel bullet3= new JLabel(iconBullet);
    String strike="\t\t\t";
    boolean start=true;
    JMenuBar mymbar;
    JMenu game,help;
    int item;
    int[] ch= new int[20];
    
    public Duck(int point,int item,int itemch[]){
        super("Duck Hunt");
        //keep trake of points
        this.point=point;
        this.item= item;
        ch=itemch;
        setSize(x,y);
        
       // setLocationRelativeTo(null);
        panel1 = new JPanel();        
        panel2 = new JPanel();
        panel3= new JPanel();
        
        creatbar();
        
        //add score to the game
        t = new JTextArea("Score->" + score+"\nDucks Left:"+duckleft);
        //no user needed
        t.setEnabled(false);
        t.setDisabledTextColor(Color.black);
        t.setFont(t.getFont().deriveFont(25.0f));
        t.setBackground(Color.green);
        
        //duck ai 
        newDuck();
        
        panel1.setLayout(null);       
        panel2.setLayout(new GridLayout(1, 0));
        //locations
        panel1.setBounds(0, 0, x, y-160);        
        panel2.setBounds(0, y-160, x,60 );
        panel3.setBounds(0, y-100, x, 40);
        //bullets
        panel3.add(bullet);
        panel3.add(bullet2);
        panel3.add(bullet3);
        panel2.add(t);        
        //colours
        panel1.setBackground(Color.blue);
        panel3.setBackground(Color.green);
        //add a mouse listener to panel so that i can have  a miss couter as well
        panel1.addMouseListener(this);
        //adding this to the frame
        getContentPane().setLayout(null);
        getContentPane().add(panel1);        
        getContentPane().add(panel2);
        getContentPane().add(panel3);        
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //thread start here
        run.start(); 
    } 
    
    
    public void newDuck() {          
        repositionDuck();      
    }
    
    public void repositionDuck() {
        panel1.add(duck);
        duck.setVisible(true);
        //puts teh duck in a random location on the panel
        duckx=(int)(Math.random()*800);
        ducky=(int)(Math.random()*600);
        //this is the size of area to click to hit the duck
        duck.setBounds(duckx, ducky, 70, 70);
        //add bullets to the thrird panel
        bullet.setVisible(true);
        bullet2.setVisible(true);
        bullet3.setVisible(true);
       
    }
    public void creatbar() {
        mymbar = new JMenuBar();
 
        game = new JMenu("Game");
 
        JMenuItem newgame = new JMenuItem("New Game");
        JMenuItem exit = new JMenuItem("Exit");
 
        newgame.addActionListener(
                new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //game reset
                        reset();
                    }
                });
 
        exit.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            //stops thread
            start=false;
            //back to home screen           
           DuckHunt newGame= new DuckHunt(point,item,ch);                  
            }
        });
 
        game.add(newgame);
        game.addSeparator();
        game.add(exit); 
        mymbar.add(game);        
        help = new JMenu("Help"); 
        JMenuItem creator = new JMenuItem("Instruction");
        creator.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "left click to shot\nyou have three bullets to shot the duck\nGOOD LUCK!");
            }
        }); 
        help.add(creator);        
        mymbar.add(help); 
        setJMenuBar(mymbar);
    }
 
    void reset() {        
        panel1.removeAll();         
        newDuck();
        score=0;
       
    }
    
     void moveForward() throws InterruptedException {
         //^ this is what the thread is used for
        
        duck.setBounds(duckx, ducky, 70, 70);        
         //repaint the screen
        panel1.repaint();
        show();
        //rand to pick location of the bird
        //left
         if (rand==0 ) {
            for(int i=0;i<=flightlength;i++){                
                duckx+= -5;
                ducky +=0;
                duck.setBounds(duckx, ducky, 70, 70);
                //this is so the duck goes not go off screen
                if (duckx <= 50) {
                    duckx = 50;
                    break;
                }
                //allows the program to make it look like the duck is moving and not just jumping
                run.sleep(5);                
            }
            //change diretions if at a wall
            if(duckx==50){
                rand=2;                
            }
            //next location 
            else{
               rand=(int)(Math.random()*8); 
            }
            //the game gets harder the more there is
            //this is the decision length
            run.sleep(diff);
             
        } 
         //up
        if (rand==1) {
            for(int i=0;i<=flightlength;i++){
                duckx += 0;
                ducky += -5;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky <=50) {
                    ducky = 50;
                    break;
                }        
                run.sleep(5);
            }
            if(ducky==50){
                rand=3;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
            run.sleep(diff);
          
        }
        //right
        if (rand==2 ) {
            for(int i=0;i<=flightlength;i++){
                duckx += 5; 
                ducky += 0;
                duck.setBounds(duckx, ducky, 70, 70);
                if (duckx>= x-100) {
                    duckx = x-100;
                    break;
                }
                run.sleep(5);
            }
            if(duckx==x-100){
                rand=0;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
           run.sleep(diff);
        } 
        //down
        if (rand==3 ) {
            for(int i=0;i<=flightlength;i++){
                duckx+= 0;
                ducky += 5;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky>= y-230) {
                    ducky = y-230;
                    break;
                }
                run.sleep(5);
            } 
            if(ducky==y-230){
                rand=1;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
             run.sleep(diff);
        }
        //bottom right
        if (rand==4 ) {
            for(int i=0;i<=flightlength*5;i++){
                duckx+= 1;
                ducky += 1;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky>= y-230) {
                    ducky = y-230;
                    break;
                }
                 if (duckx>= x-100) {
                    duckx = x-100;
                    break;
                }
                run.sleep(1);
            } 
            if(ducky==y-230){
                rand=1;                
            }
            if(ducky==x-100){
                rand=0;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
             run.sleep(diff);
        }
        //top right
        if (rand==5 ) {
            for(int i=0;i<=flightlength*5;i++){
                duckx+= 1;
                ducky += -1;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky<= 50) {
                    ducky = 50;
                    break;
                }
                 if (duckx>= x-100) {
                    duckx = x-100;
                    break;
                }
                run.sleep(1);
            } 
            if(ducky==50){
                rand=1;               
            }
            if(ducky==x-100){
                rand=0;               
            }
            else{
               rand=(int)(Math.random()*8); 
            }
             run.sleep(diff);
        }
        //top left
        if (rand==6 ) {
            for(int i=0;i<=flightlength*5;i++){
                duckx+= -1;
                ducky += -1;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky<=50) {
                    ducky = 50;
                    break;
                }
                 if (duckx<= 50) {
                    duckx = 50;
                    break;
                }
                run.sleep(1);
            } 
            if(ducky==50){
                rand=3;                
            }
            if(ducky==50){
                rand=2;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
             run.sleep(diff);
        }
        //botton left
        if (rand==7 ) {
            for(int i=0;i<=flightlength*5;i++){
                duckx+= -1;
                ducky += 1;
                duck.setBounds(duckx, ducky, 70, 70);
                if (ducky>= y-230) {
                    ducky = y-230;
                    break;
                }
                 if (duckx<= 50) {
                    duckx = 50;
                    break;
                }
                run.sleep(1);
            } 
            if(ducky==y-230){
                rand=1;                
            }
            if(ducky==50){
                rand=2;                
            }
            else{
               rand=(int)(Math.random()*8); 
            }
             run.sleep(diff);
        }
    }
    //thread
    @Override  
    public void run() {
        while(start) {
            try {                
                moveForward();
            } catch (InterruptedException ex) {
                Logger.getLogger(Duck.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //sleep of there is not an overload
                Thread.sleep(speed);
            } catch (InterruptedException ie) {
           }          
        }
    }
 
   
    @Override
    public void mouseClicked(MouseEvent e) {    }

    @Override
    public void mousePressed(MouseEvent e) {
        //if the player hits the duck
        //e.getY() gets the location of the mouse
        if(e.getY()<=(ducky+60)&&e.getY()>=(ducky)&&e.getX()<=(duckx+60)&&e.getX()>=(duckx)){ 
            duck.setVisible(false);
            //gets rid of the labels on the panel
            duck.removeAll();
            //score is added to the bored
            score+=100;            
            //number of ducks left
            duckleft--;
            //if you hit the duck a O will rep that
            strike+=" O";
            //setting the text
            t.setText("Score->"+score+"\t"+strike+"\nDucks Left:"+duckleft);
            t.setFont(t.getFont().deriveFont(25.0f));
            //makes the decision faster 
            if(diff>0){
            diff-=50;            
           } 
            //pop up menu to say that you ahve hit the duck
            JOptionPane.showMessageDialog(null, "HIT");            
            try {
                //wait time
                run.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Duck.class.getName()).log(Level.SEVERE, null, ex);
            }
            //new duck is called
            repositionDuck();
            //miss counter is reset
            miss=0;
            //number of ducks hit
            hit++;
            //number of ducks-10
            duckCount++;  
            
        }             
           
          else{
            //if missed
            miss++;
            //bullets on screen disappear
            if(miss==1){
                    bullet3.setVisible(false);
                }
                if(miss==2){
                    bullet2.setVisible(false);
                }
                if(miss==3){
                    bullet.setVisible(false);
                }
                //the duck wins and gets to go free is missed three shots
            if(miss==3){
                JOptionPane.showMessageDialog(null,"FLY AWAY");                
                miss=0;
                duckleft--;
                //rep a miss 
                strike+=" X";
                t.setText("Score->"+score+"\t"+strike+"\nDucks Left:"+duckleft);
                t.setFont(t.getFont().deriveFont(25.0f));
                if(diff>0){
                   diff-=50;            
                }                
                try {
                    run.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Duck.class.getName()).log(Level.SEVERE, null, ex);
                }
                duck.removeAll();
                repositionDuck();
                duckCount++;                
            }
        }
        //points 
        if(duckCount==10){
            //gets rid of the frame
            dispose();
            //stops thread
            start=false;
            //points for number of ducks shot
            if(hit==5){
                //brings up the menu
                DuckHunt endGame= new DuckHunt(hit,score,point+1,item,ch);
            }
            else if(hit==6){
                DuckHunt endGame= new DuckHunt(hit,score,point+2,item,ch);
            }
            else if(hit==7){
                DuckHunt endGame= new DuckHunt(hit,score,point+3,item,ch);
            }
            else if(hit==8){
                DuckHunt endGame= new DuckHunt(hit,score,point+4,item,ch);
            }
            else if(hit==8){
                DuckHunt endGame= new DuckHunt(hit,score,point+5,item,ch);
            }
            else if(hit==10){
                DuckHunt endGame= new DuckHunt(hit,score,point+6,item,ch);
            }
            else{
                 DuckHunt newGame= new DuckHunt(hit,score,point,item,ch);
            }      
        }      
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}    
}


