package local.kk.cli2048.game;

import java.util.List;

import local.kk.cli2048.base.BasePresenter;
import local.kk.cli2048.data.ranking.RankingResult;
import local.kk.cli2048.data.DataManager;
import local.kk.cli2048.data.IDataManager;

public class GamePresenter extends BasePresenter implements IGamePresenter {
    IGameView view;
    IDataManager data;

    public GamePresenter() {
        this.view = new GameView(this);
        this.data = new DataManager(this);
        this.setPlayerName("Guest");
        this.view.notifyUpdate();

    }

    public void up() {
        this.data.up();
        this.view.notifyUpdate();
    }

    public void down() {
        this.data.down();
        this.view.notifyUpdate();
    }

    public void right() {
        this.data.right();
        this.view.notifyUpdate();
    }

    public void left() {
        this.data.left();
        this.view.notifyUpdate();
    }

    public int[][] getGameGrid() {
        return this.data.getGameGrid();
    }

    public List<RankingResult> getRanking() {
        return this.data.getRanking();
    }

    @Override
    public int getPlayerScore() {
        return this.data.getScore();
    }

    @Override
    public String getPlayerName() {
        return this.data.getName();
    }

    @Override
    public void setPlayerName(String name) {
        this.data.setPlayerName(name);
    }

    @Override
    public int getPlayerBestScore() {
        // TODO Auto-generated method stub
        return 0;
    }

}
