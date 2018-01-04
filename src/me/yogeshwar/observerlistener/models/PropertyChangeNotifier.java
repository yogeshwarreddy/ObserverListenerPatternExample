package me.yogeshwar.observerlistener.models;

import java.beans.PropertyChangeListener;

public interface PropertyChangeNotifier {
	public void register(PropertyChangeListener listener);
	public void notifyListeners(String propertyName, Object oldValue, Object newValue);
}
