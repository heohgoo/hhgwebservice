# hhgwebservice
이동욱님의 `스프링 부트와 AWS로 혼자 구현하는 웹 서비스` 저서를 기반으로 백엔드 개발을 공부하기 위한 프로젝트입니다.

![image](https://github.com/heohgoo/hhgwebservice/assets/95553132/eb8a89e5-373a-4380-9512-cf999ae66177)



`Spring/SpringBoot v2.6.6(Build:Gradle)`
`Mustache(Template Engine)` 
`AWS RDS(MariaDB)/EC2/S3/CodeDeploy` 
`Travis CI`
`Nginx`




😀서버 : AWS EC2(Amazon Linux 2023)

😁CI/CD : Travis CI, AWS CodeDeploy

😃무중단 배포 서버 : Nginx(리버스 프록시) 

=> 실제 요청에 대한 처리가 뒷단의 웹 애플리케이션 서버가 처리하게 한다.

<br>
<br>



AWS CodeDeploy만으로도 배포가 가능하지만 빌드와 배포를 분리하여 Jar파일을 재사용할 수 있게 하여 `유지보수성`과 `확장성`을 늘리고자 S3에 Jar파일을 전달하거나 전달받을 수 있도록 하였다.








