package me.yogeshwar.observerlistener.observer;

import me.yogeshwar.observerlistener.models.MyModel;


public class ObserverListenerDemo {
	public static void modifyModel(MyModel model) {
		model.incrementRuns(2);
		model.incrementWickets(1);
		model.incrementRuns(4);
		model.incrementWickets(1);
		model.incrementRuns(4);
		model.incrementRuns(6);
	}
	public static void main(String[] args) {
		MyModel model = new MyModel();
		new MyObserver(model);
		new AnotherObserver(model);
		modifyModel(model);
	}

}
