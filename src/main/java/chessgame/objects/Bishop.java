package chessgame.objects;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.BoardField;

public class Bishop extends ChessPiece{

    private 

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

    public ArrayList<BoardField> getPossibleFields(BoardField currentField){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();

        String fieldName = currentField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        boolean DO = true;
        int counter = 0;

        for (int i = fieldNumber + 1; i < 9; i++){
            counter++;

            for (int j = fieldLetter + 1; j < 9; j++){
                if (j == counter + fieldLetter){
                    BoardField field = new BoardField();
                    field.setPositionInfo(i + "S" + j);
                    fields.add(field);
                }
            }

            for (int j = fieldLetter - 1; j > 0; j--){
                if (j == fieldLetter - counter){
                    BoardField field = new BoardField();
                    field.setPositionInfo(i + "S" + j + fieldLetter);
                    fields.add(field);
                }
            }
        }

        counter = 0;

        for (int i = fieldNumber - 1; i > 0; i--){
            counter++;

            for (int j = fieldLetter + 1; j < 9; j++){
                if (j == counter + fieldLetter){
                    BoardField field = new BoardField();
                    field.setPositionInfo(i + "S" + j);
                    fields.add(field);
                }
            }

            for (int j = fieldLetter - 1; j > 0; j--){
                if (j == fieldLetter - counter){
                    BoardField field = new BoardField();
                    field.setPositionInfo(i + "S" + j + fieldLetter);
                    fields.add(field);
                }
            }
        }

        return fields;
    }
}