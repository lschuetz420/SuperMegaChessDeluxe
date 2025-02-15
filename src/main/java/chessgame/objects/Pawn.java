package chessgame.objects;

import javax.swing.ImageIcon;

public class Pawn extends ChessPiece{

    private final String iconPathWhite = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/white_pawn.png";
    private final String iconPathBlack = "C:/Projects/SuperMegaChessDeluxe/ressources/images/pieces/black_pawn.png";

    public Pawn(ColorEnum color){
        piece = Piece.PAWN;
        
            if (color == ColorEnum.WHITE){
                ImageIcon whitePawn = new ImageIcon(iconPathWhite);
                icon = whitePawn;
            } else if (color == ColorEnum.BLACK){
                ImageIcon blackPawn = new ImageIcon(iconPathBlack);
                icon = blackPawn;
            }       
    }
}