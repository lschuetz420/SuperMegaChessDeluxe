package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class Pawn extends ChessPiece{

    private final String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_pawn.png";
    private final String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_pawn.png";

    public Pawn(ColorEnum color){
        piece = Piece.PAWN;
        
            if (color == ColorEnum.WHITE){
                ImageIcon whitePawn = new ImageIcon(iconPathWhite);
                icon = whitePawn;
                icon.setDescription("whitePawn");
            } else if (color == ColorEnum.BLACK){
                ImageIcon blackPawn = new ImageIcon(iconPathBlack);
                icon = blackPawn;
                icon.setDescription("blackPawn");
            }       
    }

    public ArrayList<BoardField> getPossibleFields(BoardField currentField, ColorEnum color){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();

        String fieldName = currentField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        if (fieldNumber == 2 | fieldNumber == 7 ){
            if (color == ColorEnum.WHITE ){
                BoardField field1 = new BoardField();
                int number1 = fieldNumber + 1;
                field1.setPositionInfo(number1 + "S" + fieldLetter);
                fields.add(field1);

                BoardField field2 = new BoardField();
                int number2 = fieldNumber + 2;
                field2.setPositionInfo(number2 + "S" + fieldLetter);
                fields.add(field2);
            } else if (color == ColorEnum.BLACK){
                BoardField field1 = new BoardField();
                int number1 = fieldNumber - 1;
                field1.setPositionInfo(number1 + "S" + fieldLetter);
                fields.add(field1);

                BoardField field2 = new BoardField();
                int number2 = fieldNumber - 2;
                field2.setPositionInfo(number2 + "S" + fieldLetter);
                fields.add(field2);
            }
        } else {
            if (color == ColorEnum.WHITE ){
                BoardField field1 = new BoardField();
                int number1 = fieldNumber + 1;
                field1.setPositionInfo(number1 + "S" + fieldLetter);
                fields.add(field1);

            } else if (color == ColorEnum.BLACK){
                BoardField field1 = new BoardField();
                int number1 = fieldNumber - 1;
                field1.setPositionInfo(number1 + "S" + fieldLetter);
                fields.add(field1);

            }
        }

        return fields;
    }
}