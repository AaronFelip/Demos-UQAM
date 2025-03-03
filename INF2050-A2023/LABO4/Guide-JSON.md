# Guide des Fichiers JSON

## Qu'est-ce qu'un Fichier JSON ?

JSON (JavaScript Object Notation) est un format de données léger et facile à lire. Il est couramment utilisé pour stocker et échanger des données structurées. Un fichier JSON est un texte formaté qui contient des informations sous forme de paires clé-valeur.

## Structure de Base

Un fichier JSON est composé d'objets et/ou de tableaux JSON. Voici à quoi ressemblent les structures de base :

### Objet JSON

Un objet JSON est entouré de `{}` (accolades) et contient des paires clé-valeur. Chaque paire est séparée par une virgule.

Exemple :
```json
{
  "nom": "John",
  "age": 30,
  "ville": "Paris"
}
```


### Tableau JSON
Un tableau JSON est entouré de `[ ]` (crochets) et contient une liste ordonnée de valeurs, qui peuvent être des objets, des tableaux, des nombres, des chaînes de caractères, des booléens ou null. Chaque valeur est séparée par une virgule.

Exemple :

```text
[
  "pomme",
  "banane",
  "orange"
]
```

### Clés et Types de Valeurs
Clés : Les clés sont des chaînes de caractères entourées de guillemets doubles. Elles sont utilisées pour identifier les valeurs dans un objet JSON.

Types de Valeurs : Les valeurs peuvent être de plusieurs types différents :

- Chaînes de caractères (entourées de guillemets doubles) : "nom": "John"
- Nombres (entiers ou décimaux) : "age": 30
- Booléens (true ou false) : "estEtudiant": true
- Objets JSON : "adresse": {"rue": "123 Rue Principale", "ville": "Paris"}
- Tableaux JSON : "fruits": ["pomme", "banane", "orange"]
- null : "moyenne": null

### Ce qui est Permìs
- Un fichier JSON doit commencer par un objet JSON ou un tableau JSON.
- Les clés doivent être des chaînes de caractères entre guillemets doubles.
- Les valeurs doivent être des chaînes de caractères (entre guillemets doubles), des nombres, des booléens, des objets JSON, des tableaux JSON ou null.
- Les objets JSON peuvent contenir d'autres objets ou tableaux JSON.
- Les tableaux JSON peuvent contenir une liste de valeurs de différents types.

### Exemple Complet
Voici un exemple complet de fichier JSON :

```text
{
  "personne": {
    "nom": "Alice",
    "age": 25,
    "estEtudiant": false
  },
  "freresEtSoeurs": ["Bob", "Charlie"],
  "adresse": null
}
```


Ce guide vous aidera à comprendre la structure de base d'un fichier JSON, les clés, les types de 
valeurs autorisés, les objets et les tableaux JSON, ainsi que ce qui est permis lors de la création de 
fichiers JSON. Utilisez ces connaissances pour manipuler et échanger des données JSON dans vos projets 
de programmation.

**N'oubliez jamais de faire valider vos fichiers JSON!**
