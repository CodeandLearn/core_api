# Core API RESTful
## Lancement de l'API
Il existe deux scripts `launcher.bat` pour Windows et `launcher.sh` pour Linux/Mac
```
	java -jar CL_SpringMVC_APIRestFul_Core-0.0.1.jar
```

### I - Récupération du token
`username:password` ex : `test:secret` encodé en base64 donne `dGVzdDpzZWNyZXQ=`
```
	POST http://127.0.0.1:8080/oauth/token?grant_type=client_credentials
    Header: Authorization: Basic dGVzdDpzZWNyZXQ=
```
```
    {
        "access_token": "18ad7851-b3ea-482e-9e5d-73a8dcfcbd86",
        "token_type": "bearer",
        "expires_in": 43059,
        "scope": "read"
    }
```

### II - Utilisation du token
```
    GET http://127.0.0.1:8080/[path...]
    Header : Authorization: Bearer 18ad7851-b3ea-482e-9e5d-73a8dcfcbd86
```