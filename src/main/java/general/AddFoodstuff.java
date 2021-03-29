package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFoodstuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFoodstuff() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<KeyValue> viewData = new ArrayList<KeyValue>();
		
		viewData.add(new KeyValue("method", "POST"));
		
		StringWriter renderedHtml = TemplateHelper.getTemplate("templates/addFoodstuff.vm", viewData);
        
        PrintWriter out = response.getWriter();
        out.println(renderedHtml);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
