#!/bin/bash

# For use on Linux OS or any OS with bash

mvn test
mvn jacoco:report

if [[ "$OSTYPE" == "linux-gnu" ]]; then
  xdg-open target/site/jacoco/index.html
elif [[ "$OSTYPE" == "darwin"* ]]; then
  open target/site/jacoco/index.html
else
  echo "Please open target/site/jacoco/index.html on your browser"
fi
