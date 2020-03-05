package com.study.constants;

import com.study.apps.MyApp;

import java.io.File;

public class Constant {

    public static final String Base_Url = "https://cdwan.cn/api/";



    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

    public static final int CLICK_TIME = 2000;

    public static int uid;

}
