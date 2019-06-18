package com.jdk8.toa4.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Created by kobe on 2019/6/18.20:05
 *
 * @author kobe
 * <br/>
 * Description:
 * XtAx 解析 xml 文档。
 */
public class XtAXDemo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\xml\\videos1.xml";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        FileInputStream is = new FileInputStream(path);
        XMLStreamReader r = factory.createXMLStreamReader(is);

        int e = r.getEventType();
        // 它也是按事件。来处理 xml
        // 它是下一个事件。
        //while (r.hasNext()) {
        //int e = r.next();
        while (true) {
            // 表示文档解析开始。就判断，返回事件的 int值，是不是等于它里面的某个常量。
            if (e == XMLStreamConstants.START_DOCUMENT) {
                System.out.println("开始解析。。");
            } else if (e == XMLStreamConstants.START_ELEMENT) {
                // 遇到某个元素时。
                if (r.getLocalName().equals("title")) {
                    System.out.println(r.getElementText());
                }
                // 得属性。
                if (r.getLocalName().equals("video")) {
                    System.out.println(r.getAttributeValue(0));
                }
                // 判断它是不是一个结束标签。
            }
            if (!r.hasNext()) {
                break;
            }
            e = r.next();
        }
    }
}
