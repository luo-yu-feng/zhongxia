package com.sunconit.share.learnlambda;
import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlTest {

  public static void main(String[] args) {
    try {
      // 读取 xml 文件
      File fileinput = new File(
          "D:\\Wechat\\WeChat Files\\wxid_6b90fi2xrvjk22\\FileStorage\\File\\2022-03\\nvr.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory
          .newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fileinput);

      // 方法1：将xml文件转化为String
       StringWriter sw = new StringWriter();
       TransformerFactory tf = TransformerFactory.newInstance();
       Transformer transformer = tf.newTransformer();
       transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
       "no");
       transformer.setOutputProperty(OutputKeys.METHOD, "xml");
       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
       transformer.transform(new DOMSource(doc), new StreamResult(sw));

      //方法2：和方法1类似
//      DOMSource domSource = new DOMSource(doc);
//      StringWriter writer = new StringWriter();
//      StreamResult result = new StreamResult(writer);
//      TransformerFactory tf = TransformerFactory.newInstance();
//      Transformer transformer = tf.newTransformer();
//      transformer.transform(domSource, result);

      // 将转换过的xml的String 样式打印到控制台
      String s = sw.toString();
      System.out.println(s);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
