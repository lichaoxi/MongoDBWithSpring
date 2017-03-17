package com.ryan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.ryan.utils.MongoDBUtil;

/**
 * Servlet implementation class UpdatePerson
 */
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryname = request.getParameter("queryname");
		Double updateage = Double.valueOf(request.getParameter("updateage"));
	
		String dbName = "personmap";
        String collName = "person";
        MongoCollection<Document> coll = MongoDBUtil.instance.getCollection(dbName, collName);
        
        Document querydoc = new Document();
        querydoc.put("name", queryname);

        Document updatedoc = new Document();
        updatedoc.put("name", queryname);
        updatedoc.put("age", updateage);
        
        
        MongoDBUtil.instance.update(coll, querydoc , new Document("$set",updatedoc));
        
        PrintWriter out = response.getWriter();
        out.write("update success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
