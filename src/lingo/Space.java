/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lingo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Nayden
 */
public class Space extends JFrame {
   JPanel panel;
    JButton run,main;
    JLabel time, points;
    JTextArea help;
    boolean menu=true;
    int point;
    int item;
    int[] ch= new int[20];

    public Space(int point,int item,int itemch[]){
        
        //start up for the game
        super("Space Flight");
        this.item= item;
        this.point=point;
        ch=itemch;
        
        setSize(400,400);
        setVisible(true);            
        setDefaultCloseOperation(3);        
        setLocationRelativeTo(null);        
        panel= new JPanel();
        
        //new game
        run= new JButton("New Game");
        run.setFont(run.getFont().deriveFont(25.0f));        
        run.setActionCommand("new");
        run.addActionListener(new ButtonListener());
        
        //back to main menu
        main= new JButton("Back to Carnival");
        main.setFont(main.getFont().deriveFont(25.0f));
        main.setActionCommand("back");
        main.addActionListener(new ButtonListener());
        
        //help for the game
        help= new JTextArea();
        help.setText("Avoid the Asteriods by using the arrow keys \nGet the cans of fuel to add points and fuel\ndont let the fuel run out\nGOOD LUCK!");
        help.setEnabled(false);
        help.setDisabledTextColor(Color.black); 
        help.setBackground(Color.green);
        
        panel.add(run);
        panel.add(main);
        panel.add(help);
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.green);        
        add(panel);
      }
    //overload 
     public Space (int sec,int point,int item, int itemch[]){        
        //end game pop up
        super("Space Flight");
        this.item=item;
        ch=itemch;
        this.point=point;                 
        setSize(300,400);
        setVisible(true);            
        setDefaultCloseOperation(3);        
        setLocationRelativeTo(null);        
        panel= new JPanel();
        
        //display number of hits,the score, and the number of points
        time= new JLabel    ("time:        "+sec);
        points= new JLabel  ("points:      "+point);
        time.setFont(time.getFont().deriveFont(25.0f));
        points.setFont(points.getFont().deriveFont(25.0f));
        
        //new gmae
        run= new JButton("New Game");
        run.setFont(run.getFont().deriveFont(25.0f));
        run.setActionCommand("new");
        run.addActionListener(new ButtonListener());
        
        //back to the main menu
        main= new JButton("Back to Carnival");
        main.setFont(main.getFont().deriveFont(25.0f));
        main.setActionCommand("back");
        main.addActionListener(new ButtonListener());
        
        panel.add(time);       
        panel.add(points);
        panel.add(run);        
        panel.add(main);
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.green);
        add(panel);
                  
    }    
    
    private class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String event = ae.getActionCommand();
            if(event.equals("new")){                
                SpaceFlight newGame= new SpaceFlight(point,item,ch);               
                dispose();                
            }
            else if(event.equals("back")){
               Lingo back = new Lingo(point,item,ch);
               dispose();
            }
        }
    }  
    
    
}
