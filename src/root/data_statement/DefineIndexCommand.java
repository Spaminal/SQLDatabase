/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.data_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class DefineIndexCommand.
 */
public class DefineIndexCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"define\\s+index\\s+on\\s+(\\w+)"
					+ "\\s*(\\(\\s*[a-zA-Z]*\\s*\\))\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String indexName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			tableName = matcherOne.group(1);
			indexName = matcherOne.group(2);
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		System.out
				.println("This is a syntactically correct Define Index statement");
	}
}
