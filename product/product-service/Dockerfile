FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ENV PROFILE default
ENV PORT 8084
ADD ./target/product-service.jar /app/
CMD ["java", "-Xmx200m", "-jar","-Dspring.profiles.active=$PROFILE","-Dserver.port=$PORT","/app/product-service.jar"]

EXPOSE 8084