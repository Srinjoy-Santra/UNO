/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*import javax.media.*;
 
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;*/

/**
 *
 * @author nEW u
 */
public class FrontPage {
    JLabel heading,disp;
    JFrame frame;
    JButton newgame,exit;
    //Player player;
    public FrontPage() {
        frame = new JFrame("Front Page");
        //frame.setLayout(new FlowLayout());
        frame.setSize(1000,500);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        heading=new JLabel("UNO");
        disp=new JLabel();
        newgame=new JButton("New game");
        exit=new JButton("Exit");
        
        heading.setBounds(10, 10, 100, 50);
        newgame.setBounds(100,50,200,50);
        exit.setBounds(350, 50, 200, 50);
        
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disp.setText(e.getActionCommand());
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disp.setText(e.getActionCommand());
            }
        });
        
        frame.add(heading);
        frame.add(newgame);
        frame.add(exit);
        frame.add(disp);
        frame.setVisible(true);
    }
    
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {new FrontPage();}
        });
    }
    
}
