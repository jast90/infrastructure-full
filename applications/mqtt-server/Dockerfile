FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ADD ./target/mqtt-server.jar /app/
CMD ["java", "-Xmx200m", "-jar","/app/mqtt-server.jar"]

EXPOSE 1883 8080