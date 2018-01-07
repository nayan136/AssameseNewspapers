package com.example.nayanjyoti.assamesenewspapers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nayanjyoti on 26-09-2017.
 */

public class Data {

    private static final List<String> newspaperNameList = new ArrayList<String>(){{
        add("Asomiya Pratidin");
        add("Niyomiya Barta");
        add("Assamiya Khabor");
        add("Amar Asom");
        add("Dainik Asom");
        add("Dainik Janambhumi");
        add("Assam Tribune");
    }};

    public static List<String> getNewspaperNameList() {
        return newspaperNameList;
    }

    private static final List<String> newspaperUrls = new ArrayList<String>(){{
       add("http://asomiyapratidin.in/np-images/medium/ap-%s-%s-%s-%d.jpg");
        add("http://www.niyomiyabarta.org/%s%s%s/images/p%d/main.gif");
        add("http://www.assamiyakhabor.com/publishfinal/asset/guwahati/%s%s%s/pages/ghy%d.%s");
    }};

    public static List<String> getNewspaperUrls() {
        return newspaperUrls;
    }
}
