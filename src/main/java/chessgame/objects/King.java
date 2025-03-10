package chessgame.objects;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.BoardField;

public class King extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_king.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_king.png";
    
    public King(ColorEnum color){
        piece = Piece.KING;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteKing = new ImageIcon(iconPathWhite);
            icon = whiteKing;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackKing = new ImageIcon(iconPathBlack);
            icon = blackKing;
        }

    }
}