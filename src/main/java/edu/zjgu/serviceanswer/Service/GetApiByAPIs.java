package edu.zjgu.serviceanswer.Service;



import edu.zjgu.serviceanswer.KGdao.getApiByAPIsDao;

import java.util.List;

public class GetApiByAPIs {
    public static List<String> getApiByAPIs(List<String> apis) {
        return getApiByAPIsDao.getApiByAPIs(apis);
    }
}
