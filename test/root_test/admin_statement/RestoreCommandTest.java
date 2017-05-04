/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.admin_statement;

import org.junit.Before;

import root.admin_statement.RestoreCommand;
import root_test.AbstractCommandTest;

public class RestoreCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new RestoreCommand();
		good = new String[] {
				"restore from 'ham//frog//ribbit';",
				"restore from 'ham//frog//ribbit' ;",
				"restore from 'ham //frog/ /ribbit ';",
				"restore    from 'ham//frog//ribbit'            ;",
		};
		bad = new String[] { 
				"restore from 'ham//frog//ribbit;",
				"restore from ham//frog//ribbit';",
		};
	}
}
