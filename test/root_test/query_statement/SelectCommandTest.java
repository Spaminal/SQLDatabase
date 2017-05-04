/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.SelectCommand;
import root_test.AbstractCommandTest;

public class SelectCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new SelectCommand();
		good = new String[] {
				"select emp;",
				"select emp where sal > 500;",
				"select  emp where sal = 500;",
				"select emp  where sal < 500;",
				"select emp where  sal <= 500;",
				"select emp where sal  >=  500;",
				"select emp where sal  >=  '88/88/8888';",
		};
		bad = new String[] { 
				"selectemp where sal > 500;",
				"select emp where sal > 500",
				"select emp where sal> 500;",
				"selectemp;",
		};
	}
}
