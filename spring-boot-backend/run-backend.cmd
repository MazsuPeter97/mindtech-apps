call mvn clean install
call docker build -t mindtech-apps.jar .
call docker-compose up -d