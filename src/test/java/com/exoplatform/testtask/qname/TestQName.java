/** Written by Ann Zhulyova 5.07.2009
 */
package com.exoplatform.testtask.qname;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestQName extends TestCase {
	/* Initializing strings for testing */
	private String testString1="pref:name"; 		 //correct
	private String testString2="prefix123:name "; 	 //correct
	private String testString3="_pref:name name";	 //correct
	private String testString4="name1  name2 name3"; //incorrect
	private String testString5="name";				 //correct
	private String testString6="_prefix:name";		 //correct
	private String testString7=":name";				 //incorrect
	private String testString8="..";				 //incorrect
	private String testString9="";					 //incorrect
	private String testString10="prefix:";			 //incorrect
	private String testString11=" name";			 //incorrect
	private String testString12=" prefix:name";		 //incorrect
	private String testString13="pref: name";		 //incorrect
	private String testString14="pre fix:name";		 //incorrect
	private String testString15="name/name";		 //incorrect
	private String testString16="name1[name3";		 //incorrect
	private String testString17="name1:name3:name10";//incorrect
	
	public TestQName(String testName) {
        super(testName);
    }
	/* The following tests for QName class*/
    public void testParse1() throws Exception {
    	QName qname = QName.parse(this.testString1);
        assertTrue((qname.getPrefix().equals("pref")) && (qname.getLocalName().equals("name")));
    }
    public void testParse2() throws Exception {
       	try{
       		QName.parse(this.testString2);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse3() throws Exception {
    	QName qname = QName.parse(this.testString3);
        assertTrue((qname.getPrefix().equals("_pref")) && (qname.getLocalName().equals("name name")));
    }
    public void testParse4() throws Exception {
       	try{
       		QName.parse(this.testString4);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse6() throws Exception {
    	QName qname = QName.parse(this.testString6);
        assertTrue((qname.getPrefix().equals("_prefix")) && (qname.getLocalName().equals("name")));
    }
    public void testParse5() throws Exception {
    	QName qname = QName.parse(this.testString5);
        assertTrue(qname.getLocalName().equals("name"));
    }
    public void testParse7() throws Exception {
       	try{
       		QName.parse(this.testString7);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse8() throws Exception {
       	try{
       		QName.parse(this.testString8);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse9() throws Exception {
       	try{
       		QName.parse(this.testString9);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse10() throws Exception {
       	try{
       		QName.parse(this.testString10);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse11() throws Exception {
       	try{
       		QName.parse(this.testString11);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse12() throws Exception {
       	try{
       		QName.parse(this.testString12);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse13() throws Exception {
       	try{
       		QName.parse(this.testString13);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse14() throws Exception {
       	try{
       		QName.parse(this.testString14);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse15() throws Exception {
       	try{
       		QName.parse(this.testString15);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse16() throws Exception {
       	try{
       		QName.parse(this.testString16);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    public void testParse17() throws Exception {
       	try{
       		QName.parse(this.testString17);
    		fail("No exception was thrown");
    	}catch(IllegalNameException e){
    	}
    }
    
    /*Main for executing tests*/   
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        TestSuite suite = new TestSuite();
        //Adding tests
        suite.addTest(new TestQName("testParse1"));
        suite.addTest(new TestQName("testParse2"));
        suite.addTest(new TestQName("testParse3"));
        suite.addTest(new TestQName("testParse4"));
        suite.addTest(new TestQName("testParse5"));
        suite.addTest(new TestQName("testParse6"));
        suite.addTest(new TestQName("testParse7"));
        suite.addTest(new TestQName("testParse8"));
        suite.addTest(new TestQName("testParse9"));
        suite.addTest(new TestQName("testParse10"));
        suite.addTest(new TestQName("testParse11"));
        suite.addTest(new TestQName("testParse12"));
        suite.addTest(new TestQName("testParse13"));
        suite.addTest(new TestQName("testParse14"));
        suite.addTest(new TestQName("testParse15"));
        suite.addTest(new TestQName("testParse16"));
        suite.addTest(new TestQName("testParse17"));
        runner.doRun(suite);
    }
}



