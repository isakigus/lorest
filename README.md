How to run mysql

docker run -p 3306:3306 --name lore-mysql -e MYSQL_ROOT_PASSWORD=Muela2000 \
 -e MYSQL_DATABASE=muela -e MYSQL_USER=muela -e MYSQL_PASSWORD=Muela2000 -d mysql:latest