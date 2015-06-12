#!/usr/bin/env sh
aapt="/opt/mobisec/Android/sdk/build-tools/22.0.1/aapt"
apk="$1"
#echo $apk
${aapt} dump badging $apk | grep uses-permission

