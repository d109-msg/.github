# 포팅 매뉴얼

<br/>

## 환경 변수

```
# 소셜 로그인
oauth2:
  client:
    registration:
      google:
        client-id: ENC({GOOGLE_CLIENT_ID})
        client-secret: ENC({GOOGLE_CLIENT_SECRET})

      naver:
        client-id: ENC({NAVER_CLIENT_ID})
        client-secret: ENC({NAVER_CLIENT_SECRET})

      kakao:
        client-id: ENC({KAKAO_CLIENT_ID})
        client-secret: ENC({KAKAO_CLIENT_SECRET})

# OpenAI
open-ai:
  secret-key: ENC({OPENT_AI_SECRET_KEY})

# AWS S3
cloud:
  aws:
    credentials:
      access-key: ENC({AWS_ACCESS_KEY})
      secret-key: ENC({AWS_SECRET_KEY})

# DB
spring:
  datasource:
    jdbc-url: ENC({JDBC_URL})
    username: ENC({MARIA_DB_USERNAME})
    password: ENC({MARIA_DB_PASSWORD})

  data:
    redis:
      host: ENC({REDIS_HOST})
      port: ENC({REDIS_PORT})
      password: ENC({REDIS_PASSWORD})

    mongodb:
      uri: ENC({MONGO_DB_URI})


```

<br/>

## 주요 기술

### Frontend

- Node.js : v20.10.0
- Vue.js : v3.2.13
- Axios
- IDE : Visual Studio Code

### Backend

- Java : v17.0.9
- Spring Boot : v3.2.1
- WebSocket
- STOMP
- IDE : IntelliJ

### Database

- Redis : v5.0.7
- MongoDB : v7.0.5
- MariaDB : v10.3.39
- AWS S3

### Infrastructure

- Docker : v25.0.1
- Docker Compose : v2.24.3
- Docker Distribution : v2.8.3
- NGINX : v1.25.3
- Jenkins : v2.444

### ETC

- Firebase
- OpenAI

<br/>

## 설치 및 실행

본 프로젝트는 Jenkins 서버, Application 서버, MariaDB 서버, MongoDB 서버로 구성되어 있습니다.  
기본적으로 4G 이상의 RAM 환경에 설치하는 것을 권장합니다.

<br/>

### 1. Redis

1.1. 패키지 업데이트 및 업그레이드

```
sudo apt-get update
sudo apt-get upgrade
sudo apt dist-upgrade
```

1.2. Redis 설치

```
sudo add-apt-repository "deb http://archive.ubuntu.com/ubuntu $(lsb_release -sc) universe"
sudo apt-get install redis-server
```

1.3. Redis 버전 확인

```
redis-server --version
```

1.4. Redis 상태 확인 (기본적으로 Redis는 6379 포트 사용)

```
sudo systemctl status redis.service
```

1.5. Redis 설정 파일

```
sudo nano /etc/redis/redis.conf
```

1.6. 비밀번호 설정 (주석 해제)

```
requirepass {비밀번호}
```

1.7. Redis 접속 및 비밀번호 입력

```
redis-cli
auth {비밀번호}
```

<br/>

### 2. MariaDB

2.1. 패키지 업데이트 및 업그레이드

```
sudo apt-get update
sudo apt-get upgrade
sudo apt dist-upgrade
```

2.2. MariaDB 설치

```
sudo apt install mariadb-server
sudo apt-get install mariadb-client
```

2.3. MariaDB 보안 설정

```
sudo mysql_secure_installation
```

2.4. MariaDB 설치 확인

```
sudo mysql -u root -p
select version();
```

2.5 MariaDB 상태 확인

```
sudo systemctl status mariadb
```

2.6. MariaDB 설정 파일 (허용할 IP 설정)

```
sudo vim /etc/mysql/mariadb.conf.d/50-server.cnf
```

2.7. MariaDB 원격 접속 계정 생성

```
CREATE USER '{사용자명}'@'%' IDENTIFIED BY '{비밀번호}';
GRANT ALL PRIVILEGES ON *.* TO '{사용자명}'@'%';
flush privileges;
```

<br/>

### 3. MongoDB

3.1. 패키지 업데이트 및 업그레이드

```
sudo apt-get update
sudo apt-get upgrade
sudo apt dist-upgrade
```

3.2. MongoDB 설치

```
sudo apt-get install gnupg curl

curl -fsSL https://pgp.mongodb.com/server-7.0.asc | \
   sudo gpg -o /usr/share/keyrings/mongodb-server-7.0.gpg \
   --dearmor

echo "deb [ arch=amd64,arm64 signed-by=/usr/share/keyrings/mongodb-server-7.0.gpg ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/7.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-7.0.list

sudo apt-get update

sudo apt-get install -y mongodb-org
```

3.3. MongoDB 시작

```
sudo systemctl start mongod
```

3.4. MongoDB 상태 확인

```
sudo systemctl status mongod
```

3.5. 재부팅할 때 MongoDB 시작 설정

```
sudo systemctl enable mongod
```

3.6. MongoDB 접속

```
mongosh "mongodb://{주소}:27017"
use admin
```

3.7. 관리자 계정 추가

```
db.createUser(
  {
    user: "사용자명",
    pwd: passwordPrompt(),
    roles: [
      { role: "userAdminAnyDatabase", db: "admin" },
      { role: "readWriteAnyDatabase", db: "admin" }
    ]
  }
)

// 설정하고 싶은 비밀번호
{비밀번호}
```

3.8. MongoDB 종료

```
db.adminCommand( { shutdown: 1 } )
```

3.9. MongoDB 설정

```
sudo nano /etc/mongod.conf

// bindIp: 허용할 IP 혹은 0.0.0.0으로 변경
// security 주석 해제 후 아래에 "  authorization: enabled" 추가
```

3.10. MongoDB 시작

```
sudo service mongod start

// 시작 시 오류 생길 경우
sudo rm -rf /tmp/mongodb-27017.sock
```

3.11. MongoDB 재접속

```
mongosh --port 27017  --authenticationDatabase     "admin" -u "{사용자명}" -p
```

3.12. 서비스용 DB 설정

```
use msg

db.createUser({
    user: '{사용자명}',
    pwd: '{비밀번호}',
    roles: [{role:'dbOwner', db:'msg'}]
})
```

<br/>

### 4. Jenkins

4.1. Jenkins Dockerfile 작성

```
FROM jenkins/jenkins:jdk17

USER root

RUN apt-get update \
 && apt-get -y install lsb-release \
 && curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg \
 && curl -L "https://github.com/docker/compose/releases/download/v2.5.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose \
 && chmod +x /usr/local/bin/docker-compose \
 && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null \
 && apt-get update \
 && apt-get -y install docker-ce docker-ce-cli containerd.io \
 && curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
 && apt-get install -y nodejs
RUN usermod -aG docker jenkins

USER jenkins
```

4.2. Jenkins docker-compose-jenkins.yml 작성

```
version: '3'
services:
        jenkins:
                restart: always
                container_name: jenkins
                build: .
                image: jenkins:latest
                ports:
                        - "8080:8080"
                volumes:
                        - /home/ubuntu/jenkins-data:/var/jenkins_home
                        - /var/run/docker.sock:/var/run/docker.sock
```

4.3. 프론트엔드 파이프라인 작성

```
pipeline {
    agent any

    tools {nodejs "NodeJS 20.10.0"}
    stages {
        stage('GitLab Clone') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                        git credentialsId: 'gitlab-id-pw', branch: 'fe/dev', url: GIT_URL
                    }
                }
            }
        }
        stage('Project Build') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'frontend-env', variable: 'FE_ENV')]) {
                        sh """
                        cd ./frontend &&
                        chmod -R 755 . &&
                        cp ${FE_ENV} . &&
                        npm install &&
                        npm run build
                        """
                    }
                }
            }
        }
        stage('Project Copy') {
            steps {
                withCredentials([string(credentialsId: 'application-ip', variable: 'EC2_SERVER_IP')]) {
                    sshagent(credentials: ['application-pem']) {
                        sh """
                            scp -r ./frontend/dist ubuntu@${EC2_SERVER_IP}:/home/ubuntu/nginx
                        """
                    }
                }
            }
        }
        stage('Project Deploy') {
            steps {
                withCredentials([string(credentialsId: 'application-ip', variable: 'EC2_SERVER_IP')]) {
                    sshagent(credentials: ['application-pem']) {
                        sh """
                            ssh ubuntu@${EC2_SERVER_IP} 'sudo docker exec -i nginx bash -c "nginx -s reload"'
                        """
                        sh 'sudo docker system prune -a -f'
                    }
                }
            }
        }
    }

    post {
        success {
            script {
                withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                    withCredentials([string(credentialsId: 'mattermost-url', variable: 'MM_URL')]) {
                        def Author_ID = sh(script: 'git show -s --pretty=%an', returnStdout: true).trim()
                        def Author_Name = sh(script: 'git show -s --pretty=%ae', returnStdout: true).trim()
                        mattermostSend(color: 'good',
                                       message: "[Frontend] Build Success\nby ${Author_ID} (${Author_Name})\n(<${GIT_URL}|Details>)",
                                       endpoint: "${MM_URL}",
                                       channel: 'mafia_in_sns_game')
                    }
                }
            }
        }
        failure {
            script {
                withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                    withCredentials([string(credentialsId: 'mattermost-url', variable: 'MM_URL')]) {
                        def Author_ID = sh(script: 'git show -s --pretty=%an', returnStdout: true).trim()
                        def Author_Name = sh(script: 'git show -s --pretty=%ae', returnStdout: true).trim()
                        mattermostSend(color: 'danger',
                                       message: "[Frontend] Build Fail\n${Author_ID} (${Author_Name})\n(<${GIT_URL}|Details>)",
                                       endpoint: "${MM_URL}",
                                       channel: 'mafia_in_sns_game')
                    }
                }
            }
        }
    }
}
```

4.4. 백엔드 파이프라인 작성

```
pipeline {
    agent any
    stages {
        stage('GitLab Clone') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                        git credentialsId: 'gitlab-id-pw', branch: 'be/dev', url: GIT_URL
                    }
                }
            }
        }
        stage('Project Build') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'application-yml', variable: 'APP_YML')]) {
                        withCredentials([file(credentialsId: 'application-secret-yml', variable: 'APP_SECRET_YML')]) {
                            withCredentials([file(credentialsId: 'service-account-json', variable: 'SERVICE_JSON')]) {
                                sh '''
                                cd ./backend/src/main/resources &&
                                chmod -R 755 . &&
                                cp ${APP_YML} . &&
                                cp ${APP_SECRET_YML} . &&
                                cp ${SERVICE_JSON} .
                                '''
                                sh '''
                                cd ./backend &&
                                chmod +x gradlew &&
                                ./gradlew clean build --exclude-task test
                                '''
                            }
                        }
                    }
                }
            }
        }
        stage('Docker Build and Push') {
            steps {
                sh 'pwd'
                sh 'ls -al'
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-path', usernameVariable: 'DOCKER_REPO', passwordVariable: 'DOCKER_PROJECT')]) {
                        withCredentials([string(credentialsId: 'docker-registry-url', variable: 'REGISTRY_URL')]) {
                            sh 'cd ./backend && sudo docker build --platform linux/amd64 -t ${REGISTRY_URL}/${DOCKER_PROJECT} .'
                            sh 'cd ./backend && sudo docker image push ${REGISTRY_URL}/${DOCKER_PROJECT}'
                            sh 'sudo docker system prune -a -f'
                            echo 'docker push Success!!'
                        }
                    }
                }
            }
        }
        stage('Project Deploy') {
            steps {
                sh 'pwd'
                script {
                    withCredentials([string(credentialsId: 'application-ip', variable: 'EC2_SERVER_IP')]) {
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-path', usernameVariable: 'DOCKER_REPO', passwordVariable: 'DOCKER_PROJECT')]) {
                            def status = sh(script: 'curl -o /dev/null -w "%{http_code}" "https://${EC2_SERVER_IP}/api/test/env"', returnStdout: true).trim()
                            echo "status: ${status}"
                            def currentUpstream = 'green'
                            if (status == '200') {
                                currentUpstream = sh(script: 'curl -s "https://${EC2_SERVER_IP}/api/test/env"', returnStdout: true).trim()
                            }
                            def currentPort = currentUpstream == 'blue' ? 8080 : 8081
                            def stoppedPort = currentUpstream == 'blue' ? 8081 : 8080
                            def targetUpstream = currentUpstream == 'blue' ? 'green' : 'blue'
                            echo "targetUpstream: ${targetUpstream}"
                            echo "currentUpstream: ${currentUpstream}"
                            sshagent(credentials: ['application-pem']) {
                                withCredentials([usernamePassword(credentialsId: 'docker-hub-id-pw', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                    withCredentials([string(credentialsId: 'docker-registry-url', variable: 'REGISTRY_URL')]) {
                                        sh """
                                            ssh ubuntu@${EC2_SERVER_IP} 'sudo docker pull ${REGISTRY_URL}/${DOCKER_PROJECT}:latest &&
                                            sudo docker-compose -f blue-green/docker-compose-${targetUpstream}.yml up -d'
                                        """
                                    }
                                }
                            }
                            retry(10) {
                                sh(script: 'curl -s https://${EC2_SERVER_IP}:${stoppedPort}/api/test/env', returnStatus: true) == 0
                                sleep time: 10, unit: 'SECONDS'
                            }
                            sshagent(credentials: ['application-pem']) {
                                sh """
                                    ssh ubuntu@${EC2_SERVER_IP} 'sudo docker exec -i nginx bash -c "chmod +x ./etc/nginx/conf.d/deploy.sh"'
                                """
                                sh """
                                    ssh ubuntu@${EC2_SERVER_IP} 'sudo docker exec -i nginx bash -c "./etc/nginx/conf.d/deploy.sh ${targetUpstream}"'
                                """
                                sh """
                                    ssh ubuntu@${EC2_SERVER_IP} 'sudo docker exec -i nginx bash -c "nginx -s reload"'
                                """
                            }
                            sshagent(credentials: ['application-pem']) {
                                sh """
                                    ssh ubuntu@${EC2_SERVER_IP} 'sudo docker-compose -f blue-green/docker-compose-${currentUpstream}.yml down'
                                """
                                sh """
                                    ssh ubuntu@${EC2_SERVER_IP} 'sudo docker system prune -a -f'
                                """
                            }
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            script {
                withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                    withCredentials([string(credentialsId: 'mattermost-url', variable: 'MM_URL')]) {
                        def Author_ID = sh(script: 'git show -s --pretty=%an', returnStdout: true).trim()
                        def Author_Name = sh(script: 'git show -s --pretty=%ae', returnStdout: true).trim()
                        mattermostSend(color: 'good',
                                      message: "[Backend] Build Success\nby ${Author_ID} (${Author_Name})\n(<${GIT_URL}|Details>)",
                                      endpoint: "${MM_URL}",
                                      channel: 'mafia_in_sns_game')
                    }
                }
            }
        }
        failure {
            script {
                withCredentials([string(credentialsId: 'gitlab-repo-url', variable: 'GIT_URL')]) {
                    withCredentials([string(credentialsId: 'mattermost-url', variable: 'MM_URL')]) {
                        def Author_ID = sh(script: 'git show -s --pretty=%an', returnStdout: true).trim()
                        def Author_Name = sh(script: 'git show -s --pretty=%ae', returnStdout: true).trim()
                        mattermostSend(color: 'danger',
                                      message: "[Backend] Build Fail\n${Author_ID} (${Author_Name})\n(<${GIT_URL}|Details>)",
                                      endpoint: "${MM_URL}",
                                      channel: 'mafia_in_sns_game')
                    }
                }
            }
        }
    }
}
```

<br/>

### 5. Docker Distribution

5.1. docker-compose-registry.yml 작성

```
version: "3.3"
volumes:
  registry_data: { }
services:
  registry:
    restart: always
    image: registry
    container_name: registry
    volumes:
      - registry_data:/var/lib/registry/docker/registry/v2 # image 저장
    ports:
      - "5000:5000"
```

5.2. 레지스트리가 HTTP를 사용할 경우 다음 파일 수정 (Jenkins EC2)

```
sudo vim /etc/docker/daemon.json
```

5.3. 아래 항목 추가

```
{
    "insecure-registries" : ["{프라이빗 레지스트리 아이피}:5000"]
}
```

5.4. 서비스 재시작

```
sudo systemctl daemon-reload
sudo systemctl restart docker
```

5.5. 레지스트리로부터 이미지를 내려받는 애플리케이션 EC2에도 4.2~4.4 수행

<br/>

### 6. NGINX

6.1. default.conf 작성 (SSL 발급 이전)

```
server {

  listen 80;
  listen [::]:80;
  #listen 443 ssl;
  #listen [::]:443 ssl;
  server_name {도메인 주소 or 공인 아이피};

  root /usr/share/nginx/html;
  #access_log  /var/log/nginx/host.access.log  main;

  location /.well-known/acme-challenge {
    root /var/lib/letsencrypt/;
  }

  location / {
    try_files $uri $uri/ /index.html;
  }

  #error_page  404              /404.html;

  # redirect server error pages to the static page /50x.html

  error_page   500 502 503 504  /50x.html;
  location = /50x.html {
    root   /usr/share/nginx/html;
  }
}
```

6.2. docker-compose-nginx.yml 작성 (SSL 발급 이전)

```
version: '3.1'

services:
  nginx:
    container_name: nginx
    image: nginx:latest
    restart: always
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - /etc/letsencrypt:/etc/letsencrypt
      - /var/lib/letsencrypt:/var/lib/letsencrypt
      - /home/ubuntu/nginx/conf.d:/etc/nginx/conf.d
      - /home/ubuntu/nginx/sites-enabled:/etc/nginx/sites-enabled
        #- /home/ubuntu/nginx/dist:/usr/share/nginx/html
```

6.3. 도커 컨테이너로 NGINX 실행

```
docker-compose -f docker-compose-nginx.yml up -d
```

6.4. SSL 인증서 발급을 위한 certbot 실행 (docker-compose-nginx.yml의 letsencrypt와 볼륨 위치 동일해야 함)

```
docker run -it --rm --name certbot -v "/etc/letsencrypt:/etc/letsencrypt" \
    -v "/var/lib/letsencrypt:/var/lib/letsencrypt" \
    certbot/certbot certonly --webroot -w /var/lib/letsencrypt \
    -d {도메인 주소} --agree-tos
```

6.5. default.conf 작성 (SSL 발급 이후)

```
upstream blue {
  # server i10d109.p.ssafy.io:8080;
  server 172.26.5.89:8080;
}

upstream green {
  server 172.26.5.89:8081;
}

server {
  client_max_body_size 10M;

  include /etc/nginx/conf.d/service-env.inc;

  listen 80;
  listen [::]:80;
  listen 443 ssl;
  listen [::]:443 ssl;
  server_name i10d109.p.ssafy.io;

  root /usr/share/nginx/html;
  #access_log  /var/log/nginx/host.access.log  main;

  if ($scheme = http) {
    return 301 https://$server_name$request_uri;
  }

  location /.well-known/acme-challenge {
    root /var/lib/letsencrypt/;
  }

  location / {
    try_files $uri $uri/ /index.html;
  }

  location /api {
    proxy_pass http://$service_url;

    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $scheme;
  }

  location /api/ws-stomp {
    proxy_pass http://$service_url;

    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $scheme;
  }

  ssl_certificate /etc/letsencrypt/live/i10d109.p.ssafy.io/fullchain.pem;
  ssl_certificate_key /etc/letsencrypt/live/i10d109.p.ssafy.io/privkey.pem;

  #error_page  404              /404.html;

  # redirect server error pages to the static page /50x.html
  #
  error_page   500 502 503 504  /50x.html;
  location = /50x.html {
    root   /usr/share/nginx/html;
  }

  # proxy the PHP scripts to Apache listening on 127.0.0.1:80
  #
  #location ~ \.php$ {
  #    proxy_pass   http://127.0.0.1;
  #}

  # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
  #
  #location ~ \.php$ {
  #    root           html;
  #    fastcgi_pass   127.0.0.1:9000;
  #    fastcgi_index  index.php;
  #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
  #    include        fastcgi_params;
  #}

  # deny access to .htaccess files, if Apache's document root
  # concurs with nginx's one
  #
  #location ~ /\.ht {
  #    deny  all;
  #}
}
```

6.6. docker-compose-nginx.yml 작성 (SSL 발급 이후)

```
version: '3.1'

services:
  nginx:
    container_name: nginx
    image: nginx:latest
    restart: always
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - /etc/letsencrypt:/etc/letsencrypt
      - /var/lib/letsencrypt:/var/lib/letsencrypt
      - /home/ubuntu/nginx/conf.d:/etc/nginx/conf.d
      - /home/ubuntu/nginx/sites-enabled:/etc/nginx/sites-enabled
      - /home/ubuntu/nginx/dist:/usr/share/nginx/html
```

6.7. deploy.sh 작성 (default.conf에서 $service_url을 blue <-> green으로 바꿔주는 역할)

```
#!/bin/bash
targetUpstream=$1
echo "set \$service_url $targetUpstream;" > /etc/nginx/conf.d/service-env.inc
```

6.8. service-env.inc 작성

```
set $service_url blue;
```

6.9. sites.conf 작성

```
include /etc/nginx/sites-enabled/*;
```

6.10. NGINX 컨테이너 종료

```
docker-compose -f docker-compose-nginx.yml down
```

6.11. 도커 컨테이너로 NGINX 실행

```
docker-compose -f docker-compose-nginx.yml up -d
```

<br/>

### 7. Blue Green Server

7.1. docker-compose-blue.yml 작성

```
version: '3.8'

services:
  blue:
    restart: always
    image: {프라이빗 레지스트리 아이피}:5000/mafia-in-sns-game:latest
    container_name: blue
    ports:
      - "8080:8080"
    environment:
      - PROFILES=blue
      - ENV=blue
      - JASYPT_PASSWORD={비밀번호}
    extra_hosts:
      - host.docker.internal:host-gateway
```

7.2. docker-compose-green.yml 작성

```
version: '3.8'

services:
  green:
    restart: always
    image: {프라이빗 레지스트리 아이피}:5000/mafia-in-sns-game:latest
    container_name: green
    ports:
      - "8081:8081"
    environment:
      - PROFILES=green
      - ENV=green
      - JASYPT_PASSWORD={비밀번호}
    extra_hosts:
      - host.docker.internal:host-gateway
```

7.3. 백엔드 프로젝트 디렉토리에 있는 Dockerfile 작성

```
FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=build/libs/backend-0.0.1-SNAPSHOT.jar
ARG PROFILES
ARG ENV
ARG JASYPT_PASSWORD
COPY ${JAR_FILE} backend.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-Djasypt.encryptor.password=${JASYPT_PASSWORD}", "-jar", "/backend.jar"]
```

7.4. Application 서버 직접 실행 혹은 Jenkins Webhook으로 실행

```
docker-compose -f docker-compose-blue(green).yml up -d
```
