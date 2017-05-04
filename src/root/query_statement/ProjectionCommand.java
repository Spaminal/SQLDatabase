/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.query_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class ProjectionCommand.
 */
public class ProjectionCommand implements ICommand {

	private Pattern patternOne = Pattern
			.compile("project\\s+(\\w+)\\s+over\\s+(.+);",
					Pattern.CASE_INSENSITIVE);
	private Pattern fieldListPattern = Pattern.compile("(,\\s*)");
	private Pattern fieldPattern = Pattern.compile("\\s*([a-zA-Z]+)");
	private String queryList;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			String[] fieldList = fieldListPattern.split(matcherOne.group(2));
			for (String field : fieldList) {
				Matcher fieldMatcher = fieldPattern.matcher(field.trim());
				if (!fieldMatcher.matches()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		System.out
				.println("This is a syntactically correct Projection statement");

	}

}
