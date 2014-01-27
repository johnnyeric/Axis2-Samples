export AXIS2_HOME=/home/shameera/Training/Axis2/distribution/binary/axis2-1.6.2
sh $AXIS2_HOME/bin/wsdl2java.sh -uri SampleService.wsdl -ss -sd -uw -ns2p http//axis2.apache.org/sample/wsdl=org.apache.axis2.sample.wsdl.service,http//axis2.apache.org/sample/wsdl/types=org.apache.axis2.sample.wsdl.types

