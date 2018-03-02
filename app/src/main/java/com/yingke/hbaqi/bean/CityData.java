package com.yingke.hbaqi.bean;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2/26.
 */

public class CityData implements Serializable {

    //城市类包含了一个城市的数据
    public String name,dataTime,level,maxPoll,color,intro,tips,pm25,pm25_24h,pm10,pm10_24h,so2,co,no2,o3,o3_8h;
    public  int aqi;
    public List<Pointer> pointerList;

    public CityData(Node cityNode) {
        super();
        //按标签挨个取出相应标签的内容
        this.name = getByTag(cityNode, "name");
        this.dataTime = getByTag(cityNode, "datatime");
        this.aqi = Integer.parseInt(getByTag(cityNode, "aqi")) ;
        this.level = getByTag(cityNode, "level");
        this.maxPoll = getByTag(cityNode, "maxpoll");
        String tmp = getByTag(cityNode, "color");
        this.color = tmp.replace("0x", "#");
        this.intro = getByTag(cityNode, "intro");
        this.tips = getByTag(cityNode, "tips");

        Element city = (Element)cityNode;
        NodeList pointers = city.getElementsByTagName("Pointer");
        NodeList Polls = city.getElementsByTagName("Poll");


        //向city的pointer列表中添加监测点
        pointerList = new ArrayList<>();
        for (int i=0;i<pointers.getLength();i++){
            Node pNode = pointers.item(i);
            pointerList.add(new Pointer(pNode));
        }


        for (int i=0;i<Polls.getLength();i++) {
            switch (i) {
                case 0:
                    Node pm25node = Polls.item(i);
                    this.pm25 = getByTag(pm25node, "value");
                    ;
                    break;
                case 1:
                    Node pm25_24h = Polls.item(i);
                    this.pm25_24h = getByTag(pm25_24h, "value");
                    ;
                    break;
                case 2:
                    Node pm10 = Polls.item(i);
                    this.pm10 = getByTag(pm10, "value");
                    ;
                    break;
                case 3:
                    Node pm10_24h = Polls.item(i);
                    this.pm10_24h = getByTag(pm10_24h, "value");
                    ;
                    break;
                case 4:
                    Node so2 = Polls.item(i);
                    this.so2 = getByTag(so2, "value");
                    ;
                    break;
                case 5:
                    Node co = Polls.item(i);
                    this.co = getByTag(co, "value");
                    ;
                    break;
                case 6:
                    Node no2 = Polls.item(i);
                    this.no2 = getByTag(no2, "value");
                    ;
                    break;
                case 7:
                    Node o3 = Polls.item(i);
                    this.o3 = getByTag(o3, "value");
                    ;
                    break;
                case 8:
                    Node o3_8h = Polls.item(i);
                    this.o3_8h = getByTag(o3_8h, "value");
                    ;
                    break;

            }
        }



    }

    @Override
    public String toString() {
        return "CityData{" +
                "name='" + name + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", aqi='" + aqi + '\'' +
                ", level='" + level + '\'' +
                ", maxPoll='" + maxPoll + '\'' +
                ", color='" + color + '\'' +
                ", intro='" + intro + '\'' +
                ", tips='" + tips + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", pm25_24h='" + pm25_24h + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", pm10_24h='" + pm10_24h + '\'' +
                ", so2='" + so2 + '\'' +
                ", co='" + co + '\'' +
                ", no2='" + no2 + '\'' +
                ", o3='" + o3 + '\'' +
                ", o3_8h='" + o3_8h + '\'' +
                ", pointerList=" + pointerList +
                '}';
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMaxPoll() {
        return maxPoll;
    }

    public void setMaxPoll(String maxPoll) {
        this.maxPoll = maxPoll;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm25_24h() {
        return pm25_24h;
    }

    public void setPm25_24h(String pm25_24h) {
        this.pm25_24h = pm25_24h;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm10_24h() {
        return pm10_24h;
    }

    public void setPm10_24h(String pm10_24h) {
        this.pm10_24h = pm10_24h;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getO3_8h() {
        return o3_8h;
    }

    public void setO3_8h(String o3_8h) {
        this.o3_8h = o3_8h;
    }

    public List<Pointer> getPointerList() {
        return pointerList;
    }

    public void setPointerList(List<Pointer> pointerList) {
        this.pointerList = pointerList;
    }

    //从XML的node中取出相应标签中内容的function
    private String getByTag(Node node,String tag) {
        for (int i=0;i<node.getChildNodes().getLength();i++){
            if (tag.equalsIgnoreCase(node.getChildNodes().item(i).getNodeName()))
                return node.getChildNodes().item(i).getTextContent();
        }
        return null;
    }
}
