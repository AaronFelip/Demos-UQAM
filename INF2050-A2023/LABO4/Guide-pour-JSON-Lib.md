# Outils pour Manipuler des Fichiers JSON avec JSON-Lib

Lorsque vous travaillez avec des fichiers JSON en utilisant JSON-Lib, il est important de comprendre quelques outils clés qui vous seront très utiles. Les fichiers JSON sont souvent utilisés pour stocker et échanger des données structurées, et JSON-Lib offre des classes et des méthodes pour simplifier la manipulation de ces données.

## Objets JSON

JSON-Lib propose deux types d'objets JSON principaux qui vous permettront de créer, lire et manipuler des données JSON :

- **JSONArray :** C'est une classe qui vous permet de gérer des tableaux JSON. Vous pouvez y stocker une liste d'objets JSON ou de valeurs simples.

- **JSONObject :** Cette classe est utilisée pour représenter un objet JSON. Un objet JSON est similaire à un dictionnaire ou une table de hachage, où vous pouvez stocker des paires clé-valeur.

## Méthodes Utiles pour la Création d'un JSON

Lorsque vous créez un fichier JSON, vous pouvez utiliser les méthodes suivantes 
pour construire et ajouter des données à votre JSON :

- `JSONArray.add(JSONObject objectJson)` : Cette méthode vous permet d'ajouter un objet 
JSON à un tableau JSON. Vous pouvez ainsi accumuler plusieurs objets dans un seul tableau.

- `JSONObject.put(String clef, String valeur)` : Avec cette méthode, vous pouvez ajouter
une paire clé-valeur à un objet JSON. Vous spécifiez une clé (nom) et une valeur associée. C'est ainsi que vous définissez les propriétés de votre objet JSON.

## Méthodes Utiles pour la Lecture d'un JSON

Lorsque vous lisez un fichier JSON existant, vous aurez besoin des méthodes suivantes pour 
extraire les données dont vous avez besoin :

- `String jsonText = DiskFile.loadFileIntoString(String filename)` : Utilisez cette méthode 
pour charger le contenu d'un fichier JSON en tant que chaîne de caractères JSON. Vous pourrez ensuite 
travailler avec les données dans cette chaîne.*

- `JSONObject object = (JSONObject) JSONSerializer.toJSON(String jsonText)` : Une fois que vous 
avez chargé le contenu JSON en tant que chaîne de caractères, vous pouvez utiliser cette méthode 
pour le convertir en un objet JSON. Cela vous permettra d'accéder aux données contenues dans le fichier JSON.

- `JSONArray.get(int index)` : Si vous avez un tableau JSON, vous pouvez utiliser cette méthode
pour accéder à un élément spécifique du tableau en fonction de son index.

- `JSONOBject.getString(String clef)` : Pour accéder aux valeurs associées à une clé spécifique
dans un objet JSON, utilisez cette méthode. Vous spécifiez la clé et obtenez la valeur correspondante.

- `JSONArray array = (JSONArray) JSONObject.getJSONArray(String clef)` : Cette méthode est utile
lorsque le noeud JSON commence par "[". Elle vous permet d'obtenir un tableau JSON à partir d'un objet JSON en spécifiant la clé appropriée. De même, si le noeud JSON commence par "{", utilisez `getJSONObject(String clef)` pour obtenir un objet JSON.

**Note :** Lors de la lecture d'un fichier JSON, la méthode que vous utilisez pour accéder aux
données dépend de la structure du JSON. Si le noeud JSON commence 
par "[", vous utiliserez `getJSONArray(String clef)`, et si ça commence 
par "{", vous utiliserez `getJSONObject(String clef)`.

Ces outils et méthodes vous permettront de travailler efficacement avec des fichiers
JSON en utilisant JSON-Lib. En comprenant comment créer et lire des données JSON, 
vous serez en mesure de manipuler facilement ces données pour répondre à vos besoins de programmation.

*DiskFile vous ai fourni par votre enseignant ici: [DiskFile](https://github.com/jacquesberger/JSONParsingExample/blob/master/src/main/java/org/jberger/jsonparsingexample/json/DiskFile.java)

