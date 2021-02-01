#Build
1. run ./gradlew bootJar to build a fat jar
2. copy artifact into docker folder
3. build image
#Deploy
1. minikube delete
2. minikube start --cpus 4 --memory 4000
3. minikube addons enable ingress
4. kubectl create namespace dev-user-app
5. kubectl config set-context --current --namespace=dev-user-app
6. kubectl apply -f deployment.yaml -f service.yaml -f ingress_student.yaml -f ingress_other.yaml
#Test
Health check: curl http://arch.homework:30334/user/health

Student info: 

Ingress forwarding: curl -X GET -H "accept: */*" "http://arch.homework/otusapp/health"