package chessgame.screens;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class ChessGameWindow{

    public JFrame frame;

    public ChessGameWindow(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Game");
    }

    public void pack(){
        frame.pack();
    }

    public void add(Component component){
        frame.add(component);
    }

    public void add(Component component, String constraints){
        frame.add(component, constraints);
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }

    public void setSizeToStandard(){
        frame.setSize(500, 500);
    }

}