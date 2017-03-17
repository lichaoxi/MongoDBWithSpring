package com.ryan.utils;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * MongoDB工具类 Mongo实例代表了一个数据库连接池，即使在多线程的环境中，一个Mongo实例对我们来说已经足够了<br>
 * 注意Mongo已经实现了连接池，并且是线程安全的。 <br>
 * 设计为单例模式， 因 MongoDB的Java驱动是线程安全的，对于一般的应用，只要一个Mongo实例即可，<br>
 * Mongo有个内置的连接池（默认为10个） 对于有大量写和读的环境中，为了确保在一个Session中使用同一个DB时，<br>
 * DB和DBCollection是绝对线程安全的<br>
 */
public enum MongoDBUtil {

    /**
     * 定义一个枚举的元素，它代表此类的一个实例
     */
    instance;

    private MongoClient mongoClient;

    static {
        System.out.println("===============MongoDBUtil初始化========================");
        // 从配置文件中获取属性值
        String ip = "localhost";
        int port = 27017;
        instance.mongoClient = new MongoClient(ip, port);
    }

    // ------------------------------------共用方法---------------------------------------------------
    /**
     * 获取DB实例 - 指定DB
     * 
     * @param dbName
     * @return
     */
    public MongoDatabase getDB(String dbName) {
        if (dbName != null && !"".equals(dbName)) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            return database;
        }
        return null;
    }

    /**
     * 获取collection对象 - 指定Collection
     * 
     * @param collName
     * @return
     */
    public MongoCollection<Document> getCollection(String dbName, String collName) {
        if (null == collName || "".equals(collName)) {
            return null;
        }
        if (null == dbName || "".equals(dbName)) {
            return null;
        }
        MongoCollection<Document> collection = mongoClient.getDatabase(dbName).getCollection(collName);
        return collection;
    }

    /**
     * 关闭Mongodb
     */
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }


    /**
     * 条件查询 
     * @param coll MongoDB的连接对象
     * @param filter 
     * @return
     */
    public MongoCursor<Document> find(MongoCollection<Document> coll, Bson filter) {
        if(null!=filter){
        	return coll.find(filter).iterator();
        }else{
        	return coll.find().iterator();
        }
    }
    
      
    /**插入一条数据*/
    public void insert(MongoCollection<Document> coll,Document doc){
    	coll.insertOne(doc);
    }
    
    /**更新一条数据*/
    public void update(MongoCollection<Document> coll,Document querydoc,Document updatedoc){
    	coll.updateMany(querydoc, updatedoc);
    }

    /**删除一条数据*/
    public void delete(MongoCollection<Document> coll,Document doc){
    	coll.deleteMany(doc);
    }


    /**
     * 测试入口
     * 
     * @param args
     */
    public static void main(String[] args) {

        String dbName = "personmap";
        String collName = "person";
        MongoCollection<Document> coll = MongoDBUtil.instance.getCollection(dbName, collName);
        
        
        // 查询所有
//        Bson filter = Filters.eq("name", "ryan");
//        MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
//        while(cursor.hasNext()){
//        	System.out.println(cursor.next());
//        }
        
        //插入一条
        Document doc = new Document();
        doc.put("name", "ryan");
        doc.put("age", 20);
        MongoDBUtil.instance.insert(coll, doc);
        
        Bson filter = Filters.eq("name", "ryan");
        MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
        while(cursor.hasNext()){
        	System.out.println(cursor.next());
        }
        
        //更新一条数据
//	    Document querydoc = new Document();
//	    querydoc.put("name", "ryan");
//	    
//	    Document updatedoc = new Document();
//	    updatedoc.put("name", "ryan");
//	    updatedoc.put("age", 28);
//	    
//	    MongoDBUtil.instance.update(coll, querydoc, updatedoc);
//	    
//	    Bson filter = Filters.eq("name", "ryan");
//		MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
//		while(cursor.hasNext()){
//		System.out.println(cursor.next());
//		}
        
        
        //删除一条数据
//        Document doc = new Document();
//        MongoDBUtil.instance.delect(coll, doc);
    }
}