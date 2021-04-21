# Test API Voiture

### Installation
importer la base de donnée database.sql<br>
configurer le info de connexion de la base dans /ressources/application.properties<br>

Executer les commandes suivante:
>mvn clean install<br>
>mvn spring-boot:run

### Page d'accueil sur le client web : 
http://localhost:8080/list_car.html

Pour se connecter vous pouvez utiliser l'authentification basic.
>curl http://localhost:8080/api/car/list -u eric@gmail.com:123

### Les APIS
API list (GET) : http://localhost:8080/api/car/list

API Commenter (GET) :  http://localhost:8080/api/car/comment?carId=[IDCAR]&comment=[COMMENT]

API user connected (GET) :  http://localhost:8080/api/user

### Utilisateur disponible

eric@gmail.com/123<br>
jean@gmail.com/123<br>
marc@gmail.com/123