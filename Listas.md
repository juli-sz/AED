tipos de listas
	### simplemente enlazadas
	nodo = reg
		dato:
		prox: puntero a nodo
	fin registro

	### doblemente enlazadas
	nodo2 = reg
		ant:        //puntero interno
		dato:
		prox: puntero a nodo2
	fin registro

	cirulares -> el próximo del último elemento apunta al primero
	si es una circular doble el anterior del primero apuntara al último

	punteros externos: P, Q, PRIM, PRIM2, ULT, ANT

	#### Avanzar en una lista, si utilizamos P para recorrer
		ANT:=P
		P:=^P.PROX
	
	#### Eliminar en una lista, si utilizamos P para recorrer, y utilizamos un puntero externo ANT
	^ANT.PROX:=^P.PROX
	DISPONER(P)   -> accion que libera el espacio de memoria

	
	

