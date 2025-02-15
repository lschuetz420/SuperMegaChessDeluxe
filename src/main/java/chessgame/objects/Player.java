package chessgame.objects;

import chessgame.objects.ChessPiece.ColorEnum;

public class Player {
    
    private String name;
    private ColorEnum color;
    private Type type;
    private Difficulty difficulty;

    public enum Type{
        HUMAN,
        AI
    }

    public enum Difficulty{
        EASY,
        MEDIUM,
        HARD
    }

    public Player(String name, ColorEnum color, Type type, Difficulty difficulty){
        this.name = name;
        this.color = color;
        this.type = type;
        this.difficulty = difficulty;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setColor(ColorEnum color){
        this.color = color;
    }

    public Type getType(){
        return type;
    }

    public Difficulty geDifficulty(){
        return difficulty;
    }

    public String getName(){
        return name;
    }

    public ColorEnum getColor(){
        return color;
    }
}
