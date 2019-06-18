package com.jdk8.toa4.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

/**
 * Created by kobe on 2019/6/18.19:15
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class XpathDemo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\xml\\videos1.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(path);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        // 就是这个xml 的表达式。很强悍。
        NodeList list = (NodeList) xPath.evaluate("videos/video/title/text()",
                doc, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println(node.getNodeValue());
        }
    }
}
