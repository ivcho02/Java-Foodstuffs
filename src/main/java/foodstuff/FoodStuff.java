package foodstuff;
 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class FoodStuff {
	private String name;
	
	public FoodStuff() {}
	
	public FoodStuff(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
