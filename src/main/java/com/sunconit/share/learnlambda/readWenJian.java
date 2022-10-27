package com.sunconit.share.learnlambda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class readWenJian {

  public static void main(String[] args) throws IOException {
    FileInputStream inputStream = null;
    InputStreamReader reader = null;
    BufferedReader bufferedReader = null;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Object> listStr = new ArrayList();
    HashMap<String, String> mapRes = new HashMap<>();
    Document doc = null;
    //定义行数
    int i = 1;
    try{
       inputStream = new FileInputStream("D:\\Wechat\\WeChat Files\\wxid_6b90fi2xrvjk22\\FileStorage\\File\\2022-03\\nvr.xml");
       reader = new InputStreamReader(inputStream,"GBK");
       bufferedReader = new BufferedReader(reader);
      String line = "";
      while((line = bufferedReader.readLine()) != null){
        if (line.contains("</enableAnr>")){
          System.out.println(line);
        }

      }

    }catch (Exception e){
      e.printStackTrace();
    }finally {
      bufferedReader.close();
      reader.close();
      inputStream.close();
    }

  }
}
