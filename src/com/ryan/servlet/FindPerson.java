package com.ryan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.ryan.model.Person;
import com.ryan.utils.MongoDBUtil;

/**
 * Servlet implementation class FindPerson
 */
public class FindPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FindPerson() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbName = "personmap";
        String collName = "person";
        MongoCollection<Document> coll = MongoDBUtil.instance.getCollection(dbName, collName);
        
        
        List<Person> personList = new ArrayList<Person>();
        // ²éÑ¯ËùÓÐ
        //Bson filter = Filters.eq("name", "ryan1");
        Bson filter = null;
        MongoCursor<Document> cursor = MongoDBUtil.instance.find(coll, filter);
        while(cursor.hasNext()){
        	Document tempdoc = cursor.next();
        	Person person = new Person();
        	person.set_id(tempdoc.get("_id").toString());
        	person.setName(tempdoc.get("name").toString());
        	person.setAge(Double.valueOf(tempdoc.get("age").toString()));
        	personList.add(person);
        }
        
        Gson gson = new Gson();
        
        PrintWriter out = response.getWriter();
        out.write(gson.toJson(personList));
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
