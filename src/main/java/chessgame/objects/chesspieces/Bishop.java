package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;
import chessgame.objects.widgets.ChessPiece.PieceColor;
import chessgame.objects.widgets.ChessPiece.Piece;

public class Bishop extends ChessPiece{

    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_bishop.png";
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_bishop.png";

    public Bishop(PieceColor color){
        this.piece = Piece.BISHOP;
        
        if (color == PieceColor.WHITE){
            ImageIcon whiteBishop = new ImageIcon(iconPathWhite);
            icon = whiteBishop;
            icon.setDescription("whiteBishop");
        } else if (color == PieceColor.BLACK){
            ImageIcon blackBishop = new ImageIcon(iconPathBlack);
            icon = blackBishop;
            icon.setDescription("blackBishop");
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
        
        return fields;
    }
}