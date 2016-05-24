# Core API RESTful
## Lancement de l'API
Il existe deux scripts `launcher.bat` pour Windows et `launcher.sh` pour Linux/Mac
```
	java -jar CL_API_V2-0.0.2-jar-with-dependencies.jar
```

### I - Récupération du token
`username:password` ex : `test:secret` encodé en base64 donne `dGVzdDpzZWNyZXQ=`
```
	POST http://127.0.0.1:8080/oauth
    Header: Authorization: Basic dGVzdDpzZWNyZXQ=
    Content-Type: application/json
```
```
    {
        "access_token": "bvsm6nu2uhhgh4hglkj11dd0es",
        "token_type": "bearer",
        "expires_in": 43059,
        "scope": "read",
        "group": 10,
        "path": "/oauth",
        "method": "POST",
        "code": 200,
        "error": "OK",
        "timestamp": 1464088822719
    }
```

### II - Utilisation du token
```
    GET http://127.0.0.1:8080/[path...]
    Header : Authorization: Bearer bvsm6nu2uhhgh4hglkj11dd0es
    Content-Type: application/json
```