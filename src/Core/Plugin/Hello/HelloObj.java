package Core.Plugin.Hello;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HelloObj {
	@NotNull
	private String name;
	@NotNull
	private String title;
	@NotNull
	@Min(1)
	@Max(10)
	private Integer id;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Integer getId() {
		return id;
	}
}
