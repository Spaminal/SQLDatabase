package root.data_statement.tables.f_type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.Field;

/**
 * Field Type
 */
public class FieldType extends Field {

	private String fieldType;
	private int fieldSize;

	/**
	 * Blank FieldType constructor.
	 */
	public FieldType() {
		
	}

	/**
	 * Creates new Field Type from Define Table
	 */
	public FieldType(String typeString) {
		toType(typeString);
	}

	/**
	 * Creates new CharType from Reader.
	 */
	public FieldType(String typeStr, int size) {
		fieldType = typeStr;
		fieldSize = size;
	}

	/**
	 * Gets Field Type.
	 */
	public String getType() {
		return fieldType;
	}

	/**
	 * Gets Field Size as an int.
	 */
	public int getSizeInt() {
		return fieldSize;
	}
	
	/**
	 * Gets Field Size as s String.
	 */
	public String getSizeStr(){
		return Integer.toString(fieldSize);
	}

	/**
	 * Normalizes new Field Types.
	 */
	public void toType(String typeStr) {
		Pattern charParseP = Pattern.compile("char\\s*\\(\\s*(\\d+)\\s*\\)",
				Pattern.CASE_INSENSITIVE);
		Matcher charParseM = charParseP.matcher(typeStr);
		if (typeStr.matches("(?i:integer)")) {
			fieldType = "INTEGER";
		} else if (typeStr.matches("(?i:date)")) {
			fieldType = "DATE";
		} else if (typeStr.matches("(?i:real)")) {
			fieldType = "REAL";
		} else if (typeStr.matches("(?i:varchar)")) {
			fieldType = "VARCHAR";
		} else if (typeStr.matches("(?i:boolean)")) {
			fieldType = "BOOLEAN";
		} else if (charParseM.matches()) {
			fieldType = "CHAR";
			fieldSize = Integer.parseInt(charParseM.group(1));
		}
	}

}
