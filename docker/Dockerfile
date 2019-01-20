# Docker部署Javaweb(war)
# Dockerfile for lifecat-servlet
# 1. Copy lifecat.war to current directory
# 2. Build with: docker build -t lifecat-servlet .
# 3. Run with: docker run -d -p 8091:8080 lifecat-servlet

FROM tomcat:7.0

MAINTAINER kevinten <wshten@gmail.com>

ADD lifecatweb.war /usr/local/tomcat/webapps/

EXPOSE 8080
