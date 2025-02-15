package chessgame.objects;

import javax.swing.ImageIcon;

public class Knight extends ChessPiece{
    
    public Knight(ColorEnum color){
        piece = Piece.KNIGHT;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteKnight = new ImageIcon();
            icon = whiteKnight;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackKnight = new ImageIcon();
            icon = blackKnight;
        }

    }    
}