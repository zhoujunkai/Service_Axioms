package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getMashupbyTagDao;
import edu.zjgu.serviceanswer.KGdao.getTagByApiDao;

import java.io.IOException;
import java.util.List;

public class GetMashupbyTag {
    public static Double getMashupByTags(String s) throws IOException {
        return getMashupbyTagDao.getMashupByTags(s);
    }
    public static List<String> getMashupByTagsMashupname(String s) throws IOException {
        return getMashupbyTagDao.getMashupByTagsMashupname(s);
    }

    public static String getMashupByTag(String tag) throws IOException{
        return  getMashupbyTagDao.getMashupByTag(tag);
    }
}
