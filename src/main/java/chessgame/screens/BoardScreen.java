package chessgame.screens;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.*;

public class BoardScreen extends Screen {

    public BoardScreen(){
        panel.setLayout(new GridLayout());
    }

    public JPanel getPanel(){
        return panel;
    }

}
