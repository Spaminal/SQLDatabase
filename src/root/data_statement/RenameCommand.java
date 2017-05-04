/* Jacob Culley
 * CS 210 
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.data_statement.tables.TableMap;
import root.data_statement.xml.Writer;

/**
 * Renames table.
 */
public class RenameCommand implements root.ICommand {

	private Pattern patternOne = Pattern.compile(
			"rename\\s+table\\s+(\\w+)\\s+to\\s+(\\w+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String prevName;
	private String newName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			prevName = matcherOne.group(1).toUpperCase();
			newName = matcherOne.group(2).toUpperCase();
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		
		TableMap.getTableMap().renameTable(prevName, newName);
		new Writer();
	}

}
