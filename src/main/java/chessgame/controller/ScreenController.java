package chessgame.controller;

import chessgame.screens.*;

public class ScreenController{

    private static ChessGameWindow window;
    private static Menu menu;
    private static Board board;

    private static ScreenController screenController;

    private ScreenController(){
        if (window == null){
            window = new ChessGameWindow();
        }

        if (menu == null){
            menu = new Menu(window);
        }

        if (board == null){
            board = new Board(window);
        }
    }

    public static ScreenController getInstance() {
        if (screenController == null) {
            screenController = new ScreenController();
        }
        return screenController;
    }

    public static Menu getMenu(){
        return menu;
    }

    public static Board getBoard(){
        return board;
    }

    public void showMenuScreen(){
        window.setVisible(true);
        board.setVisible(false);
        menu.setVisible(true);
    }

    public void showBoardScreen(){
        window.setVisible(true);
        menu.setVisible(false);
        board.setVisible(true);
    }


}