package chessgame;

import chessgame.controller.ScreenController;

public class ChessGame{
    public static void main(String[] args){
        new ChessGame().start();
    }

    public void start(){
        new ScreenController().showMenuScreen();
    }
}