@REM =============================================================================================
    @ECHO OFF
    SETLOCAL

@REM =============================================================================================
@REM Param�tres de la machine virtuelle utilis�e (VM : Virtual Machine)
@REM mettre ici le chemin de java.exe � utiliser
@REM pour connaitre la version, se positionner dans le dossier du java.exe
@REM et taper: java -version
	SET VM=D:\dq9a1g\Private\Personnel\formations\eclipse3_71_sonar\jdk1_6022\bin\java.exe
	SET ARG_VM= -Xms64M -Xmx512M

@REM =============================================================================================
@REM Archives java (CP : ClassPath)
	SET CP= demoProperties.jar

@REM =============================================================================================
@REM Classe de lancement du Batch (CLASS : Class)
	SET CLASS=demo.properties.ExemplePropertiesLigneCommande
@REM arguments �ventuels du main
	SET ARG_BATCH=


@REM =============================================================================================
@REM Lancement du batch
    Date /T
    time /T
    @ECHO ON
    "%VM%" %ARG_VM% -Dtype.plateforme="version ligne de commande dos" -classpath %CP%  %CLASS% %ARG_BATCH% 
    @ECHO OFF
    pause