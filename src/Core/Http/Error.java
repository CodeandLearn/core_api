package Core.Http;

import Core.Model;

/**
 * Created by teddy on 21/05/2016.
 */
public class Error extends Model {
    public Error(String socket, int code) {
        setCode(socket, code);
    }
}
