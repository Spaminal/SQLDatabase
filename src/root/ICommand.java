/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 * ICommand interface base supplied by instructor
 */

package root;

/**
 * Matches each command and executes command's function if match found.
 */
public interface ICommand {

	/**
	 * Matches the input against each commands pattern
	 */
	boolean matches(String input);

	/**
	 * Performs the matching commands function.
	 */
	void execute();
}