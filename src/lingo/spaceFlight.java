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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author Nayden
 */
public class SpaceFlight extends JFrame implements KeyListener, Runnable {
    JPanel panel1,panel2;
    JLabel player = new JLabel();
    JLabel rock = new JLabel();
    JTextArea text= new JTextArea();
    JButton fuel;
    JProgressBar progress;   
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();    
    int x = screenSize.width, y = screenSize.height,speed = 1;
    int playerx=100;
    int playery= y/2;     
    Thread run,runrock;    
    
    JMenuBar mymbar;
    JMenu game, help, level;    
    protected boolean start=true;
    int[] ch= new int[20];    
    int item=0,point=10;
    
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
    
     ImageIcon icon21 = new ImageIcon("img/asteroid1.png");
    JLabel asteroid1 = new JLabel(icon21);
     ImageIcon icon22 = new ImageIcon("img/asteroid2.png");
    JLabel asteroid2 = new JLabel(icon22);
     ImageIcon icon23 = new ImageIcon("img/asteroid3.png");
    JLabel asteroid3 = new JLabel(icon23);
    
    int rocky,rockx,fuelx,fuely, rand=(int)(Math.random()*3);   
    int time=0,fuelleft=100,flight=500;
    boolean newCan=true,move=true;
      
    public SpaceFlight(int point,int item,int itemch[]){
       super("Space Flight");
        this.point= point;
        this.item=item;
        ch=itemch;        
        setSize(x, y-40);        
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        //progress bar fot the fuel
        progress = new JProgressBar();
        progress.setBackground(Color.red);
        progress.setString("Fuel Level");
        progress.setStringPainted(true);
        
        //time for the score
        text = new JTextArea("Time:"+time);
        text.setFont(text.getFont().deriveFont(25.0f));
        text.setEnabled(false);
        text.setBackground(Color.black);
        fuel= new JButton();
        fuel.setEnabled(false);
       
        // will make the player 
        Player();
        creatbar();
        
        panel1.setLayout(null);        
        panel2.setLayout(new GridLayout(0, 1));        
        panel1.setBounds(0,0, x, y-160);        
        panel1.setBackground(Color.black);        
        panel2.setBounds(0, y-160, x, 60);       
        
        panel2.add(text);
        panel2.add(progress);
        
        getContentPane().setLayout(null);        
        add(panel1);       
        add(panel2);      
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        addKeyListener(this);        
        // start thread
        run = new Thread(this);
        run.start(); // go to run() method
        
        
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
           Space newGame= new Space(point,item,ch);                  
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
                JOptionPane.showMessageDialog(null, "Avoid the Asteriods\nby using the arrow keys \nGet the cans of fuel to\nadd points and fuel\nGOOD LUCK!");
            }
        }); 
        help.add(creator);        
        mymbar.add(help); 
        setJMenuBar(mymbar);
    }
 
    void reset() {        
        panel1.removeAll();         
        newRock();
        Player();
        time=0;
       
    }  
    //fuel
    public void Progress(){
        //ever seconf 10 point of fuel is taken off
         fuelleft-=10;
         progress.setValue(fuelleft);        
         
    }
    public void Player() { 
        //player is the player selected in the store
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
    //rock is created there are three different ones
      public void newRock() {       
      
        if(rand==0){
            rock=asteroid1;     
        }
        else if(rand==1){
            rock=asteroid2;
        }
        else if(rand==2){    
            rock=asteroid3;
        }
         repositionRock();
    }
    //place the rock to the lelf side
    public void repositionRock() {
        panel1.add(rock);
        rock.setVisible(true);
        //set x value
        rockx=1700;
        //random y value
        rocky=(int)(Math.random()*(y-400))-100;      
        rock.setBounds(rockx, rocky,500,500);
        move=true;
       
    }
    //keeps the player on the screen
    void playerMove() {      
        player.setBounds(playerx, playery, 50, 50);
        panel1.repaint();
        show();
               
    }
    //main process
    //moves the rock and has the hit box
     void moveForward() throws InterruptedException {          
         panel1.repaint();
         show();
         //moves right
         for(int i=0;i<=flight;i++){               
            rockx=rockx -5;            
            rock.setBounds(rockx, rocky, 500, 500);          
            //this is so the rock goes not go off screen
            if (rockx <=-500) {
                rand=(int)(Math.random()*3);
                rock.removeAll();                
                newRock();              
                break;                    
            }
            //bug reset
            if(rockx==-5&&rocky==0){                
                rand=(int)(Math.random()*3);
                rock.removeAll();                
                newRock();              
                break;     
            }
            //hit box for asteroid 1
           if(rand==0){
            //for the x and y
            if(playerx<=rock.getX()+295 && playerx>=rock.getX()+80 && playery<=rock.getY()+500 && playery>=rock.getY()+50){
                //stops thread
                   start=false;
                   dispose();
                   //points is the time / by the 5 
                   point+=time/10;                   
                   Space newGame= new Space(time,point,item,ch);
                   break; 
            }
               //for the other side of the player
             if(playerx+50<=rock.getX()+295 && playerx+50>=rock.getX()+80 && playery+50<=rock.getY()+500 && playery+50>=rock.getY()+50){                    
                start=false;
                dispose();
                point+=time/10;                
                Space newGame= new Space(time,point,item,ch);
                break; 
            }
         }
            //ateroid 2
         if(rand==1){
            if(playerx<=rock.getX()+400 && playerx>=rock.getX()+80 && playery<=rock.getY()+375 && playery>=rock.getY()+80){                
                start=false;
                dispose();
                 point+=time/10;
                 Space newGame= new Space(time,point,item,ch);
                break; 
            }
            
             if(playerx+50<=rock.getX()+400 && playerx+50>=rock.getX()+80 && playery+50<=rock.getY()+375 && playery+50>=rock.getY()+80){                
                start=false;
                dispose();
                 point+=time/5;
                 Space newGame= new Space(time,point,item,ch);
                break; 
            }
         }
         //asteroid 3
         if(rand==2){
            if(playerx<=rock.getX()+300 && playerx>=rock.getX()+50 && playery<=rock.getY()+500 && playery>=rock.getY()){                
                start=false;
                dispose();
                point+=time/10;
                 Space newGame= new Space(time,point,item,ch);
                break; 
            }
            
             if(playerx+50<=rock.getX()+300 && playerx+50>=rock.getX()+50 && playery+50<=rock.getY()+500 && playery+50>=rock.getY()){                
                start=false;
                dispose();
                 point+=time/10;
                 Space newGame= new Space(time,point,item,ch);
                break; 
            }
             
         }
         //sets the fuel can
         if(newCan==true){           
            panel1.add(fuel);
            fuelx=(int)(Math.random()*800);
            fuely=(int)(Math.random()*600);
            fuel.setBounds(fuelx, fuely,10, 20);
            newCan=false; 
        }
         //hit box for the fuel can 
        if(playerx<=fuel.getX()+50 && playerx>=fuel.getX()-50 && playery<=fuel.getY()+50 && playery>=fuel.getY()-50){            
              //adds fuel to the progress bar
              fuelleft+=20;
              //time is the points 
              time+=5;
              fuel.removeAll();
              //only have a max fuel of 100
              if(fuelleft>100){
                 fuelleft=100;
               }  
              newCan=true;
             
          }            
         if(playerx+50<=fuel.getX()+50 && playerx+50>=fuel.getX()-50 && playery+50<=fuel.getY()+50 && playery+50>=fuel.getY()-50){             
                fuelleft+=20;
                time+=5; 
                fuel.removeAll();                
                if(fuelleft>100){
                    fuelleft=100;
                }       
                newCan=true;
                   
             }
          if(playerx<=fuel.getX()-50 && playerx>=fuel.getX()-50 && playery+50<=fuel.getY()+50 && playery+50>=fuel.getY()-50){            
              fuelleft+=20;
              time+=5;
              fuel.removeAll();              
              if(fuelleft>100){
                 fuelleft=100;
               }  
              newCan=true;
             
          }
           if(playerx+50<=fuel.getX()+50 && playerx+50>=fuel.getX()-50 && playery<=fuel.getY()+50 && playery>=fuel.getY()-50){          
              fuelleft+=20;
              time+=5;
              fuel.removeAll();              
              if(fuelleft>100){
                 fuelleft=100;
               }  
              newCan=true;
             
          }
           //if the fuel run out
            if(fuelleft==0){
              start=false;              
              dispose();              
              point+=time/10;                   
              Space newGame= new Space(time,point,item,ch);
              break;
              
         }
            //smooths the look
         run.sleep(5);
        
        }
        
       
                           
    }
     //clock
     public void Timer() throws InterruptedException {
         //prints ever sec to the screen
        Thread.sleep(989);
        time+=1;
        text.setText("Time:"+time);
            
     }
     //player movements
    @Override
    public void keyPressed(KeyEvent e) {
        
        //left
        if ( e.getKeyCode() == 37) {
            playerx+= -40;
            if (playerx <= 10) {
            playerx = 10;
            }
            player.setBounds(playerx, playery, 50, 50);
            
        }
         
        // move to up when plazyer pressed up arrow
        if (e.getKeyCode() == 38) {            
            playery += -40;
            if (playery<=10) {
            playery = 10;
            }
            player.setBounds(playerx, playery, 50, 50);
           
        }
        //  move to right when player pressed right arrow
        if (e.getKeyCode() == 39) {
            playerx += 40;
             if (playerx >= x-90) {
                   playerx = x-90;
             }
            player.setBounds(playerx, playery, 50, 50);
            
        }
        // move to down when player pressed down arrow
        if (e.getKeyCode() == 40) {            
            playery += 40;
            if (playery>= y-210) {
                 playery =y-210;
            }
            player.setBounds(playerx, playery, 50, 50);
        }     
     }
    @Override
    public void keyReleased(KeyEvent e) {} 
    @Override
    public void keyTyped(KeyEvent e) {} 
    
    @Override
    //thread
    public void run() {
       while(start) {
           try {              
               playerMove();               
               Timer();
               Progress();
               moveForward();              
           } catch (InterruptedException ex) {
               Logger.getLogger(SpaceFlight.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
                Thread.sleep(speed);
           } 
           catch (InterruptedException ie) {
           }                      
       }
    }   
}
