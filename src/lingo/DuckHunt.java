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
 * @author nayden cuncins
 */
public class DuckHunt extends JFrame{
    //JFrame frame;
    JPanel panel;
    JButton run,main;
    JLabel duckHit,duckScore, points;
    JTextArea help;
    boolean menu=true;
    int point;
    int item;
    int[] ch= new int[20];

    public DuckHunt(int point,int item,int itemch[]){
        
        //start up for the game
        super("Duck Hunt");
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
        run.setActionCommand("new");
        run.addActionListener(new ButtonListener());
        
        //back to main menu
        main= new JButton("Back to Carnival");
        main.setActionCommand("back");
        main.addActionListener(new ButtonListener());
        
        help= new JTextArea();
        help.setText("left click to shot\nyou have three bullets to shot the duck\nGOOD LUCK!");
        help.setEnabled(false);
        help.setDisabledTextColor(Color.black); 
        help.setBackground(Color.green);
        
        panel.add(run);
        panel.add(main);
        panel.add(help);
        panel.setLayout(new GridLayout(0,1));
        add(panel);
      }
    //overload 
     public DuckHunt(int hit,int score,int point,int item, int itemch[]){        
        //end game pop up
        super("Duck Hunt");
        this.item=item;
        ch=itemch;
        this.point=point; 
        
        setSize(200,400);
        setVisible(true);            
        setDefaultCloseOperation(3);        
        setLocationRelativeTo(null);        
        panel= new JPanel();
        
        //display number of hits,the score, and the number of points
        duckHit = new JLabel ("Hits:        "+hit); 
        duckScore= new JLabel("score:       "+score);
        points= new JLabel   ("points:      "+point);
        
        //new gmae
        run= new JButton("New Game");        
        run.setActionCommand("new");
        run.addActionListener(new ButtonListener());
        
        //back to the main menu
        main= new JButton("Back to Carnival");
        main.setActionCommand("back");
        main.addActionListener(new ButtonListener());
        
        panel.add(duckHit);
        panel.add(duckScore);
        panel.add(points);
        panel.add(run);        
        panel.add(main);
        panel.setLayout(new GridLayout(0,1));
        add(panel);
                  
    }    
    
    private class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String event = ae.getActionCommand();
            if(event.equals("new")){
                Duck newDuck= new Duck(point,item,ch);
                dispose();                
            }
            else if(event.equals("back")){
               Lingo back = new Lingo(point,item,ch);
               dispose();
            }
        }
    }  
    
}
