# UCE Génie Logiciel Avancé : Techniques de tests

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/GabrielDesbouis/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/GabrielDesbouis/ceri-m1-techniques-de-test/tree/master)
![Checkstyle](target/site/badges/checkstyle-result.svg)
[![codecov](https://codecov.io/gh/GabrielDesbouis/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=NATDYO4V1N)](https://codecov.io/gh/GabrielDesbouis/ceri-m1-techniques-de-test)

## Nom et prénom

Gabriel DESBOUIS

## Groupe

Groupe IA ALT

## TP6

Les tests passés en revue sont les tests de la classe `PokemonFactoryTest` de la Team Rocket ont échoués.
De fait, nous pouvons constater une régression en comparant les résultats mon implémentation avec celle de la Team
Rocket.
En effet, les statistiques des pokémons générés par la Team Rocket sont erronées et elle ne permet d'empêcher la
création de pokémons avec un index négatif.
Voici d'autres défauts que nous avons pu constater :

- La méthode generateRandomStat() utilise une boucle qui effectue un million d'itérations pour générer une statistique
  aléatoire. Cela est inefficace et peut entraîner une mauvaise performance. Une meilleure approche consisterait à
  utiliser la classe Random pour générer directement une valeur aléatoire entre une plage spécifiée.

- L'utilisation de UnmodifiableMap sur la map index2name n'est pas nécessaire dans ce contexte. Cette classe est
  généralement utilisée pour rendre une map immuable, ce qui n'est pas le cas ici. Il suffit d'utiliser HashMap pour la
  déclaration de la variable.

- La map index2name est statique et initialisée manuellement avec une poignée de noms de Pokémon. Pour une
  implémentation complète, il est nécessaire de mapper tous les index possibles aux noms correspondants. Sinon, si
  l'index n'est pas trouvé dans la map, le nom "MISSINGNO" est retourné pour tous les Pokémon inconnus, ce qui est
  incorrect.

Nous pouvons également parler de toute la partie de style du code de la Team Rocket :

- Les noms de variables dans certaines parties du code ne suivent pas les conventions de nommage recommandées. Par
  exemple, les noms des variables aMap et rn ne sont pas explicites et ne donnent pas d'indication claire sur leur rôle
  ou leur contenu.

- Le formatage du code n'est pas uniforme. Certaines parties du code utilisent une indentation incorrecte ou
  incohérente, ce qui peut rendre la lecture et la compréhension du code plus difficiles.

- Les commentaires du code sont en français.
