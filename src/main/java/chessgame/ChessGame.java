package chessgame;

import chessgame.controller.ScreenController;

public class ChessGame{

    private static ScreenController screenController;

    public ChessGame(){
        if (screenController == null){
            screenController = ScreenController.getInstance();
        }
    }

    public static void main(String[] args){
        new ChessGame().start();
    }

    public void start(){
        try {
            screenController.showMenuScreen();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}