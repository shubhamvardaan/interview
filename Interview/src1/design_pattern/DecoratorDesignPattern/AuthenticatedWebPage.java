package design_pattern.DecoratorDesignPattern;

public class AuthenticatedWebPage extends WebPageDecorator {

	public AuthenticatedWebPage(Webpage basicwebpage) {
		super(basicwebpage);
		// TODO Auto-generated constructor stub
	}

	public void authenticatedUser() {
		System.out.println("Aauthenticating user");
	}

	public void display() {
		super.display();
		this.authenticatedUser();
	}

}
