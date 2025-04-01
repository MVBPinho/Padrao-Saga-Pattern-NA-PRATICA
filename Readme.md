# Comandos MySQL para este curso

## 🐳 Acesse o Docker e crie as 3 tabelas do Curso

```bash
docker ps
docker exec -it docker-db-1 mysql -u root -p
senha: example
```

```sql
CREATE DATABASE saga_sale;
CREATE DATABASE saga_inventory;
CREATE DATABASE saga_payment;
SHOW DATABASES;
EXIT;
```

✅ **Executar os 3 projetos** para criar as tabelas de forma automática com o JPA.

✅ **Realizar os 2 INSERTS abaixo:**

```sql
INSERT INTO saga_inventory.inventories VALUES(null, 1, 10);
INSERT INTO saga_payment.users VALUES (null, 50.00, 'Danilo');
```

---

## 🛠️ Realize a configuração do MySQL no DBeaver

- **Server Host:** `localhost`
- **Port:** `3306`
- **Database:** `saga_sale`
- **Username:** `root`
- **Password:** `example`
- **Test Connection** ✅
- **Finish** 🎉

---

## ⚡ Offset Explorer

1. **Add new Connection...**
2. **Cluster Name:** `Saga`
3. **Bootstrap servers:** `localhost:9092`
4. **Kafka Cluster Version:** `0.11`
5. **Zookeeper Check**
   - **Host:** `localhost`

### 📝 Criar um novo tópico

1. **Topics: Add Topic**
2. **Name:** `tp-saga-sale`
3. **Partition Count:** `1`
4. **Replica Count:** `1`

---

## 🎭 SAGA - Coreografia

### ✅ Vantagens:
✔️ É a maneira mais simples de implementar o padrão SAGA.  
✔️ Não possui um ponto único de falha.  
✔️ Não precisa de uma lógica de coordenação.  

### ❌ Desvantagens:
⚠️ Risco de dependência cíclica entre os participantes da SAGA.  
⚠️ Quanto mais microsserviços envolvidos, mais difícil entender o fluxo da SAGA.  

---

## 🎭 SAGA - Orquestração

### ✅ Vantagens:
✔️ Evita dependências cíclicas entre serviços.  
✔️ Reduz a complexidade dos participantes.  
✔️ Bom para fluxos de trabalho complexos envolvendo muitos participantes.  

### ❌ Desvantagens:
⚠️ Risco de concentrar muita lógica no orquestrador.  
⚠️ Aumento de gastos com infraestrutura.  

---

# 🚀 Collection para cadastrar uma venda

```bash
curl --location 'http://localhost:8081/api/v1/sales' \
--header 'Content-Type: application/json' \
--data '{
    "productId" : 1,
    "userId" : 1,
    "value" : 30.00,
    "quantity" : 1
}'
```
