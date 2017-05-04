/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.admin_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;

/**
 * The Class BackupCommand.
 */
public class BackupCommand implements ICommand {

	private Pattern patternOne = Pattern.compile(
			"backup\\s+to\\s+'(.+)'\\s*;", Pattern.CASE_INSENSITIVE);
	private String fileName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			fileName = matcherOne.group(1).replaceAll("\\s+", "");
			return true;
		}
		return false;
	}

	@Override
	public void execute() {

		System.out.println("This is a syntactically correct Backup statement");

	}

}
