package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getApiByTagsDao;

import java.util.List;

public class GetApiByTags {
    public static String getApiByTags(String tag) {
        return getApiByTagsDao.getApiByTags(tag);
    }

    public static double getApiByTagsCount(String tag) {
        return getApiByTagsDao.getApiByTagsCount(tag);
    }

    public static List<String> getApiByTagsApiName(String tag) {
        return getApiByTagsDao.getApiByTagsApiName(tag);
    }

    public static int getApiByTagsSum(String tag) {
        return getApiByTagsDao.getApiByTagsSum(tag);
    }
}
