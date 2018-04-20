package gravyt;

import java.util.Random;

public class PCPlayer implements Player {
    private Mark mark;
    private String playerName;

    @Override
    public int makeNextMove() {
        Random rand = new Random();
        return rand.nextInt(7);
    }

    @Override
    public Mark setMark(int playerNumber) {
        if (playerNumber==1)return mark=Mark.X;
        else return mark=Mark.O;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
    @Override
    public Mark getMark(){
        return mark;
    }

    @Override
    public void setPlayerName(String name){
        playerName = name;
    }
}
