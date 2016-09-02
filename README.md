# Core API RESTful 1.0.1 beta
## Updater
Pour faciliter la récupération des dernières mise à jours vous pouvez utiliser un **[Gitlab-Builds-updater](https://gitlab.com/tfSheol/Gitlab-Builds-updater)**

## Liens utiles
* Les dernière versions stable **[Release](https://gitlab.com/CodeandLearn/core_api/pipelines?scope=tags)** et le dernier changelog **[Changelog](https://gitlab.com/CodeandLearn/core_api/tags)**
* Le calendrier des livrables **[Agenda](https://gitlab.com/CodeandLearn/core_api/milestones)**
* Les derniers builds beta sont ici : [Last Builds](https://gitlab.com/CodeandLearn/core_api/pipelines)
* Quand vous avez un un problème avec l'api c'est par ici : [Issues](https://gitlab.com/CodeandLearn/core_api/issues)
* Pour plus d'informations sur les routes et les capacité de l'api : [Wiki & Doc](https://gitlab.com/CodeandLearn/core_api/wikis/home) ou [depot doc](https://gitlab.com/CodeandLearn/Doc) 

## Contrib pro-tip
Pour éviter de commit des fichiers ou dossiers non voulus voici l'astuce:
```
git rm --cached .idea/ -r
```

## Lancement de l'API
Il existe deux scripts `launcher.bat` pour Windows et `launcher.sh` pour Linux/Mac
```
	java -jar cl_api.jar
```

### I - Récupération du token
`username:password` ex : `Admin:password` encodé en base64 donne `QWRtaW46cGFzc3dvcmQ=`
```
	POST http://127.0.0.1:3000/oauth
```

#### Header
```
    Authorization: Basic QWRtaW46cGFzc3dvcmQ=
    Content-Type: application/json
```

En cas de connexion réussie:
```
    {
      "code": 200,
      "method": "POST",
      "token_type": "bearer",
      "error": "OK",
      "access_token": "vv0627hpeii5ftjsk0a8fab616",
      "path": "/oauth",
      "user_id": 12,
      "scope": "read/write",
      "expires_in": 1472811066249,
      "email": "admin@gmail.com",
      "group": 50,
      "username": "Admin",
      "timestamp": 1472803866249
    }
```

En cas d'erreur de nom d'utilisateur ou de mot de passe:
```
    {
      "path": "/oauth",
      "code": 401,
      "error_msg": "username or password is incorrect!",
      "method": "POST",
      "error": "Unauthorized",
      "timestamp": 1472803995627
    }
```

### II - Utilisation du token
```
    GET http://127.0.0.1:3000/[path...]
```

#### Header
```
    Authorization: Bearer bvsm6nu2uhhgh4hglkj11dd0es
    Content-Type: application/json
```