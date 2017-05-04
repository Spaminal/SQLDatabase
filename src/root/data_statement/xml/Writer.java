package root.data_statement.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import root.data_statement.tables.TableMap;
import root.data_statement.tables.Table;
import root.data_statement.tables.Field;

/**
 * Writes TableMap contents to external XML file.
 */
public class Writer {
	ArrayList<String> tableList;

	/**
	 * Writes TableMap contents to external XML file.
	 */
	public Writer() {
		File file = new File(".data.xml");
		tableList = TableMap.getTableMap().getTableList();
		try {
			write(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}

	/**
	 * Writes TableMap contents to external XML file.
	 */
	public Writer(String path) {
		File file = new File(path);
		tableList = TableMap.getTableMap().getTableList();
		try {
			write(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}

	/**
	 * Formats and Outputs TableMap contents to external File.
	 */
	public void write(File file) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new FileOutputStream(file));
		out.println("<tableMapContents>");
		for (String str : tableList) {
			Table table = TableMap.getTableMap().getTable(str);
			out.println("<table>");
			out.println("<tableName>" + table.getName() + "</tableName>");
			for (Field field : table.getFields()) {
				out.print("<field>");
				out.print("<fieldName>" + field.getFieldName() + "</fieldName>");
				out.print("<fieldType>" + field.getFieldType() + "</fieldType>");	
				if (field.getFieldType() == "CHAR") {
					out.print("<fieldSize>" + field.getFieldSizeInt()
							+ "</fieldSize>");
				}
				out.println("</field>");
			}
			out.println("</table>");
		}
		out.println("</tableMapContents>");
		out.close();
	}
}
