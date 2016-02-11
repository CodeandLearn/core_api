package Core.Plugin.Default;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerMapping;

public class Default {
	protected HttpServletRequest request;
	protected HttpServletResponse reply;
	private Timestamp timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public Default(HttpServletRequest request) {
		this.request = request;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.status = 200;
		this.error = "OK";
		this.message = "";
		this.path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
	}
	
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

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
