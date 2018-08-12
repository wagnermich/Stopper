package at.michael.stopper.handler;

import at.michael.stopper.views.main.MainPresenter;

public interface IPresenter {

	public void injectPreviousPresenter(IPresenter main);
}
