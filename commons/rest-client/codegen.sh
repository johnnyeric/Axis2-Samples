export AXIS2_HOME=/home/amila/presentations/axis2/traning/binary/axis2-SNAPSHOT
sh $AXIS2_HOME/bin/wsdl2java.sh -uri RestService.wsdl -wv 2 -u -ns2p http//axis2.apache.org/sample/rest=org.apache.axis2.sample.rest.client,http//axis2.apache.org/sample/rest/types=org.apache.axis2.sample.rest.types
