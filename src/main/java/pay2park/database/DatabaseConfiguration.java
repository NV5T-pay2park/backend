package pay2park.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/*
docker run -d --rm --name pay2park \
-e MYSQL_ROOT_PASSWORD=Truong18122001? \
-e MYSQL_USER=root \
-e MYSQL_PASSWORD=Truong18122001? \
-e MYSQL_DATABASE=NV5T_parking_lot \
-p 3309:3306 \
--volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u root -p
*/
@Configuration
@EnableJpaRepositories(basePackages = {"pay2park.repository"})
public class DatabaseConfiguration {

}