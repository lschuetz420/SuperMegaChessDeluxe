package chessgame.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chessgame.controller.ScreenController;

public class BoardMenu extends Screen{

    private JButton buttonEndGame;

    private final JLabel labelCurrentTurnTEXT = new JLabel("Turn: ");
    private JLabel labelCurrentTurn;

    private final JLabel labelCurrentPlayerTEXT = new JLabel("Player: ");
    private JLabel labelCurrentPlayer;

    public BoardMenu(){
        createBoardMenu();
        panel.setVisible(false);
    }

    private void createBoardMenu(){
        panel.add(labelCurrentTurnTEXT);
        labelCurrentTurn = new JLabel("1");
        panel.add(labelCurrentTurn);

        panel.add(labelCurrentPlayerTEXT);
        labelCurrentPlayer = new JLabel("Player1/White");
        panel.add(labelCurrentPlayer);

        buttonEndGame = new JButton();
        buttonEndGame.setSize(200,200);
        buttonEndGame.setText("END");
        buttonEndGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ScreenController.getInstance().showMenuScreen();
            }
        });
        panel.add(buttonEndGame);
    }
    
    public JPanel getPanel(){
        return panel;
    }
}