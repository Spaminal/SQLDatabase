/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.RenameCommand;
import root_test.AbstractCommandTest;

public class RenameCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new RenameCommand();
		good = new String[] {
				"rename table emp to dept;",
				"rename table emp  to dept;",
				"rename table emp to  dept;",
				"rename table emp to dept ;",
				"rename table   emp  to  dept ;",
				"rename     table emp to dept;",
		};
		bad = new String[] { 
				"rename table empto dept;",	
				"reame table emp to dept;",
				"rename table emp to dept",
				"rename table emp to;",
		};
	}
}
