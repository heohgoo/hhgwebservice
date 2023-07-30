#!/usr/bin/env bash

#엔진엑스에 연결되어 있지 않지만 실행 중이던 기존 스프링부트 종료

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
#stop.sh가 속해 있는 경로를 찾는다.
source ${ABSDIR}/profile.sh
#자바에서의 import 구문과 같다. profile.sh의 여러 함수를 사용할 수 있게 해준다.

REPOSITORY=/home/ec2-user/app/step3
PROJECT_NAME=hhgwebservice

echo "> Build 파일 복사"
echo "> cp $REPOSITORY/zip/*.jar $REPOSITORY/"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> JAR_NAME 에 실행 권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PROFILE=$(find_idle_profile)

echo "> $JAR_NAME 를 profile=$IDLE_PROFILE 로 실행합니다."

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,classpath:/application-$IDLE_PROFILE.properties,/
  home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=$IDLE_PROFILE \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &