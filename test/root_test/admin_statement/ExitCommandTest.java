/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.admin_statement;

import root.admin_statement.ExitCommand;
import root_test.AbstractCommandTest;

import org.junit.Before;

/**
 * The Class ExitCommandTest.
 */
public class ExitCommandTest extends AbstractCommandTest {
	
	@Override
	@Before
	public void setUp() throws Exception {
		command = new ExitCommand();
		good = new String[] { 
				"exit;",
				"EXIT;",
				"ExIt;" 
		};
		bad = new String[] { 
				"exit:",
				"xitts;",
				"EXI :;" 
		};

	}
}
