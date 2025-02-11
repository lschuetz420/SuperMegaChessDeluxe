package chessgame.screens;

import javax.swing.*;

public class Screen{

    public JFrame frame;
    public JPanel panel;

    public Screen(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Game");
        frame.pack();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }

    
}