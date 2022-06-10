package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.neo4j.driver.v1.Values.parameters;


public class getApiByAPIsDao {
    public static List<String> getApiByAPIs(List<String> apis) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
        List<String> findAPI = new ArrayList<>();
        //根据两个API推理出另外的API
        if (apis.size() == 1) {
            StatementResult result = session.run("Match (n:Api {name:"+"\""+apis.get(0)+"\""+"})-[*]->()<-[*]-(m:Api) return m.name limit 5");
            while (result.hasNext()) {
                Record record = result.next();
                findAPI.add(record.get("m.name").asString());
            }
            session.close();
            driver.close();
        }
        if (apis.size() == 2) {
//            StatementResult result = session.run("Match (n:Api {name:{name1}})-[*]->()<-[*]-(m:Api) Match (l:Api {name:{name2}})-[*]->()<-[*]-(m:Api) return m.name", parameters("name1", apis.get(1), "name2", apis.get(0)));
            String sql = "Match (n:Api {name:"+"\""+apis.get(0)+"\""+"})-[*]->()<-[*]-(m:Api) Match (l:Api {name:"+"\""+apis.get(1)+"\""+"})-[*]->()<-[*]-(m:Api) return m.name limit 5";
            System.out.println(sql);
            StatementResult result = session.run(sql);
            Set<String> resultSet = new HashSet<>();
            while (result.hasNext()) {
                Record record = result.next();
                //先用set集合排除掉
                resultSet.add(record.get("m.name").asString());
            }
            for (String value:resultSet){
                /*anwserresult = anwserresult+" "+value;*/
                findAPI.add(value);
            }
            session.close();
            driver.close();
        }
        return findAPI;
    }
}
