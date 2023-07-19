package local.kk.cli2048.data;

public interface IPlayerData {
    void addScore(int score);

    void setName(String name);

    int getScore();

    String getName();
}
