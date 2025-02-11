package chessgame.objects;

import javax.swing.*;

public class ChessPiece{
    
    public ImageIcon icon;
    public ColorEnum color;
    public Piece piece;

    public enum ColorEnum{
        BLACK,
        WHITE
    }

    public enum Piece{
        PAWN,
        ROOK,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING
    }

    public void setIcon(ImageIcon icon){
        this.icon = icon;
    }

    public void setColor(ColorEnum color){
        this.color = color;    
    }

    private void setType(Piece piece){
        this.piece = piece;
    }

    public ImageIcon getIcon(){
        return icon;
    }

    public ColorEnum getColor(){
        return color;
    }

    public Piece getType(){
        return piece;
    }
}
