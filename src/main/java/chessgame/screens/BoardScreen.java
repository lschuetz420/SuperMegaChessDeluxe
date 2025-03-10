package chessgame.screens;

import javax.swing.*;

public class BoardScreen extends Screen {

    public BoardScreen(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    public JPanel getPanel(){
        return panel;
    }
}
