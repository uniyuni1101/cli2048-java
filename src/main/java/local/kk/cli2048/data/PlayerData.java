package local.kk.cli2048.data;

public class PlayerData {
    private String name;
    private int score = 0;

    public void addScore(int score) {
        this.score += score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}
