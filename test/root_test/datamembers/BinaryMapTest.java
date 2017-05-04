package root_test.datamembers;



import org.junit.Before;
import org.junit.Test;

import root.data_statement.tables.Field;
import root.data_statement.tables.Table;
import root.data_statement.tables.TableMap;

public class BinaryMapTest {

	
	String tableName = "HAMSTER";
	Table table;
	@Before
	public void setUp() throws Exception {
		
		String[] withFields = new String[]{
				"ham varchar",
				"chicken real",
				"face integer"
		};
		String[] valueList = {
				"'happiness'",
				"256",
				"10"
		};
		String fName = "hamster";
		
		table = new Table(fName, withFields);
			
		//table.getField("HAMSTER").addValue("256");
		//table.getField("HAMSTER").addValue("10");
	}

	@Test
	public void test() {
		
		Field field = table.getField("HAM");
		System.out.println(field.getFieldName());
		field.addValue("'happiness'");
		//System.out.println(field.getFieldValueStr());
		
		
		
		table.printFields();
		
		
		
		
		
		
		
	}

}
