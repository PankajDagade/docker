#base image
FROM eclipse-temurin:21

#set working directory inside the container
WORKDIR /app

# Copy the jar from local target folder to container
COPY target/eureka-product-client-resttemplate.jar eureka-product-client-resttemplateapp.jar

EXPOSE 8083

ENTRYPOINT [ "java", "-jar", "eureka-product-client-resttemplateapp.jar" ]