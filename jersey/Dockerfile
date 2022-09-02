FROM tomcat:latest
COPY  jersey /target/my-app.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]

FROM tomcat:10-jdk17
ADD target/MyWebApp.war /usr/local/tomcat/webapps/MyWebApp.war
EXPOSE 8080
CMD ["catalina.sh", "run"]