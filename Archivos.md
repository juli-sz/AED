# Archivos
## ¿qué es un archivo?
es una secuencia de registros con estructura definida, se almacenan en memoria física
## los archivos pueden ser
### secuenciales
se acceden de forma consecutiva del primer al ultimo elemento
### indexados
poseen un área de "indice" o clave por la cual se pueden acceder o buscar a registros particulares

## operar con archivos...
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
- op1
	```
	archivo_secuencial: archivo de reg1 ordenado por campo1, campo2
	```
- op2
	```
	archivo_indexado: archivo de reg1 indexado por campo1, campo2
	```
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
- para controlar la condicion de finalizacion usamos "no fin de archivo" `NFDA(nombre_archivo)` -->
```MIENTRAS NFDA(ARCH)```
- para escribir en un archivo de salida o sobre escribir en el de entrada podemos usar "escribir" o "grabar" pasando por parametro el archivo donde quiero escribir y la variable(registro o ventana) que quiero escribir
```
GRABAR(ARCH,VENTANA)
ESC(ARCH,VENTANA)
```

