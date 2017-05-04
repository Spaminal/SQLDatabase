/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 * SelectCommand class base supplied by instructor
 */

package root.query_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * Select Command.
 */
public class SelectCommand implements ICommand {

	private Pattern patternOne = Pattern.compile("select\\s+(\\w+)\\s+"
			+ "where\\s+(\\w+)\\s+(=|!=|<|>|<=|>=)\\s*(.+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private Pattern patternTwo = Pattern.compile("select\\s+(\\w+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String tableName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		Matcher matcherTwo = patternTwo.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(1);
			return true;
		} else if (matcherTwo.matches()) {
			tableName = matcherTwo.group(1);
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		System.out.println("This is a syntactically correct Select statement");

	}

}
