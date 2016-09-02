package Core.Http;

import Core.Singleton.ConfigSingleton;
import Core.Singleton.ServerSingleton;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * Created by teddy on 31/05/2016.
 */
public class Map extends HashMap {
    private static String CHARSET = ConfigSingleton.getInstance().getCharset();

    public int getInt(Object key) {
        try {
            return Integer.parseInt(get(key).toString());
        } catch (NumberFormatException e) {
            ServerSingleton.getInstance().log("[SERVER] -> Map.getInt : " + e, e);
        }
        return -1;
    }

    public String getString(Object key) {
        try {
            return String.valueOf(URLDecoder.decode(get(key).toString(), CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getDouble(Object key) {
        try {
            return Double.valueOf(get(key).toString());
        } catch (NumberFormatException e) {
            ServerSingleton.getInstance().log("[SERVER] -> Map.getDouble : " + e, e);
        }
        return -1;
    }

    public float getFloat(Object key) {
        try {
            return Float.valueOf(get(key).toString());
        } catch (NumberFormatException e) {
            ServerSingleton.getInstance().log("[SERVER] -> Map.getFloat : " + e, e);
        }
        return -1;
    }

    public boolean getBoolean(Object key) {
        try {
            return Boolean.valueOf(get(key).toString());
        } catch (NumberFormatException e) {
            ServerSingleton.getInstance().log("[SERVER] -> Map.getBoolean : " + e, e);
        }
        return false;
    }

    public long getLong(Object key) {
        try {
            return Long.valueOf(get(key).toString());
        } catch (NumberFormatException e) {
            ServerSingleton.getInstance().log("[SERVER] -> Map.getBoolean : " + e, e);
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object replace(Object key, Object value) {
        return super.replace(key, value);
    }
}
