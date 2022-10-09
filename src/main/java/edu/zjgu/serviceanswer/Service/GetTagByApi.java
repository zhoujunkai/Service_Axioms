package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getTagByApiDao;

import java.io.IOException;
import java.util.List;

public class GetTagByApi {
    public static String getTagAnswer(String s) throws IOException {
        return getTagByApiDao.getTagByApi(s);
    }

    public static List<String> getTagAnswerNames(String s) throws IOException {
        return getTagByApiDao.getTagByApiName(s);
    }
    public static  int getTagCount(String s) throws IOException {
        return getTagByApiDao.getTagByApiCount(s);

    }
}
