# Azure Playground

A Spring Boot application demonstrating **Azure Key Vault with hot refresh** with monitoring stack: **Grafana, Prometheus, Promtail, and Loki**.

## Features

- Azure Key Vault integration with automatic configuration refresh
- Complete monitoring and logging solution
- Docker Compose setup for easy deployment

## Prerequisites

- Java 21
- Azure account with Key Vault access
- Docker & Docker Compose (for containerized deployment)



## Quick Start

### Running with Docker Compose

1. Clone and configure:
   ```bash
   git clone [https://github.com/SashaPog/Azure-Playground.git](https://github.com/SashaPog/azure-keyvault-grafana-stack.git)
   cd Azure-Playground
   ```

   

2. Create `.env` file:
   ```env
   PROFILE=dev
   AZURE_CLIENT_ID=your-client-id
   AZURE_TENANT_ID=your-tenant-id
   AZURE_CLIENT_SECRET=your-client-secret
   KEY_VAULT_NAME=your-keyvault-name
   ```

3. Start services:
   ```bash
   docker-compose up -d
   ```

4. Access:
   - Application: http://localhost:8080
   - Grafana: http://localhost:3000 (admin/admin)
   - Prometheus: http://localhost:9090

### Running Locally (Without Docker)

**Option 1: Azure CLI**
comment this lines
spring.cloud.azure.credential.client-id=${AZURE_CLIENT_ID}
spring.cloud.azure.credential.client-secret=${AZURE_SECRET_ID}
spring.cloud.azure.profile.tenant-id=${AZURE_TENANT_ID}
```bash
az login
export PROFILE=dev
./mvnw spring-boot:run
```

**Option 2: Environment Variables**
```bash
export PROFILE=dev
export AZURE_CLIENT_ID=your-client-id
export AZURE_TENANT_ID=your-tenant-id
export AZURE_CLIENT_SECRET=your-client-secret
export KEY_VAULT_NAME=your-keyvault-name
./mvnw spring-boot:run
```

## Monitoring

After starting with Docker Compose, configure Grafana data sources:
- **Prometheus**: `http://prometheus:9090`
- **Loki**: `http://loki:3100`

## Hot Refresh

Update secrets in Azure Key Vault and the application automatically picks up changes without restart.
