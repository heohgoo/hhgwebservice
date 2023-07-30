#!/usr/bin/env bash

# stop.sh, start.sh, health.sh, profile.sh에서 공용으로 사용할 'profile'과 포트 체크 로직
# 쉬고 있는 profile 찾기: real1이 사용 중이라면, real2가 쉬고 있고, 반대면 real1이 쉬고 있다.

function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)
    # 현재 엔진엑스가 바라보고 있는 스프링 부트가 정상적으로 수행 중인지 확인, 응답값을 HttpStatus로 받는다.

    if [ $(RESPONSE_CODE) -ge 400 ] #RESPONSE_CODE가 오류 코드를 반환한다면 400~503 사이로 반환하니, 모두 에러로 간주하고 real2를 profile로 사용

    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi

    if [ $(CURRENT_PROFILE) == real1 ]
    then
      IDLE_PROFILE=real2
      #엔진엑스와 연결되지 않은 profile
    else
      IDLE_PROFILE=real1
    fi

    echo "${IDLE_PROFILE}"
    #bash 스크립트는 값을 반환하는 기능이 없으므로, 결과 출력 후 클라이언트에서 그 값을 잡아서 사용하게 한다.
}


#쉬고 있는 profile의 Port 찾기
function find_idle_port() {
  IDLE_PROFILE=$(find_idle_profile)

  if [ $(IDLE_PROFILE) == real1 ]
  then
    echo "8081"
  else
    echo "8082"
  fi
}