package local.kk.cli2048.game;

import java.io.Console;
import java.io.IOError;
import java.io.IOException;

import local.kk.cli2048.base.BaseView;

public class GameView extends BaseView implements IGameView {
    private Console cons = System.console();
    private IGamePresenter mPresenter;

    public GameView(IGamePresenter presenter) {

        this.mPresenter = presenter;
    }

    private void inputPlayerName() {
        System.out.print("PlayerName (Default Guest): ");
        String name = "Guest";
        try {
            name = cons.readLine();
        } catch (IOError e) {
            System.exit(1);
        }

        this.mPresenter.setPlayerName(name);
        this.show();
    }

    private void display2048Board() {

    }

    private void displayData() {

    }

    private void displayHelper() {
        this.show();
        System.out.println();
        StringBuilder builder = new StringBuilder();
        builder.append("Command: w -> UP\n");
        builder.append("Command: a -> LEFT\n");
        builder.append("Command: s -> DOWN\n");
        builder.append("Command: d -> RIGHT\n");
        builder.append("Command: n, N -> setting Player Name\n");
        builder.append("Command: h, H, help, HELP -> showHelp\n");

        System.out.println(builder.toString());
        System.out.println();
    }

    public void show() {
        int[][] grid = this.mPresenter.getGameGrid();
        int score = this.mPresenter.getPlayerScore();
        String name = this.mPresenter.getPlayerName();

        for (int[] line : grid) {
            for (int item : line) {
                System.out.print(item);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        System.out.print("Player: ");
        System.out.println(name);

        System.out.print("Score: ");
        System.out.println(score);
    }

    private KeyEvent getUserEvent() {
        System.out.print("Command: ");
        String input = "";
        try {
            input = cons.readLine();
        } catch (IOError e) {
            System.exit(1);
        } catch (IndexOutOfBoundsException e) {
        }

        switch (input) {
            case "w":
                return KeyEvent.UP;
            case "a":
                return KeyEvent.LEFT;
            case "s":
                return KeyEvent.DOWN;
            case "d":
                return KeyEvent.RIGHT;
            case "h":
            case "H":
            case "help":
            case "HELP":
                return KeyEvent.HELP;
            case "n":
            case "N":
                return KeyEvent.INPUT_USERNAME;
            default:
                return KeyEvent.OTHER;
        }
    }

    public void run() {

        while (!this.isDoneState()) {
            switch (this.getUserEvent()) {
                case UP:
                    this.mPresenter.up();
                    break;

                case DOWN:
                    this.mPresenter.down();
                    break;

                case RIGHT:
                    this.mPresenter.right();
                    break;

                case LEFT:
                    this.mPresenter.left();
                    break;

                case INPUT_USERNAME:
                    this.inputPlayerName();
                    break;

                case HELP:
                    this.displayHelper();
                    break;

                default:
                    this.displayHelper();
            }
        }
    }

}
