package com.jdk8.toa4.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by kobe on 2019/6/18.19:31
 *
 * @author kobe
 * <br/>
 * Description:
 * 使用 SAX 的方式，来解析 xml文档。
 */
public class SAXDemo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\xml\\videos1.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser p = factory.newSAXParser();
        // 回调方法。
        p.parse(new File(path),new DefaultHandler(){

            // 标识它是那一个元素。
            String tag;

            @Override
            public void startDocument() throws SAXException {
                System.out.println("// 在文档开始解析时调用，并且只调用一次。");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("// 在文档解析结束时调用，并且只调用一次。");
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // 它没有办法区分，到低是那一个元素的内容。
                //System.out.println("遇到文本时，就会触发。");
                if ("title".equals(tag)) {
                    String s = new String(ch, start, length);
                    System.out.println(s);
                }
                tag = null;
            }

            /**
             *"遇到某个元素标签时，就会调用。"
             * @param uri 它是命名空间的uri
             * @param localName 没有前缀的一个名字。
             * @param qName 带有权限的类名。
             * @param attributes 元素的属性。
             * @throws SAXException
             */
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // 我只想获取title 元素里面的文本内容。
                //System.out.println("遇到某个元素标签时，就会调用。");
                if ("title".equals(qName)) {
                    tag = "title";
                }
                // 然后它又执行 characters() 方法了，注：这几个方法是不停的一直在调用。
                // laotan:video 它就是一个权限类名。就可以得到它的属性了。
                if ("laotan:video".equals(qName)) {
                    // 得到id属性的，属性值。
                    // 你得到属性值后，可以用一个集合把它存储起来。方便后续的使用。
                    System.out.println(attributes.getValue("id"));
                }
            }
        });
    }
}
