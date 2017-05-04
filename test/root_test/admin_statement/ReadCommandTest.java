/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.admin_statement;

import org.junit.Before;

import root.admin_statement.ReadCommand;
import root_test.AbstractCommandTest;

public class ReadCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new ReadCommand();
		good = new String[] {
				"read 'C:\\JavaTests\\totalmess';",
				"read 'C:\\ JavaTests\\ totalmess';",
				"read 'C:\\ JavaTests\\ totalmess'  ;",
				"read 'C:\\JavaTests\\nobreaks';",
				"read 'C:\\JavaTests\\somebreaks';",
				"read  'C:\\  JavaTests   \\totalmess  '  ;",
				"read     'C:\\JavaTests\\totalmess'    ;",
				"read     'C:\\Java Tests\\total mess';            ",
				"read  'C: \\JavaTests\\tota lmess ' ; ",
				"read     'C: \\ JavaTests\\totalmess';",
				"read ' C:\\Ja vaTests\\totalmess';",
				"read     'C:\\JavaTests\\totalmess';",
				"read     'C:\\J ava T es t s\\to talme ss ';",
				"read     'C:\\Ja va Test s\\tot almess';",
				"read     'C:\\JavaTests\\totalmess';",
				"read     'C:\\Ja va Tests\\totalmess';",
				"read     'C:\\JavaTes ts\\total  mess';",
				/* Linux filepaths
				"read '/home/jculley1/Desktop/stuff/Modules/test/textfiles/nobreaks';",
				"read '/home/jculley1/Desktop/stuff/Modules/test/textfiles/nobreaks' ;",
				"read '/home/jculley1/Desktop/stuff/Modules/test/textfiles/ nobreaks';",
				"read '/home/jculley1/Desktop/stuff/Modules/test/ textfiles/nobreaks';",
				"read '/home/jculley1/Desktop/  stuff   /Modules/test/textfiles/nobreaks';",
				"read '/home/jculley1/Desktop/stuff/Modules/test/textfiles/nobreaks';",
				"READ   '/home/jculley1/Desktop/stuff/Modules/test/textfiles/nobreaks  '  ;",
				*/
		};
		bad = new String[] { 
				"read '/home/text.txt':",
				"rad ' frog;",
				"readd '",
				"read 'C:\\JavaTests\\totalmess.txt'';",
				"read ':\\Tests\\totas';"
		};
	}
}
