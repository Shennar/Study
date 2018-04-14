package GravyT;

import java.util.Random;

public class PCPlayer implements Players {
    private Marks mark = Marks.O;
    private String playerName = "Computer player";

    @Override
    public int makeNextMove() {
        Random rand = new Random();
        return rand.nextInt(7);
    }

    @Override
    public Marks getMark() {
        return mark;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
