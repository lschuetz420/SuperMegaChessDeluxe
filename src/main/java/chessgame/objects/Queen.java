package chessgame.objects;

import javax.swing.ImageIcon;

public class Queen extends ChessPiece{
    
    private String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_queen.png";
    private String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_queen.png";

    public Queen(ColorEnum color){
        piece = Piece.QUEEN;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteQueen = new ImageIcon(iconPathWhite);
            icon = whiteQueen;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackQueen = new ImageIcon(iconPathBlack);
            icon = blackQueen;
        }

    }    
}