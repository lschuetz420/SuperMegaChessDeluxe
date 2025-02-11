package chessgame.objects;

import chessgame.objects.ChessPiece.ColorEnum;

public class Player {
    
    private String name;
    private ColorEnum color;

    public Player(String name, ColorEnum color){
        this.name = name;
        this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setColor(ColorEnum color){
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public ColorEnum getColor(){
        return color;
    }
}
