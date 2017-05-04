/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class UpdateCommand.
 */
public class UpdateCommand implements ICommand {

	private Pattern patternOne = Pattern.compile("update\\s+(\\w+)\\s+"
			+ "set\\s+([a-zA-Z]+)\\s+=\\s+(.+)\\s+"
			+ "where\\s+(\\w+)\\s*(=|!=|<|>|<=|>=)\\s*(.+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private Pattern patternTwo = Pattern.compile(
			"update\\s+(\\w+)\\s+set\\s+([a-zA-Z]+)\\s+=\\s+(.+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	
	private String tableName;
	private String fieldName;
	private String fieldValue;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		Matcher matcherTwo = patternTwo.matcher(input.trim());
		if (matcherOne.matches()) {
			return true;
		} else if (matcherTwo.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		System.out.println("This is a syntactically correct Update statement");
	}

}
