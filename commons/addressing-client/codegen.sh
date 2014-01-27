export AXIS2_HOME=/home/amila/presentations/axis2/traning/binary/axis2-SNAPSHOT
sh $AXIS2_HOME/bin/wsdl2java.sh -uri http://localhost:8080/axis2/services/AddressingService?wsdl -u -uw -ns2p http//axis2.apache.org/sample/addressing=org.apache.axis2.sample.addressing.client,http//axis2.apache.org/sample/addressing/types=org.apache.axis2.sample.addressing.types

