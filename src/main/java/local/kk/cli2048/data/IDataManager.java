package local.kk.cli2048.data;

import java.util.List;

import local.kk.cli2048.data.ranking.RankingResult;

public interface IDataManager {

    void up();

    void down();

    void right();

    void left();

    int getScore();

    String getName();

    List<RankingResult> getRanking();

    void addScore(int score);

    void setPlayerName(String name);

    int[][] getGameGrid();

}
