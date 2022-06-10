package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getTagByApiDao;

import java.io.IOException;

public class GetTagByApi {
    public static String getTagAnswer(String s) throws IOException {
        return getTagByApiDao.getTagByApi(s);
    }
}
