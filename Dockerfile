FROM openjdk:11.0.15-oraclelinux7
EXPOSE 8080
ADD target/pay2park-backend-0.0.1-SNAPSHOT.jar pay2park.jar
ENTRYPOINT ["java", "-jar", "/pay2park.jar"]
#FROM maven:latest
#RUN mkdir /pay2park-backend
#WORKDIR /pay2park-backend
#COPY . .
#EXPOSE 8080
#CMD ["mvn", "spring-boot:run"]