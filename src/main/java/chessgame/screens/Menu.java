package chessgame.screens;

import javax.swing.*;

import chessgame.controller.ScreenController;
import chessgame.objects.Player.Difficulty;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Screen{

    private ChessGameWindow window;

    private JButton buttonPlay;

    private JComboBox comboBoxModi;
    private JComboBox comboBoxDifficulty;
    private JComboBox comboBoxPlayerSelection;

    private JTextField textFieldNamePlayer1;
    private JTextField textFieldNamePlayer2;

    public Menu(ChessGameWindow window){
        this.window = window;
        createMenu();
        window.add(panel);
        window.pack();
        panel.setVisible(false);
    }

    public void createMenu(){
        buttonPlay = new JButton();
        buttonPlay.setSize(200, 200);
        buttonPlay.setText("Play");
        buttonPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (inputOK()){
                    ScreenController.getInstance().showBoardScreen();
                    ScreenController.getBoard().startGame(comboBoxModi.getSelectedItem().toString(),(Difficulty) comboBoxDifficulty.getSelectedItem(),comboBoxPlayerSelection.getSelectedItem().toString(),textFieldNamePlayer1.getText(),textFieldNamePlayer2.getText());
                }
            }
        });
        panel.add(buttonPlay);
        
        comboBoxDifficulty = new JComboBox<Difficulty>();
        comboBoxDifficulty.addItem(Difficulty.EASY);
        comboBoxDifficulty.addItem(Difficulty.MEDIUM);
        comboBoxDifficulty.addItem(Difficulty.HARD);
        panel.add(comboBoxDifficulty);
        
        comboBoxPlayerSelection = new JComboBox();
        comboBoxPlayerSelection.addItem("Player 1");
        comboBoxPlayerSelection.addItem("Player 2");
        panel.add(comboBoxPlayerSelection);

        textFieldNamePlayer1 = new JTextField();
        textFieldNamePlayer1.setToolTipText("Player 1");
        textFieldNamePlayer1.setPreferredSize(new Dimension(100,20));
        panel.add(textFieldNamePlayer1);
    
        textFieldNamePlayer2 = new JTextField();
        textFieldNamePlayer2.setToolTipText("Player 2");
        textFieldNamePlayer2.setPreferredSize(new Dimension(100,20));
        panel.add(textFieldNamePlayer2);

        comboBoxModi = new JComboBox<>();
        comboBoxModi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JComboBox comboBox = (JComboBox) e.getSource();
                String selected = (String) comboBox.getSelectedItem();
                if (selected.equals("Singleplayer")){
                    comboBoxDifficulty.setEnabled(true);
                    comboBoxPlayerSelection.setEnabled(true);
                    textFieldNamePlayer2.setEnabled(false);
                    textFieldNamePlayer1.setToolTipText("Player name");
                    textFieldNamePlayer2.setToolTipText("");
                } else {
                    comboBoxDifficulty.setEnabled(false);
                    comboBoxPlayerSelection.setEnabled(false);
                    textFieldNamePlayer2.setEnabled(true);
                    textFieldNamePlayer1.setToolTipText("Player 1");
                    textFieldNamePlayer2.setToolTipText("Player 2");
                }
            }
        });
        comboBoxModi.addItem("Singleplayer");
        comboBoxModi.addItem("Multiplayer");
        panel.add(comboBoxModi);
    }

    private boolean inputOK(){
        String mode = (String) comboBoxModi.getSelectedItem();        

        switch (mode){
            case "Singleplayer":
                if (textFieldNamePlayer1.getText().equals("")){
                    JOptionPane.showMessageDialog(buttonPlay, "Please enter a name", "Invalid input", JOptionPane.INFORMATION_MESSAGE);                    
                    return false;
                }
            break;

            case "Multiplayer":
                if (textFieldNamePlayer1.getText().equals("") | textFieldNamePlayer2.getText().equals("")){
                    JOptionPane.showMessageDialog(buttonPlay, "Please enter a name for Player 1 and Player 2", "Invalid input", JOptionPane.INFORMATION_MESSAGE);                    
                    return false;
                }
            break;
        }

        return true;
    }
}