package design_pattern.DecoratorDesignPattern;

public class BasicWebpage implements Webpage {

	String name = "basic webpage";
	int page_no = 2;
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(name);
		System.out.println(page_no);
	}

	
}
