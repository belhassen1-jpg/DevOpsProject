FROM openjdk:17
EXPOSE 8089
ADD target/kaddem-1.0.0.jar kaddem-1.0.0.jar
ENTRYPOINT ["java","-jar","/kaddem-1.0.0.jar"]