package general;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateHelper {
	public static StringWriter getTemplate(String templateName, ArrayList<KeyValue> viewData) {
		Properties p = new Properties();
    	
    	p.setProperty("resource.loader", "class");
    	p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(p);
           
        Template template = velocityEngine.getTemplate(templateName);
        
        VelocityContext context = new VelocityContext();
        
		for (KeyValue element : viewData) {
			String key = (String) element.getKey();
			Object value = (Object) element.getValue();
			
        	context.put(key, value);        	
        }
        
        StringWriter writer = new StringWriter();
        
        template.merge(context, writer);
        
		return writer;
	}
}
