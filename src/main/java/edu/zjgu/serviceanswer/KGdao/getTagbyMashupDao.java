package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class getTagbyMashupDao {
    public static void main(String[] args) {
        int a=TagbyMashupCount("mashup@2008-formula-one-map");
        System.out.println(a);
    }
    public static int  TagbyMashupCount(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
        String anwserResult = null;
        int tagcount=0;
        StatementResult result = session.run("MATCH (n:Mashup)-[*2]-(m:tag)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
            Record record = result.next();
//            System.out.println(record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ");
            tagcount+=1;
            anwserResult = record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ";
//            System.out.println(record.get("mname").asString()+" ");
        }
//        System.out.println(TagName);
        session.close();
        driver.close();
        return tagcount;
    }

    public static List<String>  TagbyMashupTagName(String apiname) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "zjk990205"));
        Session session = driver.session();
//        String anwserResult = null;
        List<String> MashupTag=new ArrayList<>();
        StatementResult result = session.run("MATCH (n:Mashup)-[*2]-(m:tag)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
            Record record = result.next();
//            System.out.println(record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ");
            MashupTag.add(record.get("mname").asString());
//            anwserResult = record.get("name").asString() + "的标签是" + record.get("mname").asString() + " ";
//            System.out.println(record.get("mname").asString()+" ");
        }
//        System.out.println(TagName);
        session.close();
        driver.close();
        return MashupTag;
    }
}
