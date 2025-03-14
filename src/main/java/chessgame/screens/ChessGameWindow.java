package chessgame.screens;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class ChessGameWindow{

    public JFrame frame;

    public ChessGameWindow(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Game");
        frame.setSize(800,800);
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

    public void revalidate(){
        frame.revalidate();
    }

    public void repaint(){
        frame.repaint();
    }

    public void setLayout(LayoutManager manager){
        frame.setLayout(manager);
    }

    public void setSizeToDefault(){
        frame.setSize(800,800);
    }

    public void setSizeToFullScreen(){
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setSize(int x, int y){
        frame.setSize(x,y);
    }

    public void remove(Component component){
        frame.remove(component);
    }

    public Boolean hasComponent(Component component){
        Component[] components = frame.getComponents(); 
        Component checkComponent;
        Boolean returnValue = false;

        for (int i = 0; i < components.length; i++){
            checkComponent = components[i];
            if (checkComponent.getClass().getName().equals(component.getClass().getName())){
                returnValue = true;   
            } else if (i == components.length - 1 && checkComponent.getClass().getName().equals(component.getClass().getName()) == false){
                returnValue = false;
            }
        }

        return returnValue;
    }
}