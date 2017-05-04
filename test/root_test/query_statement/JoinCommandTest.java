/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.JoinCommand;
import root_test.AbstractCommandTest;

public class JoinCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new JoinCommand();
		good = new String[] {
				"join emp and dept;",
				"join  emp  and  dept           ;",
				"join emp and dept;",
				"join emp and dept;",
		};
		bad = new String[] { 
				"join emp and dept",
				"joinemp and dept;",
				"jin emp and dept;",
				"join emp and dept::;",
				"join emp anddept;",
				"join empand dept;dd",
		};
	}
}
