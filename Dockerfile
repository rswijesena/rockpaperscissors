FROM openjdk:16-jdk-alpine
MAINTAINER baeldung.com
COPY target/rockpaperscissor-1.0.0.jar rockpaperscissor-1.0.0.jar
ENTRYPOINT ["java","-jar","/rockpaperscissor-1.0.0.jar"]