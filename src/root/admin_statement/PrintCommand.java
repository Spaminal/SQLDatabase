/* Jacob Culley
 * CS 210 
 */

package root.admin_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.TableMap;

/**
 * Prints the Directory specified
 */
public class PrintCommand implements root.ICommand {

	private Pattern patternOne = Pattern.compile("print\\s+(\\w+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private Pattern patternTwo = Pattern.compile("dictionary",
			Pattern.CASE_INSENSITIVE);
	private String tableName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(1).toUpperCase();
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		Matcher matcherTwo = patternTwo.matcher(tableName);
		if (matcherTwo.matches()) {
			TableMap.getTableMap().printTables();
		}

	}

}
