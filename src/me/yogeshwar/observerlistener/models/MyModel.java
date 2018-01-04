package me.yogeshwar.observerlistener.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyModel implements PropertyChangeNotifier {
	Score scoreboard = new Score(0, 0);
	List<PropertyChangeListener> listeners = new ArrayList<>();

	public class Score {
		AtomicInteger runs;
		AtomicInteger wickets;

		public Score(int runs, int wickets) {
			super();
			this.runs = new AtomicInteger(runs);
			this.wickets = new AtomicInteger(wickets);
		}

		/**
		 * @return the runs
		 */
		public int getRuns() {
			return runs.get();
		}

		/**
		 * @param runs
		 *            the runs to set
		 */
		public void setRuns(int runs) {
			this.runs.set(runs);
		}

		/**
		 * @return the wickets
		 */
		public int getWickets() {
			return wickets.get();
		}

		/**
		 * @param wickets
		 *            the wickets to set
		 */
		public void setWickets(int wickets) {
			this.wickets.set(wickets);
		}

	}

	public void setRuns(int runs) {
		notifyListeners("RUNS", scoreboard.runs.get(), runs);
		scoreboard.setRuns(runs);
	}

	public void setWickets(int wickets) {
		notifyListeners("WICKETS", scoreboard.wickets.get(), wickets);
		scoreboard.setWickets(wickets);
	}

	public void incrementRuns(int byRuns) {
		notifyListeners("RUNS", scoreboard.runs.get(), scoreboard.runs.get() + byRuns);
		scoreboard.setRuns(scoreboard.runs.get() + byRuns);
	}

	public void incrementWickets(int byWickets) {
		notifyListeners("WICKETS", scoreboard.wickets.get(), scoreboard.wickets.get() + byWickets);
		scoreboard.setWickets(scoreboard.wickets.get() + byWickets);
	}

	/**
	 * @param listener
	 *            the listener to add
	 */
	public void register(PropertyChangeListener listener) {
		this.listeners.add(listener);
	}

	public void notifyListeners(String propertyName, Object oldValue, Object newValue) {
		for (PropertyChangeListener propertyChangeListener : listeners) {
			propertyChangeListener
					.propertyChange(new PropertyChangeEvent(this.getClass(), propertyName, oldValue, newValue));
		}
	}

}
