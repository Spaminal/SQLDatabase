/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.IntersectionCommand;
import root_test.AbstractCommandTest;

public class IntersectionCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new IntersectionCommand();
		good = new String[] {
				"intersect emp and dept;",
				"intersect emp and dept;",
				"intersect emp and dept ;",
				"intersect  emp  and  dept     ;",
		};
		bad = new String[] { 
				"intersect emp and dept",
				"intersect  and dept;",
				"intersect emp and dept:",
				"interse emp and dept;",
		};
	}
}
