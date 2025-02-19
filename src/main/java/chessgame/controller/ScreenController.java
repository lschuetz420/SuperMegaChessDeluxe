package chessgame.controller;

import chessgame.screens.*;

public class ScreenController{

    private static ChessGameWindow window;
    private static Menu menu;
    private static BoardScreen boardScreen;
    private static Board board;
    private static BoardMenu boardMenu;

    private static ScreenController screenController;

    private ScreenController(){
        if (menu == null){
            menu = new Menu();
        }
        
        if (boardScreen == null){
            boardScreen = new BoardScreen();
        }

        if (boardMenu == null){
            boardMenu = new BoardMenu();
        }

        if (board == null){
            board = new Board();
        }
        
        if (window == null){
            window = new ChessGameWindow();
            
            window.add(menu.getPanel());
            
            boardScreen.add(boardMenu.getPanel());
            boardScreen.add(board.getPanel());
            window.add(boardScreen.getPanel());
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

    public static BoardScreen getBoardScreen(){
        return boardScreen;
    }

    public void showMenuScreen(){
        window.setVisible(true);
        boardScreen.setVisible(false);
        menu.setVisible(true);
    }

    public void showBoardScreen(){
        window.setVisible(true);
        menu.setVisible(false);
        boardScreen.setVisible(true);
    }


}