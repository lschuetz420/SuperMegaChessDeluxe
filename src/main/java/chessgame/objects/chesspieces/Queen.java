package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class Queen extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_queen.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_queen.png";

    public Queen(PieceColor color){
        this.piece = Piece.QUEEN;
        
        if (color == PieceColor.WHITE){
            ImageIcon whiteQueen = new ImageIcon(iconPathWhite);
            icon = whiteQueen;
            icon.setDescription("whiteQueen");
        } else if (color == PieceColor.BLACK){
            ImageIcon blackQueen = new ImageIcon(iconPathBlack);
            icon = blackQueen;
            icon.setDescription("blackQueen");
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
                    field.setPositionInfo(i + "S" + j);
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
                    field.setPositionInfo(i + "S" + j);
                    fields.add(field);
                }
            }
        }

        for (int i = fieldNumber + 1; i < 9;i++){
            BoardField field = new BoardField();
            field.setPositionInfo(i + "S" + fieldLetter);
            fields.add(field);
        }

        for (int i = fieldNumber - 1; i > 0; i--){
            BoardField field = new BoardField();
            field.setPositionInfo(i + "S" + fieldLetter);
            fields.add(field);
        }

        for (int j = fieldLetter + 1; j < 9; j++){
            BoardField field = new BoardField();
            field.setPositionInfo(fieldNumber + "S" + j);
            fields.add(field);
        }

        for (int j = fieldLetter - 1; j > 0; j--){
            BoardField field = new BoardField();
            field.setPositionInfo(fieldNumber + "S" + j);
            fields.add(field);
        }
        
        return fields;
    }
}