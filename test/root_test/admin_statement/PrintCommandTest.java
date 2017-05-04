/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.admin_statement;

import org.junit.Before;

import root.admin_statement.PrintCommand;
import root_test.AbstractCommandTest;

public class PrintCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new PrintCommand();
		good = new String[] {
				"print dictionary;",
				"print diction;",
				"print emp;",
				"print emp ;",
				"print  emp   ;",
				"print  emp;",
				
		};
		bad = new String[] { 
				"print ;",
				"print emp dagh;",
				"print emp",
				"print emp:",
				"print 'emp';",
				"printz emp;",
				"print;",
				"pr int;",
				
		};
	}
}
