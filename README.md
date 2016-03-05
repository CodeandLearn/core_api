# Core API RESTful
## Importation du projet sous Eclipse
//TODO
## Lancement de l'API
Fonctionne mieux sous linux.
```
	java -jar server.jar
```
Adresse de requ�te voir la doc
```
	http://127.0.0.1:8080/[requ�te...]
```

I - username:password en base64 example test:secret donne dGVzdDpzZWNyZXQ=
POST http://127.0.0.1:8080/oauth/token
Header: Authorization: Basic dGVzdDpzZWNyZXQ=
Payload: grant_type=client_credentials

result : 
{
  "access_token": "18ad7851-b3ea-482e-9e5d-73a8dcfcbd86",
  "token_type": "bearer",
  "expires_in": 43059,
  "scope": "read"
}

II -
GET http://localhost:8080/[path...]
Header : Authorization: Bearer 18ad7851-b3ea-482e-9e5d-73a8dcfcbd86
