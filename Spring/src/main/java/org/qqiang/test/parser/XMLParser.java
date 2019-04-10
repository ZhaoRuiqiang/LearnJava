/**
 * 
 */
package org.qqiang.test.parser;

/**
 * @author QQiang
 *
 */
public class XMLParser implements Parser {

	@Override
	public void parse(String str) {
		System.out.println("XMLParser.parse :: " + str);
	}

}
