package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getApiByTagsDao;

public class GetApiByTags {
    public static String getApiByTags(String tag) {
        return getApiByTagsDao.getApiByTags(tag);
    }
}
