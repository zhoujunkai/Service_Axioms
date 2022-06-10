package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.KGdao.getFunctionByApiDao;
import edu.zjgu.serviceanswer.utills.GetApiName;

import java.io.IOException;
import java.util.List;

public class GetFunctionByApi {
    public static String getFunctionAnswer(String s) throws IOException {
        //获取所有api的名字
        List<String> apiName = GetApiName.getName();
        String finalname = null;//存储最终的名字
        for (String apiname : apiName) {
            if (s.contains(apiname)) {
                finalname = apiname;
                break;
            }
        }
        return getFunctionByApiDao.getCatogoryByApi(finalname);
    }

}
