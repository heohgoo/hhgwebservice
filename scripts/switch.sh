#!/usr/bin/env bash

#엔진엑스가 바라보는 스프링부트 프로젝트를 최신 버전으로 변경
ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
  IDLE_PORT=$(find_idle_port)

  echo "> 전환할 Port: $IDLE_PORT"
  echo "> Port 전환"
  echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" |
  #하나의 문장을 구성해 파이프라인(|)으로 넘겨주기 위해 echo 사용
sudo tee /etc/nginx/conf.d/service-url.inc

  echo "> 엔진엑스 reload"
  sudo service nginx reload
  #엔진엑스 설정을 다시 불러온다. restart와는 달리 끊김 없이 불러온다. 하지만 중요한 설정들은 반영되지 않는다.
  #외부의 설정 파일인 service-url을 불러오는 거라 reload로도 가능
}