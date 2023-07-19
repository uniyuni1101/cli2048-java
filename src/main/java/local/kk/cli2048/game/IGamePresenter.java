package local.kk.cli2048.game;

import java.util.List;

import local.kk.cli2048.base.IPresenter;
import local.kk.cli2048.data.ranking.RankingResult;

public interface IGamePresenter extends IPresenter {
    void up();

    void down();

    void right();

    void left();

    int getPlayerScore();

    String getPlayerName();

    void setPlayerName(String name);

    int[][] getGameGrid();

    List<RankingResult> getRanking();

    int getPlayerBestScore();

}
