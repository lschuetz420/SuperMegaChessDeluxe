package chessgame.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chessgame.controller.ScreenController;
import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class BoardMenu extends Screen{

    private JButton buttonEndGame;

    private final JLabel labelCurrentTurnTEXT = new JLabel("Turn: ");
    private JLabel labelCurrentTurn;

    private final JLabel labelCurrentPlayerTEXT = new JLabel("Player: ");
    private JLabel labelCurrentPlayer;

    private BoardField[] takenPiecesWhite = new BoardField[16];
    private BoardField[] takenPiecesBlack = new BoardField[16];

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

        for (int i = 0; i < 16; i++){
            BoardField fieldWhite = new BoardField();
            panel.add(fieldWhite.getButtonObject());
            takenPiecesWhite[i] = fieldWhite;
            
            BoardField fieldBlack = new BoardField();
            panel.add(fieldBlack.getButtonObject());
            takenPiecesBlack[i] = fieldBlack;
        }
    }

    public void addToTakenWhitePieces(ChessPiece piece){
        for (int i = 0; i < 16; i++){
            if (takenPiecesWhite[i].getChessPiece() == null){
                takenPiecesWhite[i].setChessPiece(piece);
                break;
            }
        }
    }

    public void addToTakenBlackPieces(ChessPiece piece){
        for (int i = 0; i < 16; i++){
            if (takenPiecesBlack[i].getChessPiece() == null){
                takenPiecesBlack[i].setChessPiece(piece);
                break;
            }
        }
    }

    public void setTextLabelCurrentTurn(String text){
        labelCurrentTurn.setText(text);
    }

    public void setTextLabelCurrentPlayer(String text){
        labelCurrentPlayer.setText(text);
    }

    public JPanel getPanel(){
        return panel;
    }
}