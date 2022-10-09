package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class getApiByTagsDao {
    public static String getApiByTags(String tag) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
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

    public static double getApiByTagsCount(String tag) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        StatementResult result = session.run("match (n{name:{name1}})-[r:label]-(m) return m.name As mname", parameters("name1", tag));
        String anwserresult = "有关" + tag + "的api有";

        int tagcount=0;

        while (result.hasNext()) {
            Record record = result.next();
            anwserresult = anwserresult + record.get("mname").asString() + "  ";
            tagcount+=1;
        }
        double sum=1.0/tagcount;
//        System.out.println(sum);

        session.close();
        driver.close();
        return sum;
    }

    public static List<String> getApiByTagsApiName(String tag) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        StatementResult result = session.run("match (n{name:{name1}})-[r:label]-(m) return m.name As mname", parameters("name1", tag));
        String anwserresult = "有关" + tag + "的api有";


        List<String> ApiName=new ArrayList<>();


        while (result.hasNext()) {
            Record record = result.next();
            anwserresult = anwserresult + record.get("mname").asString() + "  ";
            ApiName.add(record.get("mname").asString());
        }

//        System.out.println(ApiName);

        session.close();
        driver.close();
        return ApiName;
    }

    public static int getApiByTagsSum(String tag) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        StatementResult result = session.run("match (n{name:{name1}})-[r:label]-(m) return m.name As mname", parameters("name1", tag));
        String anwserresult = "有关" + tag + "的api有";

        int tagcount=0;

        while (result.hasNext()) {
            Record record = result.next();
            anwserresult = anwserresult + record.get("mname").asString() + "  ";
            tagcount+=1;
        }

//        System.out.println(sum);

        session.close();
        driver.close();
        return tagcount;
    }
}
