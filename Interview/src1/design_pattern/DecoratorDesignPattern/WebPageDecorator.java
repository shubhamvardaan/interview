package design_pattern.DecoratorDesignPattern;

public abstract class WebPageDecorator implements Webpage {
	protected Webpage basicwebpage;

	public WebPageDecorator(Webpage basicwebpage) {
		this.basicwebpage = basicwebpage;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		this.basicwebpage.display();
	}

}
