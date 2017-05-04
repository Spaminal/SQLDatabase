/* Jacob Culley
 * CS 210 
 */

package root.data_statement.tables;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import root.exceptions.DataMismatchException;
import root.exceptions.DuplicateDataException;
import root.exceptions.TableException;

/**
 * Table Field creation and management.
 */
public class Table {

	private ArrayList<Field> tableFields;
	private Pattern fieldTypePattern = Pattern.compile(
			"([a-zA-Z]+)\\s+(integer|date|real|varchar|"
					+ "char\\s*\\(\\s*[\\d]+\\s*\\)|boolean)",
			Pattern.CASE_INSENSITIVE);
	private String tableName;
	private boolean hasValues = false;

	/**
	 * Creates blank Table.
	 */
	public Table() {

	}

	/**
	 * Creates Blank table with name.
	 */
	public Table(String tableName) {
		tableFields = new ArrayList<Field>();
		this.tableName = tableName;
	}

	/**
	 * Creates Table with Fields with FieldTypes.
	 */
	public Table(String tableName, String[] withFields) {
		try {
			if (dupeField(withFields)) {
				throw new DuplicateDataException("Table Already Exists");
			} else {
				tableFields = new ArrayList<Field>();
				this.tableName = tableName.toUpperCase();
				for (String fieldVar : withFields) {
					Matcher valM = fieldTypePattern.matcher(fieldVar);
					if (valM.matches()) {
						Field field = new Field(valM.group(1).toUpperCase(),
								valM.group(2).toUpperCase());
						tableFields.add(field);
					}
				}
			}
		} catch (DuplicateDataException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Adds Field with FieldType to Table.
	 */
	public void addField(String fieldName, String fieldType) {
		try {
			if (containsField(fieldName)) {
				throw new DuplicateDataException("Field Already Exists");
			} else {
				tableFields.add(new Field(fieldName.toUpperCase(), fieldType
						.toUpperCase()));
			}
		} catch (DuplicateDataException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Adds Field with Char and Size to Table.
	 */
	public void addField(String fieldName, String fieldType, int charSize) {
		try {
			if (containsField(fieldName)) {
				throw new DuplicateDataException("Field Already Exists");
			} else {
				tableFields.add(new Field(fieldName.toUpperCase(), fieldType
						.toUpperCase(), charSize));
			}
		} catch (DuplicateDataException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Add Values to Table.
	 */
	public void addFieldValues(String[] valueList) {
		try {
			if (valueList.length != tableFields.size()) {
				throw new DataMismatchException("Values Don't Match");
			} else {
				for (int i = 0; i > tableFields.size(); i++) {
					Field f = tableFields.get(i);
					f.addValue(valueList[i]);
				}
			}
			hasValues = true;
		} catch (DataMismatchException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Renames this table.
	 */
	public void rename(String newName) {
		tableName = newName;
	}

	/**
	 * Gets name of Table.
	 */
	public String getName() {
		return this.tableName;
	}

	/**
	 * Gets Field with fieldName.
	 */
	public Field getField(String fieldName) {
		for (Field field : getFields()) {
			if (field.getFieldName().equals(fieldName)) {
				return field;
			}
		}
		return new Field();
	}

	/**
	 * Gets List of Fields
	 */
	public ArrayList<Field> getFields() {
		return tableFields;
	}

	/**
	 * Gets Value State.
	 */
	public boolean hasValues() {
		return hasValues;
	}

	/**
	 * Checks if Table contains Field with fieldName.
	 */
	public boolean containsField(String fieldName) {
		for (Field f : tableFields) {
			if (f.getName() == fieldName) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks initial Field list for duplicates.
	 */
	public boolean dupeField(String[] withFields) {
		ArrayList<String> fieldNames = new ArrayList<String>();
		for (String fieldName : withFields) {
			Matcher dupeMatch = fieldTypePattern.matcher(fieldName);
			if (dupeMatch.matches()) {
				if (fieldNames.contains(dupeMatch.group(1))) {
					return true;
				}
				fieldNames.add(dupeMatch.group(1));
			}
		}
		return false;
	}

	/**
	 * Displays Fields and Field Types in Table.
	 */
	public void printFields() {
		try {
			System.out.println();
			for (Field f : tableFields) {
				System.out.println(f);
			}
		} catch (NullPointerException e) {
			System.out.println("No Data To Display");
		}
	}

	@Override
	public String toString() {
		return "Table Name: " + tableName;

	}

}
