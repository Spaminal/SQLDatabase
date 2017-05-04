/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.MinusCommand;
import root_test.AbstractCommandTest;

public class MinusCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new MinusCommand();
		good = new String[] {
				"minus emp and dept;",
				"minus  emp and dept;",
				"minus emp  and dept;",
				"minus emp and  dept;",
				"minus emp and dept ;",
				"minus  emp  and  dept ;",
				"minus emp and dept;",
				
				
		};
		bad = new String[] { 
				"minus emp and dept",
				"minus emp and dept:;",
				"minusemp and dept;",
				"minus empand dept;",
				"minus emp anddept;",
				"minus emp and;",
				"minu emp and dept;",
				"minus  and dept;",
				"minus emp and ;",
				
		};
	}
}
