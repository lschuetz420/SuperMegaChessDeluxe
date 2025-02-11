package chessgame.objects;

import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;

public class BoardField {
    
    private JButton button;
    private ChessPiece chessPiece = null;
    
    public BoardField(){
        button = new JButton();
    }

    public void addActionListener(ActionListener listener){
        button.addActionListener(listener);
    }

    public void setChessPiece(ChessPiece chessPiece){
        this.chessPiece = chessPiece;
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
