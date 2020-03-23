# KafkaTwitter

## Summary

This application will read strings of tweets in realtime and put them into Kafka.

This app is a Proof of Concept and it will enable me to test a real time data feed into my Kafka Cluster.

## How to run?

Download and run Apache Kafka ([Download](https://kafka.apache.org/downloads))

Setup Twitter API credentials ([Sign Up](https://developer.twitter.com/en/apply-for-access))

Setup an ElasticSearch Cloud Instance with Bonsai ([Sign Up](https://app.bonsai.io/signup))

Add a config file named `twitter.properties` inside `src/main/resources` directory.

twitter.properties:
```
# to demo Twitter Kafka Connect Source (do not edit)
name=TwitterSourceDemo
tasks.max=1
connector.class=com.github.jcustenborder.kafka.connect.twitter.TwitterSourceConnector
process.deletes=false
filter.keywords=bitcoin
kafka.status.topic=twitter_status_connect
kafka.delete.topic=twitter_deletes_connect

# twitter api configs (fill in)
twitter.oauth.consumerKey=<API_key>
twitter.oauth.consumerSecret=<API_secret_key>
twitter.oauth.accessToken=<Access_token>
twitter.oauth.accessTokenSecret=<Access_token_secret>

# elastic search configs (fill in)
elasticsearch.hostname=<Hostname>.bonsaisearch.net
elasticsearch.username=<Access_key>
elasticsearch.password=<Access_secret>
```

Run the main function of the modules you would like to use

