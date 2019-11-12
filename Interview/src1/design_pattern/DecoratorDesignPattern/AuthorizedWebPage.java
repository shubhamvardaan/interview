package design_pattern.DecoratorDesignPattern;

public class AuthorizedWebPage extends WebPageDecorator {

	public AuthorizedWebPage(Webpage basicwebpage) {
		super(basicwebpage);
	}

	public void authorizedUser() {
		System.out.println("Authorizing user");
	}

	public void display() {
		super.display();
		this.authorizedUser();
	}
}
