package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Hello world!
 */
public class getCatogoryByApiDao {
    public static String getCatogoryByApi(String apiname) {
        String answer = null;
//        System.out.println("传入的api名字是："+apiname);
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
//        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
//                        "RETURN a.name AS name, a.title AS title",
//                parameters( "name", "Arthur001" ) );
        StatementResult result = session.run("MATCH (n:Api)-[r:belong_to]->(m) where n.name={name} RETURN n.name As name,m.name As mname", parameters("name", apiname));
        while (result.hasNext()) {
//            Record record = result.next();
//            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
            Record record = result.next();
            System.out.println(record.get("name").asString() + "的类别是" + record.get("mname").asString());
            answer = record.get("name").asString() + "的类别是" + record.get("mname").asString();
        }
        session.close();
        driver.close();
        return answer;
    }
}
