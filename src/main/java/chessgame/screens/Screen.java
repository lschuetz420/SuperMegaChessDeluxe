package chessgame.screens;

import javax.swing.*;

import java.awt.Component;

public class Screen{

    public JPanel panel;

    public Screen(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
    }

    public void add(Component component){
        panel.add(component);
    }

    public void setVisible(boolean visible){
        panel.setVisible(visible);
    }

    public void setAllComponentsVisible(boolean visible){
        Component[] components = panel.getComponents();

        for (int i = 0; i < components.length; i++){
            JPanel panel = (JPanel) components[i]; 
            panel.setVisible(visible);
        }
    }

}