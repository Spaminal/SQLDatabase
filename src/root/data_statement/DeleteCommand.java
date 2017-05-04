/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class DeleteCommand.
 */
public class DeleteCommand implements ICommand {

	private Pattern patternOne = Pattern.compile("delete\\s+(\\w+)\\s*;");
	private Pattern patternTwo = Pattern.compile("delete\\s+(\\w+)\\s+"
			+ "where\\s+([a-zA-Z]+)\\s+(=|!=|<|>|<=|>=)\\s+(.+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String boolExp;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		Matcher matcherTwo = patternTwo.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(1);
			return true;
		} else if (matcherTwo.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void execute() {
		System.out.println("This is a syntactically correct Delete statement");

	}

}
