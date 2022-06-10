package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class getApiByFunctionDao {
    public static List<String> getApiByFunction(List<String> functionNameList) {
        List<String> APIList = new ArrayList<>();
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
        if (functionNameList.size() == 1) {
            StatementResult result = session.run("match (n{name:{name1}})-[r:has]-(m) return m.name As mname", parameters("name1", functionNameList.get(0)));
            while (result.hasNext()) {
                Record record = result.next();
                APIList.add(record.get("mname").asString());
            }
            session.close();
            driver.close();
        }
        if (functionNameList.size() == 2) {
            StatementResult result = session.run("match (n:Function),(nn:Function)-[r:has]-(m) where n.name={name1} and nn.name={name2} return m.name As mname", parameters("name1", functionNameList.get(1), "name2", functionNameList.get(0)));
            while (result.hasNext()) {
                Record record = result.next();
                APIList.add(record.get("mname").asString());
            }
            session.close();
            driver.close();
        }
        if (functionNameList.size() == 3) {

        }
        return APIList;
    }
}
