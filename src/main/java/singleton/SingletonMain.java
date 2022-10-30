package singleton;

import java.sql.SQLException;

public class SingletonMain {

    public static void main(String[]arg) throws SQLException {
        /*MongoDBClient mongoDBClient = MongoDBClient.getClient();
        System.out.println(mongoDBClient.getData());
        MongoDBClient mongoDBClient2 = MongoDBClient.getClient();
        System.out.println(mongoDBClient2.getData());
        MongoDBClient mongoDBClient3 = MongoDBClient.getClient();
        System.out.println(mongoDBClient3.getData());*/
        SqlDBClient sql = SqlDBClient.getInstance();
        System.out.println(sql.url);


    }
}
