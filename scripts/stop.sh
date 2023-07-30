#!/usr/bin/env bash

#엔진엑스에 연결되어 있지 않지만 실행 중이던 기존 스프링부트 종료

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
#stop.sh가 속해 있는 경로를 찾는다.
source ${ABSDIR}/profile.sh
#자바에서의 import 구문과 같다. profile.sh의 여러 함수를 사용할 수 있게 해준다.

IDLE_PORT=$(find_idle_port)

echo "> $IDLE_PORT 에서 구동 중인 애플리케이션 pid 확인"
IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})

if [ -z ${IDLE_PID} ]
then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 ${IDLE_PID}
  sleep5
fi