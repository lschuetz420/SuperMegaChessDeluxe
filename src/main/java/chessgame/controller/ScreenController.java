package chessgame.controller;

import java.awt.FlowLayout;

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
        
        if (boardMenu == null){
            boardMenu = new BoardMenu();
        }
        
        if (board == null){
            board = new Board();
        }

        if (boardScreen == null){
            boardScreen = new BoardScreen();
            boardScreen.add(boardMenu.getPanel());
            boardScreen.add(board.getPanel());
        }
        
        if (window == null){
            window = new ChessGameWindow();
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

    public static BoardMenu getBoardMenu(){
        return boardMenu;
    }

    public static BoardScreen getBoardScreen(){
        return boardScreen;
    }

    public void showMenuScreen(){
        if (window.hasComponent(menu.getPanel()) == false){
            window.add(menu.getPanel());
            window.pack();
        }

        menu.setVisible(true);
        boardScreen.setVisible(false);
        boardScreen.setAllComponentsVisible(false);
        window.setSizeToDefault();
        window.setVisible(true);
    }

    public void showBoardScreen(){
        if (window.hasComponent(boardScreen.getPanel()) == false){
            window.add(boardScreen.getPanel());
            window.pack();
        }

        menu.setVisible(false);
        boardScreen.setVisible(true);
        boardScreen.setAllComponentsVisible(true);
        window.setSizeToFullScreen();
        window.setVisible(true);
    }

}