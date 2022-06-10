package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getCatogoryByApiDao;

import java.io.IOException;

public class GetCategoryByApi {
    public static String getCategoryAnswer(String s) throws IOException {
        return getCatogoryByApiDao.getCatogoryByApi(s);
    }
}
