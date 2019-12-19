package cn.jastz;

import cn.jastz.mqtt.client.ClientRedisService;
import io.moquette.broker.Server;
import io.moquette.broker.config.*;
import io.moquette.interception.InterceptHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class MyBroker {


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        List<InterceptHandler> handlers = new ArrayList<>();
//        handlers.add(new RedisInterceptHandler(new ClientRedisService()));
        server.startServer(defaultConfig(),handlers);
        Runtime.getRuntime().addShutdownHook(new Thread(server::stopServer));
    }

    public static IConfig defaultConfig(){
        IResourceLoader filesystemLoader = new ClasspathResourceLoader("config/moquette.conf");
        IConfig config = new ResourceLoaderConfig(filesystemLoader);
        return config;
    }
}
