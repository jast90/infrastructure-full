FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ENV PROFILE ubox
ENV PORT 8082
ADD ./target/post-service.jar /app/
CMD ["java", "-Xmx200m", "-jar","-Dspring.profiles.active=${PROFILE}","-Dserver.port=${PORT}","/app/post-service.jar"]

EXPOSE 8082
