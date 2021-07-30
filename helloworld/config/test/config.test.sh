echo "Validating app and observability conatiners."
nc -z localhost 8080
nc -z localhost 9090
nc -z localhost 3000 

echo "Validating kafka and zookeeper (for First Cluster 1XXXX)." 
nc -z localhost 22181
nc -z localhost 29092