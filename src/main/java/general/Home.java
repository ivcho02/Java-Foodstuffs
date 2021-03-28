package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodstuff.FoodStuff;
import webServices.FoodstuffServices;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    FoodstuffServices services = new FoodstuffServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }
    
    public void initLocalStorage(HttpSession session) {
		if(session.getAttribute("foodstuffs") == null)
			session.setAttribute("foodstuffs", new ArrayList<FoodStuff>());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<KeyValue> viewData = new ArrayList<KeyValue>();
    	
    	HttpSession session = request.getSession();
    	
    	initLocalStorage(session);
    	
		ArrayList<FoodStuff> FoodStuffs = (ArrayList<FoodStuff>) session.getAttribute("foodstuffs");
            
    	viewData.add(new KeyValue("foodstuffs", FoodStuffs));
    	
    	StringWriter renderedHtml = TemplateHelper.getTemplate("templates/home.vm", viewData);
        
        PrintWriter out = response.getWriter();
        out.println(renderedHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
