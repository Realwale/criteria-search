FROM openjdk:17-oracle
COPY target/*.jar criteriasearch.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "criteriasearch.jar"]