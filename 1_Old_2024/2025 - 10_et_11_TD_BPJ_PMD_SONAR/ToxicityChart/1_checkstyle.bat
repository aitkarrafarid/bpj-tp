SET JAVA_HOME=\Programs4Formation\Programs_x64\jdk1_8111_x64\
SET SRC_PATH=../src
%JAVA_HOME%\bin\java -jar checkstyle-all-4.1.jar -f xml -c metrics.xml -r %SRC_PATH% -o toxity_checkstyle_output.xml