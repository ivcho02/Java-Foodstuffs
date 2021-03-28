package foodstuff;
 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class FoodStuff {
	private String name;
	private String weight;
	private String bestBefore;
	private String eneryValue;
	private String price;
	
	public FoodStuff() {}
	
	public FoodStuff(String name, String weight, String bestBefore, String evergyValue, String price) {
		this.setName(name);
		this.setWeight(weight);
		this.setBestBefore(bestBefore);
		this.setEneryValue(evergyValue);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBestBefore() {
		return bestBefore;
	}

	public void setBestBefore(String bestBefore) {
		this.bestBefore = bestBefore;
	}

	public String getEneryValue() {
		return eneryValue;
	}

	public void setEneryValue(String eneryValue) {
		this.eneryValue = eneryValue;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
