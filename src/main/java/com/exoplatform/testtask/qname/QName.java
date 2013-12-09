/** Written by Ann Zhulyova 4.07.2009
 */
package com.exoplatform.testtask.qname;

import java.util.Scanner;
import java.util.regex.Pattern;

/**This class implements the process of parsing a qualified name
 * @author Ann
 */
public class QName {
	/** localName is for saving local name*/
	private String  localName;
	/** prefix is for saving prefix 
	 * (if there is no prefix in qualified name then prefix=null)*/
	private String prefix;
	
	/**Main is for testing the class QName
	 * by entering different qualified names
	 * @param args
	 * @throws IllegalNameException 
	 */
	public static void main(String[] args) throws IllegalNameException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String inputString = in.nextLine();
		QName qName = QName.parse(inputString);
		System.out.print("Prefix: "+qName.getPrefix()+" Local: "+ qName.getLocalName()+" String: "+qName.getAsString());
	}
	
	/**
	 * @return String prefix of qualified name if it exists or null otherwise
	 */
	public String getPrefix(){
		return prefix;
	}
	
	/**
	 * @return String localName of qualified name
	 */
	public String getLocalName(){
		return localName;
	}
	
	/**
	 * @return String [prefix:]locaName
	 */
	public String getAsString(){
		//check for prefix not to be null
		if (prefix!=null){
			return prefix+":"+localName;
		} else{
		//if prefix is null then return only localName	
			return localName;
		}
	}
	
	/** This method implements the parser of given inputName (BNF format)
	 * @param inputName (String)
	 * @return QName object
	 * @throws IllegalNameException
	 */
	public static QName parse (String inputName) throws IllegalNameException{
		/* Compiling pattern with given regular expression
		The part of reg.exp.  ([_a-zA-Z][a-zA-Z0-9_\\-]+):)? finds the group with prefix
		which can begin with latin's letter or "_". Operator "?" checks the prefix construction
		occur one or zero time.
		(([^\\Q-[]:.*'|/\"\\E\\s]+(\\s[^\\Q-[]:.*'|/\"\\E\\s]+)*)+) is responsible for finding
		proper name.  
		*/
		Pattern pattern = Pattern.compile("(([_a-zA-Z][a-zA-Z0-9_\\-]+):)?(([^\\Q-[]:.*'|/\"\\E\\s]+(\\s[^\\Q-[]:.*'|/\"\\E\\s]+)*)+)");
		//Matching compiled pattern with the inputName 
		java.util.regex.Matcher matcher = pattern.matcher(inputName);
		if (matcher.matches()){
			//the string matches the pattern
			QName parser = new QName();
			parser.prefix = matcher.group(2);
			parser.localName = matcher.group(3);
			return parser;
		} else {
			//the string doesn't match the pattern and rising exception
			throw new IllegalNameException("ERROR!!!");
		}		
	}
}


/** This class throws exception when the qualified name
 * was not written correctly in BNF format
 */
class IllegalNameException extends Exception{
	private static final long serialVersionUID = 1L;
	public IllegalNameException() {}
	public IllegalNameException(String message) {
		super(message);
	} 
	
}
