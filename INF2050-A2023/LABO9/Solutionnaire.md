### Solutionnaire et guide d'utilisation rapide pour GIT

1 - Clonez un ancien TP de programmation

2 - Créez une branche et ajoutez quelques commentaires dans le code. Faites un
`commit` et un `push` de votre branche.
```sh
git checkout -b nom_de_votre_branche
# modifier une partie de code
git add le_fichier_modifié
git commit -m "Un commentaire pertinent"
git push -u origin nom_de_votre_branche
```

3 - Revenez sur la branche principale. Observez l'absence de vos derniers
commentaires.
```sh
git checkout master
git diff
git status
```


4 - Faites un `merge` de votre branche dans la branche principale.
```sh
git checkout master
git merge nom_de_votre_branche
git push
```

5 - Placez-vous en équipe de 2 personnes. Vous devez tous les deux utiliser le
même dépôt. Chaque personne doit se faire sa propre branche. Faites des
modifications dans votre branche et poussez vos branches sur le dépôt
central. Fusionnez régulièrement vos modifications à l'aide de `merge`. Après
plusieurs modifications, fusionnez toutes vos modifications dans la branche
principale.
```sh
git checkout -b nom_de_votre_branche
# modifier une partie de code
git add le_fichier_modifié
git commit -m "Un commentaire pertinent"
git push -u origin nom_de_votre_branche
git checkout master
git merge nom_de_votre_branche
```

6 - Refaites un exercice similaire au précédent, mais au lieu d'utiliser des
`merge`, fusionnez quelques `commits` seulement à l'aide de `cherry-pick`.
```sh
git checkout -b nom_de_votre_branche
# modifier une partie de code
git log --all --pretty=online 
# Prendre le # du commit
git checkout master 
git cherry-pick NUMERO_DU_COMMIT # Remplacez NUMERO_DU_COMMIT par le id du commit choisi
git push
```

7 - Créez une branche avec des modifications. Poussez cette branche sur github.
Créez un Pull Request et demandez à votre coéquipier de faire une révision du
code. Expérimentez la révision, faites des commentaires, ajustez le code avec
des `commits` supplémentaires. Ensuite, refaites le même exercice mais en
interchangeant vos rôles.

* Voir la démonstration

#### Extra
Pour supprimer une branche :
```sh
git checkout -b nom_de_votre_branche-1
# Modifier une partie du code
git push -u origin premiereBranche
git checkout -b nom_de_votre_branche-2
# Modifier une partie du code
git push -u origin nom_de_votre_branche-2
git checkout master
git push origin --delete nom_de_votre_branche-1
git push origin :nom_de_votre_branche-1 #Équivalent à la commande précedante
git branch -d nom_de_votre_branche-1 # option -D si la branche n'a pas été fusionnée
git branch -d nom_de_votre_branche-2
```

Pour supprimer un fichier spécifique d'un dépôt distant avec Git, vous pouvez suivre ces étapes :
```sh
git rm nom_du_fichier
git commit -m "Supprimer le fichier nom_du_fichier"
git push
```

Revenir à la version précédente suite à un commit erroné :
Pour revenir à la version précédente suite à un commit erroné, vous pouvez utiliser la commande git revert pour 
annuler les modifications apportées par le commit fautif. Voici les étapes :

1 - Identifiez le commit à annuler :
Utilisez git log pour voir l'historique des commits et trouvez le numéro de commit que vous souhaitez annuler.
```sh
git log
```

2 - Revert du commit :
Utilisez la commande git revert suivie du numéro de commit que vous souhaitez annuler.

```sh
git revert NUMERO_DU_COMMIT
git push
```

### Guide des commandes utilisé dans ce labo

- `git checkout -b nom_de_votre_branche`: Cette commande crée une nouvelle branche (-b) et se positionne dessus.
- `git add le_fichier_modifié`: Ajoute les modifications du fichier à l'index pour le prochain commit.
- `git add .` :Ajoute tous les modifications de tous les fichiers à l'index pour le prochain commit.
- `git commit -m "Un commentaire pertinent"`: Enregistre les modifications dans un commit avec un message descriptif.
- `git push -u origin nom_de_votre_branche`: Pousse les changements de la branche locale vers la branche distante correspondante.
- `git checkout master`: Change de branche pour revenir à la branche principale.
- `git diff`: Montre les différences entre le dernier commit sur la branche actuelle et les modifications non ajoutées.
- `git status`: Affiche l'état actuel du répertoire de travail.
- `git checkout master`: Assure que nous sommes sur la branche principale.
- `git merge nom_de_votre_branche`: Fusionne les modifications de la branche spécifiée dans la branche actuelle.
- `git push`: Pousse les changements fusionnés vers le dépôt distant.
- `git log --all --pretty=online`: Affiche l'historique de tous les commits avec leur numéro.
- `git cherry-pick <COMMIT>`: Applique les modifications du commit spécifié sur la branche actuelle.

### Quelques commandes supplémentaire
- `git branch`: Affiche la liste des branches locales et met en évidence celle sur laquelle vous êtes actuellement.
- `git branch -d nom_de_la_branche`: Supprime la branche spécifiée après fusion si elle a été fusionnée.
- `git branch -D nom_de_la_branche`: Supprime la branche spécifiée même si elle n'a pas été fusionnée.
- `git pull origin nom_de_la_branche`: Récupère les dernières modifications du dépôt distant dans votre branche locale.
- `git fetch`: Récupère toutes les branches du dépôt distant, mais ne fusionne pas automatiquement.
- `git log`: Affiche l'historique des commits, avec les messages, les auteurs, et les dates.
- `git reset nom_du_fichier`: Désindexe le fichier spécifié, annulant ainsi l'ajout pour le prochain commit.
- `git reset --soft HEAD~1`: Annule le dernier commit tout en conservant les modifications dans l'index.
- `git reset --hard HEAD~1`: Annule le dernier commit et supprime toutes les modifications locales.
- `git stash`: Met de côté les modifications locales non ajoutées pour les réappliquer plus tard.
- `git stash apply`: Réapplique les modifications locales mises de côté avec git stash.

Guide écrit par Aaron Osorio.