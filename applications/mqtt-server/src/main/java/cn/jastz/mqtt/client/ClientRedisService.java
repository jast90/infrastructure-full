package cn.jastz.mqtt.client;

import cn.jastz.JsonRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class ClientRedisService {
    private RedisConnectionFactory redisConnectionFactory;
    private RedisTemplate redisTemplate;
    private final String MQTT_CLIENT = "mqtt:client";

    public ClientRedisService() {
        redisConnectionFactory = new JedisConnectionFactory();
        redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
    }


    public void online(String clientId) {
        BoundHashOperations<String, String, ClientStatus> boundHashOperations = redisTemplate.boundHashOps(MQTT_CLIENT);
        ClientStatus clientStatus = boundHashOperations.get(clientId);
        if(clientStatus == null){
            clientStatus = new ClientStatus();
        }
        clientStatus.setStatus(ClientStatusEnums.ONLINE.getCode());
        boundHashOperations.put(clientId, clientStatus);
    }

    public void offline(String clientId) {
        BoundHashOperations<String, String, ClientStatus> boundHashOperations = redisTemplate.boundHashOps(MQTT_CLIENT);
        ClientStatus clientStatus = boundHashOperations.get(clientId);
        clientStatus.setStatus(ClientStatusEnums.OFFLINE.getCode());
        boundHashOperations.put(clientId, clientStatus);
    }
}
