package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame  extends JFrame {
    JButton aereoButton = new JButton("Aereo");
    JButton aeroportoButton = new JButton("Aeroporto");
    JButton voloButton = new JButton("Volo");

    public MainFrame(){
        super("Benvenuti");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(aereoButton);
        c.add(aeroportoButton);
        c.add(voloButton);


        aereoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              AereoFrame frame = new AereoFrame();
              frame.setVisible(true);
            }
        });
        
        aeroportoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              AeroportoFrame frame = new AeroportoFrame();
              frame.setVisible(true);
            }
        });
        
        voloButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              VoloFrame frame = new VoloFrame();
              frame.setVisible(true);
            }
        });
        
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
