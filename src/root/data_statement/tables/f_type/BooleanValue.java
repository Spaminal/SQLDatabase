package root.data_statement.tables.f_type;

import root.exceptions.DataMismatchException;

/**
 * Boolean value storage.
 */
public class BooleanValue extends Value {

	public BooleanValue(String valType, String valStr) {
		super (valType, valStr);
	}
	
}
