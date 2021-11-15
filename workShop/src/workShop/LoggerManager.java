package workShop;

public class LoggerManager implements LoggerService{

	private Logger[] loggers;
	
	public LoggerManager(Logger ...loggers) {
		super();
		this.loggers = loggers;
	}
	
	@Override
	public void log() {
		for (Logger logger : loggers) {
			logger.log();
		}
		
	}

	
}
