package local.kk.cli2048.base;

public abstract class BasePresenter implements IPresenter {
    private IView view;
    private IModel model;

    public BasePresenter() {

    }

    public void attachModel(IModel model) {
        this.model = model;

    }

    public void attachView(IView view) {
        this.view = view;
    }
}
