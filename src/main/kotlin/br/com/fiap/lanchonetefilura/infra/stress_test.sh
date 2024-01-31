for i in {1..10000}; do
  curl localhost:8080/api/pedido/pedidos
  sleep $1
done