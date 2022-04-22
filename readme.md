### Backend
Spring Reactive Web
Spring Data Reactive MongoDB
Spring Data Elasticsearch 

### Frontend
Vue3

### Docker
```
version: '3.1'

services:
  mongo:
    image: mongo
    restart: always
    ports:
        - 27017:27017
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: root

  elasticsearch:
    image: elasticsearch:8.1.3
    ports:
      - 9200:9200
      - 9300:9300
    environment:
      discovery.type: single-node

--> docker-compose -f docker-compose.yml up -d 
```
