package local.kk.cli2048.data.gameGrid;

public interface ITileBoard {
    void up();

    void down();

    void left();

    void right();

    boolean isMoved();

    void addScore(int score);

    ITile[][] getBoardGrid();
}
