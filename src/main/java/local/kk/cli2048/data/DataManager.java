package local.kk.cli2048.data;

import java.util.Arrays;
import java.util.List;

import local.kk.cli2048.base.BaseModel;
import local.kk.cli2048.data.gameGrid.ITileBoard;
import local.kk.cli2048.data.gameGrid.TileBoard;
import local.kk.cli2048.data.gameGrid.ITile;
import local.kk.cli2048.data.ranking.RankingResult;
import local.kk.cli2048.game.IGamePresenter;

public class DataManager extends BaseModel implements IDataManager {
    private IGamePresenter mPresenter;

    private ITileBoard tileBoard;
    private PlayerData playerData;

    public DataManager(IGamePresenter pres) {
        this.mPresenter = pres;
        this.mPresenter.attachModel(this);
        this.tileBoard = new TileBoard(this, 5);
        this.playerData = new PlayerData();
    }

    @Override
    public void up() {
        this.tileBoard.up();
    }

    @Override
    public void down() {
        this.tileBoard.down();
    }

    @Override
    public void right() {
        this.tileBoard.right();
    }

    @Override
    public void left() {
        this.tileBoard.left();
    }

    @Override
    public int getScore() {
        return this.playerData.getScore();
    }

    @Override
    public String getName() {
        return this.playerData.getName();
    }

    @Override
    public List<RankingResult> getRanking() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addScore(int score) {
        this.playerData.addScore(score);
    }

    @Override
    public void setPlayerName(String name) {
        this.playerData.setName(name);

    }

    @Override
    public int[][] getGameGrid() {
        ITile[][] t = this.tileBoard.getBoardGrid();
        int[][] res = new int[t.length][t.length];
        for (int i = 0; i < t.length; i++) {
            res[i] = Arrays.stream(t[i]).mapToInt(e -> e.getScore()).toArray();
        }
        return res;
    }

}
