FROM maven

# Copy and config application.
ENV DB_URL "jdbc:postgresql://host.docker.internal:5432/java-spring_base-app"
COPY . /usr/src/
WORKDIR /usr/src/

# ENTRYPOINT ["mvn", "clean", "install", "spring-boot:run"]
# RUN mvn clean install
# CMD mvn spring-boot:run
# CMD ["nohup mvn spring-boot:run &"]