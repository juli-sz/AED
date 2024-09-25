# Arreglos

## Estructura
### Definicion de mi arreglo
- vector o arreglo unidimensional (una dimension)
```
nombre_arreglo: arreglo de [tamaño] de tipo_de_dato
```
- matriz o arreglo bidimensional (dos dimensiones)
```
nombre_arreglo: arreglo de [tamaño_en_x][tamaño_en_y] de tipo_de_dato
```
- cubo o arreglo tridimensional (tres dimensiones)
```
nombre_arreglo: arreglo de [tamaño_en_x][tamaño_en_y][tamaño_en_z] de tipo_de_dato
```

### Atención!
---
  - tipo_de_dato: puede ser CUALQUIER tipo de dato, desde otro arreglo, a un registro o a un tipo sencillo como un alfanumérico o un número
  - tamaño_en_(x, y o z): solo para tener una idea, en realidad ustedes pueden considerar a las dimensiones como se les cante, se suele usar asi ya que cuando trabajamos al momento de recorrer los arreglos, se suele utilizar i, j, y k, que son los versores que se usa comunmente en las áreas de matemática para los ejes x, y, y z

## Uso
- para acceder al contenido de una posicion de un arreglo hacemos `nombre_arreglo[i][j]` siendo i y j los indices a los que queremos acceder
- para guardar algun valor en una posicion particular de un arreglo hacemos `nombre_arreglo[i][j]:=valor`
- para acumular dentro de una posicion particular de un arreglo hacemos ```nombre_arreglo[i][j]:=nombre_arreglo[i][j]+valor```
- para recorrer un arreglo, como sabemos la cantidad de indices (ya que nosotros los definimos), utilizamos una estructura repetitiva, manejada por contador, un ciclo para. Hacemos
  ```
  para i:=1 hasta n1 hacer
    para j:=1 hasta n2 hacer
      //lo que necesitamos hacer para cada posicion del arreglo, en este caso vamos a inicializar el arreglo
      nombre_arreglo[i][j]:=0
    fin para
  fin para
  ```
- para generar totales generales por columna, por fila y total general utilizamos un indice extra para la variable que necesitamos generar el total, es decir, si necesitamos un total x columna, vamos a utilizar un indice extra en las filas, y viceversa, en la mayoria de los casos, vamos a necesitar utilizar tanto una columna como una fila extra quedando como
  - empezando por
    |     x    | Column 1 | Column 2 |
    |----------|----------|----------|
    | fila 1   |     1    |     2    |
    | fila 2   |     1    |     3    |
  - al agregar los indices extras para los totales tenemos
    |     x    | Column 1 | Column 2 | totxfila |
    |----------|----------|----------|----------|
    | fila 1   |     1    |     2    |     3    |
    | fila 2   |     1    |     3    |     4    |
    | totxcol  |     2    |     5    |     7    |

## 