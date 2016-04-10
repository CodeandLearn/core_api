package Core.Plugins.Default;

import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

public class Default {
    protected HttpServletRequest request;
    protected HttpServletResponse reply;
    private Timestamp timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public Default(HttpServletRequest request, HttpServletResponse reply) {
        this.request = request;
        this.reply = reply;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = 200;
        this.error = "OK";
        this.message = "";
        this.path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
