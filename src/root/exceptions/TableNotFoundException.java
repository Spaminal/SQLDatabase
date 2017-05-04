package root.exceptions;

@SuppressWarnings("serial")
public class TableNotFoundException extends Exception{
	

	public TableNotFoundException(String message){
		super(message);
	}
}
