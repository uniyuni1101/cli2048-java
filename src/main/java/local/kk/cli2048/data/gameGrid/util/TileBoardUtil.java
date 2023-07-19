package local.kk.cli2048.data.gameGrid.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import local.kk.cli2048.data.gameGrid.ITile;
import local.kk.cli2048.data.gameGrid.Tile;

public class TileBoardUtil {
    private static Random rand = new Random();

    public static ITile[][] createBoardZeroFill(int dimension) {
        ITile[][] tiles = new ITile[dimension][dimension];
        for (ITile[] line : tiles) {
            Arrays.fill(line, Tile.ZERO);
        }
        return tiles;
    }

    public static ITile[][] createNewTileEmptyField(ITile[][] tile) {
        return createNewTileEmptyField(tile, createNewTileNum());
    }

    public static ITile[][] createNewTileEmptyField(ITile[][] tile, int createNum) {
        List<Point> emptyField = new ArrayList<>();

        for (int row = 0; row < tile.length; row++) {
            for (int col = 0; col < tile.length; col++) {
                if (tile[row][col] == Tile.ZERO) {
                    emptyField.add(new Point(row, col));
                }
            }
        }

        for (int i = Math.min(createNum, emptyField.size()); i > 0; i--) {
            Point p = emptyField.remove(rand.nextInt(emptyField.size()));
            tile[p.row][p.col] = createNewTile();
        }
        return tile;
    }

    private static int createNewTileNum() {
        double d = rand.nextDouble();

        if (d < 0.1) {
            return 0;
        } else if (d < 0.8) {
            return 1;
        } else {
            return 2;
        }
    }

    private static ITile createNewTile() {
        return rand.nextDouble() < 0.1 ? Tile.SCORE_4 : Tile.SCORE_2;
    }

}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.col = col;
        this.row = row;
    }
}