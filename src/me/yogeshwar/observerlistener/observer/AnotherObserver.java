package me.yogeshwar.observerlistener.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import me.yogeshwar.observerlistener.models.PropertyChangeNotifier;

public class AnotherObserver implements PropertyChangeListener {

	public AnotherObserver(PropertyChangeNotifier notifier) {
		super();
		notifier.register(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Observed change of "+evt.getPropertyName()+" from "+evt.getOldValue()+" to "+evt.getNewValue());
	}

}
