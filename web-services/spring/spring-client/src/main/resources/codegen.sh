export AXIS2_HOME=/home/amila/presentations/axis2/traning/binary/axis2-SNAPSHOT
sh $AXIS2_HOME/bin/wsdl2java.sh -uri http://127.0.0.1:8080/axis2/services/SpringService?wsdl -u -uw -ns2p http//axis2.apache.org/sample/spring=org.apache.axis2.sample.spring.client,http//axis2.apache.org/sample/spring/types=org.apache.axis2.sample.spring.types

