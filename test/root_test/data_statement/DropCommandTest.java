/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.DropCommand;
import root_test.AbstractCommandTest;

public class DropCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new DropCommand();
		good = new String[] {
				"drop table emp;",
				"drop  table emp;",
				"drop table  emp;",
				"drop table emp ;",
				"drop  table  emp      ;",
				"drop table emp;",
				"drop table emp77    ;",
				"drop table emp7;",
				
		};
		bad = new String[] { 
				"dro table emp;",
				"drop tabl emp;",
				"drop table ;",
				"drop table emp",
				"drop table emp:",
				"drop table emp;;",
				"droptable emp;",
				"drop table em9$;",
				"drop tableemp;",
				"drop table emp",
				"droptable empham;",
				
				
		};
	}
}
