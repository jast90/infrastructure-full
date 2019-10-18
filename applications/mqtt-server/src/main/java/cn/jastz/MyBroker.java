package cn.jastz;

import cn.jastz.mqtt.client.ClientRedisService;
import io.moquette.broker.Server;
import io.moquette.broker.config.FileResourceLoader;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import io.moquette.broker.config.ResourceLoaderConfig;
import io.moquette.interception.InterceptHandler;

import java.io.File;
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
        handlers.add(new RedisInterceptHandler(new ClientRedisService()));
        server.startServer(defaultConfig(),handlers);
        Runtime.getRuntime().addShutdownHook(new Thread(server::stopServer));
    }

    public static IConfig defaultConfig(){
        String configPath = System.getProperty("moquette.path", "/Users/zhangzhiwen/IdeaProjects/gitlab/infrastructure/applications/mqtt-server/src/main/resources");
        File file = new File(configPath, "config/moquette.conf");
        File defaultConfigurationFile = file;

//        LOG.info("Starting Moquette integration. Configuration file path={}", defaultConfigurationFile.getAbsolutePath());
        IResourceLoader filesystemLoader = new FileResourceLoader(defaultConfigurationFile);
        IConfig config = new ResourceLoaderConfig(filesystemLoader);
        return config;
    }
}
