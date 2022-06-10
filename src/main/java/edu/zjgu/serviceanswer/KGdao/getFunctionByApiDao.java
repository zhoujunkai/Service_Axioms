package edu.zjgu.serviceanswer.KGdao;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class getFunctionByApiDao {
    public static String getCatogoryByApi(String apiname) {
        //        System.out.println("传入的api名字是："+apiname);
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));
        Session session = driver.session();
//        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
//                        "RETURN a.name AS name, a.title AS title",
//                parameters( "name", "Arthur001" ) );
        StatementResult result = session.run("MATCH (n:Api)-[r:has]-(m:Function)where n.name={name} return n.name As name,m.name As mname", parameters("name", apiname));
        String anwserresult = apiname + "的功能是";
        while (result.hasNext()) {
//            Record record = result.next();
//            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
            Record record = result.next();
            anwserresult = anwserresult + record.get("mname").asString() + "  ";
        }
        System.out.println(anwserresult);
        session.close();
        driver.close();
        return anwserresult;
    }
}
