FROM openjdk:11
ADD target/social-media-backend-0.0.1-SNAPSHOT.jar social-media-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8087
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","social-media-backend-0.0.1-SNAPSHOT.jar"]
