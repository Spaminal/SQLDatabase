/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */

package root.admin_statement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import root.Driver;
import root.ICommand;
import root.data_statement.xml.Writer;

/**
 * Reads matching file and run command(s) found in the file.
 */
public class ReadCommand implements ICommand {

	private Pattern patternOne = Pattern.compile("read\\s+'(.+)'\\s*;",
			Pattern.CASE_INSENSITIVE);
	private String fileName;

	@Override
	public boolean matches(String input) {
		Matcher matcherOne = patternOne.matcher(input.trim());
		if (matcherOne.matches()) {
			fileName = matcherOne.group(1).replaceAll("\\s+", "");
			if (new File(fileName).exists()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void execute() {
		try {
			if (new File(fileName).canRead()) {
				System.out.println(" > Reading in File < ");
				lineReader();
				System.out.println(" > End of File Reading < ");
			} else {
				throw new FileNotFoundException("Check your filepath");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Checks end behavior of read file
	 */
	public void lineReader() throws IOException {
		Scanner inFile = new Scanner(new File(fileName));
		Driver driver = new Driver();
		while (inFile.hasNextLine()) {
			driver.lineIntake(inFile);
		}
		inFile.close();
		new Writer();
	}
}
