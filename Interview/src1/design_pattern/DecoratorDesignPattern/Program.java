package design_pattern.DecoratorDesignPattern;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Webpage page = new BasicWebpage();
		page = new AuthenticatedWebPage(page);
		page = new AuthorizedWebPage(page);
		
		page.display();
	}

}
