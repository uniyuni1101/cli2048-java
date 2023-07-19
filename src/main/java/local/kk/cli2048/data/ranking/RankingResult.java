package local.kk.cli2048.data.ranking;

public class RankingResult {
    private int score;
    private String name;

    public RankingResult(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}
