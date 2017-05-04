/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class InsertCommand.
 */
public class InsertCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"insert\\s*\\((.+)\\)\\s*into\\s+(\\w+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private Pattern valueListPattern = Pattern
			.compile(",(?=([^\']*\'[^\']*\')*[^\']*$)");

	private String tableName;
	private String[] valueList;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(2);
			valueList = valueListPattern.split(matcherOne.group(1), -1);
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		
	}

}
