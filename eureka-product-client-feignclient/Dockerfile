#base image
FROM eclipse-temurin:21

#set working directory inside the container
WORKDIR /app

# Copy the jar from local target folder to container
COPY target/eureka-product-client-feignclient.jar eureka-product-client-feignclientapp.jar

EXPOSE 8085

ENTRYPOINT [ "java", "-jar", "eureka-product-client-feignclientapp.jar" ]