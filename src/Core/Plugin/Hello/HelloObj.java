package Core.Plugin.Hello;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class HelloObj {
	@NotEmpty
	@Size(max = 16)
	private String name;
	@NotEmpty
	private String title;
	@NotNull
	@Min(1)
	@Max(value = 10, message = "test de message d'erreur")
	private int id;

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}
}
