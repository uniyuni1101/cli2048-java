package local.kk.cli2048.data.gameGrid.util;

import local.kk.cli2048.data.gameGrid.ITile;

public class MargeResult {
    private int score;
    private boolean isMoved;
    private ITile[][] tiles;

    MargeResult(ITile[][] tiles, int score, boolean isMoved) {
        this.score = score;
        this.tiles = tiles;
        this.isMoved = isMoved;
    }

    public int getScore() {
        return score;
    }

    public boolean isMoved() {
        return this.isMoved;
    }

    public ITile[][] getTile() {
        return this.tiles;
    }
}
