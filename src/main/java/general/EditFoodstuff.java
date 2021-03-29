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

public class EditFoodstuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditFoodstuff() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<KeyValue> viewData = new ArrayList<KeyValue>();
    	
    	String id = request.getParameter("id");
    	
    	HttpSession session = request.getSession();
    	
		ArrayList<FoodStuff> FoodStuffs = (ArrayList<FoodStuff>) session.getAttribute("foodstuffs");
          
		for (FoodStuff foodstuff : FoodStuffs) {
			if (foodstuff.getId() == Integer.parseInt(id)) {
				viewData.add(new KeyValue("foodstuff", foodstuff));
				
				break;
			}
		}
		
		viewData.add(new KeyValue("method", "PUT"));
    	
    	StringWriter renderedHtml = TemplateHelper.getTemplate("templates/addFoodstuff.vm", viewData);
        
        PrintWriter out = response.getWriter();
        out.println(renderedHtml);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
