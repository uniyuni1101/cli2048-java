package local.kk.cli2048.data.gameGrid;

public interface ITile {
    ITile upgrade();

    ITile clear();

    int getScore();
}
