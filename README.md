Windows:

Run commands before:

Windows:
````shell
bin/windows/zookeeper-server-start.bat config/zookeeper.properties
bin/windows/kafka-server-start.bat /config/server.properties
````

Unix:
````shell
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh /config/server.properties
````

Sample JSON can be sent to http://localhost:8080/consume:

````json
{
    "message" : "Hello World!",
    "topic" : "topic_1"
}
````