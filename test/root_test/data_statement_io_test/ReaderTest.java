package root_test.data_statement_io_test;

import org.junit.BeforeClass;
import org.junit.Test;

import root.data_statement.tables.TableMap;
import root.data_statement.xml.Reader;

public class ReaderTest {

	@BeforeClass
	public static void setUp() throws Exception {
		new Reader().Reader();
	}
		
	@Test
	public void test() {
		TableMap.getTableMap().printTables();
	}

}
