package root_test.datamembers;

import root.data_statement.tables.Table;
import org.junit.Before;
import org.junit.Test;

public class TableClassTest {
	Table table;
	@Before
	public void setUp() throws Exception {
		String[] haveFields = new String[]{
				"name varchar",
				"age integer",
				"state char(2)",
				"hame2 real",
				"age2 integer",
				"state2 char(2)",
				"name3 varchar",
				"age3 integer",
				"state3 char(2)",
				"name4 varchar",
				"age4 integer",
				"state4 char(2)",
		};
		String tableName = "Hambone";
		table = new Table(tableName, haveFields);
	}

	@Test
	public void testFieldToString() {
		System.out.println(table.toString());
		table.printFields();
	}

}
