/* Jacob Culley
 * CS 210
 * Instructor Morehead
 */

package root.admin_statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import root.ICommand;
import root.data_statement.xml.Writer;

/**
 * Exits the program.
 */
public class ExitCommand implements ICommand {

	private Pattern patternOne = Pattern.compile("exit\\s*;",
			Pattern.CASE_INSENSITIVE);

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		new Writer();
		System.out.println("Now Closing");
		System.exit(1);
	}

}
