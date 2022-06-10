package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class getApiByTagsDao {
    public static String getApiByTags(String tag) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
        StatementResult result = session.run("match (n{name:{name1}})-[r:label]-(m) return m.name As mname", parameters("name1", tag));
        String anwserresult = "有关" + tag + "的api有";
        while (result.hasNext()) {
            Record record = result.next();
            anwserresult = anwserresult + record.get("mname").asString() + "  ";
        }
        session.close();
        driver.close();
        return anwserresult;
    }
}
