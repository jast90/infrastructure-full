FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ENV PROFILE default
ENV PORT 8080
ADD ./target/fa-tui.jar /app/
CMD ["java", "-Xmx200m", "-jar","-Dspring.profiles.active=${PROFILE}","-Dserver.port=${PORT}","/app/fa-tui.jar"]

EXPOSE 8080