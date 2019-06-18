package com.jdk8.toa4.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by kobe on 2019/6/18.20:24
 *
 * @author kobe
 * <br/>
 * Description:
 * java 生成 xml
 *
 *
 *
 */
public class CtreamXmlDemo {

    public static void main(String[] args) throws Exception {
        String p = "D:\\kobe\\xx\\xX01\\Xml01.xml";
        //createByDOM(p);
        //createBySAX(p);
        //createByStAX(p);
    }



    static void createByStAX(String path) throws Exception {
        XMLOutputFactory f = XMLOutputFactory.newFactory();
        XMLStreamWriter w = f.createXMLStreamWriter(new FileOutputStream(path));
        w.writeStartDocument("UTF-8","1.0");
        w.writeStartElement("users");
        w.writeStartElement("user");
        w.writeAttribute("id","u001");
        w.writeCharacters("Tom");
        w.writeEndElement();
        w.writeEndElement();
        w.writeEndDocument();
    }

    static void createBySAX(String path) throws Exception {
        StreamResult xml = new StreamResult(new FileOutputStream(path));
        SAXTransformerFactory sff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler th = sff.newTransformerHandler();
        th.setResult(xml);

        Transformer t = th.getTransformer();
        th.startDocument();
        // 属性。
        AttributesImpl atts = new AttributesImpl();
        atts.addAttribute("","","id","","e001");
        // 1、命名空间的uri。2、xx。3、元素名。4、属性。
        th.startElement("","","person",null);
        th.startElement("","","emp",atts);
        th.characters("文本内容".toCharArray(),0,"文本内容".length());
        // 结束标签。
        th.endElement("","","emp");
        th.endElement("","","person");
        th.endDocument();
    }

    // path 生成在哪个文件下
    static void createByDOM(String path) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document d = builder.newDocument();

        // 创建根元素。
        Element root = d.createElement("emps");
        // 创建子元素。
        Element emp = d.createElement("emp");
        // 创建文本节点。
        Text name = d.createTextNode("员工名字");
        // 把它们关联上。
        d.appendChild(root);
        root.appendChild(emp);
        emp.appendChild(name);
        // 设置属性。
        emp.setAttribute("id","value01");
        // 在把它存储成一个 xml 文件。
        Transformer t = TransformerFactory.newInstance().newTransformer();
        // 表示缩进。
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        // 把它转换成那一种文档。
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        // 开始转换。
        t.transform(new DOMSource(d),new StreamResult(new File(path)));
    }

    // xsl 转换成 xml  ，path 是 xx.xml 文件。
    static void createByXLT(String path) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document d = builder.parse(path);
        // 准备 xx.xsl 文件。
        File file = new File("xx.xsl");
        StreamSource ss = new StreamSource(file);
        Transformer t = TransformerFactory.newInstance().newTransformer(ss);
        // 还可以转换成 xx.html 样。
        t.transform(new DOMSource(d) ,new StreamResult(new File(path)));
    }
}
