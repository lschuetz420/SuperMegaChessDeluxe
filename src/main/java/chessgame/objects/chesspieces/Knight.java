package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class Knight extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_knight.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_knight.png";

    public Knight(PieceColor color){
        this.piece = Piece.KNIGHT;
        
        if (color == PieceColor.WHITE){
            ImageIcon whiteKnight = new ImageIcon(iconPathWhite);
            icon = whiteKnight;
            icon.setDescription("whiteKnight");
        } else if (color == PieceColor.BLACK){
            ImageIcon blackKnight = new ImageIcon(iconPathBlack);
            icon = blackKnight;
            icon.setDescription("blackKnight");
        }

        this.color = color;
    }
    
    @Override
    public ArrayList<BoardField> getPossibleFields(BoardField currentField){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();

        String fieldName = currentField.getPositionInfo();
        String[] numbers = fieldName.split("S");

        int fieldNumber = Integer.parseInt(numbers[0]);
        int fieldLetter = Integer.parseInt(numbers[1]);

        if (fieldNumber < 7 && fieldLetter < 8){
            BoardField field1 = new BoardField();
            int number1 = fieldNumber + 2;
            int letter1 = fieldLetter + 1;
            field1.setPositionInfo(number1 + "S" + letter1);
            fields.add(field1);
        }

        if (fieldNumber < 7 && fieldLetter > 1){
            BoardField field2 = new BoardField();
            int number2 = fieldNumber + 2;
            int letter2 = fieldLetter - 1;
            field2.setPositionInfo(number2 + "S" + letter2);
            fields.add(field2);
        }

        if (fieldNumber > 2 && fieldLetter < 8){
            BoardField field3 = new BoardField();
            int number3 = fieldNumber - 2;
            int letter3 = fieldLetter + 1;
            field3.setPositionInfo(number3 + "S" + letter3);
            fields.add(field3);
        }

        if (fieldNumber > 2 && fieldLetter > 1){
            BoardField field4 = new BoardField();
            int number4 = fieldNumber - 2;
            int letter4 = fieldLetter - 1;
            field4.setPositionInfo(number4 + "S" + letter4);
            fields.add(field4);
        }

        if (fieldNumber < 8 && fieldLetter < 7){
            BoardField field5 = new BoardField();
            int number5 = fieldNumber + 1;
            int letter5 = fieldLetter + 2;
            field5.setPositionInfo(number5 + "S" + letter5);
            fields.add(field5);
        }
        
        if (fieldNumber > 1 && fieldLetter < 7){
            BoardField field6 = new BoardField();
            int number6 = fieldNumber - 1;
            int letter6 = fieldLetter + 2;
            field6.setPositionInfo(number6 + "S" + letter6);
            fields.add(field6);
        }

        if (fieldNumber < 8 && fieldLetter > 2){
            BoardField field7 = new BoardField();
            int number7 = fieldNumber + 1;
            int letter7 = fieldLetter - 2;
            field7.setPositionInfo(number7 + "S" + letter7);
            fields.add(field7);
        }

        if (fieldNumber > 1 && fieldLetter > 2){
            BoardField field8 = new BoardField();
            int number8 = fieldNumber - 1;
            int letter8 = fieldLetter - 2;
            field8.setPositionInfo(number8 + "S" + letter8);
            fields.add(field8);
        }

        return fields;
    }
}