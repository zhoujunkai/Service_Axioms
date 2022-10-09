package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getTagbyMashupDao;

import java.io.IOException;
import java.util.List;

public class GetTagbyMashup {
    public static int  TagbyMashupCount(String Mashupname) throws IOException {
        return getTagbyMashupDao.TagbyMashupCount(Mashupname);

    }
    public static List<String> TagbyMashupTagName(String Mashupname)throws IOException{
        return  getTagbyMashupDao.TagbyMashupTagName(Mashupname);
    }
}
