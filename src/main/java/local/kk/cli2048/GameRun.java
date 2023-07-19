package local.kk.cli2048;

import local.kk.cli2048.data.DataManager;
import local.kk.cli2048.data.IDataManager;
import local.kk.cli2048.game.GamePresenter;

import local.kk.cli2048.game.GameView;
import local.kk.cli2048.game.IGamePresenter;

public class GameRun {
    public static void main(String[] args) throws Exception {
        IGamePresenter pre = new GamePresenter();
        GameView view = new GameView(pre);
        IDataManager data = new DataManager(pre);
        view.start();
        view.join();
    }
}
