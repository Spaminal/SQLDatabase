/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.query_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class OrderCommand.
 */
public class OrderCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"order\\s+(\\w+)\\s+by\\s+([a-zA-Z]+)\\s+descending\\s*;",
			Pattern.CASE_INSENSITIVE);
	private Pattern patternTwo = Pattern.compile(
			"order\\s+(\\w+)\\s+by\\s+([a-zA-Z]+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String queryList;
	private String fieldName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		Matcher matcherTwo = patternTwo.matcher(input.trim());
		if (matcherOne.matches()) {
			queryList = matcherOne.group(1);
			fieldName = matcherOne.group(2);
			return true;
		} else if (matcherTwo.matches()) {
			queryList = matcherTwo.group(1);
			fieldName = matcherTwo.group(2);
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		System.out.println("This is a syntactically correct Order statement");

	}

}
