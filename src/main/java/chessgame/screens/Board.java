package chessgame.screens;

import javax.swing.*;

import chessgame.objects.*;
import chessgame.screens.ChessGameWindow;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class Board extends Screen{  
    private ChessGameWindow window;

    private Player player1 = null;
    private Player player2 = null;
    private Player activeTurnPlayer = null;

    private BoardField[][] fields = new BoardField[8][8]; 

    private int turnCounter = 1;
    private boolean gameON;



    private Pawn whitePawn1;
    private Pawn whitePawn2;
    private Pawn whitePawn3;
    private Pawn whitePawn4;
    private Pawn whitePawn5;
    private Pawn whitePawn6;
    private Pawn whitePawn7;
    private Pawn whitePawn8;

    private Rook whiteRook1;
    private Rook whiteRook2;

    private Knight whiteKnight1;
    private Knight whiteKnight2;

    private Bishop whiteBishop1;
    private Bishop whiteBishop2;

    private Queen whiteQueen;

    private King whiteKing;



    private Pawn blackPawn1;
    private Pawn blackPawn2;
    private Pawn blackPawn3;
    private Pawn blackPawn4;
    private Pawn blackPawn5;
    private Pawn blackPawn6;
    private Pawn blackPawn7;
    private Pawn blackPawn8;

    private Rook blackRook1;
    private Rook blackRook2;

    private Knight blackKnight1;
    private Knight blackKnight2;

    private Bishop blackBishop1;
    private Bishop blackBishop2;

    private Queen blackQueen;

    private King blackKing;


    
    public Board(ChessGameWindow window){
        panel.setLayout(new GridLayout(8,8));
        this.window = window;
        createBoard();
        window.add(panel);
        window.pack();
        panel.setVisible(false);
    }

    public void createBoard(){

        for (int i = 7; i > -1; i--){
            for (int j = 0; j < fields[i].length; j++){

                fields[i][j] = new BoardField();
                int N = i + 1;
                int L = j + 1;
                fields[i][j].setPositionInfo(N + "S" + L);
                fields[i][j].setSize(50, 50);

                fields[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        doFieldClickResponse(e);
                    }
                });

                panel.add(fields[i][j].getButtonObject());
            }
        }

        for (int i = 0; i < fields.length;i = i + 2){
            for (int j = 0; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(245, 245, 220));
                fields[i][j].setOpaque(true);
            }
        }
        
        for (int i = 1; i < fields.length;i = i + 2){
            for (int j = 1; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(245, 245, 220));
                fields[i][j].setOpaque(true);
            }
        }

        for (int i = 0; i < fields.length;i = i + 2){
            for (int j = 1; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(150, 111, 51));
                fields[i][j].setOpaque(true);
            }
        }
        
        for (int i = 1; i < fields.length;i = i + 2){
            for (int j = 0; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(150, 111, 51));
                fields[i][j].setOpaque(true);
            }
        }
    }

    private void doFieldClickResponse(ActionEvent e){
        BoardField field = new BoardField((JButton) e.getSource());
        System.out.println(field.getPositionInfo());
        if (field.getChessPiece() == null){
        
        } else if (field.getChessPiece().getColor() != activeTurnPlayer.getColor()){

        } else {
            String fieldName = field.getPositionInfo();
            String[] numbers = fieldName.split("S");

            int fieldNumber = Integer.parseInt(numbers[0]);
            int fieldLetter = Integer.parseInt(numbers[1]);
        }

    }
    
    public void startGame(String mode, String difficulty, String playerSelection, String namePlayer1, String namePlayer2){
        turnCounter = 1;
        activeTurnPlayer = player1;      
        gameON = true;

        whitePawn1 = new Pawn();
        
    }
}