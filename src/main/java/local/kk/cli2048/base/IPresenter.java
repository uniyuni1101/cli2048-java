package local.kk.cli2048.base;

public interface IPresenter {
    void attachView(IView view);

    void attachModel(IModel model);
}
