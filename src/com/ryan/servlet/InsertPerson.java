package com.ryan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.ryan.utils.MongoDBUtil;

/**
 * Servlet implementation class insertPerson
 */
public class InsertPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Double age = Double.valueOf(request.getParameter("age"));
	
		String dbName = "personmap";
        String collName = "person";
        MongoCollection<Document> coll = MongoDBUtil.instance.getCollection(dbName, collName);
        
        Document doc = new Document();
        doc.put("name", name);
        doc.put("age", age);
        MongoDBUtil.instance.insert(coll, doc);
        
        PrintWriter out = response.getWriter();
        out.write("insert success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
