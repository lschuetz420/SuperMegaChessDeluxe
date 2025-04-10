package chessgame.screens;

import java.util.ArrayList;

import javax.swing.*;
import javax.xml.crypto.KeySelectorException;

import chessgame.objects.*;
import chessgame.objects.chesspieces.Bishop;
import chessgame.objects.chesspieces.King;
import chessgame.objects.chesspieces.Knight;
import chessgame.objects.chesspieces.Pawn;
import chessgame.objects.chesspieces.Queen;
import chessgame.objects.chesspieces.Rook;
import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;
import chessgame.objects.widgets.Player;
import chessgame.objects.widgets.ChessPiece.PieceColor;
import chessgame.objects.widgets.ChessPiece.Piece;
import chessgame.objects.widgets.Player.Difficulty;
import chessgame.objects.widgets.Player.Type;
import chessgame.screens.ChessGameWindow;
import chessgame.controller.ScreenController;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class Board extends Screen{
    
    private ChessGameWindow window;

    private Player player1;
    private Player player2;
    private Player activeTurnPlayer;

    private BoardField[][] fields = new BoardField[8][8]; 

    private int turnCounter = 1;
    private boolean gameON;
    private ChessPiece selectedPiece = null;
    private BoardField lastSelectedField;

    private Pawn[] whitePawns;

    private Rook whiteRook1;
    private Rook whiteRook2;

    private Knight whiteKnight1;
    private Knight whiteKnight2;

    private Bishop whiteBishop1;
    private Bishop whiteBishop2;

    private Queen whiteQueen;

    private King whiteKing;



    private Pawn[] blackPawns;

    private Rook blackRook1;
    private Rook blackRook2;

    private Knight blackKnight1;
    private Knight blackKnight2;

    private Bishop blackBishop1;
    private Bishop blackBishop2;

    private Queen blackQueen;

    private King blackKing;



    public Board(){
        panel.setLayout(new GridLayout(8,8));
        createBoard();
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
        resetBoardColors();
    }

    private void resetBoardColors(){
        for (int i = 0; i < fields.length;i = i + 2){
            for (int j = 0; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(150, 111, 51));
                fields[i][j].setOpaque(true);
            }
        }
        
        for (int i = 1; i < fields.length;i = i + 2){
            for (int j = 1; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(150, 111, 51));
                fields[i][j].setOpaque(true);
            }
        }
        
        for (int i = 0; i < fields.length;i = i + 2){
            for (int j = 1; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(245, 245, 220));
                fields[i][j].setOpaque(true);
            }
        }
        
        for (int i = 1; i < fields.length;i = i + 2){
            for (int j = 0; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(245, 245, 220));
                fields[i][j].setOpaque(true);
            }
        }
    }

    private void doFieldClickResponse(ActionEvent e){
        BoardField selectedField = new BoardField((JButton) e.getSource());

        String fieldName = selectedField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        ChessPiece chessPiece = fields[fieldNumber - 1][fieldLetter - 1].getChessPiece();
        
        Color lastColor;

        if (selectedPiece == null){
            if (chessPiece == null){    
            
            } else if (chessPiece.getColor() != activeTurnPlayer.getColor()){
            
            } else {
                selectedPiece = chessPiece;
                lastSelectedField = selectedField;
                ArrayList<BoardField> fieldsP = null;
                if (chessPiece.getType() == Piece.PAWN){
                    fieldsP = chessPiece.getPossibleFields(selectedField, chessPiece.getColor());
                } else {
                    fieldsP = chessPiece.getPossibleFields(selectedField);
                }
    
                for (int i = 0; i < fieldsP.size(); i++){
                    BoardField fieldP = fieldsP.get(i);   
                    
                    String fieldNameP = fieldP.getPositionInfo();
                    String[] numbersP = fieldNameP.split("S");
    
                    int fieldNumberP = Integer.parseInt(numbersP[0]);
                    int fieldLetterP = Integer.parseInt(numbersP[1]);
    
                    fields[fieldNumberP - 1][fieldLetterP - 1].setBackgroundColor(Color.GREEN);
                }
            }
        } else if (selectedPiece != null && selectedField.getBackgroundColor() == Color.GREEN && selectedField.getChessPiece().getColor() != activeTurnPlayer.getColor()){
            ChessPiece lastPiece = fields[fieldNumber - 1][fieldLetter - 1].setCurrentGetLastChessPiece(selectedPiece);
            
            String fieldNameLast = lastSelectedField.getPositionInfo();
            String[] numbersLast = fieldNameLast.split("S");
            
            int fieldNumberLast = Integer.parseInt(numbersLast[0]);
            int fieldLetterLast = Integer.parseInt(numbersLast[1]);
            
            fields[fieldNumberLast - 1][fieldLetterLast - 1].setChessPiece(null);
            
            if (lastPiece != null){
                switch(lastPiece.getColor()){
                    case WHITE:
                        ScreenController.getInstance().getBoardMenu().addToTakenWhitePieces(lastPiece);
                    break;

                    case BLACK:
                        ScreenController.getInstance().getBoardMenu().addToTakenBlackPieces(lastPiece);
                    break;
                }
            }

            selectedPiece = null;
            changeActiveTurnPlayer();
            resetBoardColors();
        } else if (selectedPiece != null && selectedField.getBackgroundColor() != Color.GREEN){
            selectedPiece = null;
            resetBoardColors();
        } 
    }
    
    public void startGame(String mode, Difficulty difficulty, String playerSelection, String namePlayer1, String namePlayer2){
        
        switch(mode){
            case "Singleplayer":
                switch(playerSelection){
                    case "Player 1":
                        player1 = new Player(namePlayer1, PieceColor.WHITE, Type.HUMAN, null);
                        player2 = new Player("AI",PieceColor.BLACK, Type.AI, difficulty);
                    break;

                    case "Player 2":
                        player1 = new Player("AI", PieceColor.BLACK, Type.AI, difficulty);
                        player2 = new Player(namePlayer2,PieceColor.BLACK, Type.HUMAN, null);
                    break;
                }
            break;

            case "Multiplayer":
                player1 = new Player(namePlayer1,PieceColor.WHITE, Type.HUMAN, null);
                player2 = new Player(namePlayer2,PieceColor.BLACK, Type.HUMAN, null);
            break;
        }
        
        activeTurnPlayer = player1;      
        turnCounter = 1;
        gameON = true;
        
        createPieces();
        resetPiecePositions();
    }

    private void changeActiveTurnPlayer(){
        if (activeTurnPlayer.getName().equals(player1.getName())){
            activeTurnPlayer = player2;

        } else if (activeTurnPlayer.getName().equals(player2.getName())){
            activeTurnPlayer = player1;
        }
    }

    private void createPieces(){
        whitePawns = new Pawn[8];
        for (int i = 0; i < whitePawns.length; i++){
            whitePawns[i] = new Pawn(PieceColor.WHITE);
        }

        whiteRook1 = new Rook(PieceColor.WHITE);
        whiteRook2 = new Rook(PieceColor.WHITE);
        
        whiteKnight1 = new Knight(PieceColor.WHITE);
        whiteKnight2 = new Knight(PieceColor.WHITE);

        whiteBishop1 = new Bishop(PieceColor.WHITE);
        whiteBishop2 = new Bishop(PieceColor.WHITE);

        whiteQueen = new Queen(PieceColor.WHITE);

        whiteKing = new King(PieceColor.WHITE);


        
        blackPawns = new Pawn[8];
        for (int i = 0; i < blackPawns.length; i++){
            blackPawns[i] = new Pawn(PieceColor.BLACK);
        }

        blackRook1 = new Rook(PieceColor.BLACK);
        blackRook2 = new Rook(PieceColor.BLACK);
        
        blackKnight1 = new Knight(PieceColor.BLACK);
        blackKnight2 = new Knight(PieceColor.BLACK);

        blackBishop1 = new Bishop(PieceColor.BLACK);
        blackBishop2 = new Bishop(PieceColor.BLACK);

        blackQueen = new Queen(PieceColor.BLACK);

        blackKing = new King(PieceColor.BLACK);
    }

    private void resetPiecePositions(){
        for (int i = 0; i < 8; i++){
            fields[1][i].setChessPiece(whitePawns[i]);
        }

        fields[0][0].setChessPiece(whiteRook1);
        fields[0][1].setChessPiece(whiteKnight1);
        fields[0][2].setChessPiece(whiteBishop1);
        fields[0][3].setChessPiece(whiteQueen);
        fields[0][4].setChessPiece(whiteKing);
        fields[0][5].setChessPiece(whiteBishop2);
        fields[0][6].setChessPiece(whiteKnight2);
        fields[0][7].setChessPiece(whiteRook2);

        fields[2][0].setChessPiece(null);
        fields[2][1].setChessPiece(null);
        fields[2][2].setChessPiece(null);
        fields[2][3].setChessPiece(null);
        fields[2][4].setChessPiece(null);
        fields[2][5].setChessPiece(null);
        fields[2][6].setChessPiece(null);
        fields[2][7].setChessPiece(null);

        fields[3][0].setChessPiece(null);
        fields[3][1].setChessPiece(null);
        fields[3][2].setChessPiece(null);
        fields[3][3].setChessPiece(null);
        fields[3][4].setChessPiece(null);
        fields[3][5].setChessPiece(null);
        fields[3][6].setChessPiece(null);
        fields[3][7].setChessPiece(null);

        fields[4][0].setChessPiece(null);
        fields[4][1].setChessPiece(null);
        fields[4][2].setChessPiece(null);
        fields[4][3].setChessPiece(null);
        fields[4][4].setChessPiece(null);
        fields[4][5].setChessPiece(null);
        fields[4][6].setChessPiece(null);
        fields[4][7].setChessPiece(null);

        fields[5][0].setChessPiece(null);
        fields[5][1].setChessPiece(null);
        fields[5][2].setChessPiece(null);
        fields[5][3].setChessPiece(null);
        fields[5][4].setChessPiece(null);
        fields[5][5].setChessPiece(null);
        fields[5][6].setChessPiece(null);
        fields[5][7].setChessPiece(null);

        fields[7][0].setChessPiece(blackRook1);
        fields[7][1].setChessPiece(blackKnight1);
        fields[7][2].setChessPiece(blackBishop1);
        fields[7][3].setChessPiece(blackQueen);
        fields[7][4].setChessPiece(blackKing);
        fields[7][5].setChessPiece(blackBishop2);
        fields[7][6].setChessPiece(blackKnight2);
        fields[7][7].setChessPiece(blackRook2);

        for (int i = 0; i < 8; i++){
            fields[6][i].setChessPiece(blackPawns[i]);
        }
    }

    public JPanel getPanel(){
        return panel;
    }
}