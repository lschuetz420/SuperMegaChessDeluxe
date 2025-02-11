package chessgame.screens;

import javax.swing.*;

public class Menu extends Screen{

    private JPanel panel;
    private JFrame frame;
    private JButton buttonPlay;
    private JComboBox comboBoxModi;
    private JComboBox comboBoxDifficulty;

    public Menu(){
        buttonPlay = new JButton();

        comboBoxModi = new JComboBox<>();
        
        comboBoxDifficulty = new JComboBox();
    }
}