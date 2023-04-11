
FROM openjdk:19
ADD target/udemy-0.0.1-SNAPSHOT.jar ecommercev1.jar
EXPOSE 8080
CMD ["java", "-jar", "/ecommercev1.jar"]
