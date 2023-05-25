#!/bin/bash


ENV="$3"
REGION="$2"
ENV_NAME="$4"

URL_NEWRELIC="$1"/newrelic.config
URL_NGINX="$1"/nginx/conf.d/myconf.conf

if [ "$ENV" = "QA" ]; then
   size=50M
   name=NEWRELIC_QA
elif [ "$ENV" = "Staging" ]; then
    size=50M
    name=NEWRELIC_STAGING
elif [ "$ENV" = "Prod" ]; then
    size=50M
    name=NEWRELIC_PROD
elif [ "$ENV" = "Operation" ]; then
    size=2048M
    name=NEWRELIC_OPERATION
else
    echo "Invalid"
fi  

NEWRELIC_KEY=$(aws ssm get-parameters --region "$REGION" --names "$name" --query Parameters[0].Value --with-decryption |sed 's/"//g')
sed -i "s/-Dnewrelic.config.app_name=<name>/-Dnewrelic.config.app_name=$ENV_NAME/g" "$URL_NEWRELIC"
sed -i "s/-Dnewrelic.config.license_key=<key>/-Dnewrelic.config.license_key=$NEWRELIC_KEY/g" "$URL_NEWRELIC"

sed -i "s/client_max_body_size 50M/client_max_body_size $size/g" "$URL_NGINX"
