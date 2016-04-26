/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nayden
 */
public class Store extends JFrame implements Runnable{
    JPanel panel;   
    JButton[] buy= new JButton[20];   
    JButton back;
    JLabel points;
    int point;
    int[] ch = new int[20];
    int item;
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
    Thread check;
    boolean start=true;
    
    public Store(int point,int item,int itemch[]){
        super("Lingo ent. store");      
        ch=itemch;
        this.point= point;
        this.item= item;
        setSize(800,800);
        panel= new JPanel();
                
        //bring in the pic
        panel.add(square);
        panel.add(spaceship);
        panel.add(cow);
        panel.add(fish);
        
        //set up buttons        
        //5 points
        for(int i=0;i<=3;i++){            
            buy[i]= new JButton("Buy\n 5 points");
            panel.add(buy[i]);
            buy[i].addActionListener(new ButtonListener());
            buy[i].setActionCommand("buy"+i);
        }
        //test if you have already bought the icon
        for(int i=0;i<=19;i++){
            if(ch[i]==0){
                //set the text to select and a new action command
                buy[0].setText("select");
                buy[0].setActionCommand("select"+0);                
            }
            if(ch[i]==1){
                buy[1].setText("select");
                buy[1].setActionCommand("select"+1);                
            }
             if(ch[i]==2){
                buy[2].setText("select");
                buy[2].setActionCommand("select"+2);                
            }
             if(ch[i]==3){
                buy[3].setText("select");
                buy[3].setActionCommand("select"+3);                
            }
        }
         //bring in the pic
        panel.add(bird);
        panel.add(red);
        panel.add(mario);
        panel.add(happyblack);
        for(int i=4;i<=7;i++){            
            buy[i]= new JButton("Buy\n 10 points");
            panel.add(buy[i]);
            buy[i].addActionListener(new ButtonListener());
            buy[i].setActionCommand("buy"+i);
        }
        //test if you have already bought the icon
        for(int i=0;i<=19;i++){
            if(ch[i]==4){
                //set the text to select and a new action command
                buy[4].setText("select");
                buy[4].setActionCommand("select"+4);                
            }
            if(ch[i]==5){
                buy[5].setText("select");
                buy[5].setActionCommand("select"+5);                
            }
             if(ch[i]==6){
                buy[6].setText("select");
                buy[6].setActionCommand("select"+6);                
            }
             if(ch[i]==7){
                buy[7].setText("select");
                buy[7].setActionCommand("select"+7);                
            }
        }
        panel.add(Mushroom);
        panel.add(cod);
        panel.add(creeper);
        panel.add(squirtle);
        
        //set up buttons        
        //5 points
        for(int i=8;i<=11;i++){            
            buy[i]= new JButton("Buy\n 15 points");
            panel.add(buy[i]);
            buy[i].addActionListener(new ButtonListener());
            buy[i].setActionCommand("buy"+i);
        }
        //test if you have already bought the icon
        for(int i=0;i<=19;i++){
            if(ch[i]==8){
                //set the text to select and a new action command
                buy[8].setText("select");
                buy[8].setActionCommand("select"+8);                
            }
            if(ch[i]==9){
                buy[9].setText("select");
                buy[9].setActionCommand("select"+9);                
            }
             if(ch[i]==10){
                buy[10].setText("select");
                buy[10].setActionCommand("select"+10);                
            }
             if(ch[i]==11){
                buy[11].setText("select");
                buy[11].setActionCommand("select"+11);                
            }
        }
        panel.add(cry);
        panel.add(sonic);
        panel.add(planet);
        panel.add(troll);
        
        //set up buttons        
        //5 points
        for(int i=12;i<=15;i++){            
            buy[i]= new JButton("Buy\n 20 points");
            panel.add(buy[i]);
            buy[i].addActionListener(new ButtonListener());
            buy[i].setActionCommand("buy"+i);
        }
        //test if you have already bought the icon
        for(int i=0;i<=19;i++){
            if(ch[i]==12){
                //set the text to select and a new action command
                buy[12].setText("select");
                buy[12].setActionCommand("select"+12);                
            }
            if(ch[i]==13){
                buy[13].setText("select");
                buy[13].setActionCommand("select"+13);                
            }
             if(ch[i]==14){
                buy[14].setText("select");
                buy[14].setActionCommand("select"+14);                
            }
             if(ch[15]==3){
                buy[15].setText("select");
                buy[15].setActionCommand("select"+15);                
            }
        }
        panel.add(psy);
        panel.add(yes);
        panel.add(walk);
        panel.add(spg);
        
        //set up buttons        
        //5 points
        for(int i=16;i<=19;i++){            
            buy[i]= new JButton("Buy\n 25 points");
            panel.add(buy[i]);
            buy[i].addActionListener(new ButtonListener());
            buy[i].setActionCommand("buy"+i);
        }
        //test if you have already bought the icon
        for(int i=0;i<=19;i++){
            if(ch[i]==16){
                //set the text to select and a new action command
                buy[16].setText("select");
                buy[16].setActionCommand("select"+16);                
            }
            if(ch[i]==17){
                buy[17].setText("select");
                buy[17].setActionCommand("select"+17);                
            }
             if(ch[i]==18){
                buy[18].setText("select");
                buy[18].setActionCommand("select"+18);                
            }
             if(ch[i]==19){
                buy[19].setText("select");
                buy[19].setActionCommand("select"+19);                
            }
        }
        //button go back
        back= new JButton("Back to Carnival");       
        back.addActionListener(new ButtonListener());
        back.setActionCommand("back");  
        //points
        panel.add(back);
        points= new JLabel("   Points==>"+point);
        //turns the text white
        points.setEnabled(false);
        panel.add(points);
        panel.setLayout(new GridLayout(0,4));
        panel.setBackground(Color.black);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        //thread to show witch one is selected
        check= new Thread(this);
        check.start();
        
    }
    private class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String event = ae.getActionCommand(); 
            //back to lingo
            if(event.equals("back")){
                start=false;
                dispose();       
                Lingo back = new Lingo(point,item,ch);
                
            }
            //buy spaceship
            else if (event.equals("buy"+1)){
                if(point>=5){
                    item=1;
                    ch[1]=1;
                    //rest the text
                    buy[1].setText("select");
                    //new action command
                    buy[1].setActionCommand("select"+1);
                    //take away 5 points from player
                    point-=5;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                //if not enough points
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            //buy cry
            else if (event.equals("buy"+2)){  
                if(point>=5){
                    item=2;
                    ch[2]=2;
                    buy[2].setText("select");
                    buy[2].setActionCommand("select"+2);
                    point-=5;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
           else if (event.equals("buy"+3)){  
                if(point>=5){
                    item=3;
                    ch[3]=3;
                    buy[3].setText("select");
                    buy[3].setActionCommand("select"+3);
                    point-=5;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+4)){  
                if(point>=10){
                    item=4;
                    ch[4]=4;
                    buy[4].setText("select");
                    buy[4].setActionCommand("select"+4);
                    point-=10;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+5)){  
                if(point>=10){
                    item=5;
                    ch[5]=5;
                    buy[5].setText("select");
                    buy[5].setActionCommand("select"+5);
                    point-=10;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+6)){  
                if(point>=10){
                    item=6;
                    ch[6]=6;
                    buy[6].setText("select");
                    buy[6].setActionCommand("select"+6);
                    point-=10;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+7)){  
                if(point>=10){
                    item=7;
                    ch[7]=7;
                    buy[7].setText("select");
                    buy[7].setActionCommand("select"+7);
                    point-=10;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
                
            }
             else if (event.equals("buy"+8)){  
                if(point>=15){
                    item=8;
                    ch[8]=8;
                    buy[8].setText("select");
                    buy[8].setActionCommand("select"+8);
                    point-=15;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
           else if (event.equals("buy"+9)){  
                if(point>=15){
                    item=9;
                    ch[9]=9;
                    buy[9].setText("select");
                    buy[9].setActionCommand("select"+9);
                    point-=15;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+10)){  
                if(point>=15){
                    item=10;
                    ch[10]=10;
                    buy[10].setText("select");
                    buy[10].setActionCommand("select"+10);
                    point-=15;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
             else if (event.equals("buy"+11)){  
                if(point>=15){
                    item=11;
                    ch[11]=11;
                    buy[11].setText("select");
                    buy[11].setActionCommand("select"+11);
                    point-=15;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
              else if (event.equals("buy"+12)){  
                if(point>=20){
                    item=12;
                    ch[12]=12;
                    buy[12].setText("select");
                    buy[12].setActionCommand("select"+12);
                    point-=20;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
              else if (event.equals("buy"+13)){  
                if(point>=20){
                    item=13;
                    ch[13]=13;
                    buy[13].setText("select");
                    buy[13].setActionCommand("select"+13);
                    point-=20;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
              else if (event.equals("buy"+14)){  
                if(point>=20){
                    item=14;
                    ch[14]=14;
                    buy[14].setText("select");
                    buy[14].setActionCommand("select"+14);
                    point-=20;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
              else if (event.equals("buy"+15)){  
                if(point>=20){
                    item=15;
                    ch[15]=15;
                    buy[15].setText("select");
                    buy[15].setActionCommand("select"+15);
                    point-=20;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            else if (event.equals("buy"+16)){  
                if(point>=25){
                    item=16;
                    ch[16]=16;
                    buy[16].setText("select");
                    buy[16].setActionCommand("select"+16);
                    point-=25;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
              else if (event.equals("buy"+17)){  
                if(point>=25){
                    item=17;
                    ch[17]=17;
                    buy[17].setText("select");
                    buy[17].setActionCommand("select"+17);
                    point-=25;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
                else if (event.equals("buy"+18)){  
                if(point>=25){
                    item=18;
                    ch[18]=18;
                    buy[18].setText("select");
                    buy[18].setActionCommand("select"+18);
                    point-=25;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
                  else if (event.equals("buy"+19)){  
                if(point>=25){
                    item=19;
                    ch[19]=19;
                    buy[19].setText("select");
                    buy[19].setActionCommand("select"+19);
                    point-=25;
                    points.setText("   Points==>"+point);
                    points.setFont(points.getFont().deriveFont(25.0f));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not enough points");
                }
            }
            //set the player
            //square-starter
            else if(event.equals("select"+0)){              
                item=0;
            }
            //spaceship
            else if(event.equals("select"+1)){               
                item=1;
            }
            //cry
             else if(event.equals("select"+2)){                
                item=2;
            }else if(event.equals("select"+3)){                
                item=3;
            }else if(event.equals("select"+4)){                
                item=4;
            }else if(event.equals("select"+5)){                
                item=5;
            }else if(event.equals("select"+6)){                
                item=6;
            }else if(event.equals("select"+7)){                
                item=7;
            } else if(event.equals("select"+8)){                
                item=8;
            } else if(event.equals("select"+9)){                
                item=9;
            } else if(event.equals("select"+10)){                
                item=10;
            } else if(event.equals("select"+11)){                
                item=11;
            } else if(event.equals("select"+12)){                
                item=12;
            } else if(event.equals("select"+13)){                
                item=13;
            } else if(event.equals("select"+14)){                
                item=14;
            } else if(event.equals("select"+15)){                
                item=15;
            } else if(event.equals("select"+16)){                
                item=16;
            } else if(event.equals("select"+17)){                
                item=17;
            }else if(event.equals("select"+18)){                
                item=18;
            }else if(event.equals("select"+19)){                
                item=19;
            }           
        }
    }    
    @Override
    public void run() {
        //to show with cone is seleted with a red background
        while(start) {                         
                for(int i=0;i<=19;i++){
                    if(item==i){
                        buy[i].setBackground(Color.red);
                    }
                    else{
                        //everything else is white
                        buy[i].setBackground(Color.white);                       
                    }
                    
                }            
            try {
                //sleep of there is not an overload
                Thread.sleep(100);
            } catch (InterruptedException ie) {
           }          
        }
    }
    
}