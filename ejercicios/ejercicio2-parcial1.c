accion ej_parcial2 es
    ambiente
        album=registro
            cod_usuario
            cod_figurita
            cantidad
            tipo=("D","C","V")
        fin registro
        amigos = registro
            cod_usuario 
            apellido
            nombre
            celular
        fin registro
        arch_album: archivo de amigos ordenado por cod_usuario
        arch_amigos: archivo indexado por cod_usuario
        reg_album: album
        arr_album: arreglo de [1..11][1..4] de enteros
        reg_amigos: amigos
        pos_mayor,mayor:=entero

        amigo= reg
            cod
            d
            c
            v
        fin registro
        arr_amigos: arreglo de [1..11] de amigo

    proceso
        para i:=1 hasta 11 hacer
            para j:=1 hasta 4 hacer
                arr_album[i]:=0
            fin para
        fin para
        Abrir E/ (arch_album)
        Abrir E/ (arch_amigos)
        Leer(arch_album,reg_album)
        mientras NFDA(arch_album) hacer
            
            si reg_album.tipo = "D" entonces
                arr_album[reg_album.cod_usuario][1]:=arr_album[reg_album.cod_usuario][1]+reg_album.cantidad
                arr_album[reg_album.cod_usuario][4]:=arr_album[reg_album.cod_usuario][4]+reg_album.cantidad
                arr_album[11][1]:=arr_album[11][1]+reg_album.cantidad
                arr_album[11][4]:=arr_album[11][4]+reg_album.cantidad
            si no 
                si reg_album.tipo = "C" entonces
                    arr_album[reg_album.cod_usuario][2]:=arr_album[reg_album.cod_usuario][2]+reg_album.cantidad
                    arr_album[reg_album.cod_usuario][4]:=arr_album[reg_album.cod_usuario][4]+reg_album.cantidad
                    arr_album[11][2]:=arr_album[11][2]+reg_album.cantidad
                    arr_album[11][4]:=arr_album[11][4]+reg_album.cantidad
                si no
                    si  reg_album.tipo = "V" entonces
                        arr_album[reg_album.cod_usuario][3]:=arr_album[reg_album.cod_usuario][3]+reg_album.cantidad
                        arr_album[reg_album.cod_usuario][4]:=arr_album[reg_album.cod_usuario][4]+reg_album.cantidad
                        arr_album[11][3]:=arr_album[11][3]+reg_album.cantidad
                        arr_album[11][4]:=arr_album[11][4]+reg_album.cantidad
                    fin si
                fin si
            fin si

            Leer(arch_album,reg_album)
        fin mientras
        mayor:=0
        pos_mayor:=0
        para i:=1 hasta 10
            para j:=1 hasta 3 hacer
                esc("el total para el usuario:", i," y el album", j," es", arr_album[i][j])
            fin para
        fin para
        para i:=1 hasta 10 hacer
            si arr_album[i][4] > mayor entonces
                pos_mayor:=i
                mayor:=arr_mayor[i][4]
            fin si
        fin para 
        reg_amigos.clave:=pos_mayor
        Leer(arch_amigos,reg_amigos)
        si existe entonces
            esc("el que mas figuritas coleccionó fue ", reg_amigos.nombre, " ", reg_amigos.apellido, "con ", mayor, "figuritas")  
        si no
            esc("error, no existe ese amigo")
        fin si
        para i:=1 hasta 10 hacer
            esc("para el usuario: ",i," el porcentaje de figuritas descubiertas fue de: ", arr_album[i][4]*100/arr_album[11][4])
        fin para


---
    
            


para i:= hasta 10 hacer
    regsalida.amigo:=i
    regsalida.cantidad:=arr_album[i][4].cantidad
    Grabar(salida, regsalida)
fin para



