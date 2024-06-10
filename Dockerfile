FROM openjdk:17-jdk

WORKDIR /app

COPY target/ci-cs-1.0.0.jar /app/ci-cs.jar

EXPOSE 8080

CMD ["java", "-jar", "ci-cs.jar"]