# DigitalLibrary-backend
This is a project on storing any type of asset information digitally 

A user can store any type of asset he/she wish to add. Such as books, electronic gadgets.

This app helps to get details of assets we own and their location.

We have six api

1. To add an asset
2. TO read asset by Id
3. To list asset based on criteria
4. TO delete an asset
5. To modify an asset
6. To get all Assets

Sample payload
{
	"id": 1, //auto generated
	"category": "Book",
	"subCategory": "Thriller",
	"quantity": 1,
	"name": "Death on river nile",
	"location": "Rack12",
	"details": {
		"inUse": true
	},
	"configDetails": {
		"config": {
			"Author": "Agatha Criste",
			"ReleasedYear": "2000"
			//we can add as many key, values
		}
	}
}

API details are available as openAPI2.0 spec. to access
http://localhost:<port>/swagger-ui.html


**-- Build & Deployment ---**
To build the image use mvn package

you can run this application in 3 ways
1. Using jar
2. By building docker image
3. Using Kubernetes deployment

Once jar is build you can use Dockerfile present in root folder to build an image
cmd : docker build -t <name>/<imagename:version>
it build image with your dockerId 

Once image is build you can run by providing
docker run -p 8081:8080 -d name/imagename:version

To deploy as kubernetes application
Use KubernetesFiles folder, in deployment yaml add you image location (docker hub) and provide below command

kubectl apply -f deployment.yaml
kubectl apply -f libraray_service.yaml (this is to expose application through service)

once both are deployed you can check by giving kubectl get pods
if pods are in running state, then 
try localhost:80/v1/asset (get request) 
