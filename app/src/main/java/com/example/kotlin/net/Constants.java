package com.example.kotlin.net;

/**
 * 黄振伟
 * 2022/4/7
 */
public class Constants {
    static String url = "";
    //公司测试网
    public static String COMPANY_TEST_BASE_URL = "http://172.16.100.186:8888/";
    //总线正式环境
    public static String BASE_URL = "http://20.72.1.127:80/ga/xincheng-saas-app/";
    //总线测试环境
    public static String TEST_BASE_URL = "http://20.72.1.127:80/ga/xincheng-saas-app-test/";
    //从三类网minio下载图片的服务地址 返回base64
    public static final String MINIO_SERVER3 = "image/downloadFileFromMinio";
    //从三类网server下载的服务地址  返回base64
    public static final String SERVER3 = "/image/downloadFileFromMinio";
    //从二类网minio下载图片的服务地址 返回base64
    public static final String MINIO_SERVER2 = "/common/uploadBase64ToMinio";
    //文件下载地址
//    public static final String filePath = PathUtils.getSDPath() + "/" + Environment.DIRECTORY_DOWNLOADS + "/new_orange/";

    public static String getBaseUrl() {
//        if (EnvironmentConfig.RELEASE_TEST) {
//            url = Constants.BASE_URL;
//        } else if (EnvironmentConfig.TEST_ONLINE) {
//            url = Constants.TEST_BASE_URL;
//        } else {
//            url = Constants.COMPANY_TEST_BASE_URL;
//        }

        url = "http://paas.gab.ydxxw/ga/test-pursuit-evasion-appserver/";
        return url;
    }

    //登录人cardId
    public static String card = "";
}
