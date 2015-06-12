#!/usr/bin/env sh
dex="/opt/mobisec/bin/dex2jar"
java="/usr/bin/java"
file="$1"
dexfile="$2"
outfolder="$3"
${dex} $file
${java} -jar /var/www/app_detect/public/decompiler.jar -jar $dexfile -o $outfolder

