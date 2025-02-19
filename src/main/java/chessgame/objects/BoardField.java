package chessgame.objects;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import chessgame.screens.Board;

public class BoardField {
    
    private JButton button;
    private ChessPiece chessPiece = null;
    
    public BoardField(){
        button = new JButton();
    }

    public BoardField(JButton button){
        this.button = button;
    }

    public void addActionListener(ActionListener listener){
        button.addActionListener(listener);
    }

    public void setChessPiece(ChessPiece chessPiece){
        this.chessPiece = chessPiece;
        if (chessPiece != null){
            button.setIcon(chessPiece.getIcon());
        } else {
            button.setIcon(null);
        }
    }
    
    public void setPositionInfo(String info){
        button.setActionCommand(info);
    }
    
    public void setBackgroundColor(Color color){
        button.setBackground(color);
    }
    
    public void setOpaque(boolean isOpaque){
        button.setOpaque(isOpaque);
    }

    public void setSize(int width, int height){
        button.setPreferredSize(new Dimension(width, height));
    }

    public ChessPiece getChessPiece(){
        return chessPiece;
    }

    public String getPositionInfo(){
        return button.getActionCommand();
    }
    
    public JButton getButtonObject(){
        return button;
    }


}
