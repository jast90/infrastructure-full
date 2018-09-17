FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ENV PROFILE default
ENV PORT 8087
ADD ./target/store-service.jar /app/
CMD ["java", "-Xmx200m", "-jar","-Dspring.profiles.active=${PROFILE}","-Dserver.port=${PORT}","/app/store-service.jar"]

EXPOSE 8087