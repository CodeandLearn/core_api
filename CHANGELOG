# V1.0.1 beta
## Core
* Correction pour le multi db
* Rajouts: de l'email, de l'user_id et de l'username quand on effectue une récupération de token (/oauh)
* Ajout de la compression GZIP!!
* Amélioration du logger d'erreur
* Ajout du multi-token avec le maximum de token simultané pour un compte configurable dans le fichier de config
* Ajout du keep-alive

## Plugins
* Mise à jours de toutes les requêtes pour le support multi db (le SELECT * marche très bien ;))
* GET account: l'email des autres utilisateurs est caché selon la reqûete
* GET account: l'email en MD5 est fournis pour les reuquêtes /account & /accounts sous le champs "email_md5"
* PUT account: le champ vide ou inexistant de "password" permet de ne pas changer le mot de passe
* PUT account: le champ "goup_id" n'est plus utile!
* Correction de la route pour le /revoke
* Implementation du Forum
* Implementation des CodeTemplates (ne pas utiliser!)
* Fix check de l'email lors d'une inscription
* Chngement de "group" à "power" dans la réponse de /oauth

# V1.0.0 beta
## Database
* Ajout du script SQL pour MySQL
* Ajout du script SQL pour PostgresSQL
* Mise à jour du fichier config pour les adresses des serveurs SQL
* Ajout d'un champs 'name' dans différentes tables

## Plugins
* Ajout de la communication avec le serveur com
* Optimisation sur la route /register
* Correction de coherence sur exercise/exercice

## Core
* Le temps d'expiration du token se raffréchis quand il est utilisé
* Ajout du support multi DB
* Affiche l'erreur 404 quand il n'y a pas de donnée dans la DB
* Retourne l'id lors d'un insert
* Nettoyage du build généré
* Ajout d'une méthode permettant de récupérer l'id_user en fonction d'un token
* Ajout d'informations sur l'auteur + la version au lancement de l'api

# V0.0.3
## Plugins
* Update & fix Language
* Update & fix Course
* Update & fix Exercises
* Update & fix User_exercises
* Add comments by course_id in Course plugin

## Core
* Fix /register
* Fix for windows phone app
* Add route : /routes

# V0.0.2
## Plugins
* Account et Blog sont totalement fonctionnel

## Core
* Ajout d'une singleton en lien entre user, token et perms
* Attribution des routes par annotations
* Optimisation de la sécurité
* Gestion des perms selon le groupe et la route
* Restriction de l'api au application JSON seulement (Content-Type: application/json)
* Autorisation des méthodes OPTION, GET, POST, PUT & DELETE
* Fichier de config
* Perms chargés depuis un fichier
* Revoke auto d'un token
* Ajouter le temps de vie d'un token dans le fichier de conf
* Ajout d'un logger pour l'api
* Ajout d'un logger pour les actions utilisateur
* Hash password perso
* Ajout SingleTone make return header
* Salt dans le fichier config
* Route pour revoke un token
* Parsing des params GET
* System de banissement
* System de Task (tâches automatiques)
* Corrections pour AngularJS