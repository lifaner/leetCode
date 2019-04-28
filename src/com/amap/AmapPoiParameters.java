package com.amap;

/**
 * Create by lifan.
 * Date: 2019/3/7.
 * Time: 20:04.
 */
public class AmapPoiParameters {

    private String privateKey;  //请求服务权限标识
    private String keywords;    //查询关键字
    private String types;          //查询POI类型
    private String city;        //查询城市
    private String citylimit;   //仅返回指定城市数据
    private String children;    //是否按照层级展示子POI数据
    private String offset;      //每页记录数据
    private String page;        //当前页数
    private String building;    //建筑物的POI编号
    private String floor;       //搜索楼层
    private String extensions;  //返回结果控制
    private String sig;         //数字签名
    private String output;      //返回数据格式类型
    private String callback;    //回调函数

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCitylimit() {
        return citylimit;
    }

    public void setCitylimit(String citylimit) {
        this.citylimit = citylimit;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
