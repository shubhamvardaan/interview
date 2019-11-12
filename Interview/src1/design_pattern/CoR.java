package design_pattern;

abstract class Logger {
	public static int ERR = 3;
	public static int NOTICE = 5;
	public static int DEBUG = 7;
	protected int mask;
	protected Logger next;

	public Logger setNext(Logger log) {
		next = log;
		return log;
	}

	public void message(String msg, int priority) {
		if (priority <= mask) {
			writeMessage(msg);
			if (next != null) {
				next.message(msg, priority);
			}
		}
	}

	abstract protected void writeMessage(String msg);
}

class StdoutLogger extends Logger {
	public StdoutLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Writing to stdout " + msg);

	}
}

class EmailLogger extends Logger {
	public EmailLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Sending via email " + msg);

	}
}

class StderrLogger extends Logger {
	public StderrLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Sending to stderr " + msg);

	}
}

public class CoR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger, logger1, logger2;
		logger = new StdoutLogger(Logger.DEBUG);
		logger1 = logger.setNext(new EmailLogger(Logger.NOTICE));
		logger2 = logger1.setNext(new StderrLogger(Logger.ERR));
		logger.message("Entering function y.", Logger.DEBUG);
		logger.message("Step 1 completed.", Logger.NOTICE);
		logger.message("An error has occured.", Logger.ERR);

	}

}
