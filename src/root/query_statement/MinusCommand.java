/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.query_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class MinusCommand.
 */
public class MinusCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"minus\\s+(\\w+)\\s+and\\s+(\\w+)\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String queryListOne;
	private String queryListTwo;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			queryListOne = matcherOne.group(1);
			queryListTwo = matcherOne.group(2);
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		System.out.println("This is a syntactically correct Minus statement");

	}

}
