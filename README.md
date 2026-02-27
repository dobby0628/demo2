# demo2

Spring Boot

login
logout
signup

test study


```mermaid
graph TB
    subgraph Client
        WEB[Web Browser]
        MOBILE[Mobile App]
    end

    subgraph EC2["AWS EC2 (Docker Network)"]
        NGINX[Nginx\nReverse Proxy :80/:443]

        subgraph CI_CD["CI/CD"]
            GITLAB[GitLab]
            JENKINS[Jenkins]
        end

        subgraph Backend["Spring Boot Backend"]
            CHILD[Child Domain API]
            EXAM[Exam Domain API]
        end

        LIVEKIT[LiveKit\nReal-time Communication]
        MQ[RabbitMQ\nMessage Queue]
        MYSQL[(MySQL DB)]
        MINIO[(MinIO\nObject Storage)]

        subgraph AI["AI Services"]
            POSE[Pose Estimation]
            SPEECH[Speech Analysis]
            BEHAVIOR[Behavior Assessment]
        end
    end

    WEB & MOBILE --> NGINX
    NGINX --> CHILD & EXAM
    NGINX --> LIVEKIT
    GITLAB --> JENKINS --> EC2

    CHILD & EXAM --> MYSQL
    CHILD & EXAM --> MINIO
    CHILD & EXAM --> MQ

    MQ --> POSE
    MQ --> SPEECH
    MQ --> BEHAVIOR

    LIVEKIT --> MINIO
    ```
