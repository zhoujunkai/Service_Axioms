package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class getTagByApiDao {
    public static String getTagByApi(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
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

    public static List<String> getTagByApiName(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        String anwserResult = null;
        List<String> TagName= new ArrayList<>();
        StatementResult result = session.run("MATCH (n:Api)-[r:label]-(m:tag)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
            Record record = result.next();
//            System.out.println(record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ");
            TagName.add(record.get("mname").asString());
            anwserResult = record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ";
        }
//        System.out.println(TagName);
        session.close();
        driver.close();
        return TagName;
    }

    public static int  getTagByApiCount(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        String anwserResult = null;
       int tagcount=0;
        StatementResult result = session.run("MATCH (n:Api)-[r:label]-(m:tag)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
            Record record = result.next();
//            System.out.println(record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ");
           tagcount+=1;
            anwserResult = record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ";
        }
//        System.out.println(TagName);
        session.close();
        driver.close();
        return tagcount;
    }
}
