package com.jdk8.toa4.xml;

import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by kobe on 2019/6/18.18:01
 *
 * @author kobe
 * <br/>
 * Description:
 * java 解析xml 文件。
 */
public class DomDemo {

    public static void main(String[] args) throws Exception {
        //String path = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\xml\\videos.xml";
        String path = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\xml\\videos1.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 验证。
        //factory.setValidating(true);
        // 开启命名空间。
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 错误的处理器。
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                    System.out.println(exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {

            }
        });


        Document doc = builder.parse(path);

        System.out.println("得到子元素的数量：" + doc.getChildNodes().getLength());
        // 得到根元素。
        Element root = doc.getDocumentElement();
        // 命名空间。
        System.out.println(root.getNamespaceURI());
        System.out.println(root.getChildNodes().getLength());
        // 遍历所有子节点。
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            // Element是元素
            if (node instanceof Element) {
                // 得到元素的属性，如：id属性。
                // 只有元素才有属性。
                String id = ((Element) node).getAttribute("id");
                // 得到元素名称。
                System.out.println(node.getNodeName() + "\t" + id);
                // 得到所有的属性和属性值。
                NamedNodeMap map = node.getAttributes();
                for (int j = 0; j < map.getLength(); j++) {
                    System.out.println(
                            map.item(j).getNodeName() + "\t"+
                                    map.item(j).getNodeValue()
                    );
                }
            }
        }

        // 根据标称名来获取title
        NodeList titles = doc.getElementsByTagName("title");
        for (int i = 0; i < titles.getLength(); i++) {
            Node node = titles.item(i);
            //title标签里面的文本，它是一个文本子节点。
            //System.out.println(node.getNodeName());
            // 要先获取元素，在获取它的节点。
            // 如果title元素下面还有其它子元素，还需要判断
            // 通过id 来获取一个元素。
            System.out.println(node.getFirstChild().getNodeValue());
        }

        //
    }
}
