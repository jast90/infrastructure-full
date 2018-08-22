FROM java:8-jre
MAINTAINER Zhiwen Zhang <zhangzhiwen91@gmail.com>
ENV PROFILE default
ENV PORT 8080
ENV aliyunOssAccessKeyId aliyunOssAccessKeyId
ENV aliyunOssSecretAccessKey aliyunOssAccessKeyId
ADD ./target/cms.jar /app/
CMD ["java", "-Xmx200m", "-jar","-Dspring.profiles.active=${PROFILE}","-Dserver.port=${PORT}","-DaliyunOssAccessKeyId=${aliyunOssAccessKeyId}","-DaliyunOssSecretAccessKey=${aliyunOssSecretAccessKey}","/app/cms.jar"]

EXPOSE 8080