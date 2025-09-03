#!/bin/bash                              
java  -jar checkstyle-all-4.1.jar -f xml -c metrics.xml -r "$1" -o toxicity.xml
