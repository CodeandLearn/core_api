package Core.Plugin.Hello;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
