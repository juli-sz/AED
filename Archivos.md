### ¿qué es un archivo?
es una secuencia de registros con estructura definida, se almacenan en memoria física
### los archivos pueden ser
#### secuenciales
se acceden de forma consecutiva del primer al ultimo elemento
#### indexados
poseen un área de "indice" o clave por la cual se pueden acceder o buscar a registros particulares

### ¿como declaro mi archivo?
1. primero debe declarar la estructura del registro por el que se va a formar el archivo
```
	reg1 = reg
		campo1: tipo1
		campo2: tipo2
		campo3: tipo3
	fin reg
```
2. declaro el archivo segun que logica de ordenamiento tiene y si es necesario los campos por los cuales se ordena (clave)
	op1
		`archivo_secuencial: archivo de reg1 ordenado por campo1, campo2`
	op2
		`archivo_indexado: archivo de reg1 indexado por campo1, campo2
3. por ultimo, defino mis "ventanas", registros con los que voy a "recorrer" mi archivo

	`ventana_sec, ventana_index: reg1` 
### ¿como trabajo con mi archivo?
- para comenzar a trabajar con el archivo voy a tener que "abrirlo", esto se puede hacer de entrada(lectura), salida(escritura) o entrada/salida
```
	ABRIR E/(ARCH) 
	ABRIR /S(ARCH)
	ABRIR E/S(ARCH)
```
- para recorrer el archivo _secuencial_ vamos a hacer un
	```LEER(ARCHIVO,VENTANA)```
- para controlar la condicion de finalizacion usamos "no fin de archivo" `NFDA(nombre_archivo)`
	```MIENTRAS NFDA(ARCH)```
- para escribir en un archivo de salida o sobre escribir en el de entrada podemos usar "escribir" o "grabar" pasando por parametro el archivo donde quiero escribir y la variable(registro o ventana) que quiero escribir
```
GRABAR(ARCH,VENTANA)
ESC(ARCH,VENTANA)
```

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





