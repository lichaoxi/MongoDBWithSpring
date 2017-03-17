package com.ryan.utils;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * MongoDB������ Mongoʵ��������һ�����ݿ����ӳأ���ʹ�ڶ��̵߳Ļ����У�һ��Mongoʵ����������˵�Ѿ��㹻��<br>
 * ע��Mongo�Ѿ�ʵ�������ӳأ��������̰߳�ȫ�ġ� <br>
 * ���Ϊ����ģʽ�� �� MongoDB��Java�������̰߳�ȫ�ģ�����һ���Ӧ�ã�ֻҪһ��Mongoʵ�����ɣ�<br>
 * Mongo�и����õ����ӳأ�Ĭ��Ϊ10���� �����д���д�Ͷ��Ļ����У�Ϊ��ȷ����һ��Session��ʹ��ͬһ��DBʱ��<br>
 * DB��DBCollection�Ǿ����̰߳�ȫ��<br>
 */
public enum MongoDBUtil {

    /**
     * ����һ��ö�ٵ�Ԫ�أ�����������һ��ʵ��
     */
    instance;

    private MongoClient mongoClient;

    static {
        System.out.println("===============MongoDBUtil��ʼ��========================");
        // �������ļ��л�ȡ����ֵ
        String ip = "localhost";
        int port = 27017;
        instance.mongoClient = new MongoClient(ip, port);
    }

    // ------------------------------------���÷���---------------------------------------------------
    /**
     * ��ȡDBʵ�� - ָ��DB
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
     * ��ȡcollection���� - ָ��Collection
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
     * �ر�Mongodb
     */
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }


    /**
     * ������ѯ 
     * @param coll MongoDB�����Ӷ���
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
    
      
    /**����һ������*/
    public void insert(MongoCollection<Document> coll,Document doc){
    	coll.insertOne(doc);
    }
    
    /**����һ������*/
    public void update(MongoCollection<Document> coll,Document querydoc,Document updatedoc){
    	coll.updateMany(querydoc, updatedoc);
    }

    /**ɾ��һ������*/
    public void delete(MongoCollection<Document> coll,Document doc){
    	coll.deleteMany(doc);
    }


    /**
     * �������
     * 
     * @param args
     */
    public static void main(String[] args) {

        String dbName = "personmap";
        String collName = "person";
        MongoCollection<Document> coll = MongoDBUtil.instance.getCollection(dbName, collName);
        
        
        // ��ѯ����
//        Bson filter = Filters.eq("name", "ryan");
//        MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
//        while(cursor.hasNext()){
//        	System.out.println(cursor.next());
//        }
        
        //����һ��
        Document doc = new Document();
        doc.put("name", "ryan");
        doc.put("age", 20);
        MongoDBUtil.instance.insert(coll, doc);
        
        Bson filter = Filters.eq("name", "ryan");
        MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
        while(cursor.hasNext()){
        	System.out.println(cursor.next());
        }
        
        //����һ������
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
        
        
        //ɾ��һ������
//        Document doc = new Document();
//        MongoDBUtil.instance.delect(coll, doc);
    }
}