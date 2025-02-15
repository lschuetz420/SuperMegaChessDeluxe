package chessgame.objects;

import java.util.ArrayList;

import javax.swing.*;

import chessgame.objects.BoardField;

public class King extends ChessPiece{
    
    public King(ColorEnum color){
        piece = Piece.KING;
        
        if (color == ColorEnum.WHITE){
            ImageIcon whiteBishop = new ImageIcon();
            icon = whiteBishop;
        } else if (color == ColorEnum.BLACK){
            ImageIcon blackBishop = new ImageIcon();
            icon = blackBishop;
        }

    }
}