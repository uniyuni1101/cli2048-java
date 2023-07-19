package local.kk.cli2048.data.gameGrid.util;

import java.util.Arrays;

import local.kk.cli2048.data.gameGrid.ITile;
import local.kk.cli2048.data.gameGrid.Tile;

public class TileRotateMarge {
    private int rotateCount = 0;
    private ITile[][] tileGrid;
    private int dimension;
    private boolean isMarged = false;

    private TileRotateMarge(ITile[][] tileGrid, int dimension) {
        this.tileGrid = tileGrid;
        this.dimension = dimension;
    }

    public static TileRotateMarge start(ITile[][] tileGrid, int d) {
        return new TileRotateMarge(tileGrid, d);
    }

    public TileRotateMarge rot90() {
        if (this.isMarged) {
            throw new MargedObjectRuntimeException();
        }
        this.rotateCount++;
        int maxIndex = this.dimension - 1;
        ITile[][] res = new ITile[this.dimension][this.dimension];
        for (int col = 0; col < this.dimension; col++) {
            for (int row = 0; row < this.dimension; row++) {
                res[maxIndex - row][col] = this.tileGrid[col][row];
            }
        }
        this.tileGrid = res;
        return this;
    }

    private static LineMargeResult lineMarge(ITile[] tileLine) {

        int score = 0;
        boolean isMoved = false;
        ITile[] res = new ITile[tileLine.length];

        Arrays.fill(res, Tile.ZERO);

        for (int i = 0, t = 0; i < tileLine.length; i++) {
            if (tileLine[i] != Tile.ZERO) {
                res[t++] = tileLine[i];
            }
        }

        for (int i = 1; i < tileLine.length; i++) {
            if (res[i - 1] == res[i] && res[i - 1] != Tile.ZERO) {
                res[i - 1] = res[i].upgrade();
                res[i] = Tile.ZERO;
                score += res[i - 1].getScore();

                for (int j = i; j < tileLine.length - 1; j++) {
                    res[j] = res[j + 1];
                    res[j + 1] = Tile.ZERO;
                }
            }
        }

        isMoved = !Arrays.equals(res, tileLine);
        return new LineMargeResult(score, isMoved, res);
    }

    public MargeResult marge() {
        ITile[][] res = new ITile[this.dimension][this.dimension];
        int score = 0;
        boolean isMoved = false;
        for (int i = 0; i < this.dimension; i++) {
            LineMargeResult result = lineMarge(this.tileGrid[i]);
            res[i] = result.getLineTile();
            score += result.getScore();
            isMoved = isMoved || result.isMoved();
        }
        this.tileGrid = res;
        int loop = (4 - (this.rotateCount % 4) % 4);
        for (int x = 0; x < loop; x++) {
            this.rot90();
        }
        return new MargeResult(this.tileGrid, score, isMoved);
    }
}

class LineMargeResult {
    private int score;
    private boolean isMoved;
    private ITile[] lineTile;

    LineMargeResult(int score, boolean moved, ITile[] lineTile) {
        this.score = score;
        this.isMoved = moved;
        this.lineTile = lineTile;
    }

    public ITile[] getLineTile() {
        return lineTile;
    }

    public int getScore() {
        return score;
    }

    public boolean isMoved() {
        return isMoved;
    }

}

class MargedObjectRuntimeException extends RuntimeException {

}
