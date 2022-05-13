# Shop
 + Back-End using Spring Boot :
   - JWT -> token
   - JBDC -> core
   - Mysql -> database


# Docker
docker network create employee-mysql
docker container run --network shopping-net --name shopping-docker-container -p 8080:8080 -d --platform linux/amd64  shopping-docker
