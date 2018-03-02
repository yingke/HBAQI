package com.yingke.hbaqi.bean;

import org.w3c.dom.Node;

import java.io.Serializable;

/**
 * Created by Dell on 2/26.
 */

public class Pollution implements Serializable {
    public  String  pm2_5,pm2_5_24h,pm10,pm10_24h,so2,co,no2,o3,o3_8h;


    //从XML的node中取出相应标签中内容的function
    private String getByTag(Node node, String tag) {
        for (int i=0;i<node.getChildNodes().getLength();i++){
            if (tag.equalsIgnoreCase(node.getChildNodes().item(i).getNodeName()))
                return node.getChildNodes().item(i).getTextContent();
        }
        return null;
    }
}
