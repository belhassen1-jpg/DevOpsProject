FROM openjdk:17
EXPOSE 8089
ADD target/kaddem-2.1.jar kaddem-2.1.jar
ENTRYPOINT ["java","-jar","/kaddem-2.1.jar"]