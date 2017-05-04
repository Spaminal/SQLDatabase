package root_test.data_statement;

import org.junit.Before;

import root.data_statement.DeleteCommand;
import root_test.AbstractCommandTest;

public class DeleteCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new DeleteCommand();
		good = new String[] {
				"delete emp;",
				"delete emp where sal < 500;",
				"delete farm where animal = 'ham';",
				"delete   emp where sal <= 500;",
				"delete emp where sal != 500;",
				"delete emp where   sal < 500;",
				"delete emp where sal < '10/12/2015';",
				"delete  emp   ;",
				"delete emp where sal != 500;",
				"delete emp where sal <= 500;",
				"delete emp  where sal >= 500;",
				"delete emp where sal = 500;",
				"delete emp where sal > 500;",
				"delete emp where sal < 500 ;",
				"delete  emp  where  sal  <  500  ;",
				"delete emp where sal != '10/12/2015';",
				"delete   emp where sal = '10/12/2015';",
				"delete emp where sal < '10/12/2015';",
				"delete emp  where  sal > '10/12/2015';",
				"delete emp where sal <= '10/12/2015';",
				"delete emp where    sal >= '10/12/2015';",
				
				
		};
		bad = new String[] { 
				"delete emp where;",
				"delete emp if sal;",
				"delete emp hambone;",
				"delete;",
				"delete emp  where sal == 500;",
				"delete emp if;",
				"delete emp where sal !! 400;",
				"delete emp ",
				"delete emp where sal > 100",
				"delete emp where sal1 < 500;",
				"delete emp99 where ham = 27z;",
				
		};
	}
}
