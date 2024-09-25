# Corte de Control
### ¿para que sirve?
generalmente lo usamos para realizar estadisticas, conteos de valores los cuales tenemos que agrupar segun algun criterio, para realizarlo necesitamos que el archivo este ORDENADO, se utiliza generalmente para archivos de caracter secuencial

### ¿en que consiste?
consiste en un control de los campos claves, detecta cuando hay un cambio en esta y emite totales parciales entre otras cosas cuando se da este cambio

### ¿como lo empleo?
- un archivo secuencial ordenado va a tener un orden de jerarquía dentro de sus campos, se dice que el primero será el de "mayor nivel" y el ultimo sera el de "menor nivel"
- los cortes de control se emplean por medio de procedimientos, y se realizan de forma recurrente durante todo el analisis del archivo a analizar
- un corte, para cualquier nivel, tiene como principal responsabilidad actualizar su resguardo y llamar al corte del nivel mas proximo inferior, por otro lado, si se requiere en ese corte la muestra de totales, esto se debera hacer antes de la actualizacion del resguardo.
- vamos a ejemplificar sobre este archivo
```
reg1=reg
	campo1:
	campo2:
	campo3:
	campo4:
fin reg
ARCH: ARCHIVO DE REG1 ORDENADO POR CAMPO1, CAMPO2, CAMPO3
V: REG1
```
- entonces, teniendo en cuenta el anterior, vamos a tener un corte para cada uno de esos 3 campos
```
PROCEDIMIENTO CORTE_CAMPO3() ES
	//MOSTRAR TOTALES DE CAMPO1
	//NO TIENE CORTE MAS CHICO ASI Q NO LLAMA A NADIE
	RES_CAMPO3:=V.CAMPO3
FIN PROCEDIMIENTO

PROCEDIMIENTO CORTE_CAMPO2() ES
	//MOSTRAR TOTALES DE CAMPO2
	CORTE_CAMPO3()
	RES_CAMPO2:=V.CAMPO2
FIN PROCEDIMIENTO
	
PROCEDIMIENTO CORTE_CAMPO1() ES
	//MOSTRAR TOTALES DE CAMPO1
	CORTE_CAMPO2()
	RES_CAMPO1:=V.CAMPO1
FIN PROCED
```





