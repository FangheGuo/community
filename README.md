
##部署
###依赖
- GIT
- JDK
- MAVEN
- MYSQL
##步骤
- yum update
- yum install git
- mkdir App
- cd App/
- git clone https://github.com/FangheGuo/community.git
- cd community
- yum install maven
- mvn -v
- mvn clean compile package

## 资料
[spring文档](https://spring.io/guides)

[bootstrap文档](https://v3.bootcss.com/getting-started/)

[spring web文档](https://spring.io/guides/gs/serving-web-content/)

[github OAUTH](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[thymyleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#iteration-basics)

[Markdown 插件](http://editor.md.ipandao.com/)

##工具
[visual](http://www.visual-paradigm.com/)

[maven仓库](https://mvnrepository.com/)

[git画图](http://www.git-scm.com/download/)

[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

[lombok](https://projectlombok.org/)

##脚本
```sql

create table USER
(
    ID           INTEGER default NEXT VALUE auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
```

```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
mvn  flyway:migrate
```