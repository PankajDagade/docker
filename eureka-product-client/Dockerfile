#base image
FROM eclipse-temurin:21

#set working directory inside the container
WORKDIR /app

# Copy the jar from local target folder to container
COPY target/eureka-product-client.jar eureka-productapp-client.jar

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "eureka-productapp-client.jar" ]