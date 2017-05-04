/* Jacob Culley
 * CS 210 
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.TableMap;
import root.data_statement.xml.Writer;

/**
 * Removes Table from Table Collection.
 */
public class DropCommand implements root.ICommand {

	private Pattern patternOne = Pattern.compile("drop\\s+table\\s+(\\w+)\\s*;",
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
		
		TableMap.getTableMap().removeTable(tableName);
		new Writer();
	}

}
