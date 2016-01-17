package Core;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void loadJar(String s) throws Exception {
		JarFile jarFile = new JarFile(s);
		Enumeration<JarEntry> e = jarFile.entries();
		URL[] urls = { new URL("jar:file:" + s + "!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);
		while (e.hasMoreElements()) {
			JarEntry jarEntry = (JarEntry) e.nextElement();
			if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
				continue;
			}
			String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
			className = className.replace('/', '.').replace("bin.", "");
			System.out.println(className);
			cl.loadClass(className);
		}
		jarFile.close();
	}

	public static void main(String[] args) {
		try {
			/*
			 * Le *.jar est bien chargé (chacunes de ses classes est bien
			 * intanciés mais SpringMVC ne fait pas le lien.
			 * loadJar("./plugins/HelloWorld.jar");
			 */
			//loadJar("./plugins/HelloWorld.jar");
			SpringApplication app = new SpringApplication(Application.class);
			app.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}