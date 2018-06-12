FROM java:8-jre
MAINTAINER Jast Zhang <zhangzhiwen91@gmail.com>

ADD ./target/open-service-1.0-SNAPSHOT.jar /app/

CMD ["java","-Xmx200m","jar","/app/open-service-1.0-SNAPSHOT.jar"]
EXPOSE 8888