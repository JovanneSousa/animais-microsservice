# Animal Service API

API para gerenciamento de animais cadastrados, com endpoints para listar, cadastrar e consultar informações detalhadas, incluindo contagem de animais por funcionário em um intervalo de datas.

---

## Base URL

```
http://localhost:8081/animais
```

---

## Endpoints

### 1. Listar todos os animais

**GET** `/animais`

**Descrição:** Retorna todos os animais cadastrados no sistema.

**Resposta Exemplo:**
```json
[
  {
    "id": 1,
    "especie": "CACHORRO",
    "nomeProvisorio": "Cachorrinho",
    "idadeEstimada": 5,
    "raca": "SRD",
    "dataEntrada": "2025-09-01",
    "dataAdocao": null,
    "condicoesChegada": "bem pulguento",
    "nomeRecebedor": "Jovane",
    "porte": "medio"
  }
]
```

---

### 2. Cadastrar um animal

**POST** `/animais`

**Descrição:** Cadastra um novo animal no sistema.

**Body (JSON):**
```json
{
  "especie": "CACHORRO",
  "nomeProvisorio": "Toto",
  "idadeEstimada": 2,
  "raca": "Pincher",
  "dataEntrada": "2025-09-01",
  "condicoesChegada": "50% tremedeira 50% ódio",
  "nomeRecebedor": "Giovanna",
  "porte": "pequeno",
  "dataAdocao": "2025-09-01"
}
```

**Resposta Exemplo:**
```json
{
  "id": 2,
  "especie": "CACHORRO",
  "nomeProvisorio": "Toto",
  "idadeEstimada": 2,
  "raca": "Pincher",
  "dataEntrada": "2025-09-01",
  "dataAdocao": "2025-09-01",
  "condicoesChegada": "50% tremedeira 50% ódio",
  "nomeRecebedor": "Giovanna",
  "porte": "pequeno"
}
```

---

### 3. Listar animais não adotados

**GET** `/animais/not-adopted`

**Descrição:** Retorna todos os animais que ainda não foram adotados.

---

### 4. Listar animais adotados

**GET** `/animais/adopted`

**Descrição:** Retorna todos os animais que já foram adotados.

---

### 5. Filtrar por espécie

**GET** `/animais/cachorro`  
**GET** `/animais/gato`

**Descrição:** Retorna apenas animais da espécie especificada.

---

### 6. Contagem de animais cadastrados por funcionário

**GET** `/animais/count-by-funcionario`

**Descrição:** Retorna a quantidade de animais cadastrados por cada funcionário em um intervalo de datas. O intervalo máximo permitido é de **1 ano**.

**Query Parameters:**

| Parâmetro  | Tipo   | Descrição                         | Exemplo        |
|------------|--------|-----------------------------------|----------------|
| startDate  | string | Data inicial no formato YYYY-MM-DD | 2025-01-01     |
| endDate    | string | Data final no formato YYYY-MM-DD   | 2025-09-01     |

**Exemplo de URL:**
```
http://localhost:8081/animais/count-by-funcionario?startDate=2025-01-01&endDate=2025-09-01
```

**Resposta Exemplo:**
```json
[
  {
    "nomeRecebedor": "Jovane",
    "quantidadeAnimais": 5
  },
  {
    "nomeRecebedor": "Giovanna",
    "quantidadeAnimais": 3
  }
]
```

**Observações:**
- Se o intervalo de datas for maior que um ano, o endpoint retornará erro.
- Todos os nomes dos funcionários são agrupados e contabilizados automaticamente no SQL.

