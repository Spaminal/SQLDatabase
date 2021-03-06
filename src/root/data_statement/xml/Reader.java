package root.data_statement.xml;

import java.io.IOException;
import javax.xml.transform.TransformerConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import root.data_statement.tables.TableMap;

/**
 * Reads into memory the default XML file.
 */
public class Reader {

    public static void main(String[] args)
	throws SAXException,
	       IOException,
	       TransformerConfigurationException {
	new Reader().Reader();
    }

    /**
     * Default File Path Handler
     */
    public void Reader() throws SAXException, IOException {
	XMLReader reader = XMLReaderFactory.createXMLReader();
	reader.setContentHandler(new ContentHandler());
	reader.parse(".data.xml");
    }

    /**
     * Parses File for Defined XML Tags.
     */
    private class ContentHandler extends DefaultHandler {

	private boolean isTable;
	private boolean isTableName;
	private boolean isField;
	private boolean isFieldName;
	private boolean isFieldType;
	private boolean isFieldSize;
	private String tableName;
	private String fieldName;
	private String fieldType;
	private int fieldSize;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
				 Attributes attributes) {
	    if (qName.equals("table")) {
		isTable = true;
	    } else if (qName.equals("tableName")) {
		isTableName = true;
	    } else if (qName.equals("field")) {
		isField = true;
	    } else if (qName.equals("fieldName")) {
		isFieldName = true;
	    } else if (qName.equals("fieldType")) {
		isFieldType = true;
	    } else if(qName.equals("fieldSize")){
		isFieldSize = true;
	    } 
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
	    if (qName.equals("table")) {
		isTable = false;
	    } else if (qName.equals("tableName")) {
		TableMap.getTableMap().createTable(tableName);
		isTableName = false;
	    } else if (qName.equals("field")) {
		if (fieldType.equals("CHAR")){
		    TableMap.getTableMap().getTable(tableName).addField(fieldName, fieldType, fieldSize);
		} else {
		    TableMap.getTableMap().getTable(tableName).addField(fieldName, fieldType);
		}
		isField = false;
	    } else if (qName.equals("fieldName")) {
		isFieldName = false;
	    } else if (qName.equals("fieldType")) {
		isFieldType = false;
	    } else if (qName.equals("fieldSize")) {
		isFieldSize = false;
	    } 
	}

	@Override
	public void characters(char[] ch, int start, int length)
	    throws SAXException {
	    if (isTableName) {
		tableName = new String(ch, start, length);
	    } else if (isFieldName) {
		fieldName = new String(ch, start, length);
	    } else if (isFieldType) {
		fieldType = new String(ch, start, length);
	    } else if (isFieldSize) {
		fieldSize = Integer.parseInt(new String(ch, start, length));
	    }
	}
    }
}
