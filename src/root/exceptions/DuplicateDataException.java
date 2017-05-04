package root.exceptions;

@SuppressWarnings("serial")
public class DuplicateDataException extends Exception {
	
	public DuplicateDataException(String message){
		super(message);
	}
}
