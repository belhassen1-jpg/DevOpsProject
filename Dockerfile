FROM openjdk:17
RUN apt-get update && apt-get install -y curl
ADD target/kaddem-1.0.0.jar kaddem-1.0.0.jar
ENTRYPOINT ["java","-jar","/kaddem-1.0.0.jar"]
EXPOSE 8089

