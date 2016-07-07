# Core API RESTful 1.0.0 beta
## Liens utiles
* Les dernière versions stable **[Release](https://gitlab.com/CodeandLearn/core_api/pipelines?scope=tags)** et le dernier changelog **[Changelog](https://gitlab.com/CodeandLearn/core_api/tags)**
* Le calendrier des livrables **[Agenda](https://gitlab.com/CodeandLearn/core_api/milestones)**
* Les derniers builds beta sont ici : [Last Builds](https://gitlab.com/CodeandLearn/core_api/pipelines)
* Quand vous avez un un problème avec l'api c'est par ici : [Issues](https://gitlab.com/CodeandLearn/core_api/issues)
* Pour plus d'informations sur les routes et les capacité de l'api : [Wiki & Doc](https://gitlab.com/CodeandLearn/core_api/wikis/home) ou [depot doc](https://gitlab.com/CodeandLearn/Doc) 

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

Header :
```
    Authorization: Basic QWRtaW46cGFzc3dvcmQ=
    Content-Type: application/json
```

```
    {
        "access_token": "bvsm6nu2uhhgh4hglkj11dd0es",
        "token_type": "bearer",
        "expires_in": 43059,
        "scope": "read",
        "group": 50,
        "path": "/oauth",
        "method": "POST",
        "code": 200,
        "error": "OK",
        "timestamp": 1464088822719
    }
```

### II - Utilisation du token
```
    GET http://127.0.0.1:3000/[path...]
```

Header :
```
    Authorization: Bearer bvsm6nu2uhhgh4hglkj11dd0es
    Content-Type: application/json
```