package chessgame.objects;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.BoardField;

public class Bishop extends ChessPiece{

    public Bishop(ColorEnum color){
        piece = Piece.BISHOP;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteBishop = new ImageIcon();
            icon = whiteBishop;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackBishop = new ImageIcon();
            icon = blackBishop;
        }

    }

    public BoardField[] getPossibleFields(BoardField currentField){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();

        String fieldName = currentField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        boolean DO = true;

        while (DO){
            for (int i = fieldNumber; i < 8; i++){
                
            }
        }
    }
}