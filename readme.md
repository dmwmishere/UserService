# Build
1. run ./gradlew bootJar to build a fat jar
2. copy artifact into docker folder
3. build image
# Deploy
1. minikube delete
2. minikube start --cpus 4 --memory 4000
3. minikube addons enable ingress
4. kubectl create namespace dev-user-app
5. kubectl config set-context --current --namespace=dev-user-app
6. kubectl apply -f deployment.yaml -f service.yaml -f ingress_student.yaml -f ingress_other.yaml
# Test
Health check: curl http://arch.homework:30334/user/health

Student info: 

Ingress forwarding: curl -X GET -H "accept: */*" "http://arch.homework/otusapp/health"

# Run with helm
helm install userapp ./user-chart/

# Monitoring
Prometheus endpoint: http://localhost:8080/actuator/prometheus

install monitoring stack with helm:
- kubectl config set-context --current --namespace=monitoring
- helm install prom prometheus-community/kube-prometheus-stack -f prometheus.yaml --atomic

forward prometheus: kubectl port-forward service/prom-kube-prometheus-stack-prometheus 9090

forward grafana: kubectl port-forward prom-grafana-66975458db-8z4ht 3000

Run the app:
- kubectl config set-context --current --namespace=dev-user-app
- helm install userapp ./user-chart/

# TIPS

Watch:
- watch -n 3 kubectl get all --show-labels

Switch namespace:
- kubectl config set-context --current --namespace=monitoring
- kubectl config set-context --current --namespace=dev-user-app

Ingress:
- minikube addons enable ingress
- kubectl get ing
- kubectl delete ing user-ingress-other
- kubectl delete ing user-ingress-student

