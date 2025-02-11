package chessgame.screens;

import javax.swing.*;

import chessgame.objects.BoardField;
import chessgame.objects.Player;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends Screen{

    private Player player1 = null;
    private Player player2 = null;
    private Player activeTurnPlayer = null;

    private BoardField[][] fields = new BoardField[8][8]; 

    public void createBoard(){

        for (int i = 0; i < fields.length; i++){
            for (int j = 0; j < fields[i].length; j++){

                fields[i][j] = new BoardField();
                fields[i][j].setPositionInfo(i + "S" + j);

                fields[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        doFieldClickResponse(e);
                    }
                });

                panel.add(fields[i][j].getButtonObject());
            }
        }

        for (int i = 0; i < fields.length;i = i + 2){
            for (int j = 0; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(150, 111, 51));
                fields[i][j].setOpaque(true);
            }
        }

        for (int i = 1; i < fields.length;i = i + 2){
            for (int j = 1; j < fields[i].length; j = j + 2){
                fields[i][j].setBackgroundColor(new Color(245, 245, 220));
                fields[i][j].setOpaque(true);
            }
        }
    }

    private void doFieldClickResponse(ActionEvent e){
        BoardField field = (BoardField) e.getSource();
        
        if (field.getChessPiece() == null){
        
        } else if (field.getChessPiece().getColor() != activeTurnPlayer.getColor()){

        } else {
            String fieldName = field.getPositionInfo();
            String[] numbers = fieldName.split("S");

            int fieldNumber = Integer.parseInt(numbers[0]);
            int fieldLetter = Integer.parseInt(numbers[1]);
        }

    } 
}