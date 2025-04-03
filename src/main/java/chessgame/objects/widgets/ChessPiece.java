package chessgame.objects.widgets;

import java.util.ArrayList;

import javax.swing.*;

public class ChessPiece{
    
    public ImageIcon icon;
    public PieceColor color;
    public Piece piece;
    public String name;

    public enum PieceColor{
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

    public void setColor(PieceColor color){
        this.color = color;    
    }

    private void setType(Piece piece){
        this.piece = piece;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<BoardField> getPossibleFields(BoardField currentField){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();
        return fields;
    }

    public ArrayList<BoardField> getPossibleFields(BoardField currentField, PieceColor color){
        ArrayList<BoardField> fields = new ArrayList<BoardField>();
        return fields;
    }

    public String getName(){
        return name;
    }

    public ImageIcon getIcon(){
        return icon;
    }

    public PieceColor getColor(){
        return color;
    }

    public Piece getType(){
        return piece;
    }
}
