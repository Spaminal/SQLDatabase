/* Jacob Culley
 * CS 210 
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;
import root.data_statement.tables.TableMap;
import root.data_statement.xml.Writer;

/**
 * Creates Table with field(s) and type.
 */
public class DefineTableCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"define\\s+table\\s+(\\w+)\\s+having\\s+fields"
					+ "\\s*\\((.+)\\)\\s*;", Pattern.CASE_INSENSITIVE);
	private Pattern fieldListPattern = Pattern.compile(",\\s*");
	private Pattern fieldTypePattern = Pattern.compile(
			"([a-zA-Z]+)\\s+(integer|date|real|varchar|"
					+ "char\\s*\\(\\s*[\\d]+\\s*\\)|boolean)",
			Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String extFieldList;
	private String[] fieldList;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(1).toUpperCase();
			extFieldList = matcherOne.group(2).toUpperCase();
			fieldList = fieldListPattern.split(extFieldList, -1);
			for (String field : fieldList) {
				Matcher typeMatcher = fieldTypePattern.matcher(field.trim());
				if (!typeMatcher.matches()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		TableMap.getTableMap().createTable(tableName, fieldList);
		new Writer(".data.xml");
		

	}

}
