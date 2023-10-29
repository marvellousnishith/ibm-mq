FROM amazoncorretto:17
VOLUME /temp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]