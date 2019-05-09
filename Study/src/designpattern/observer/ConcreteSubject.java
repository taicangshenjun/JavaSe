package designpattern.observer;

public class ConcreteSubject extends Subject {

	@Override
	public void notifyObserver() {
	    System.out.println("����Ŀ�귢���ı�...");
	    System.out.println("--------------");       
	   
	    for(Object obs: observerList)
	    {
	        ((Observer)obs).response();
	    }
	}

}
