package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	protected List<Observer> observerList = new ArrayList<Observer>();
	
	public abstract void notifyObserver();
	
	public void add(Observer observer) {
		observerList.add(observer);
	}
	
	public void remove(Observer observer) {
		observerList.remove(observer);
	}
	
}
