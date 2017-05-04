/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.admin_statement;

import org.junit.Before;

import root.admin_statement.BackupCommand;
import root_test.AbstractCommandTest;

public class BackupCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new BackupCommand();
		good = new String[] {
				"backup to 'ham//dog//fog';",
				"backup   to 'ham//dog//fog' ;",
				"backup to 'ham //dog //fog';",
				"backup to ' ham//dog//fog ' ;",
				"backup to     'ham  //dog //fog';",
				"backup to 'ham//dog//fog';",
				"backup to 'ham//dog//fog';",
				
		};
		bad = new String[] {
				"backup to 'ham//dog//fog;",
				"backup to 'ham//dog//fog",
				"backupto 'ham//dog//fog;",
				"backupto'ham//dog//fog;",
				"backup to ham//dog//fog;",
				"backup to 'ham//dog//fog;",
				
							
		};
	}
}
