package com.yingke.hbaqi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.yingke.hbaqi.bean.CityData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



/**
 * Created by Yingke on 2/26.
 */

public class Parserxml {

    public Parserxml(String s) {

    }

    public static List<CityData> Toxml(String result)  {

         List<CityData> cdList  = new ArrayList<>();
        //建立一个解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            InputStream is = new ByteArrayInputStream(result.getBytes());
            Document document = builder.parse(is);
            Element element = document.getDocumentElement();
            //获得所有的Citys节点数据
            NodeList cityList = element.getElementsByTagName("Citys");

            Element citys = (Element)cityList.item(0);
            NodeList city = citys.getChildNodes();

            for (int i=0;i < city.getLength();i++){
                //此时的city节点的item上，有的是一个城市的所有数据
                Node node = city.item(i);
                if (node.getNodeName().equalsIgnoreCase("city")) {
                    CityData cd = new CityData(node);
                    cdList.add(cd);
                }
            }
            Collections.sort(cdList, new Comparator<CityData>() {
                @Override
                public int compare(CityData o1, CityData o2) {
                    if(o1.getAqi()>o2.getAqi()){
                        return 1;
                    }else if(o1.getAqi()==o2.getAqi()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }

        return cdList;

    }
    //从XML的node中取出相应标签中内容的function
    private static String getByTag(Node node,String tag) {
        for (int i=0;i<node.getChildNodes().getLength();i++){
            if (tag.equalsIgnoreCase(node.getChildNodes().item(i).getNodeName()))
                return node.getChildNodes().item(i).getTextContent();
        }
        return null;
    }
}
