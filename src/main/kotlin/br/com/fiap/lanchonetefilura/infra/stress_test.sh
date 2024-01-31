for i in {1..500}; do
  curl localhost:8080/api/pedido/pedidos
  sleep 1
done