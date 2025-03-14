package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class King extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_king.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_king.png";
    
    public King(ColorEnum color){
        piece = Piece.KING;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteKing = new ImageIcon(iconPathWhite);
            icon = whiteKing;
            icon.setDescription("whiteKing");
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackKing = new ImageIcon(iconPathBlack);
            icon = blackKing;
            icon.setDescription("blackKing");
        }

    }

    public ArrayList<BoardField> getPossibleFields(BoardField currentField){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();

        String fieldName = currentField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        if (fieldNumber != 8){
            BoardField field1 = new BoardField();
            int number1 = fieldNumber + 1;
            field1.setPositionInfo(number1 + "S" + fieldLetter);
            fields.add(field1);
        }

        if (fieldNumber != 8 && fieldLetter != 8){
            BoardField field2 = new BoardField();
            int number2 = fieldNumber + 1;
            int letter2 = fieldLetter + 1;
            field2.setPositionInfo(number2 + "S" + letter2);
            fields.add(field2);
        }

        if (fieldLetter != 8){
            BoardField field3 = new BoardField();
            int letter3 = fieldLetter + 1;
            field3.setPositionInfo(fieldNumber + "S" + letter3);
            fields.add(field3);
        }

        if (fieldNumber != 1){
            BoardField field4 = new BoardField();
            int number4 = fieldNumber - 1;
            field4.setPositionInfo(number4 + "S" + fieldLetter);
            fields.add(field4);
        }

        if (fieldNumber != 1 && fieldLetter != 1){
            BoardField field5 = new BoardField();
            int number5 = fieldNumber - 1;
            int letter5 = fieldLetter - 1;
            field5.setPositionInfo(number5 + "S" + letter5);
            fields.add(field5);
        }

        if (fieldLetter != 1){
            BoardField field6 = new BoardField();
            int letter6 = fieldLetter - 1;
            field6.setPositionInfo(fieldNumber + "S" + letter6);
            fields.add(field6);
        }

        if (fieldNumber != 1 && fieldLetter != 8){
            BoardField field7 = new BoardField();
            int number7 = fieldNumber - 1;
            int letter7 = fieldLetter + 1;
            field7.setPositionInfo(number7 + "S" + letter7);
            fields.add(field7);
        }

        if (fieldNumber != 8 && fieldLetter != 1){
            BoardField field8 = new BoardField();
            int number8 = fieldNumber + 1;
            int letter8 = fieldLetter - 1;
            field8.setPositionInfo(number8 + "S" + letter8);
            fields.add(field8);
        }

        return fields;
    }
}