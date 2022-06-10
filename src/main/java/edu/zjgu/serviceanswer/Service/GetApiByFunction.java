package edu.zjgu.serviceanswer.Service;



import edu.zjgu.serviceanswer.KGdao.getApiByFunctionDao;

import java.io.IOException;
import java.util.List;

public class GetApiByFunction {
    public static List<String> getApiByFunction(List<String> functionList) throws IOException {
        return getApiByFunctionDao.getApiByFunction(functionList);
    }
}
