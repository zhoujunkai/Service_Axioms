package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class getTagByApiDao {
    public static String getTagByApi(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
        String anwserResult = null;
        StatementResult result = session.run("MATCH (n:Api)-[r:label]-(m:tag)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ");
            anwserResult = record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ";
        }
        session.close();
        driver.close();
        return anwserResult;
    }
}
