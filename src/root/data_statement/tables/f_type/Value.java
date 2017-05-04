package root.data_statement.tables.f_type;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.Field;
import root.exceptions.DataMismatchException;

/**
 * Assures field type and field value are compatible.
 */
public abstract class Value extends Field {

	private Pattern datePattern = Pattern.compile("\'\\d{2}/\\d{2})/\\d{4}\'");
	private String valueType;
	private String varcharVal;
	private long dateVal;
	private int intVal;
	private double realVal;
	private int charSize;
	private char[] charVal;
	private boolean boolVal;

	public Value(String valType, String valStr) {
		try {
			if (valType.equals("INTEGER")) {
				intVal = Integer.parseInt(valStr);
			} else if (valType.equals("REAL")) {
				realVal = Double.parseDouble(valStr);
			} else if (valType.equals("DATE")) {
				Matcher dateMatcher = datePattern.matcher(valStr);
				if (!dateMatcher.matches()) {
					throw new DataMismatchException("Date Mismatch");
				} else {
					int month = Integer.parseInt(dateMatcher.group(1));
					int day = Integer.parseInt(dateMatcher.group(2));
					int year = Integer.parseInt(dateMatcher.group(3));
					if (!checkDate(month, day, year)) {
						throw new DataMismatchException("Incorrect Date");
					} else {
						@SuppressWarnings("deprecation")
						Date date = new Date(year, month, day);
						dateVal = date.getTime();
					}
				}
			} else if (valType.equals("BOOLEAN")) {
				if (valStr.matches("?i:true")) {
					boolVal = true;
				} else if (valStr.matches("?i:false")) {
					boolVal = false;
				} else {
					throw new DataMismatchException("Not A Boolean Value");
				}
			} else if (valType.equals("VARCHAR")) {
				varcharVal = valStr.substring(1, valStr.length() - 1);
			} 
		} catch (NumberFormatException e) {
			System.out.println("Not An Integer");
		} catch (DataMismatchException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Varchar Mismatch");
		}
	}
	
	/**
	 * Char Value Constructor.
	 */
	public Value(String valType, String valStr, int valSize){
		try {
			if (!valType.equals("CHAR")) {
				throw new DataMismatchException("Char Mismatch");
			} else {
				charSize = valSize;
				if (sizeValidate(valStr, charSize)){
					charVal = new char[charSize];
					for (int i = 0; i < charSize; i++){
						charVal[i] = valStr.charAt(i);
					}
				}
			}
		} catch (DataMismatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Gets Integer Value.
	 */
	public int getIntValue() {
		return intVal;
	}
	
	/**
	 * Gets Real Value.
	 */
	public double getRealValue() {
		return realVal;
	}
	
	/**
	 * Gets Boolean Value.
	 */
	public boolean getBoolValue() {
		return boolVal;
	}
	
	/**
	 * Gets Varchar Value.
	 */
	public String getVarcharValue() {
		return varcharVal;
	}
	
	/**
	 * Gets Char Value.
	 */
	public char[] getCharValue() {
		return charVal;
	}
	
	/**
	 * Gets Char String.
	 */
	public String getCharValueStr() {
		String charStr = "";
		for(int i = 0; i < charVal.length; i++){
			charStr = charStr + charVal[i];
		}
		return charStr;
	}
	
	/**
	 * Gets Date Value in Milliseconds.
	 */
	public long getDate() {
		return dateVal;
	}
	
	/**
	 * Gets Formatted Date Value.
	 */
	public String getDateStr() {
		SimpleDateFormat df = new SimpleDateFormat("MM:dd:yyyy");
		String dateStr = df.format(dateVal);
		return dateStr;
	}

	/**
	 * Checks if Date Value is Syntactically Correct.
	 */
	public boolean checkDate(int m, int d, int y) {
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10
				|| m == 12) {
			if (d < 1 && d > 31) {
				return false;
			}
		} else if (m == 4 || m == 6 || m == 9 || m == 11) {
			if (d < 1 && d > 30) {
				return false;
			}
		} else if (m == 2) {
			if (y % 4 == 0 && d < 1 && d > 29) {
				return false;
			} else if (d < 1 && d > 29) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if Char Value matches Char Size.
	 */
	public boolean sizeValidate(String str, int size) {
		try {
			if (str.length() != charSize) {
				throw new DataMismatchException("Char Size Mismatch");
			}
		} catch (DataMismatchException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public String toString() {
		if (valueType.equals("INTEGER")){
			return Integer.toString(intVal);
		} else if (valueType.equals("REAL")){
			return Double.toString(realVal);
		} else if (valueType.equals("DATE")){
			return getDateStr();
		} else if (valueType.equals("BOOLEAN")){
			return Boolean.toString(boolVal);
		} else if (valueType.equals("VARCHAR")){
			return varcharVal;
		} else if (valueType.equals("CHAR")){
			return getCharValueStr();
		}
		
		return "";
	}
}
