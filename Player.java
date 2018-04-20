package gravyt;

public interface Player {
    public int makeNextMove();

    public String getPlayerName();

    public Mark setMark(int playerNumber);

    public Mark getMark();

    public void setPlayerName(String name);
}
