package local.kk.cli2048.data.gameGrid;

import local.kk.cli2048.data.gameGrid.util.MargeResult;
import local.kk.cli2048.data.gameGrid.util.TileBoardUtil;
import local.kk.cli2048.data.gameGrid.util.TileRotateMarge;
import local.kk.cli2048.data.IDataManager;

public class TileBoard implements ITileBoard {
    private int dimension;
    private ITile[][] boardGrid;
    private IDataManager dataManager;
    private boolean isMoved = false;

    public TileBoard(IDataManager dataManager, int dimension) {
        this.dimension = dimension;
        this.boardGrid = TileBoardUtil.createBoardZeroFill(this.dimension);
        this.boardGrid = TileBoardUtil.createNewTileEmptyField(this.boardGrid, 2);
        this.dataManager = dataManager;
    }

    private void newTileEmptyField() {
        if (this.isMoved) {
            this.boardGrid = TileBoardUtil.createNewTileEmptyField(this.boardGrid);
        }
    }

    @Override
    public void up() {
        MargeResult res = TileRotateMarge.start(this.boardGrid, this.dimension).rot90().marge();
        this.addScore(res.getScore());
        this.isMoved = res.isMoved();
        this.boardGrid = res.getTile();
        this.newTileEmptyField();
    }

    @Override
    public void down() {
        MargeResult res = TileRotateMarge.start(this.boardGrid, this.dimension).rot90().rot90().rot90().marge();
        this.addScore(res.getScore());
        this.isMoved = res.isMoved();
        this.boardGrid = res.getTile();
        this.newTileEmptyField();
    }

    @Override
    public void left() {
        MargeResult res = TileRotateMarge.start(this.boardGrid, this.dimension).marge();
        this.addScore(res.getScore());
        this.isMoved = res.isMoved();
        this.boardGrid = res.getTile();
        this.newTileEmptyField();
    }

    @Override
    public void right() {
        MargeResult res = TileRotateMarge.start(this.boardGrid, this.dimension).rot90().rot90().marge();
        this.addScore(res.getScore());
        this.isMoved = res.isMoved();
        this.boardGrid = res.getTile();
        this.newTileEmptyField();
    }

    @Override
    public boolean isMoved() {
        return this.isMoved;
    }

    @Override
    public void addScore(int score) {
        this.dataManager.addScore(score);
    }

    @Override
    public ITile[][] getBoardGrid() {
        return this.boardGrid;
    }

}
