# Projeto Java + Spring Boot com Monitoramento usando Actuator, Prometheus e Grafana

Este projeto em Java utiliza o framework Spring Boot juntamente com o módulo Spring Actuator para fornecer endpoints de monitoramento e métricas. Além disso, integra o Prometheus e o Grafana para coletar, armazenar e visualizar essas métricas, oferecendo insights valiosos sobre o desempenho da sua aplicação.

## Configuração do Projeto

### Dependências Maven

O arquivo `pom.xml` define as dependências do projeto, incluindo o Spring Boot, o H2 Database para desenvolvimento, e as bibliotecas necessárias para a integração com o Spring Actuator, Prometheus e Grafana.

### Configuração do Spring Boot

O arquivo de configuração `application.yml` especifica as configurações do Spring Boot, como a configuração do banco de dados H2 para ambientes de desenvolvimento.

### Endpoints do Spring Actuator

O projeto expõe endpoints do Spring Actuator, como `/actuator/health` e `/actuator/prometheus`, que são configurados para fornecer informações sobre a saúde da aplicação e métricas no formato Prometheus.

### Configuração do Prometheus e Grafana

O arquivo `docker-compose.yml` define serviços Docker para o Prometheus e Grafana. O Prometheus coleta métricas da aplicação, enquanto o Grafana fornece uma interface de usuário para visualização dessas métricas.

Certifique-se de ajustar as configurações conforme necessário, como as informações do banco de dados e os detalhes do serviço Prometheus no arquivo `config/prometheus.yml`.

## Executando o Projeto

Para iniciar o projeto, execute o seguinte comando:

```bash
docker-compose up
