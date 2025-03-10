package chessgame.objects;

import javax.swing.ImageIcon;

public class Knight extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_knight.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_knight.png";

    public Knight(ColorEnum color){
        piece = Piece.KNIGHT;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteKnight = new ImageIcon(iconPathWhite);
            icon = whiteKnight;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackKnight = new ImageIcon(iconPathBlack);
            icon = blackKnight;
        }

    }    
}