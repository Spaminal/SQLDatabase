/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.UnionCommand;
import root_test.AbstractCommandTest;

public class UnionCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new UnionCommand();
		good = new String[] {
				"union emp and dept;",
				"union  emp and dept;",
				"union emp  and dept;",
				"union emp and  dept;",
				"union  emp  and  dept ;",
				"union emp and dept ;",
				
		};
		bad = new String[] { 
				"union emp and dept",
				"union emp and dept",
				"union emp anddept;",
				"union empand dept;",
				"unionemp and dept;",
				"union emp and dept",
				"union emp and;",
				
		};
	}
}
