## Petit guide d'utilisation rapide de la librairie JSON.Simple.
La bibliothèque JSON.simple est une bibliothèque Java légère et simple pour travailler 
avec des données JSON. Elle vous permet de créer, analyser et manipuler des objets JSON 
en utilisant une syntaxe Java simple. Voici un résumé des principales méthodes et 
fonctionnalités de la bibliothèque JSON.simple :

### Télécharger la librairie :
Veuillez suivre ce kien pour télécharger la librairie JSON.simple. [CLIQUEZ ICI](https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/json-simple/json-simple-1.1.1.jar)

### Création d'objets JSON :
`JSONObject` : Vous pouvez créer un objet JSON en utilisant la classe `JSONObject`. 
Par exemple : `JSONObject json = new JSONObject();`.

### Création de tableaux JSON :
`JSONArray` : Vous pouvez créer un tableau JSON en utilisant la classe `JSONArray`. 
Par exemple : `JSONArray jsonArray = new JSONArray();`.`

### Ajout de données à un objet JSON :
`put(key, value)` : Vous pouvez ajouter des paires clé-valeur à un objet JSON en 
utilisant la méthode `put`. Par exemple : `json.put("name", "John");`.

### Ajout d'éléments à un tableau JSON :
`add(value)` : Vous pouvez ajouter des éléments à un tableau JSON en utilisant 
la méthode add. Par exemple : `jsonArray.add("apple");`.

### Conversion en chaîne JSON :
`toJSONString()` : Vous pouvez convertir un objet JSON ou un tableau JSON en une
chaîne JSON en utilisant la méthode `toJSONString`.

### Analyse de chaînes JSON :
`JSONParser` : Vous pouvez utiliser la classe `JSONParser` pour analyser une chaîne 
JSON et la convertir en un objet JSON ou un tableau JSON.

### Accès aux données JSON :
Vous pouvez accéder aux données JSON en utilisant les méthodes `get(key)` pour les 
objets JSON et `get(index)` pour les tableaux JSON.

### Parcours d'objets JSON :
Vous pouvez parcourir un objet JSON en utilisant des boucles `for` et en accédant 
aux paires clé-valeur.

### Parcours de tableaux JSON :
Vous pouvez parcourir un tableau JSON en utilisant des boucles `for` et en accédant 
aux éléments par index.

### Suppression de données :
Vous pouvez supprimer des paires clé-valeur d'un objet JSON en utilisant la 
méthode `remove(key)`.

### Vérification de la présence de clés :
Vous pouvez vérifier si une clé existe dans un objet JSON en utilisant la méthode 
`containsKey(key)`.

### Gestion des erreurs :
La bibliothèque génère des exceptions, telles que `ParseException`, en cas d'erreur 
lors de l'analyse d'une chaîne JSON.

JSON.simple est une bibliothèque simple et légère, adaptée pour des tâches de manipulation 
de JSON relativement simples en Java. Elle ne fournit pas de fonctionnalités avancées 
comme la désérialisation automatique en objets Java ou la gestion des types de données 
JSON complexes. Si vous avez besoin de fonctionnalités plus avancées, vous pourriez 
envisager d'autres bibliothèques telles que Gson ou Jackson, cependant ces bibliothèques 
ne seront pas vu dans le cadre de ce cours.

## Examples d'utilisation

### Création d'un objet JSON :
```agsl
JSONObject person = new JSONObject();
person.put("name", "John");
person.put("age", 30);
person.put("city", "New York");

System.out.println(person.toJSONString());
```
Cela crée un objet JSON représentant une personne avec des clés "name", "age" et "city".

### Création d'un tableau JSON :
```agsl
JSONArray fruits = new JSONArray();
fruits.add("apple");
fruits.add("banana");
fruits.add("cherry");

System.out.println(fruits.toJSONString());
```
Cela crée un tableau JSON contenant des noms de fruits.

### Analyse d'une chaîne JSON :
```agsl
String jsonText = "{\"name\":\"Alice\",\"age\":25,\"city\":\"London\"}";
JSONParser parser = new JSONParser();
JSONObject person = (JSONObject) parser.parse(jsonText);

String name = (String) person.get("name");
long age = (long) person.get("age");
String city = (String) person.get("city");

System.out.println("Name: " + name);
System.out.println("Age: " + age);
System.out.println("City: " + city);
```
Cela analyse une chaîne JSON et accède aux données de l'objet JSON.

### Parcours d'un objet JSON :
```agsl
JSONObject person = new JSONObject();
person.put("name", "John");
person.put("age", 30);
person.put("city", "New York");

for (Object key : person.keySet()) {
    String fieldName = (String) key;
    Object value = person.get(fieldName);
    System.out.println(fieldName + ": " + value);
}
```
Cela parcourt et affiche les paires clé-valeur de l'objet JSON.

### Parcours d'un tableau JSON :
```agsl
JSONArray fruits = new JSONArray();
fruits.add("apple");
fruits.add("banana");
fruits.add("cherry");

for (int i = 0; i < fruits.size(); i++) {
    String fruit = (String) fruits.get(i);
    System.out.println("Fruit " + (i + 1) + ": " + fruit);
}
```
Cela parcourt et affiche les éléments du tableau JSON.

### Suppression de données d'un objet JSON :
```agsl
JSONObject person = new JSONObject();
person.put("name", "John");
person.put("age", 30);
person.put("city", "New York");

person.remove("age"); // Supprime la clé "age" de l'objet JSON

System.out.println(person.toJSONString());
```
Cela supprime la clé "age" de l'objet JSON.

### Vérification de la présence d'une clé dans un objet JSON :
```agsl
JSONObject person = new JSONObject();
person.put("name", "John");
person.put("city", "New York");

boolean containsAge = person.containsKey("age");
System.out.println("Contains age: " + containsAge); // Affiche "Contains age: false"
```
Cela vérifie si la clé "age" existe dans l'objet JSON.



