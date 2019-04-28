package com.amap;

/**
 * Create by lifan.
 * Date: 2019/3/7.
 * Time: 18:08.
 */
public class AmapUtil {

    private final String privateKey = "0cc242d6dea21e35a19cd1caea809739";
    private String url = "https://restapi.amap.com/v3/place/text?";

    public AmapTextResult getResult(){
        AmapPoiParameters parameters = new AmapPoiParameters();
        parameters.setPrivateKey(privateKey);
        parameters.setKeywords("北京大学");
        parameters.setCity("北京");
        parameters.setChildren("0");
        parameters.setOffset("20");
        parameters.setPage("1");
        parameters.setExtensions("base");
        return null;
    }

}
