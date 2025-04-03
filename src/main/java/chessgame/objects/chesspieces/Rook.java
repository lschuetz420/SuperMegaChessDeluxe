package chessgame.objects.chesspieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import chessgame.objects.widgets.BoardField;
import chessgame.objects.widgets.ChessPiece;

public class Rook extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_rook.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_rook.png";

    public Rook(PieceColor color){
        this.piece = Piece.ROOK;
        
        if (color == PieceColor.WHITE){
            ImageIcon whiteRook = new ImageIcon(iconPathWhite);
            icon = whiteRook;
            icon.setDescription("whiteRook");
        } else if (color == PieceColor.BLACK){
            ImageIcon blackRook = new ImageIcon(iconPathBlack);
            icon = blackRook;
            icon.setDescription("blackRook");
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