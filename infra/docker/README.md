# fish-25

![docker](https://img.shields.io/badge/docker&compose-blue?logo=docker)
![Spring Boot](https://img.shields.io/badge/jenkins-orange?logo=jenkins)
![Gradle](https://img.shields.io/badge/ubuntu-20.04-red?logo=ubuntu)

---

## 배포 유의사항

### develop
개발서버 배포환경 입니다.
develop 브랜치로 release 되면 개발서버에 CI/CD가 됩니다.

```gherkin
SERVER : gunimon.iptime.org:18097
CLIENT : gunimon.iptime.org:8080
```

### prod
추가예정