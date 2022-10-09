package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getCatogoryByApiDao;

import java.io.IOException;

public class GetCategoryByApi {
    public static String getCategoryAnswer(String s) throws IOException {
        return getCatogoryByApiDao.getCatogoryByApi(s);
    }
    public static void getCatogoryByApiAlter1(String apiname,String correct,String error)throws IOException{
        getCatogoryByApiDao.getCatogoryByApiAlter(apiname,correct,error);
    }
}
