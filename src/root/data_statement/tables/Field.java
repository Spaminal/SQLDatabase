/* Jacob Culley
 * CS 210 
 */

package root.data_statement.tables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.f_type.BooleanValue;
import root.data_statement.tables.f_type.CharValue;
import root.data_statement.tables.f_type.DateValue;
import root.data_statement.tables.f_type.FieldType;
import root.data_statement.tables.f_type.IntegerValue;
import root.data_statement.tables.f_type.RealValue;
import root.data_statement.tables.f_type.Value;
import root.data_statement.tables.f_type.VarcharValue;

/**
 * Field name, type, and value storage.
 */
public class Field extends Table {

	private String fieldName;
	private FieldType type;
	private Value fieldValue;
	private boolean hasValue = false;

	/**
	 * Creates blank Field.
	 */
	public Field() {
		fieldName = new String();
	}

	/**
	 * Creates new Field.
	 */
	public Field(String fieldName, String type) {
		this.fieldName = fieldName;
		this.type = new FieldType(type);
	}

	/**
	 * Creates new Field with Size from Reader.
	 */
	public Field(String fieldName, String fieldType, int size) {
		this.fieldName = fieldName;
		this.type = new FieldType(fieldType, size);
	}

	/**
	 * Adds Value to Field.
	 */
	public void addValue(String valStr) {
		toValue(valStr);
		hasValue = true;
	}

	/**
	 * Gets Field name.
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Gets FieldType.
	 */
	public String getFieldType() {
		return type.getType();
	}

	/**
	 * Gets Field Size as an Int.
	 */
	public int getFieldSizeInt() {
		return type.getSizeInt();
	}

	/**
	 * Get Field Size as a String.
	 */
	public String getFieldSizeStr() {
		return type.getSizeStr();
	}

	/**
	 * Gets Field Value.
	 */
	public Value getFieldValue() {
		return fieldValue;
	}

	/**
	 * Gets Field Value as a String.
	 */
	public String getFieldValueStr() {
		String val = fieldValue.toString();
		return val;
	}

	/**
	 * Filters Field Value to Field Types.
	 */
	public void toValue(String valStr) {
		if (type.equals("INTEGER") && valueMatch(valStr)) {
			fieldValue = new IntegerValue("INTEGER", valStr);
		} else if (type.equals("REAL") && valueMatch(valStr)) {
			fieldValue = new RealValue("REAL", valStr);
		} else if (type.equals("DATE") && valueMatch(valStr)) {
			fieldValue = new DateValue("DATE", valStr);
		} else if (type.equals("BOOLEAN") && valueMatch(valStr)) {
			fieldValue = new BooleanValue("BOOLEAN", valStr);
		} else if (type.equals("VARCHAR") && valueMatch(valStr)) {
			fieldValue = new VarcharValue("VARCHAR", valStr);
		} else if (type.equals("CHAR") && valueMatch(valStr)) {
			fieldValue = new CharValue("CHAR", valStr, type.getSizeInt());
		}
	}

	/**
	 * Checks if Value matches FieldType.
	 */
	public boolean valueMatch(String valStr) {
		Pattern intPattern = Pattern.compile("\\d+");
		Pattern realPattern = Pattern
				.compile("(\\d+\\.\\d*)|(\\d*\\.\\d+)|(\\d+)");
		Pattern datePattern = Pattern.compile("\'\\d{2}/\\d{2})/\\d{4}\'");
		Pattern boolPattern = Pattern.compile("true|false",
				Pattern.CASE_INSENSITIVE);
		Pattern varPattern = Pattern.compile(
				"\'(?=([^\']*\'[^\']*\')*[^\']*$)\'", Pattern.CASE_INSENSITIVE);
		Pattern charPattern = Pattern.compile(
				"char\\s*\\(\\s*(\\d+)\\s*\\)\\s*", Pattern.CASE_INSENSITIVE);
		if (type.equals("INTEGER")) {
			Matcher intMatch = intPattern.matcher(valStr);
			if (intMatch.matches()) {
				return true;
			}
		} else if (type.equals("REAL")) {
			Matcher realMatch = realPattern.matcher(valStr);
			if (realMatch.matches()) {
				return true;
			}
		} else if (type.equals("DATE")) {
			Matcher dateMatch = datePattern.matcher(valStr);
			if (dateMatch.matches()) {
				return true;
			}
		} else if (type.equals("BOOLEAN")) {
			Matcher boolMatch = boolPattern.matcher(valStr);
			if (boolMatch.matches()) {
				return true;
			}
		} else if (type.equals("VARCHAR")) {
			Matcher varMatch = varPattern.matcher(valStr);
			if (varMatch.matches()) {
				return true;
			}
		} else if (type.equals("CHAR")) {
			Matcher charMatch = charPattern.matcher(valStr);
			if (charMatch.matches()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (getFieldType().equals("CHAR") && hasValue) {
			return "Field Name: " + fieldName + ", Type: " + getFieldType()
					+ ", Size: " + getFieldSizeInt() + ", Value: "
					+ getFieldValue();
		} else if (getFieldType().equals("CHAR")) {
			return "Field Name: " + fieldName + ", Type: " + getFieldType()
					+ ", Size: " + getFieldSizeInt();
		} else if (!getFieldType().equals("CHAR") && hasValue) {
			return "Field Name: " + fieldName + ", Type: " + getFieldType()
					+ ", Value: " + getFieldValue();
		}
		return "Field Name: " + fieldName + ", Type: " + getFieldType();
	}
}
