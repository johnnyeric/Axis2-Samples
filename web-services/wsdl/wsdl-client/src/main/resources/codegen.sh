export AXIS2_HOME=/home/amila/presentations/axis2/traning/binary/axis2-1.6.2
sh $AXIS2_HOME/bin/wsdl2java.sh -uri SampleService.wsdl -u -uw -ns2p http//axis2.apache.org/sample/wsdl=org.apache.axis2.sample.wsdl.client,http//axis2.apache.org/sample/wsdl/types=org.apache.axis2.sample.wsdl.types

