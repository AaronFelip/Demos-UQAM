## Configurer GIT sur votre machine
``` 
$ git config --global user.name "username"
$ git config --global user.email "email@domaine.ext"
$ git config --global core.editor "vim|nano"
$ git config --global color.ui auto
$ git config --global push.default simple
``` 

### Pour voir votre configuration
```
$ git config --list
```

## Solutions

1. Créez un dépôt distant vide sur GitLab.  
- Aller sur le Gitlab de l'UQAM et créer son dépôt


2. Créez un dépôt local vide. Y ajouter un fichier `readme.txt` avec votre nom à
   l'intérieur. Faites un `commit` de ce fichier et un `push` sur votre dépôt
   distant.

- À l'aide du terminal, faites les commandes suivantes,
une à la suite de l'autre.

``` 
- mkdir nomDeVotreDossier
- cd nomDeVotreDossier
- git init --initial-branch=main
- git remote add origin https://gitlab.info.uqam.ca/aaron/inf2050-labo2.git // changer l'URL par la vôtre
- vim readme.txt \\Écrire son nom dans le fichier, puis sauvegarder (esc puis :wq)
- git add readme.txt
- git commit -m "Ajout d'un fichier Readme"
- git push -u origin main
``` 

3. Modifiez le fichier `readme.txt` pour y ajouter le signe du cours. Poussez
   (`push`) vos changements sur le dépôt distant.

``` 
- vim readme.txt \\Écrire le sigle du cours, puis sauvegarder (esc puis :wq)
- git add readme.txt
- git commit -m "Mise à jour du fichier Readme"
- git push
``` 

4. Supprimez complètement le répertoire contenant votre projet de votre
   ordinateur. Clônez le dépôt distant sur votre poste.

``` 
- cd ..
- rm -rf nomDeVotreDossier
- git clone https://gitlab.info.uqam.ca/aaron/inf2050-labo2.git // changer l'URL par la vôtre
``` 

5. Ajoutez un programme Java dans votre dépôt. Votre programme doit être un
   FizzBuzz ([détails de FizzBuzz](https://en.wikipedia.org/wiki/Fizz_buzz)].
   Faites votre FizzBuzz pour aller de 1 à 100. Poussez votre programme sur le
   dépôt distant. Assurez-vous de ne pas pousser le fichier `.class` sur le
   dépôt distant.

``` 
- cd nomDeVotreDossier
- git add FizzBuzz.java
- git commit -m "Ajout du programme FizzBuzz."
- git push
``` 

6. Ajoutez un fichier `.gitignore` pour ignorer les fichiers `.class`.

``` 
- vim .gitignore (écrire *.class et sauvegarder)
- git add . // remarque: on utilise le . ici, ceci permet de add tous les fichiers qui ont été modifié
- git commit -m "Ajout du fichier .gitignore"
- git push
``` 

7. Modifiez votre programme pour faire le FizzBuzz de 1 à 200. Poussez vos
   modifications.

```
- git add .
- git commit -m "Modification mineure dans le fichier FizzBuzz"
- git push
``` 

8. Partagez votre dépôt avec un collègue de classe. Votre collègue doit clôner
   le dépôt, y ajouter un commentaire (au début du fichier) et pousser ses
   changements.

9. Faites une modification sur votre dépôt ensuite en ajoutant aussi un
   commentaire (mais à la fin du fichier). Poussez vos changements. Le `push`
   devrait échouer parce que vos sources ne sont pas à jour avec le dépôt
   distant. Mettez vos sources à jour avec un `pull` et poussez vos changements
   à nouveau.

10. Provoquez un conflit en modifiant tous les deux la même portion de code.
    Réglez le conflit.

11. Faites un changement dans le code (introduisez un bogue par exemple). Faites
    le `commit` du bogue. Annulez la modification (`revert`) et replacez votre
    dépôt local comme il l'était avant l'introduction du bogue.

```
- git commit -a -m "introduction d'un bogue"
- git revert HEAD
```


