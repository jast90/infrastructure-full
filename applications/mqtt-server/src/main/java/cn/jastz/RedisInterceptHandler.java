package cn.jastz;

import cn.jastz.mqtt.client.ClientRedisService;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisInterceptHandler implements InterceptHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ClientRedisService clientRedisService;

    public RedisInterceptHandler(ClientRedisService clientRedisService) {
        this.clientRedisService = clientRedisService;
    }

    @Override
    public String getID() {
        return "Redis Handler";
    }

    @Override
    public Class<?>[] getInterceptedMessageTypes() {
        return null;
    }

    @Override
    public void onConnect(InterceptConnectMessage interceptConnectMessage) {
        logger.info("redis intercept handler,connect clientId:{}",interceptConnectMessage.getClientID());
        clientRedisService.online(interceptConnectMessage.getClientID());
    }

    @Override
    public void onDisconnect(InterceptDisconnectMessage interceptDisconnectMessage) {
        clientRedisService.offline(interceptDisconnectMessage.getClientID());
    }

    @Override
    public void onConnectionLost(InterceptConnectionLostMessage interceptConnectionLostMessage) {

    }

    @Override
    public void onPublish(InterceptPublishMessage interceptPublishMessage) {

    }

    @Override
    public void onSubscribe(InterceptSubscribeMessage interceptSubscribeMessage) {

    }

    @Override
    public void onUnsubscribe(InterceptUnsubscribeMessage interceptUnsubscribeMessage) {

    }

    @Override
    public void onMessageAcknowledged(InterceptAcknowledgedMessage interceptAcknowledgedMessage) {

    }
}
