ECHO OFF

:: Elements name.
set imageName="ribaslucian/java-spring_prova-cast-app:1"
set containerName="java-spring_prova-cast-app"

IF "%~1"=="dockerfile" (

:: Remove old container and old image.
docker rm -f %containerName%
docker rmi %imageName%

:: Build iamge.
docker build -f ".dockerfile" -t %imageName% .

:: Run/Create container.
docker run -d -it ^
    --name %containerName% ^
    -p 80:80 ^
    %imageName% ^
    mvn clean install spring-boot:run

:: Enter on container
:: docker exec -it %containerName% bash

) ELSE (
    docker-compose up
)