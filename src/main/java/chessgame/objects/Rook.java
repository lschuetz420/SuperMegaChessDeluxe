package chessgame.objects;

import javax.swing.ImageIcon;

public class Rook extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_rook.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_rook.png";

    public Rook(ColorEnum color){
        piece = Piece.ROOK;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteRook = new ImageIcon(iconPathWhite);
            icon = whiteRook;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackRook = new ImageIcon(iconPathBlack);
            icon = blackRook;
        }

    }    
}