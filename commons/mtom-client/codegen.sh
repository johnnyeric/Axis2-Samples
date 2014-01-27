export AXIS2_HOME=/home/amila/presentations/axis2/traning/binary/axis2-SNAPSHOT
sh $AXIS2_HOME/bin/wsdl2java.sh -uri http://localhost:8080/axis2/services/MTOMService?wsdl -u -uw -ns2p http//axis2.apache.org/sample/mtom=org.apache.axis2.sample.mtom.client,http//axis2.apache.org/sample/mtom/types=org.apache.axis2.sample.mtom.types

