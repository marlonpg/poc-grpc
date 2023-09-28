#1 - Create proto file
#2 - Define the service and the models inside the .proto
#3 - Call protocol buffer compiler to generate Java files
#4 - protoc --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN -I=$SRC_DIR --java_out=$DST_DIR --grpc-java_out=$DST_DIR $SRC_DIR/HelloService.proto


TODO
1 - create unit tests 
    1.1 - create performance test
    1.2 - create gatling tests
2 - create complex object (e.g:List<>)
3 - create a new server and call it using grpc
