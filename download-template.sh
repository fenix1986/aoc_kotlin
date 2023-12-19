#!/bin/sh
if [ -z "$1" ]
then
	y=`date +"%Y"`
	d=`date +"%d"`
	d=`expr $d + 0`
else
	if [ -z "$2" ]
	then
		echo usage: $0 year day
		exit 1
	fi
	
	y=$1
	d=$2
fi

curl --cookie "session=value_from_cookie" https://adventofcode.com/$y/day/$d/input > src/y$y/day$d.txt
