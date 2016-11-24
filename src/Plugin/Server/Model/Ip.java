package Plugin.Server.Model;

import Core.Http.Code;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.IpSingleton;
import Plugin.Server.Obj.IpObj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by teddy on 24/11/2016.
 */
public class Ip extends Model {
    public Ip whiteListIp(String socket, String ip) {
        IpSingleton.getInstance().whiteListIp(ip);
        setCode(socket, Code.OK);
        return this;
    }

    public Ip unbanIp(String socket, String ip) {
        IpSingleton.getInstance().unbanIp(ip);
        setCode(socket, Code.OK);
        return this;
    }

    public Ip banIp(String socket, String ip) {
        IpSingleton.getInstance().banIp(ip);
        setCode(socket, Code.OK);
        return this;
    }

    public Ip getIp() {
        Properties props = getListIp();
        for (Object data : props.stringPropertyNames().toArray()) {
            addIp(data.toString(), !Boolean.parseBoolean(props.get(data).toString()), Boolean.parseBoolean(props.get(data).toString()));
        }
        return this;
    }

    private void addIp(String ip, boolean banned, boolean whiteListed) {
        IpObj ipObj = new IpObj();
        ipObj.ip = ip;
        ipObj.isBanned = banned;
        ipObj.isWhiteListed = whiteListed;
        data.add(ipObj);
        length = data.size();
    }

    private Properties getListIp() {
        Properties props = new Properties();
        try {
            FileReader file = new FileReader(new File("ip.properties"));
            props.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}
